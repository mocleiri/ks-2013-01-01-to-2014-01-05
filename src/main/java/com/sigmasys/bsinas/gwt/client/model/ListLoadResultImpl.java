package com.sigmasys.bsinas.gwt.client.model;

import com.extjs.gxt.ui.client.data.ListLoadResult;

import java.io.Serializable;
import java.util.List;

/**
 * ListLoadResultImpl
 *
 * @param <T> Serializable type
 * @author Michael Ivanov
 */

public class ListLoadResultImpl<T extends Serializable> implements ListLoadResult<T>, Serializable {

    private List<T> data;

    public ListLoadResultImpl() {
    }

    public ListLoadResultImpl(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
