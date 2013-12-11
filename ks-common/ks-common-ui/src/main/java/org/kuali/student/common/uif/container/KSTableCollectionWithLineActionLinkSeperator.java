package org.kuali.student.common.uif.container;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.kuali.rice.krad.uif.component.Component;
import org.kuali.rice.krad.uif.container.CollectionGroupBase;
import org.kuali.rice.krad.uif.element.Action;

/**
 * Created with IntelliJ IDEA.
 * User: aliabad4
 * Date: 5/3/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class KSTableCollectionWithLineActionLinkSeperator extends CollectionGroupBase {

    private String lineActionSeparator = "";

    public String getLineActionSeparator() {
        return lineActionSeparator;
    }

    public void setLineActionSeparator(String lineActionSeparator) {
        this.lineActionSeparator = lineActionSeparator;
    }

    public List<? extends Component> getLineActions(){
        List<? extends Component> actions = super.getLineActions();
        List<Component> returnedActions = null;
        if(actions != null && super.isRenderLineActions()){
            returnedActions = new ArrayList<Component>();
            int index = 0;
            for(Component action: actions){
                index++;
                returnedActions.add(action);
                if(index < actions.size()) {
                    Action a = new Action();
                    String id = action.getId() + "lineActionSeparator" + index;
                    a.addStyleClass("ks-line-action-seperator");
                    a.setOnClickScript("return false;");
                    a.setId(id);
                    a.setTemplate(a.getTemplate());
                    a.setTemplateName(action.getTemplateName());
                    a.setMethodToCall("");
                    a.setActionEvent("");
                    a.setActionLabel(lineActionSeparator);
                    a.setFocusOnIdAfterSubmit(id);
                    a.setRender(action.isRender());
                    a.setContext(new HashMap<String, Object>(action.getContext()));
                    a.setExpressionGraph(new HashMap<String, String>(action.getExpressionGraph()));
                    a.setRefreshExpressionGraph(new HashMap<String, String>(action.getRefreshExpressionGraph()));
                    a.setPropertyExpressions(new HashMap<String, String>(action.getPropertyExpressions()));
                    returnedActions.add(a);
                }
            }
        }
        return returnedActions;
    }

    /**
     * @see org.kuali.rice.krad.uif.component.ComponentBase#copy()
     */
    @Override
    protected <T> void copyProperties(T component) {
        super.copyProperties(component);

        KSTableCollectionWithLineActionLinkSeperator ksTableCollectionWithLineActionLinkSeperatorCopy = (KSTableCollectionWithLineActionLinkSeperator) component;

        ksTableCollectionWithLineActionLinkSeperatorCopy.setLineActionSeparator(this.lineActionSeparator);
    }
}