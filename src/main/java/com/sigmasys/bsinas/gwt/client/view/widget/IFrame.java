package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.Style;
import com.google.gwt.dom.client.BodyElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.FrameElement;
import com.google.gwt.user.client.ui.Frame;

/**
 * An extension to GWT version of iframe.
 * <p/>
 *
 * @author Michael Ivanov
 */
public class IFrame extends Frame {

    private boolean updateNeeded;

    public IFrame(String url) {
        super(url);
        setFrameBorder(0);
    }

    public IFrame(String url, String style) {
        this(url);
        setStyleName(style);
    }

    protected FrameElement getFrameElement() {
        return getElement().cast();
    }

    public void setFrameBorder(int frameBorder) {
        getFrameElement().setFrameBorder(frameBorder);
    }

    public void setMarginHeight(int marginHeight) {
        getFrameElement().setMarginHeight(marginHeight);
    }

    public void setMarginWidth(int marginWidth) {
        getFrameElement().setMarginWidth(marginWidth);
    }

    public void setName(String name) {
        getFrameElement().setName(name);
    }

    public boolean isUpdateNeeded() {
        return updateNeeded;
    }

    public void setUpdateNeeded(boolean updateNeeded) {
        this.updateNeeded = updateNeeded;
    }

    public void setContent(String html) {
        Document document = getFrameElement().getContentDocument();
        if (document != null) {
            BodyElement body = document.getBody();
            if (body != null) {
                body.setInnerHTML(html);
            }
        }
    }

    public String getContent() {
        Document document = getFrameElement().getContentDocument();
        if (document != null) {
            BodyElement body = document.getBody();
            if (body != null) {
                return body.getInnerHTML();
            }
        }
        return null;
    }

    public void setScrollMode(Style.Scroll scroll) {
        switch (scroll) {
            case AUTO:
                getFrameElement().setScrolling("auto");
                break;
            case ALWAYS:
                getFrameElement().setScrolling("yes");
                break;
            case NONE:
                getFrameElement().setScrolling("no");
        }
    }

}
