var BUBBLEPOPUP_DEFAULT_OPTIONS = {
    position: 'bottom',
    align: 'left',
    tail: { align:'left', hidden:false },
    manageMouseEvents: false,
    themePath: '../krad/plugins/tooltip/jquerybubblepopup-theme/',
    themeName: 'ks-form',
    closingSpeed: 125
};


/*******************************************************************************
 *  Open a hidden section in a jquery bubblepopup using an event like onclick
 *  and freeze it until the user clicks outside of the popup, or on the
 *  optional close button.
 *  Parameters:
 *      e            : event object (required)
 *      contentId    : id of hidden section with content (required)
 *      popupOptions : map of bubblepopup options (optional)
 *      closeButton  : when true, a small close button is rendered in the
 *                     top-right corner of the popup (optional)
 ******************************************************************************/
function openPopupContent(e, contentId, popupOptions, closeButton) {
   _openPopupContentFunction(e, contentId, popupOptions, closeButton)
}

/*******************************************************************************
 *  Open a hidden section in a jquery bubblepopup after an ajax call and
 *  freeze it until the user clicks outside of the popup, or on the optional
 *  close button.
 *  Parameters:
 *      targetId     : target id to receive popup (required)
 *      contentId    : id of hidden section with content (required)
 *      popupOptions : map of bubblepopup options (optional)
 *      closeButton  : when true, a small close button is rendered in the
 *                     top-right corner of the popup (optional)
 ******************************************************************************/
function openPopupContentViaAjax(targetId, contentId, popupOptions, closeButton) {
    _openPopupContentFunction(targetId, contentId, popupOptions, closeButton);
}


var gCurrentBubblePopupId;
// PAGE_LOAD_EVENT is probably better, but not available in Rice 2.2.0
jQuery(document).on(kradVariables.VALIDATION_SETUP_EVENT, function(event) {
    openPopupContentsWithErrors();
});


/*******************************************************************************
 *  Locate all bubblepopup content and see if any have a error displayed (via
 *  class "uif-hasError").  If so, locate the action which opens the content
 *  and submit the click event for that action.
 ******************************************************************************/
function openPopupContentsWithErrors() {
    var hiddenScript,popupFormId;
    var bubblePopupContent = {};
    jQuery("div.uif-bubblepopup-content").each(function(){
        if (bubblePopupContent[this.id] == true) {
            // .detach() apparently creates duplicates in the DOM, and this code eliminates them
            return false;
        }
        bubblePopupContent[this.id] = true;

        if (jQuery('.uif-hasError',jQuery(this)).length > 0) {
            popupFormId = this.id;
            // find the action linked to this popup via the openPopupContent() function:
            jQuery('.uif-action').siblings('input[type="hidden"][data-role="script"]').each(function(){
                hiddenScript = jQuery(this).val();
                if ((hiddenScript.indexOf('openPopupContent') != -1)
                    &&  (hiddenScript.indexOf(popupFormId) != -1)) {
                    var saveSpeed = (typeof BUBBLEPOPUP_DEFAULT_OPTIONS['openingSpeed'] === "undefined") ?
                        -1 : BUBBLEPOPUP_DEFAULT_OPTIONS['openingSpeed'];
                    BUBBLEPOPUP_DEFAULT_OPTIONS['openingSpeed'] = 1;  // open popup as fast as possible
                    jQuery('#'+jQuery(this).attr('data-for')).click();
                    BUBBLEPOPUP_DEFAULT_OPTIONS['openingSpeed'] = saveSpeed;
                    return false;  // break from .each
                }
            });
        }
    });
}


/*******************************************************************************
 *  Attempt to prevent event from bubbling up
 ******************************************************************************/
function stopEvent(e) {
    if (!e) {
        var e = window.event
    };
    if (e.stopPropagation) {
        e.preventDefault();
        e.stopPropagation();
    } else {
        e.returnValue = false;
        e.cancelBubble = true;
    }
    return false;
}



/*** PRIVATE METHODS **********************************************************/

// See documentation for "openPopupContent" functions, above
function _openPopupContentFunction(source, contentId, popupOptions, closeButton) {
    var popupTarget;
    if (typeof source === "string") {
        popupTarget = jQuery("#" + source);
    } else {  // source is a trigger event
        stopEvent(source);
        popupTarget = jQuery((source.currentTarget) ? source.currentTarget : source.srcElement);
    }

    // save open property before closing popups
    var isPopupOpen = popupTarget.IsBubblePopupOpen();

    // close the current popup
    if (gCurrentBubblePopupId) {
        _hideBubblePopup(jQuery("#"+gCurrentBubblePopupId));
    }
    //jQuery(".uif-tooltip").HideAllBubblePopups(); // probably not needed

    if (isPopupOpen) {  // action toggles popup on/off
        return;
    }

    gCurrentBubblePopupId = popupTarget.attr('id');
    var clickName = "click." + gCurrentBubblePopupId;

    // add required class uif-tooltip to action and create popup
    if (!popupTarget.HasBubblePopup()) {
        popupTarget.addClass("uif-tooltip");
        //initBubblePopups();  // shotgun approach to CreateBubblePopup, versus...
        popupTarget.CreateBubblePopup(".uif-tooltip");

        var popupContent = jQuery("#" + contentId);

        if (closeButton) {
            var closeButton = jQuery('<div class="uif-popup-closebutton"/>');
            closeButton.on( clickName, function(){_hideBubblePopup(popupTarget)} );
            popupContent.prepend(closeButton);
        }

        // Odd error work-around with 2 popup forms: pressing Enter in a text
        // field on the second popup causes a click event on the first button.
        // True.
        jQuery("input,select",popupContent).keypress(function(event){
            if (event.keyCode == 10 || event.keyCode == 13) {
                stopEvent(event);
            }
        });
    }

    var clonedDefaultOptions = jQuery.extend({}, BUBBLEPOPUP_DEFAULT_OPTIONS);
    jQuery.extend(clonedDefaultOptions, popupOptions, {innerHtmlId:contentId});
    popupTarget.ShowBubblePopup(clonedDefaultOptions,true);
    popupTarget.FreezeBubblePopup();

    // close popup on any click outside current popup
    jQuery(document).on(clickName, function(e) {
        var docTarget = jQuery((e.target) ? e.target : e.srcElement);
        if (docTarget.parents("div.jquerybubblepopup").length === 0) {
            _hideBubblePopup(popupTarget);
        }
    });

    // Note: afterHidden property causes openPopupContentsWithErrors() to break
    function _hideBubblePopup(target) {
        target.HideBubblePopup();
        jQuery(document).off("click."+target.attr('id'));
        gCurrentBubblePopupId = "";
    }
}
