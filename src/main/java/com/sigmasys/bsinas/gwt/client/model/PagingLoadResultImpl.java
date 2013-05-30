package com.sigmasys.bsinas.gwt.client.model;

import com.extjs.gxt.ui.client.data.PagingLoadResult;

import java.io.Serializable;
import java.util.List;

/**
 * PagingResult.
 *
 * @author Michael Ivanov
 */
public class PagingLoadResultImpl<T extends Serializable> implements PagingLoadResult<T>, Serializable {

    private int offset;
    private int totalLength;
    private List<T> data;

    public PagingLoadResultImpl() {}

    public PagingLoadResultImpl(List<T> data) {
        this(data, 0, data.size());
    }

    public PagingLoadResultImpl(List<T> data, int offset, int totalLength) {
       this.data = data;
       this.offset = offset;
       this.totalLength = totalLength;
    }

    public int getOffset() {
        return offset;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setTotalLength(int totalLength) {
        this.totalLength = totalLength;
    }

    public List<T> getData() {
        return data;
    }
    
    public void setData(List<T> data) {
        this.data = data;
    }
}
