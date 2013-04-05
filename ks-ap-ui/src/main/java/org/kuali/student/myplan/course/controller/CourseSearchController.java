/*
 * Copyright 2011 The Kuali Foundation
 * 
 * Licensed under the Educational Community License, Version 1.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/ecl1.php
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.kuali.student.myplan.course.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.kuali.rice.core.api.util.KeyValue;
import org.kuali.rice.krad.web.controller.UifControllerBase;
import org.kuali.rice.krad.web.form.UifFormBase;
import org.kuali.student.ap.framework.config.KsapFrameworkServiceLocator;
import org.kuali.student.ap.framework.context.CourseSearchConstants;
import org.kuali.student.ap.framework.course.CourseSearchForm;
import org.kuali.student.ap.framework.course.CourseSearchItem;
import org.kuali.student.ap.framework.course.CourseSearchStrategy;
import org.kuali.student.myplan.course.form.CourseSearchFormImpl;
import org.kuali.student.myplan.course.util.CampusSearch;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.core.search.dto.SearchRequestInfo;
import org.kuali.student.r2.core.search.infc.SearchResult;
import org.kuali.student.r2.core.search.infc.SearchResultRow;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/course/**")
public class CourseSearchController extends UifControllerBase {

	private static final Logger LOG = Logger
			.getLogger(CourseSearchController.class);

	/**
	 * HTTP session attribute key for holding recent search results.
	 */
	private static final String RESULTS_ATTR = CourseSearchController.class
			.getName() + ".results";

	/**
	 * HTTP session attribute key for holding trending state.
	 */
	private static final String TRSTATE_ATTR = CourseSearchController.class
			.getName() + ".trendingState";

	/**
	 * Keyed mapping of DataTables search column order by facet id. This column
	 * order is fully internal to this controller class, and is used to tie
	 * faceted searches columns on the search item.
	 * 
	 * @see #FACET_COLUMNS_REVERSE
	 * @see #getFacetValues(HttpServletResponse, HttpServletRequest)
	 */
	private static final Map<String, Integer> FACET_COLUMNS;

	/**
	 * Ordered list of facet column ids by DataTables column order. This column
	 * order is fully internal to this controller class, and is used to tie
	 * faceted searches columns on the search item.
	 * 
	 * @see #FACET_COLUMNS
	 * @see #getFacetValues(HttpServletResponse, HttpServletRequest)
	 */
	private static final List<String> FACET_COLUMNS_REVERSE;

	/**
	 * Internal count of trending search keywords.
	 */
	private static final TrendingState TRENDING = new TrendingState();

	/**
	 * Initialize internal facet column order.
	 */
	static {
		Set<String> facetKeys = KsapFrameworkServiceLocator
				.getCourseSearchStrategy().getFacetSort().keySet();
		Map<String, Integer> m = new java.util.HashMap<String, Integer>(
				facetKeys.size());
		List<String> l = new java.util.ArrayList<String>(facetKeys.size());
		for (String fk : facetKeys) {
			m.put(fk, l.size());
			l.add(fk);
		}
		FACET_COLUMNS = Collections.synchronizedMap(Collections
				.unmodifiableMap(m));
		FACET_COLUMNS_REVERSE = Collections.synchronizedList(Collections
				.unmodifiableList(l));
	}

	/**
	 * Trending search state controller.
	 * 
	 * <p>
	 * This class monitors keywords by relevance score in search results
	 * continuously as search results report keyword sets.
	 * </p>
	 * 
	 * <p>
	 * TODO: evaluate moving to a public framework class.
	 * </p>
	 * 
	 * @see CourseSearchItem#getKeywords()
	 */
	private static class TrendingState {

		/**
		 * Keyword count tracking map.
		 */
		private final Map<String, Long> count = Collections
				.synchronizedMap(new java.util.HashMap<String, Long>(256));

		/**
		 * Handle to the last reported array of search keywords.
		 * 
		 * <p>
		 * This field is populated via the order parameter
		 * {@link #trend(String[], Map)} when non-null, and may be expected to
		 * be truncated to a relatively small size (32) prior to being
		 * populated.
		 * </p>
		 * 
		 * @see SessionSearchInfo#SessionSearchInfo(HttpServletRequest,
		 *      CourseSearchStrategy, FormKey, CourseSearchForm, String)
		 */
		private String[] related;

		/**
		 * Record trending keywords related to an active search.
		 * 
		 * @param order
		 *            The keywords to record as trending, in order of relevance
		 *            to the active search. This parameter should be truncated
		 *            before sending.
		 * @param keywordCount
		 *            Mapping of keywords counts to use as increment values for
		 *            the trending score. It is expected that order represents a
		 *            subset of the this map's keys.
		 */
		private void trend(String[] order, Map<String, Integer> keywordCount) {
			if (order.length == 0)
				return;
			long topCount = keywordCount.get(order[0]).longValue();
			if (topCount == 0L)
				return;
			for (String key : related = order) {
				Integer c = keywordCount.get(key);
				assert c != null : key;
				synchronized (count) {
					Long tsc = count.get(key);
					if (tsc == null)
						tsc = 0L;
					tsc += c.longValue() * 100L / topCount;
					count.put(key, tsc);
				}
			}
		}

		/**
		 * Purge trending state to keep only the 128 most relevant entries.
		 * <p>
		 * Only the most relevant entries are displayed, but many more are kept
		 * as a buffer. The 128 size limit prevents the count map from growing
		 * too large.
		 * </p>
		 */
		private void purge() {
			if (count.size() > 128) {
				String[] tsk;
				synchronized (count) {
					tsk = count.keySet().toArray(new String[count.size()]);
				}
				// Sort by lowest to highest trending count
				Arrays.sort(tsk, new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						Long i1 = count.get(o1);
						Long i2 = count.get(o2);
						if (i1 == i2)
							return 0;
						if (i1 == null)
							return -1;
						if (i2 == null)
							return 1;
						return i1.compareTo(i2);
					}
				});
				// Removed lowest count entries until down to 128
				for (int i = 0; i < tsk.length && count.size() > 128; i++)
					count.remove(tsk[i]);
			}
		}

		/**
		 * Retrieve the top n trending search keywords observed at this node.
		 * 
		 * @param n
		 *            The number of entries to ensure are in the set on return.
		 *            There may be fewer entries, but there will not be more
		 *            unless passed.
		 * @param rv
		 *            A set that may or may not be null, and that may or may not
		 *            already contain entries. This set will be returned if
		 *            non-null, otherwise a new set will be created.
		 * @return The passed in set if non-null, otherwise a new set will be
		 *         created. Either way, the returned set will contain up to n
		 *         entries supplied by this node in addition to the entries
		 *         already in the set when passed in.
		 */
		private Set<String> top(int n, Set<String> rv) {
			purge(); // drop all but the 128 most relevent entries
			rv = rv == null ? new java.util.LinkedHashSet<String>(n) : rv;

			// Use the last related search for 1/3 of the entries
			int rn = (n - rv.size()) / 3;
			if (related != null)
				for (int i = 0; i < related.length && i < rn; i++)
					rv.add(related[i]);
			if (LOG.isDebugEnabled())
				LOG.debug("Trending " + n + " related terms " + rv);
			String[] sk;

			// Use trending counts to select the other 2/3 of the entries
			synchronized (count) {
				sk = count.keySet().toArray(new String[count.size()]);
			}
			// Sort by highest to lowest trending count
			Arrays.sort(sk, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					Long n1 = count.get(o1);
					Long n2 = count.get(o2);
					if (n1 == n2)
						return 0;
					if (n1 == null)
						return 1;
					if (n2 == null)
						return -1;
					return -n1.compareTo(n2);
				}
			});
			// Truncate results
			for (int i = 0; rv.size() < n && i < sk.length; i++)
				rv.add(sk[i]);
			if (LOG.isDebugEnabled())
				LOG.debug("Trending " + n + " top count " + rv);
			return rv;
		}
	}

	/**
	 * Get a session bound trending state for tracking common keywords for the
	 * current user.
	 * 
	 * @param request
	 *            The incoming servlet request.
	 * @return A trending state monitor for tracking the current user's search
	 *         activity.
	 */
	private static TrendingState getSessionTendingState(
			HttpServletRequest request) {
		HttpSession sess = request.getSession();
		TrendingState rv = (TrendingState) sess.getAttribute(TRSTATE_ATTR);
		if (rv == null)
			sess.setAttribute(TRSTATE_ATTR, rv = new TrendingState());
		return rv;
	}

	/**
	 * Report trending keywords for the current user.
	 * 
	 * <p>
	 * This method proxies trending reports to all relevant monitors. At preset,
	 * we are tracking the current user's activity (
	 * {@link #getSessionTendingState(HttpServletRequest)}) and global activity
	 * on this node ({@link #TRENDING}).
	 * 
	 * @param request
	 *            The incoming servlet request.
	 * @param order
	 *            The keywords to track, in order from most to least relevant to
	 *            the current search. To keep trending operation efficient, this
	 *            array should be truncated 32 or fewer entries before tracking.
	 * @param keywordCount
	 *            A mapping from keywords to a relevance score relative to the
	 *            current search. It is expected that order represents a subset
	 *            of this mapping's key set.
	 */
	private static void trend(HttpServletRequest request, String[] order,
			Map<String, Integer> keywordCount) {
		TRENDING.trend(order, keywordCount);
		getSessionTendingState(request).trend(order, keywordCount);
	}

	/**
	 * Opaque key representing a unique search form.
	 * <p>
	 * This key is used to match cached results across multiple requests for the
	 * same search, and is considered to be unique if all search inputs on the
	 * form used to construct the key are unique.
	 * </p>
	 */
	private static class FormKey {
		private final String searchQuery;
		private final String searchTerm;
		private final String[] campusSelect;

		private FormKey(CourseSearchForm f) {
			this.searchQuery = f.getSearchQuery();
			this.searchTerm = f.getSearchTerm();
			this.campusSelect = f.getCampusSelect() == null ? null : f
					.getCampusSelect().toArray(
							new String[f.getCampusSelect().size()]);
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(campusSelect);
			result = prime * result
					+ ((searchQuery == null) ? 0 : searchQuery.hashCode());
			result = prime * result
					+ ((searchTerm == null) ? 0 : searchTerm.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FormKey other = (FormKey) obj;
			if (!Arrays.equals(campusSelect, other.campusSelect))
				return false;
			if (searchQuery == null) {
				if (other.searchQuery != null)
					return false;
			} else if (!searchQuery.equals(other.searchQuery))
				return false;
			if (searchTerm == null) {
				if (other.searchTerm != null)
					return false;
			} else if (!searchTerm.equals(other.searchTerm))
				return false;
			return true;
		}

	}

	/**
	 * Input command processor for supporting DataTables server-side processing.
	 * 
	 * <p>
	 * TODO: Evaluate moving to a public class in KRAD.
	 * </p>
	 * 
	 * @see <a
	 *      href="http://datatables.net/usage/server-side">http://datatables.net/usage/server-side</a>
	 */
	private static class DataTablesInputs {
		private final int iDisplayStart, iDisplayLength, iColumns,
				iSortingCols, sEcho;
		private final String sSearch;
		private final Pattern patSearch;
		private final boolean bRegex;
		private final boolean[] bSearchable_, bRegex_, bSortable_;
		private final String[] sSearch_, sSortDir_, mDataProp_;
		private final Pattern[] patSearch_;
		private final int[] iSortCol_;

		private DataTablesInputs(HttpServletRequest request) {
			String s;
			iDisplayStart = (s = request.getParameter("iDisplayStart")) == null ? 0
					: Integer.parseInt(s);
			iDisplayLength = (s = request.getParameter("iDisplayLength")) == null ? 0
					: Integer.parseInt(s);
			iColumns = (s = request.getParameter("iColumns")) == null ? 0
					: Integer.parseInt(s);
			bRegex = (s = request.getParameter("bRegex")) == null ? false
					: new Boolean(s);
			patSearch = (sSearch = request.getParameter("sSearch")) == null
					|| !bRegex ? null : Pattern.compile(sSearch);
			bSearchable_ = new boolean[iColumns];
			sSearch_ = new String[iColumns];
			patSearch_ = new Pattern[iColumns];
			bRegex_ = new boolean[iColumns];
			bSortable_ = new boolean[iColumns];
			for (int i = 0; i < iColumns; i++) {
				bSearchable_[i] = (s = request.getParameter("bSearchable_" + i)) == null ? false
						: new Boolean(s);
				bRegex_[i] = (s = request.getParameter("bRegex_" + i)) == null ? false
						: new Boolean(s);
				patSearch_[i] = (sSearch_[i] = request.getParameter("sSearch_"
						+ i)) == null
						|| !bRegex_[i] ? null : Pattern.compile(sSearch_[i]);
				bSortable_[i] = (s = request.getParameter("bSortable_" + i)) == null ? false
						: new Boolean(s);
			}
			iSortingCols = (s = request.getParameter("iSortingCols")) == null ? 0
					: Integer.parseInt(s);
			iSortCol_ = new int[iSortingCols];
			sSortDir_ = new String[iSortingCols];
			for (int i = 0; i < iSortingCols; i++) {
				iSortCol_[i] = (s = request.getParameter("iSortCol_" + i)) == null ? 0
						: Integer.parseInt(s);
				sSortDir_[i] = request.getParameter("sSortDir_" + i);
			}
			mDataProp_ = new String[iColumns];
			for (int i = 0; i < iColumns; i++)
				mDataProp_[i] = request.getParameter("mDataProp_" + i);
			sEcho = (s = request.getParameter("sEcho")) == null ? 0 : Integer
					.parseInt(s);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(super.toString());
			sb.append("\n\tiDisplayStart = ");
			sb.append(iDisplayStart);
			sb.append("\n\tiDisplayLength = ");
			sb.append(iDisplayLength);
			sb.append("\n\tiColumns = ");
			sb.append(iColumns);
			sb.append("\n\tsSearch = ");
			sb.append(sSearch);
			sb.append("\n\tbRegex = ");
			sb.append(bRegex);
			for (int i = 0; i < iColumns; i++) {
				sb.append("\n\tbSearchable_").append(i).append(" = ");
				sb.append(bSearchable_[i]);
				sb.append("\n\tsSearch_").append(i).append(" = ");
				sb.append(sSearch_[i]);
				sb.append("\n\tbRegex_").append(i).append(" = ");
				sb.append(bRegex_[i]);
				sb.append("\n\tbSortable_").append(i).append(" = ");
				sb.append(bSortable_[i]);
			}
			sb.append("\n\tiSortingCols = ");
			sb.append(iSortingCols);
			for (int i = 0; i < iSortingCols; i++) {
				sb.append("\n\tiSortCol_").append(i).append(" = ");
				sb.append(iSortCol_[i]);
				sb.append("\n\tsSortDir_").append(i).append(" = ");
				sb.append(sSortDir_[i]);
			}
			for (int i = 0; i < iColumns; i++) {
				sb.append("\n\tmDataProp_").append(i).append(" = ");
				sb.append(mDataProp_[i]);
			}
			sb.append("\n\tsEcho = ");
			sb.append(sEcho);
			return sb.toString();
		}
	}

	/**
	 * Simple object for tracking facet click/count state.
	 * 
	 * @see SessionSearchInfo
	 */
	private static class FacetState implements Serializable {
		private static final long serialVersionUID = 1719950239861974273L;

		private FacetState() {
		}

		private boolean checked = true;
		private int count;
	}

	/**
	 * Simple object representing pre-processed search data.
	 * 
	 * @see SessionSearchInfo
	 * @see CourseSearchItem#getSearchColumns()
	 * @see CourseSearchItem#getFacetColumns()
	 */
	private static class SearchInfo implements Serializable {
		private static final long serialVersionUID = 8697147011424347285L;

		private final CourseSearchItem item;
		private final String[] sortColumns;
		private final Map<String, String[]> facetColumns;

		private SearchInfo(CourseSearchItem item) {
			this.item = item;
			sortColumns = item.getSortColumns();
			facetColumns = item.getFacetColumns();
		}

		@Override
		public String toString() {
			return "SearchInfo [searchColumns=" + item.getCourseId()
					+ ", sortColumns=" + Arrays.toString(sortColumns)
					+ ", facetColumns=" + facetColumns + "]";
		}
	}

	/**
	 * Session-bound search results cache. This object backs the facet and data
	 * table result views on the KSAP course search front-end. Up to three
	 * searches are stored in the HTTP session via these objects.
	 * 
	 * <p>
	 * TODO: Evaluate moving to a generic framework class in KRAD.
	 * </p>
	 */
	private static class SessionSearchInfo {

		/**
		 * The search form input data used to key this session info object.
		 */
		private final FormKey formKey;

		/**
		 * The search result column data.
		 */
		private final List<SearchInfo> searchResults;

		/**
		 * The calculated facet state.
		 */
		private final Map<String, Map<String, FacetState>> facetState;

		/**
		 * Pruned facet state - this shared state keeps a count of all facets
		 * values that were pruned from display due to size limits and relevance
		 * scoring.
		 * 
		 * <p>
		 * Note that pruned is not reliable - it is only a placeholder to
		 * facilitate the counting algorithm and is used for informational
		 * logging. The first facet build leaves pruned rows uncounted - on
		 * updated builds they are recorded in the log for tuning purposes.
		 * </p>
		 */
		private final FacetState pruned;

		/**
		 * The oneClick flag records whether or not any facet state leaf nodes
		 * have been switched to false. Until oneClick has been set, count
		 * updates and clickAll requests will be ignored.
		 * 
		 * @see #facetClick(String, int)
		 * @see #facetClickAll()
		 * @see #updateFacetCounts()
		 */
		private boolean oneClick = false;

		/**
		 * Compose search information based on materialized inputs.
		 * 
		 * <p>
		 * This constructor is potentially expensive - it is where the actual
		 * search is performed on the back end when pulling data or facet table
		 * results.
		 * </p>
		 * 
		 * @param searcher
		 *            The controller's strategy instance.
		 * @param formKey
		 *            The form key that will be used as an attribute handle to
		 *            the search results in the HTTP session.
		 * @param form
		 *            The search form.
		 * @param principalName
		 *            The principal name of the current user.
		 * @see CourseSearchController#getJsonResponse(HttpServletResponse,
		 *      HttpServletRequest)
		 * @see CourseSearchController#getFacetValues(HttpServletResponse,
		 *      HttpServletRequest)
		 */
		private SessionSearchInfo(HttpServletRequest request,
				CourseSearchStrategy searcher, FormKey formKey,
				CourseSearchForm form, String principalName) {
			// Verify that form key data matches the actual search form
			assert (formKey.searchQuery == null && form.getSearchQuery() == null)
					|| (formKey.searchQuery != null && (formKey.searchQuery
							.equals(form.getSearchQuery()))) : formKey.searchQuery
					+ " " + form.getSearchQuery();
			assert (formKey.searchTerm == null && form.getSearchTerm() == null)
					|| (formKey.searchTerm != null && (formKey.searchTerm
							.equals(form.getSearchTerm()))) : formKey.searchTerm
					+ " " + form.getSearchTerm();
			String[] cs = null;
			assert (formKey.campusSelect == null && form.getCampusSelect() == null)
					|| (formKey.campusSelect != null && (Arrays.equals(
							formKey.campusSelect,
							cs = form.getCampusSelect().toArray(
									new String[form.getCampusSelect().size()])))) : formKey.campusSelect
					+ " " + cs;
			this.formKey = formKey;

			// Hit search back end and break down into column values
			List<CourseSearchItem> courses = searcher.courseSearch(form,
					principalName);
			List<SearchInfo> resultList = new java.util.ArrayList<SearchInfo>(
					courses.size());
			for (CourseSearchItem course : courses)
				resultList.add(new SearchInfo(course));
			this.searchResults = Collections.unmodifiableList(Collections
					.synchronizedList(resultList));

			// Calculate initial facet state when search results are non-empty
			if (searchResults.isEmpty())
				facetState = Collections.emptyMap();
			else {
				Map<String, String[]> facetColumns = searchResults.get(0).facetColumns;
				assert facetColumns.size() == searcher.getFacetSort().size() : facetColumns
						.size() + " != " + searcher.getFacetSort().size();
				Map<String, Map<String, FacetState>> facetStateMap = new java.util.HashMap<String, Map<String, FacetState>>(
						facetColumns.size());
				for (String fk : facetColumns.keySet())
					facetStateMap.put(fk,
							new java.util.HashMap<String, FacetState>());
				final Map<String, Integer> kwc = new java.util.HashMap<String, Integer>();
				// Generate initial counts, unabridged and unordered
				for (SearchInfo row : searchResults) {
					// Validate that the number of facet columns is uniform
					// across all search rows
					assert row.facetColumns != null
							|| row.facetColumns.size() == facetColumns.size() : row.facetColumns == null ? "null"
							: row.facetColumns.size() + " != "
									+ facetColumns.size();
					// Update facet counts for all columns, creating pre-checked
					// state nodes as needed
					for (Entry<String, Map<String, FacetState>> fce : facetStateMap
							.entrySet()) {
						Map<String, FacetState> fm = fce.getValue();
						for (String key : row.facetColumns.get(fce.getKey())) {
							assert key.startsWith(";") && key.endsWith(";")
									&& key.length() >= 3 : key;
							String facetKey = key
									.substring(1, key.length() - 1);
							FacetState fs = fm.get(facetKey);
							if (fs == null)
								fm.put(facetKey, fs = new FacetState());
							fs.count++;
						}
					}
					for (String kw : row.item.getKeywords()) {
						Integer kwi = kwc.get(kw);
						if (kwi == null)
							kwc.put(kw, 1);
						else
							kwc.put(kw, kwi + 1);
					}
				}
				// Post-process based on calculated totals and per-column rules
				for (String fk : facetColumns.keySet()) {
					final Map<String, FacetState> fm = facetStateMap.get(fk);
					Map<String, FacetState> nfm;
					if (fm.isEmpty())
						// Discard superfluous empty map references
						facetStateMap.put(fk, nfm = Collections.emptyMap());
					else {
						// Establish facet key order
						String[] sk = fm.keySet()
								.toArray(new String[fm.size()]);
						// Sort by relevance for trending
						Arrays.sort(sk, new Comparator<String>() {
							@Override
							public int compare(String o1, String o2) {
								FacetState fs1 = fm.get(o1);
								FacetState fs2 = fm.get(o2);
								return fs1.count == fs2.count ? 0
										: fs1.count < fs2.count ? 1 : -1;
							}
						});
						// Truncate results to show only the 50 most relevant
						// words in the facet
						sk = Arrays.copyOf(sk, Math.min(sk.length, 50));
						// Sort according to strategy definitions
						Arrays.sort(sk, searcher.getFacetSort().get(fk));
						nfm = new java.util.LinkedHashMap<String, FacetState>(
								sk.length);
						for (String k : sk) {
							assert k != null : fk;
							// Insert truncated facet keys in order
							nfm.put(k, fm.get(k));
						}

						// Seal the map for synchronized use
						facetStateMap.put(fk, Collections
								.synchronizedMap(Collections
										.unmodifiableMap(nfm)));
					}
				}
				facetState = Collections.synchronizedMap(Collections
						.unmodifiableMap(facetStateMap));

				// Establish keyword relevance order
				String[] sk = kwc.keySet().toArray(new String[kwc.size()]);
				// Sort by relevance for trending
				Arrays.sort(sk, new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						Integer i1 = kwc.get(o1);
						Integer i2 = kwc.get(o2);
						if (i1 == i2)
							return 0;
						if (i1 == null)
							return 1;
						if (i2 == null)
							return -1;
						return -i1.compareTo(i2);
					}
				});
				sk = Arrays.copyOf(sk, Math.min(sk.length, 32));
				trend(request, sk, kwc);
			}
			// Tread pruned facets as not checked unless all
			// visible facet values in the same group are checked
			pruned = new FacetState();
			pruned.checked = false;
		}

		/**
		 * Get the facet state associated with a specific facet column value.
		 * 
		 * @param key
		 *            The facet column value to use as the facet key.
		 * @param facetId
		 *            The facet id.
		 * @return The facet state associated with the indicated column value.
		 */
		private FacetState getFacetState(String key, String facetId) {
			Map<String, FacetState> fm = facetState.get(facetId);
			assert key.startsWith(";") && key.endsWith(";")
					&& key.length() >= 3 : key;
			String facetKey = key.substring(1, key.length() - 1);
			FacetState fs = fm.get(facetKey);
			if (fs == null)
				return pruned;
			else
				return fs;
		}

		/**
		 * Walk through the facet columns in the search results and update
		 * counts based on the current facet state. The method assumes that the
		 * facet state structure is fully formed but that the click state has
		 * change since the last time counts were calculated.
		 */
		private void updateFacetCounts() {
			if (searchResults.isEmpty())
				return;

			// Determine the number of facet columns - this should be uniform
			// across the facet state table and the facet columns in each row
			Map<String, String[]> facetCols = searchResults.get(0).facetColumns;
			assert facetState.size() == facetCols.size() : facetState.size()
					+ " != " + facetCols.size();

			// Reset the count on all facet state leaf nodes to 0
			pruned.count = 0;
			Map<String, Boolean> all = new java.util.HashMap<String, Boolean>(
					facetState.size());
			for (Entry<String, Map<String, FacetState>> fse : facetState
					.entrySet())
				for (FacetState fs : fse.getValue().values()) {
					fs.count = 0;
					if (!Boolean.FALSE.equals(all.get(fse.getKey())))
						all.put(fse.getKey(), fs.checked);
				}

			// Iterate search results
			for (SearchInfo row : searchResults) {

				// Validate facet column count matches facet table size
				assert row.facetColumns != null
						|| row.facetColumns.size() == facetCols.size() : row.facetColumns == null ? "null"
						: row.facetColumns.size() + " != " + facetCols.size();

				// identify filtered rows before counting
				boolean filtered = false;
				for (Entry<String, String[]> fce : facetCols.entrySet()) {
					if (filtered)
						continue;
					String fk = fce.getKey();
					if (row.facetColumns.get(fk).length == 0) {
						// When there are no values on this facet column, filter
						// unless all is checked on the column
						filtered = Boolean.FALSE.equals(all.get(fk));
					} else {
						// Filter unless there is at least one match for one
						// checked facet on this row
						boolean hasOne = false;
						for (String fci : row.facetColumns.get(fk))
							if (!hasOne && getFacetState(fci, fk).checked)
								hasOne = true;
						assert !filtered : "filtered state changed";
						filtered = !hasOne;
					}
				}
				if (!filtered)
					// count all cells in all non-filtered rows
					for (Entry<String, String[]> fce : row.facetColumns
							.entrySet())
						for (String fci : fce.getValue())
							getFacetState(fci, fce.getKey()).count++;
			}
			if (LOG.isDebugEnabled())
				LOG.debug("Pruned facet entry " + pruned.count);
		}

		/**
		 * Update checked state on all facets following a click event from the
		 * browser.
		 * 
		 * @param key
		 *            The facet key clicked. May be 'All'.
		 * @param fcol
		 *            The facet column the click is related to.
		 */
		private void facetClick(String key, String fcol) {
			LOG.debug("Facet click " + key + " " + fcol);
			Map<String, FacetState> fsm = facetState.get(fcol);
			if (fsm == null)
				return;
			if ("All".equals(key))
				for (FacetState fs : fsm.values())
					fs.checked = true;
			else {
				FacetState fs = null;

				// Determine if all facets are checked prior to recording
				// This state corresponds to the "All" checkbox being
				// checked on the browser, in which case no other boxes
				// in the group appear to be checked.
				boolean all = true;
				for (FacetState ifs : fsm.values())
					if (!all)
						continue;
					else
						all = all && ifs.checked;

				// when all checked, clear all but the clicked box
				if (all) {
					for (Entry<String, FacetState> fe : fsm.entrySet())
						if (fe.getValue().checked = key.equals(fe.getKey())) {
							assert fs == null : fs + " " + fe;
							fs = fe.getValue();
						}
					assert fs != null : fcol + " " + key;
					oneClick = true;
				} else {
					// when all are not checked, toggle the clicked box
					fs = facetState.get(fcol).get(key);
					assert fs != null : fcol + " " + key;
					// Update checked status of facet
					if (!(fs.checked = !fs.checked))
						oneClick = true;
					// unchecking the last box in the group, check all
					boolean none = true;
					for (FacetState ifs : facetState.get(fcol).values())
						if (!none)
							continue;
						else
							none = !ifs.checked;
					if (none)
						for (FacetState tfs : fsm.values())
							tfs.checked = true;
				}
			}
			if (oneClick)
				updateFacetCounts();
		}

		private void facetClickAll() {
			LOG.debug("Facet click all");
			if (oneClick) {
				for (Entry<String, Map<String, FacetState>> fse : facetState
						.entrySet())
					for (FacetState fs : fse.getValue().values())
						fs.checked = true;
				updateFacetCounts();
				oneClick = false;
			}
		}

		private List<SearchInfo> getFilteredResults(
				final DataTablesInputs dataTablesInputs) {
			final List<SearchInfo> filteredResults = new java.util.ArrayList<SearchInfo>(
					searchResults);

			/**
			 * Tracks loop state for search filtering.
			 */
			class Iter implements Iterator<SearchInfo> {

				/**
				 * Backing iterator.
				 */
				Iterator<SearchInfo> i = filteredResults.iterator();

				/**
				 * The row data last returned by {@link #next()}.
				 */
				SearchInfo current;

				/**
				 * The removed state of the current row
				 */
				boolean removed = false;

				/**
				 * The search string on the current column.
				 */
				String searchString = dataTablesInputs.sSearch;

				/**
				 * The search patter on the current column, null if non-regex.
				 */
				Pattern searchPattern = dataTablesInputs.patSearch;

				/**
				 * Current column pointer.
				 */
				int j = -1;

				/**
				 * Column iterator.
				 */
				Iterator<String[]> fi = new Iterator<String[]>() {
					@Override
					public boolean hasNext() {
						// break column loop once row has been removed,
						// or when all columns have been seen
						return !removed && j < current.facetColumns.size() - 1;
					}

					@Override
					public String[] next() {
						// break column loop once row has been removed
						if (removed)
							throw new IllegalStateException(
									"Row has been removed");
						// increase column pointer, update search fields
						j++;
						if (dataTablesInputs.sSearch_[j] != null) {
							searchString = dataTablesInputs.sSearch_[j];
							searchPattern = dataTablesInputs.patSearch_[j];
						} else {
							searchString = dataTablesInputs.sSearch;
							searchPattern = dataTablesInputs.patSearch;
						}
						// Here is where data tables column # is tied to inernal
						// facet column order.
						return current.facetColumns.get(FACET_COLUMNS_REVERSE
								.get(j));
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};

				/**
				 * Determine whether or not DataTables defines the current
				 * column as searchable.
				 * 
				 * @return True if DataTables defines the current column as
				 *         searchable.
				 */
				private boolean isSearchable() {
					return dataTablesInputs.bSearchable_[j];
				}

				/**
				 * Get the column iterator, after resetting to the start of the
				 * row.
				 * 
				 * @return The column iterator, reset to the start of the row.
				 */
				private Iterable<String[]> facets() {
					return new Iterable<String[]>() {
						@Override
						public Iterator<String[]> iterator() {
							j = -1;
							return fi;
						}
					};
				}

				@Override
				public boolean hasNext() {
					return i.hasNext();
				}

				@Override
				public SearchInfo next() {
					removed = false;
					return current = i.next();
				}

				@Override
				public void remove() {
					removed = true;
					// if (LOG.isDebugEnabled())
					// LOG.debug("Removed " + this);
					i.remove();
				}

				@Override
				public String toString() {
					return "Iter [current="
							+ Arrays.toString(current.facetColumns
									.get(FACET_COLUMNS_REVERSE.get(j)))
							+ ", removed=" + removed + ", searchString="
							+ searchString + ", searchPattern=" + searchPattern
							+ ", j=" + j + " (" + FACET_COLUMNS_REVERSE.get(j)
							+ ")]";
				}
			}
			Iter li = new Iter();
			while (li.hasNext()) { // filter search results
				SearchInfo ln = li.next();
				// li maintains its own handle to the row
				assert ln == li.current; // ln is otherwise unused
				for (String[] cell : li.facets()) {
					if (li.isSearchable()) {
						if (li.searchString == null
								|| li.searchString.trim().equals(""))
							continue;
						if (cell == null || cell.length == 0)
							li.remove();
						else {
							boolean match = false;
							for (String c : cell) {
								if (match)
									continue;
								if (li.searchPattern == null) {
									if (c.toUpperCase().equals(
											li.searchString.toUpperCase()))
										match = true;
								} else if (li.searchPattern.matcher(c)
										.matches())
									match = true;
							}
							if (!match)
								li.remove();
						}
					}
				}
			}

			// Perform sorting if requested
			if (dataTablesInputs.iSortingCols > 0)
				Collections.sort(filteredResults, new Comparator<SearchInfo>() {
					@Override
					public int compare(SearchInfo o1, SearchInfo o2) {
						for (int i = 0; i < dataTablesInputs.iSortingCols; i++) {
							String s1 = o1.sortColumns[dataTablesInputs.iSortCol_[i]];
							String s2 = o2.sortColumns[dataTablesInputs.iSortCol_[i]];
							if (s1 == null && s2 == null)
								continue;
							if (s1 == null)
								return "desc"
										.equals(dataTablesInputs.sSortDir_[i]) ? 1
										: -1;
							if (s2 == null)
								return "desc"
										.equals(dataTablesInputs.sSortDir_[i]) ? -1
										: 1;
							int rv = s1.compareTo(s2);
							if (rv != 0)
								return rv;
						}
						return 0;
					}
				});

			return filteredResults;
		}
	}

	/**
	 * Get a list of the 10 most commonly seen search keywords.
	 * 
	 * @return The 10 most commonly seen search keywords.
	 */
	static Set<String> getCurrentTrend() {
		return TRENDING.top(
				10,
				getSessionTendingState(
						((ServletRequestAttributes) RequestContextHolder
								.getRequestAttributes()).getRequest()).top(6,
						null));
	}

	private CourseSearchStrategy searcher = KsapFrameworkServiceLocator
			.getCourseSearchStrategy();

	private CampusSearch campusSearch = new CampusSearch();

	private ObjectMapper mapper = new ObjectMapper();

	/**
	 * Synchronously retrieve session bound search results for an incoming
	 * request.
	 * 
	 * <p>
	 * This method ensures that only one back-end search per HTTP session is
	 * running at the same time for the same set of criteria. This is important
	 * since the browser fires requests for the facet table and the search table
	 * independently, so this consideration constrains those two requests to
	 * operating synchronously on the same set of results.
	 * </p>
	 * 
	 * @param request
	 *            The incoming request.
	 * @return Session-bound search results for the request.
	 */
	private SessionSearchInfo getSearchResults(HttpServletRequest request) {
		String user = KsapFrameworkServiceLocator.getUserSessionHelper()
				.getStudentId();

		// Populate search form from HTTP request
		CourseSearchForm form = searcher.createSearchForm();
		form.setSearchQuery(request.getParameter("queryText"));
		form.setCampusSelect(Arrays.asList(request.getParameter("campusParam")
				.split("\\s*,\\s*")));
		form.setSearchTerm(request.getParameter("termParam"));
		if (LOG.isDebugEnabled())
			LOG.debug("Search form : " + form);

		// Check HTTP session for cached search results
		FormKey k = new FormKey(form);
		@SuppressWarnings("unchecked")
		Map<FormKey, SessionSearchInfo> results = (Map<FormKey, SessionSearchInfo>) request
				.getSession().getAttribute(RESULTS_ATTR);
		if (results == null)
			request.getSession()
					.setAttribute(
							RESULTS_ATTR,
							results = Collections
									.synchronizedMap(new java.util.LinkedHashMap<FormKey, SessionSearchInfo>()));
		SessionSearchInfo table = null;
		// Synchronize on the result table to constrain sessions to
		// one back-end search at a time
		synchronized (results) {
			// dump search results in excess of 3
			while (results.size() > 3) {
				Iterator<?> ei = results.entrySet().iterator();
				ei.next();
				ei.remove();
			}
			results.put(
					k, // The back-end search happens here --------V
					(table = results.remove(k)) == null ? table = new SessionSearchInfo(
							request, searcher, k, form, user) : table);
		}
		return table;
	}

	@Override
	protected UifFormBase createInitialForm(HttpServletRequest request) {
		return (UifFormBase) searcher.createSearchForm();
	}

	@RequestMapping(value = "/course/{courseCd}", method = RequestMethod.GET)
	public String get(@PathVariable("courseCd") String courseCd,
			@ModelAttribute("KualiForm") CourseSearchForm form,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String number = "";
		String subject = "";
		String courseId = "";
		courseCd = courseCd.toUpperCase();
		StringBuffer campus = new StringBuffer();
		List<KeyValue> campusKeys = campusSearch.getKeyValues();
		for (KeyValue k : campusKeys) {
			campus.append(k.getKey().toString());
			campus.append(",");
		}
		String[] splitStr = courseCd.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
		if (splitStr.length == 2) {
			number = splitStr[1];
			subject = splitStr[0];
		} else {
			StringBuffer splitBuff = new StringBuffer();
			for (int i = 0; i < splitStr.length; i++) {
				splitBuff.append(splitStr[i]);
			}
			response.sendRedirect("../course?searchQuery=" + splitBuff
					+ "&searchTerm=any&campusSelect=" + campus);
			return null;

		}
		CourseSearchStrategy strategy = KsapFrameworkServiceLocator
				.getCourseSearchStrategy();
		Map<String, String> divisionMap = strategy.fetchCourseDivisions();

		ArrayList<String> divisions = new ArrayList<String>();
		strategy.extractDivisions(divisionMap, subject, divisions, false);
		if (divisions.size() > 0) {
			subject = divisions.get(0);
		}

		SearchRequestInfo searchRequest = new SearchRequestInfo(
				"myplan.course.getcluid");
		SearchResult searchResult = null;
		try {
			searchRequest.addParam("number", number);
			searchRequest.addParam("subject", subject.trim());
			searchRequest.addParam("currentTerm", KsapFrameworkServiceLocator
					.getAtpHelper().getCurrentAtpId());
			searchRequest.addParam("lastScheduledTerm",
					KsapFrameworkServiceLocator.getAtpHelper()
							.getLastScheduledAtpId());
			searchResult = KsapFrameworkServiceLocator.getCluService().search(
					searchRequest,
					KsapFrameworkServiceLocator.getContext().getContextInfo());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		for (SearchResultRow row : searchResult.getRows()) {
			courseId = searcher.getCellValue(row, "lu.resultColumn.cluId");
		}
		if (courseId.equalsIgnoreCase("")) {
			response.sendRedirect("../course?searchQuery=" + courseCd
					+ "&searchTerm=any&campusSelect=" + campus);
			return null;

		}
		response.sendRedirect("../inquiry?methodToCall=start&viewId=CourseDetails-InquiryView&courseId="
				+ courseId);
		return null;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(@ModelAttribute("KualiForm") UifFormBase form,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		super.start(form, result, request, response);
		form.setViewId("CourseSearch-FormView");
		form.setView(super.getViewService()
				.getViewById("CourseSearch-FormView"));
		return getUIFModelAndView(form);
	}

	@RequestMapping(value = "/course/", method = RequestMethod.GET)
	public String doGet(@ModelAttribute("KualiForm") UifFormBase form,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		return "redirect:/myplan/course";
	}

	@RequestMapping(params = "methodToCall=start")
	public ModelAndView start(@ModelAttribute("KualiForm") UifFormBase form,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		if (!Boolean.valueOf(request.getAttribute(
				CourseSearchConstants.IS_ACADEMIC_CALENDER_SERVICE_UP)
				.toString())) {
			KsapFrameworkServiceLocator.getAtpHelper().addServiceError(
					"searchTerm");
		}
		super.start(form, result, request, response);
		return getUIFModelAndView(form);
	}

	@RequestMapping(value = "/course/search")
	public void getJsonResponse(HttpServletResponse response,
			HttpServletRequest request) throws IOException {

		// Parse incoming jQuery datatables inputs
		final DataTablesInputs dataTablesInputs = new DataTablesInputs(request);
		if (LOG.isDebugEnabled())
			LOG.debug(dataTablesInputs);
		SessionSearchInfo table = getSearchResults(request);
		if (table == null) {
			return;
		}
		if (table.searchResults != null && !table.searchResults.isEmpty()) {
			SearchInfo firstRow = table.searchResults.iterator().next();
			// Validate incoming jQuery datatables inputs
			assert table != null;
			assert table.searchResults.isEmpty()
					|| dataTablesInputs.iColumns >= firstRow.item
							.getSearchColumns().length : firstRow.item
					.getSearchColumns().length
					+ " > "
					+ dataTablesInputs.iColumns;
			assert table.searchResults.isEmpty()
					|| dataTablesInputs.iColumns >= firstRow.sortColumns.length : firstRow.sortColumns.length
					+ " > " + dataTablesInputs.iColumns;
			assert table.searchResults.isEmpty()
					|| dataTablesInputs.iColumns >= firstRow.facetColumns
							.size() : firstRow.facetColumns.size() + " > "
					+ dataTablesInputs.iColumns;
			assert table.searchResults.isEmpty()
					|| dataTablesInputs.iColumns == firstRow.facetColumns
							.size()
					|| dataTablesInputs.iColumns == firstRow.sortColumns.length
					|| dataTablesInputs.iColumns == firstRow.item
							.getSearchColumns().length : "Max("
					+ firstRow.facetColumns.size() + ","
					+ firstRow.sortColumns.length + ","
					+ firstRow.item.getSearchColumns().length + ") != "
					+ dataTablesInputs.iColumns;
		}

		// DataTables search filter is tied to facet click state on the front
		// end, but is only loosely coupled on the server side.
		List<SearchInfo> filteredResults = table
				.getFilteredResults(dataTablesInputs);

		// Render JSON response for DataTables
		ObjectNode json = mapper.createObjectNode();
		json.put("iTotalRecords", table.searchResults.size());
		json.put("iTotalDisplayRecords", filteredResults.size());
		json.put("sEcho", Integer.toString(dataTablesInputs.sEcho));
		ArrayNode aaData = mapper.createArrayNode();
		for (int i = 0; i < Math.min(filteredResults.size(),
				dataTablesInputs.iDisplayLength); i++) {
			int resultsIndex = dataTablesInputs.iDisplayStart + i;
			if (resultsIndex >= filteredResults.size())
				break;
			ArrayNode cs = mapper.createArrayNode();
			String[] scol = filteredResults.get(resultsIndex).item
					.getSearchColumns();
			for (String col : scol)
				cs.add(col);
			for (int j = scol.length; j < dataTablesInputs.iColumns; j++)
				cs.add((String) null);
			aaData.add(cs);
		}
		json.put("aaData", aaData);
		String jsonString = mapper.writeValueAsString(json);
		if (LOG.isDebugEnabled())
			LOG.debug("JSON output : "
					+ (jsonString.length() < 8192 ? jsonString : jsonString
							.substring(0, 8192)));

		response.setContentType("application/json");
		response.setHeader("Cache-Control", "No-cache");
		response.setHeader("Cache-Control", "No-store");
		response.setHeader("Cache-Control", "max-age=0");
		response.getWriter().println(jsonString);
	}

	@RequestMapping(value = "/course/facetValues")
	public void getFacetValues(HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		SessionSearchInfo table = getSearchResults(request);
		assert table.facetState != null;

		// Update click state based on inputs - see myplan.search.js
		String fclick = request.getParameter("fclick");
		String fcol = request.getParameter("fcol");
		if (fclick != null && fcol != null)
			table.facetClick(fclick, fcol);
		else
			table.facetClickAll();

		// Create the oFacets object used by myplan.search.js
		ObjectNode oFacets = mapper.createObjectNode();
		oFacets.put("sQuery", table.formKey.searchQuery);
		oFacets.put("sTerm", table.formKey.searchTerm);
		ArrayNode aCampus = oFacets.putArray("aCampus");
		for (String c : table.formKey.campusSelect)
			aCampus.add(c);
		ObjectNode oSearchColumn = oFacets.putObject("oSearchColumn");
		for (Entry<String, Integer> fce : FACET_COLUMNS.entrySet())
			oSearchColumn.put(fce.getKey(), fce.getValue());
		ObjectNode oFacetState = oFacets.putObject("oFacetState");
		for (Entry<String, Map<String, FacetState>> row : table.facetState
				.entrySet()) {
			ObjectNode ofm = oFacetState.putObject(row.getKey());
			for (Entry<String, FacetState> fse : row.getValue().entrySet()) {
				ObjectNode ofs = ofm.putObject(fse.getKey());
				ofs.put("checked", fse.getValue().checked);
				ofs.put("count", fse.getValue().count);
			}
		}
		String jsonString = mapper.writeValueAsString(oFacets);
		if (LOG.isDebugEnabled())
			LOG.debug("JSON output : "
					+ (jsonString.length() < 8192 ? jsonString : jsonString
							.substring(0, 8192)));

		response.setContentType("application/json");
		response.setHeader("Cache-Control", "No-cache");
		response.setHeader("Cache-Control", "No-store");
		response.setHeader("Cache-Control", "max-age=0");
		response.getWriter().println(jsonString);
	}

	@RequestMapping(params = "methodToCall=searchForCourses")
	public ModelAndView searchForCourses(
			@ModelAttribute("KualiForm") CourseSearchFormImpl form,
			BindingResult result, HttpServletRequest httprequest,
			HttpServletResponse httpresponse) {
		return getUIFModelAndView(form,
				CourseSearchConstants.COURSE_SEARCH_RESULT_PAGE);
	}

	public List<String> getResults(SearchRequestInfo request, String division,
			String code) {

		if (division != null && code != null) {
			request.addParam("division", division);
			request.addParam("code", code);
		} else if (division != null && code == null)
			request.addParam("division", division);
		else
			return Collections.emptyList();

		request.addParam("lastScheduledTerm", KsapFrameworkServiceLocator
				.getAtpHelper().getLastScheduledAtpId());
		request.addParam("currentTerm", KsapFrameworkServiceLocator
				.getAtpHelper().getCurrentAtpId());
		SearchResult searchResult;
		try {
			if ((searchResult = KsapFrameworkServiceLocator.getCluService()
					.search(request,
							KsapFrameworkServiceLocator.getContext()
									.getContextInfo())) == null)
				return Collections.emptyList();
		} catch (MissingParameterException e) {
			throw new IllegalArgumentException("CLU lookup error", e);
		} catch (InvalidParameterException e) {
			throw new IllegalArgumentException("CLU lookup error", e);
		} catch (OperationFailedException e) {
			throw new IllegalStateException("CLU lookup error", e);
		} catch (PermissionDeniedException e) {
			throw new IllegalStateException("CLU lookup error", e);
		}
		List<String> results = new java.util.ArrayList<String>(searchResult
				.getRows().size());
		for (SearchResultRow row : searchResult.getRows())
			results.add(searcher.getCellValue(row, "courseCode"));
		return results;
	}

}
