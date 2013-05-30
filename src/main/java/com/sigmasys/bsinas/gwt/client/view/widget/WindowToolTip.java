package com.sigmasys.bsinas.gwt.client.view.widget;

import com.extjs.gxt.ui.client.core.XDOM;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Point;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.RootPanel;

import java.util.Date;

/**
 * A subclass of {@link com.extjs.gxt.ui.client.widget.Window} which mimics the behavior
 * of (and is based on the source code of) a {@link com.extjs.gxt.ui.client.widget.tips.ToolTip}.
 *
 * @author Michael Ivanov
 */
public class WindowToolTip extends Window {

    private int quickShowInterval = 250;
    private boolean constrainPosition = true;
    private boolean autoHide = true;
    private int dismissDelay = 5000;
    private int hideDelay = 200;
    private int[] mouseOffset = new int[]{10, 10};
    private int showDelay = 500;
    private boolean trackMouse;
    private Component target;
    private Point targetXY = new Point(0, 0);
    private Timer dismissTimer;
    private Timer showTimer;
    private Timer hideTimer;
    private Listener<ComponentEvent> listener;
    private Date lastActive;

    private static WindowToolTip previouslyShownWindowToolTip = null;

    /**
     * Creates a new tip instance.
     */
    public WindowToolTip() {
        hidden = true;
        lastActive = new Date();
    }

    /**
     * Creates a new tool tip.
     *
     * @param target the target widget
     */
    public WindowToolTip(Component target) {
        this();
        initTarget(target);
    }

    @Override
    public void hide() {

        clearTimers();
        lastActive = new Date();

        super.hide();

        if (isAttached()) {
            RootPanel.get().remove(this);
        }
    }

    /**
     * Shows this tip at the specified position.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void showAt(int x, int y) {

        if (disabled)
            return;
        lastActive = new Date();
        clearTimers();

        if (!isAttached()) {
            RootPanel.get().add(this);
        }
        super.show();

        Point p = new Point(x, y);
        if (constrainPosition) {
            p = el().adjustForConstraints(p);
        }
        setPagePosition(p.x + XDOM.getBodyScrollLeft(), p.y
                + XDOM.getBodyScrollTop());
        el().setVisibility(true);

        if (dismissDelay > 0 && autoHide) {
            dismissTimer = new Timer() {
                public void run() {
                    hide();
                }
            };
            dismissTimer.schedule(dismissDelay);
        }

    }

    /**
     * Shows this tip at the specified position.
     *
     * @param point the position
     */
    public void showAt(Point point) {
        showAt(point.x, point.y);
    }

    @Override
    protected void onDisable() {
        super.onDisable();
        hide();
    }

    public void initTarget(final Component target) {
        if (this.target != null) {
            this.target.removeListener(Events.OnMouseOver, listener);
            this.target.removeListener(Events.OnMouseOut, listener);
            this.target.removeListener(Events.OnMouseMove, listener);
            this.target.removeListener(Events.Hide, listener);
            this.target.removeListener(Events.Detach, listener);
            this.target.removeListener(Events.Render, listener);
        }

        this.target = target;
        if (listener == null) {
            listener = new Listener<ComponentEvent>() {
                public void handleEvent(ComponentEvent be) {
                    Element source = target.getElement();
                    EventType type = be.getType();
                    if (type == Events.OnMouseOver) {
                        Element from = DOM.eventGetFromElement(be.getEvent());
                        if (from != null && !DOM.isOrHasChild(source, from)) {
                            onTargetOver(be);
                        }
                    } else if (type == Events.OnMouseOut) {
                        Element to = DOM.eventGetToElement(be.getEvent());
                        if (to != null && !DOM.isOrHasChild(source, to)) {
                            onTargetOut(be);
                        }
                    } else if (type == Events.OnMouseMove) {
                        onMouseMove(be);
                    } else if (type == Events.Hide || type == Events.Detach) {
                        hide();
                    }
                }
            };
        }
        if (target != null) {
            target.addListener(Events.OnMouseOver, listener);
            target.addListener(Events.Render, listener);
            target.addListener(Events.OnMouseOut, listener);
            target.addListener(Events.OnMouseMove, listener);
            target.addListener(Events.Hide, listener);
            target.addListener(Events.Detach, listener);
            target.sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT
                    | Event.ONMOUSEMOVE);
        }
    }

    @Override
    public void show() {

        if (previouslyShownWindowToolTip != null) {
            previouslyShownWindowToolTip.hide();
        }

        if (disabled) {
            return;
        }

        showAt(getTargetXY(0));

        previouslyShownWindowToolTip = this;

    }

    protected void clearTimer(String timer) {
        if (timer.equals("hide")) {
            if (hideTimer != null) {
                hideTimer.cancel();
                hideTimer = null;
            }
        } else if (timer.equals("dismiss")) {
            if (dismissTimer != null) {
                dismissTimer.cancel();
                dismissTimer = null;
            }
        } else if (timer.equals("show")) {
            if (showTimer != null) {
                showTimer.cancel();
                showTimer = null;
            }
        }
    }

    protected void clearTimers() {
        clearTimer("show");
        clearTimer("dismiss");
        clearTimer("hide");
    }

    protected void delayShow() {
        if (hidden && showTimer == null) {
            if ((new Date().getTime() - lastActive.getTime()) < quickShowInterval) {
                show();
            } else {
                showTimer = new Timer() {
                    public void run() {
                        show();
                    }
                };
                showTimer.schedule(showDelay);
            }

        } else if (!hidden && autoHide) {
            show();
        }
    }

    protected void onMouseMove(ComponentEvent ce) {
        targetXY = ce.getXY();
        if (!hidden && trackMouse) {
            Point p = getTargetXY(0);
            if (constrainPosition) {
                p = el().adjustForConstraints(p);
            }
            setPagePosition(p);
        }
    }

    protected void onTargetOut(ComponentEvent ce) {
        if (disabled) {
            return;
        }
        clearTimer("show");
        if (autoHide) {
            delayHide();
        }
    }

    protected void onTargetOver(ComponentEvent ce) {
        if (disabled || !ce.within(target.getElement())) {
            return;
        }

        clearTimer("hide");
        targetXY = ce.getXY();
        delayShow();
    }

    private void delayHide() {
        if (!hidden && hideTimer == null) {
            if (hideDelay == 0) {
                hide();
                return;
            }
            hideTimer = new Timer() {
                public void run() {
                    hide();
                }
            };
            hideTimer.schedule(hideDelay);
        }
    }

    private Point getTargetXY(int targetCounter) {
        int[] mouseOffset = this.mouseOffset;
        int x = targetXY.x + mouseOffset[0];
        int y = targetXY.y + mouseOffset[1];
        return new Point(x, y);
    }

    /**
     * Returns the quick show interval.
     *
     * @return the quick show interval
     */
    public int getQuickShowInterval() {
        return quickShowInterval;
    }

    /**
     * Sets the quick show interval (defaults to 250).
     *
     * @param quickShowInterval the quick show interval
     */
    public void setQuickShowInterval(int quickShowInterval) {
        this.quickShowInterval = quickShowInterval;
    }

    public boolean isAutoHide() {
        return autoHide;
    }

    public void setAutoHide(boolean autoHide) {
        this.autoHide = autoHide;
    }

    public int getDismissDelay() {
        return dismissDelay;
    }

    public void setDismissDelay(int dismissDelay) {
        this.dismissDelay = dismissDelay;
    }

    public int getHideDelay() {
        return hideDelay;
    }

    public void setHideDelay(int hideDelay) {
        this.hideDelay = hideDelay;
    }

    public int[] getMouseOffset() {
        return mouseOffset;
    }

    public void setMouseOffset(int[] mouseOffset) {
        this.mouseOffset = mouseOffset;
    }

    public int getShowDelay() {
        return showDelay;
    }

    public void setShowDelay(int showDelay) {
        this.showDelay = showDelay;
    }

    public boolean isTrackMouse() {
        return trackMouse;
    }

    public void setTrackMouse(boolean trackMouse) {
        this.trackMouse = trackMouse;
    }

}
