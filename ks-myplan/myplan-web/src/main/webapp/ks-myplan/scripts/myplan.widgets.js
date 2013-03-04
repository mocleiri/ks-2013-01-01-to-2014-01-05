function readUrlHash(key) {
    if (window.location.href.split("#")[1]) {
        var aHash = window.location.href.split("#")[1].replace('#', '').split('&');
        var oHash = {};
        jQuery.each(aHash, function (index, value) {
            oHash[value.split('=')[0]] = value.split('=')[1];
        });
        if (oHash[key]) {
            if (decodeURIComponent(oHash[key]) == "true" || decodeURIComponent(oHash[key]) == "false") {
                return (decodeURIComponent(oHash[key]) == "true");
            } else {
                return decodeURIComponent(oHash[key]);
            }
        } else {
            return false;
        }
    } else {
        return false;
    }
}

function setUrlHash(key, value) {
    var aHash = [];
    if (window.location.href.split("#")[1]) {
        aHash = window.location.href.split("#")[1].replace('#', '').split('&');
    }
    var oHash = {};
    if (aHash.length > 0) {
        jQuery.each(aHash, function (index, value) {
            oHash[decodeURIComponent(value.split('=')[0])] = decodeURIComponent(value.split('=')[1]);
        });
        var oTemp = {};
        oTemp[key] = value;
        jQuery.extend(oHash, oTemp);
    } else {
        oHash[key] = value;
    }
    aHash = [];
    for (var key in oHash) {
        if (key != "" && oHash[key] != "") aHash.push(encodeURIComponent(key) + "=" + encodeURIComponent(oHash[key]));
    }
    window.location.replace("#" + aHash.join("&"));
}

function readUrlParam(key) {
    var aParams = window.location.search.replace('?', '').split('&');
    var oParams = {};
    jQuery.each(aParams, function (index, value) {
        oParams[value.split('=')[0]] = value.split('=')[1];
    });
    if (oParams[key]) {
        return decodeURIComponent(oParams[key]);
    } else {
        return false;
    }
}

function setUrlParam(key, value) {
    var aParams = [];
    if (window.location.search) {
        aParams = window.location.search.replace('?', '').split('&');
    }
    var oParams = {};
    if (aParams.length > 0) {
        jQuery.each(aParams, function (index, value) {
            oParams[value.split('=')[0]] = value.split('=')[1];
        });
        var oTemp = {};
        oTemp[key] = value;
        jQuery.extend(oParams, oTemp);
    } else {
        oParams[key] = value;
    }
    aParams = [];
    for (var key in oParams) {
        if (key != "" && oParams[key] != "") aParams.push(encodeURIComponent(key) + "=" + encodeURIComponent(oParams[key]));
    }
    window.location.replace(window.location.protocol + "//" + window.location.host + window.location.pathname + "?" + aParams.join("&"));
}

/* This is for DOM changes to refresh the view on back to keep the view updated */
if (readUrlHash("modified")) {
    var url = window.location.href;
    var aHash = window.location.href.split("#")[1].replace("#", "").split("&");
    aHash.splice("modified=true", 1);
    window.location.assign(url.split("#")[0] + ((aHash.length > 0) ? "#" + aHash.join("&") : ""));
}

jQuery(document).ready(function () {
    jQuery("head").append('<!--[if ie 9]><style type="text/css" media="screen"> \
        button.uif-primaryActionButton,button.uif-secondaryActionButton, \
        button.uif-primaryActionButton:hover,button.uif-secondaryActionButton:hover,\
        button.uif-primaryActionButton[disabled="true"],\
        button.uif-primaryActionButton[disabled="disabled"],\
        button.uif-primaryActionButton[disabled="true"]:hover,\
        button.uif-primaryActionButton[disabled="disabled"]:hover,\
        button.uif-secondaryActionButton[disabled="true"],\
        button.uif-secondaryActionButton[disabled="disabled"],\
        button.uif-secondaryActionButton[disabled="true"]:hover,\
        button.uif-secondaryActionButton[disabled="disabled"]:hover{ \
            filter:none !important;}</style><![endif]-->\
    ');
});

function sessionExpired() {
    window.location = '/student/myplan/sessionExpired';
}

function stopEvent(e) {
    if (!e) var e = window.event;
    if (e.stopPropagation) {
        e.preventDefault();
        e.stopPropagation();
    } else {
        e.returnValue = false;
        e.cancelBubble = true;
    }
    return false;
}

function openCourse(courseId, e) {
    stopEvent(e);
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    if (jQuery(target).parents(".jquerybubblepopup.jquerybubblepopup-myplan").length > 0) {
        window.location = "inquiry?methodToCall=start&viewId=CourseDetails-InquiryView&courseId=" + courseId;
    } else {
        openPlanItemPopUp(courseId, 'add_remove_course_popover_page', {courseId:courseId}, e, null, {tail:{align:'left'}, align:'left', position:'bottom', alwaysVisible:'false'}, true);
    }
}
/*
 ######################################################################################
 Function: Launch generic bubble popup
 ######################################################################################
 */
function openPopUp(id, getId, methodToCall, action, retrieveOptions, e, selector, popupStyles, popupOptions, close) {
    stopEvent(e);

    var popupHtml = jQuery('<div />').attr("id", id + "_popup");

    if (popupStyles) {
        jQuery.each(popupStyles, function (property, value) {
            jQuery(popupHtml).css(property, value);
        });
    }

    var popupOptionsDefault = {
        innerHtml:popupHtml.wrap("<div>").parent().clone().html(),
        themePath:'../ks-myplan/jquery-bubblepopup/jquerybubblepopup-theme/',
        manageMouseEvents:true,
        selectable:true,
        tail:{align:'middle', hidden:false},
        position:'left',
        align:'center',
        alwaysVisible:false,
        themeMargins:{total:'20px', difference:'5px'},
        themeName:'myplan',
        distance:'0px',
        openingSpeed:0,
        closingSpeed:0
    };

    var popupSettings = jQuery.extend(popupOptionsDefault, popupOptions);

    var popupBox;
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    if (selector === null) {
        popupBox = jQuery(target);
    } else {
        popupBox = jQuery(target).parents(selector);
    }

    fnCloseAllPopups();

    popupBox.CreateBubblePopup({manageMouseEvents:false});
    popupBox.ShowBubblePopup(popupSettings, false);
    var popupBoxId = popupBox.GetBubblePopupID();
    popupBox.FreezeBubblePopup();

    jQuery(document).on('click', function (e) {
        var tempTarget = (e.target) ? e.target : e.srcElement;
        if (jQuery(tempTarget).parents("div.jquerybubblepopup.jquerybubblepopup-myplan").length === 0) {
            popupBox.RemoveBubblePopup();
            fnCloseAllPopups();
        }
    });

    var tempForm = jQuery('<form />').attr("id", id + "_form").attr("action", action).attr("method", "post").hide();
    var tempFormInputs = '<div style="display:none;">';
    jQuery.each(retrieveOptions, function (name, value) {
        tempFormInputs += '<input type="hidden" name="' + name + '" value="' + value + '" />';
    });
    tempFormInputs += '</div>';
    jQuery(tempForm).append(tempFormInputs);
    jQuery("body").append(tempForm);

    var elementToBlock = jQuery("#" + id + "_popup");

    var updateRefreshableComponentCallback = function (htmlContent) {
        var component;
        if (jQuery("span#request_status_item_key", htmlContent).length <= 0) {
            component = jQuery("#" + getId, htmlContent);
        } else {
            eval(jQuery("input[data-for='plan_item_action_response_page']", htmlContent).val().replace("#plan_item_action_response_page", "body"));
            var sError = '<img src="/student/ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverErrors[0] + '</span>';
            component = jQuery("<div />").html(sError).addClass("myplan-feedback error").width(175);
        }
        elementToBlock.unblock({onUnblock:function () {
            if (jQuery("#" + id + "_popup").length) {
                popupBox.SetBubblePopupInnerHtml(component);
                if (close || typeof close === 'undefined') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").append('<img src="../ks-myplan/images/btnClose.png" class="myplan-popup-close"/>');
                jQuery("#" + popupBoxId + " img.myplan-popup-close").on('click', function () {
                    popupBox.RemoveBubblePopup();
                    fnCloseAllPopups();
                });
            }
            runHiddenScripts(getId);
        }});
    };

    myplanAjaxSubmitForm(methodToCall, updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:"false"}, elementToBlock, id);
    jQuery("form#" + id + "_form").remove();
}


function openMenu(id, getId, atpId, e, selector, popupClasses, popupOptions, close) {
    stopEvent(e);
    if (atpId != null) {
        var openForPlanning = jQuery('input[id^="' + atpId + '_plan_status"]').val()

        if (openForPlanning == "false" && getId != "completed_menu_items") {
            getId = "completed_backup_menu_items"
        }
    }


    var popupHtml = jQuery('<div />').attr("id", id + "_popup").attr("class", popupClasses).html(jQuery("#" + getId).html());

    var popupOptionsDefault = {
        innerHtml:popupHtml.wrap("<div>").parent().clone().html(),
        themePath:'../ks-myplan/jquery-bubblepopup/jquerybubblepopup-theme/',
        manageMouseEvents:true,
        selectable:true,
        tail:{align:'middle', hidden:false},
        position:'left',
        align:'center',
        alwaysVisible:false,
        themeMargins:{total:'20px', difference:'5px'},
        themeName:'myplan',
        distance:'0px',
        openingSpeed:0,
        closingSpeed:0
    };

    var popupSettings = jQuery.extend(popupOptionsDefault, popupOptions);

    var popupBox;
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    if (selector === null) {
        popupBox = jQuery(target);
    } else {
        popupBox = jQuery(target).parents(selector);
    }

    fnCloseAllPopups();

    popupBox.CreateBubblePopup({manageMouseEvents:false});
    popupBox.ShowBubblePopup(popupSettings, false);
    var popupBoxId = popupBox.GetBubblePopupID();
    popupBox.FreezeBubblePopup();

    jQuery("#" + id + "_popup a").each(function () {
        var linkId = jQuery(this).attr("id");
        jQuery(this).siblings("input[data-for='" + linkId + "']").removeAttr("script").attr("name", "script").val(function (index, value) {
            return value.replace("'" + linkId + "'", "'" + linkId + "_popup'");
        });
        jQuery(this).attr("id", linkId + "_popup");
        jQuery.each(jQuery(target).data(), function (key, value) {
            jQuery("#" + linkId + "_popup").attr("data-" + key, value);
        });
    });

    if (close || typeof close === 'undefined') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").append('<img src="../ks-myplan/images/btnClose.png" class="myplan-popup-close"/>');

    runHiddenScripts(id + "_popup");

    jQuery(document).on('click', function (e) {
        var tempTarget = (e.target) ? e.target : e.srcElement;
        if (jQuery(tempTarget).parents("div.jquerybubblepopup.jquerybubblepopup-myplan").length === 0) {
            popupBox.RemoveBubblePopup();
            fnCloseAllPopups();
        }
    });
}

/*
 ######################################################################################
 Function: Launch generic bubble popup
 ######################################################################################
 */
function openPopUpForm(id, getId, methodToCall, action, retrieveOptions, e, selector, popupStyles, popupOptions, close) {
    stopEvent(e);

    var popupHtml = jQuery('<div />').attr("id", id + "_popup");

    if (popupStyles) {
        jQuery.each(popupStyles, function (property, value) {
            jQuery(popupHtml).css(property, value);
        });
    }

    var popupOptionsDefault = {
        innerHtml:popupHtml.wrap("<div>").parent().clone().html(),
        themePath:'../ks-myplan/jquery-bubblepopup/jquerybubblepopup-theme/',
        manageMouseEvents:true,
        selectable:true,
        tail:{align:'middle', hidden:false},
        position:'left',
        align:'center',
        alwaysVisible:false,
        themeMargins:{total:'20px', difference:'5px'},
        themeName:'myplan',
        distance:'10px',
        openingSpeed:0,
        closingSpeed:0
    };

    var popupSettings = jQuery.extend(popupOptionsDefault, popupOptions);

    var popupBox;
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    if (selector === null) {
        popupBox = jQuery(target);
    } else {
        popupBox = jQuery(target).parents(selector);
    }

    fnCloseAllPopups();

    popupBox.CreateBubblePopup({manageMouseEvents:false});
    popupBox.ShowBubblePopup(popupSettings, false);
    var popupBoxId = popupBox.GetBubblePopupID();
    popupBox.FreezeBubblePopup();

    jQuery(document).on('click', function (e) {
        var tempTarget = (e.target) ? e.target : e.srcElement;
        if (jQuery(tempTarget).parents("div.jquerybubblepopup.jquerybubblepopup-myplan").length === 0) {
            popupBox.RemoveBubblePopup();
            fnCloseAllPopups();
        }
    });

    var tempForm = jQuery('<form />').attr("id", id + "_form").attr("action", action).attr("method", "post").hide();
    var tempFormInputs = '<div style="display:none;">';
    jQuery.each(retrieveOptions, function (name, value) {
        tempFormInputs += '<input type="hidden" name="' + name + '" value="' + value + '" />';
    });
    tempFormInputs += '</div>';
    jQuery(tempForm).append(tempFormInputs);
    jQuery("body").append(tempForm);

    var elementToBlock = jQuery("#" + id + "_popup");

    var updateRefreshableComponentCallback = function (htmlContent) {
        var component;
        if (jQuery("span#request_status_item_key", htmlContent).length <= 0) {
            component = jQuery("#" + getId, htmlContent);
            var planForm = jQuery('<form />').attr("id", id + "_form").attr("action", "plan").attr("method", "post");
        } else {
            eval(jQuery("input[data-for='plan_item_action_response_page']", htmlContent).val().replace("#plan_item_action_response_page", "body"));
            var sError = '<img src="/student/ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverErrors[0] + '</span>';
            component = jQuery("<div />").html(sError).addClass("myplan-feedback error").width(175);
        }
        elementToBlock.unblock({onUnblock:function () {
            if (jQuery("#" + id + "_popup").length) {
                popupBox.SetBubblePopupInnerHtml(component);
                jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").wrapInner(planForm);
                if (close || typeof close === 'undefined') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").append('<img src="../ks-myplan/images/btnClose.png" class="myplan-popup-close"/>');
                jQuery("#" + popupBoxId + " img.myplan-popup-close").on('click', function () {
                    popupBox.RemoveBubblePopup();
                    fnCloseAllPopups();
                });
            }
            runHiddenScripts(getId);
        }});
    };

    myplanAjaxSubmitForm(methodToCall, updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:"false"}, elementToBlock, id);
    jQuery("form#" + id + "_form").remove();
}


/*
 ######################################################################################
 Function: Launch plan item bubble popup
 ######################################################################################
 */
function openPlanItemPopUp(id, getId, retrieveOptions, e, selector, popupOptions, close) {
    stopEvent(e);

    var popupHtml = jQuery('<div />').attr("id", id + "_popup").css({
        width:"300px",
        height:"16px"
    });

    var popupOptionsDefault = {
        innerHtml:popupHtml.wrap("<div>").parent().clone().html(),
        themePath:'../ks-myplan/jquery-bubblepopup/jquerybubblepopup-theme/',
        manageMouseEvents:true,
        selectable:true,
        tail:{align:'middle', hidden:false},
        position:'left',
        align:'center',
        alwaysVisible:false,
        themeMargins:{total:'18px', difference:'5px'},
        themeName:'myplan',
        distance:'10px',
        openingSpeed:0,
        closingSpeed:0
    };

    var popupSettings = jQuery.extend(popupOptionsDefault, popupOptions);

    var popupBox;
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    if (selector === null) {
        popupBox = jQuery(target);
    } else {
        popupBox = jQuery(target).parents(selector);
    }

    fnCloseAllPopups();

    popupBox.CreateBubblePopup({manageMouseEvents:false});
    popupBox.ShowBubblePopup(popupSettings, false);
    var popupBoxId = popupBox.GetBubblePopupID();
    fnPositionPopUp(popupBoxId);
    popupBox.FreezeBubblePopup();

    jQuery(document).on('click', function (e) {
        var tempTarget = (e.target) ? e.target : e.srcElement;
        if (jQuery(tempTarget).parents("div.jquerybubblepopup.jquerybubblepopup-myplan").length === 0) {
            popupBox.RemoveBubblePopup();
            fnCloseAllPopups();
        }
    });

    var tempForm = jQuery('<form />').attr("id", id + "_form").attr("action", "plan").attr("method", "post").hide();
    var tempFormInputs = '<div style="display:none;"><input type="hidden" name="viewId" value="PlannedCourse-FormView" />';
    jQuery.each(retrieveOptions, function (name, value) {
        tempFormInputs += '<input type="hidden" name="' + name + '" value="' + value + '" />';
    });
    tempFormInputs += '</div>';
    jQuery(tempForm).append(tempFormInputs);
    jQuery("body").append(tempForm);

    var elementToBlock = jQuery("#" + id + "_popup");

    var updateRefreshableComponentCallback = function (htmlContent) {
        var component;
        if (jQuery("span#request_status_item_key", htmlContent).length <= 0) {
            component = jQuery("#" + getId, htmlContent);
            var planForm = jQuery('<form />').attr("id", id + "_form").attr("action", "plan").attr("method", "post");
        } else {
            eval(jQuery("input[data-for='plan_item_action_response_page']", htmlContent).val().replace("#plan_item_action_response_page", "body"));
            var sError = '<img src="/student/ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverErrors[0] + '</span>';
            component = jQuery("<div />").html(sError).addClass("myplan-feedback error").width(175);
        }
        elementToBlock.unblock({onUnblock:function () {
            if (jQuery("#" + id + "_popup").length) {
                popupBox.SetBubblePopupInnerHtml(component);
                fnPositionPopUp(popupBoxId);
                if (status != 'error') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").wrapInner(planForm);
                if (close || typeof close === 'undefined') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").append('<img src="../ks-myplan/images/btnClose.png" class="myplan-popup-close"/>');
                jQuery("#" + popupBoxId + " img.myplan-popup-close").on('click', function () {
                    popupBox.RemoveBubblePopup();
                    fnCloseAllPopups();
                });
            }
            runHiddenScripts(getId);
        }});
    };

    myplanAjaxSubmitForm("startAddPlannedCourseForm", updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:"false"}, elementToBlock, id);
    jQuery("form#" + id + "_form").remove();
}
function openDialog(sText, e, close) {
    stopEvent(e);

    var dialogHtml = jQuery('<div />').html(sText).css({
        width:"300px"
    });

    var popupOptionsDefault = {
        innerHtml:dialogHtml.wrap("<div>").parent().clone().html(),
        themePath:'../ks-myplan/jquery-bubblepopup/jquerybubblepopup-theme/',
        manageMouseEvents:true,
        selectable:true,
        tail:{hidden:true},
        position:'top',
        align:'center',
        alwaysVisible:false,
        themeMargins:{total:'20px', difference:'5px'},
        themeName:'myplan',
        distance:'0px',
        openingSpeed:0,
        closingSpeed:0
    };

    var popupBox = jQuery("body");

    fnCloseAllPopups();

    popupBox.CreateBubblePopup({manageMouseEvents:false});
    popupBox.ShowBubblePopup(popupOptionsDefault, false);
    var popupBoxId = popupBox.GetBubblePopupID();
    popupBox.FreezeBubblePopup();

    if (close || typeof close === 'undefined') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").append('<img src="../ks-myplan/images/btnClose.png" class="myplan-popup-close"/>');

    fnPositionPopUp(popupBoxId);

    jQuery(document).on('click', function (e) {
        var tempTarget = (e.target) ? e.target : e.srcElement;
        if (jQuery(tempTarget).parents("div.jquerybubblepopup.jquerybubblepopup-myplan").length === 0) {
            popupBox.RemoveBubblePopup();
            fnCloseAllPopups();
        }
    });

    jQuery("#" + popupBoxId + " img.myplan-popup-close").on('click', function () {
        popupBox.RemoveBubblePopup();
        fnCloseAllPopups();
    });
}

function fnPositionPopUp(popupBoxId) {
    if (parseFloat(jQuery("#" + popupBoxId).css("top")) < 0 || parseFloat(jQuery("#" + popupBoxId).css("left")) < 0) {
        var top = (document.documentElement && document.documentElement.scrollTop) || document.body.scrollTop;
        var left = (document.documentElement && document.documentElement.scrollLeft) || document.body.scrollLeft;
        var iTop = ( top + ( jQuery(window).height() / 2 ) ) - ( jQuery("#" + popupBoxId).height() / 2 );
        var iLeft = ( left + ( jQuery(window).width() / 2 ) ) - ( jQuery("#" + popupBoxId).width() / 2 );
        jQuery("#" + popupBoxId).css({top:iTop + 'px', left:iLeft + 'px'});
    }
}


function myplanWriteHiddenToForm(propertyName, propertyValue, formId) {
    //removing because of performFinalize bug
    jQuery('input[name="' + escapeName(propertyName) + '"]').remove();

    if (propertyValue.indexOf("'") != -1) {
        jQuery("<input type='hidden' name='" + propertyName + "'" + ' value="' + propertyValue + '"/>').appendTo(jQuery("#" + formId));
    } else {
        jQuery("<input type='hidden' name='" + propertyName + "' value='" + propertyValue + "'/>").appendTo(jQuery("#" + formId));
    }
}
/*
 ######################################################################################
 Function: Submit
 ######################################################################################
 */
function myplanAjaxSubmitPlanItem(id, type, methodToCall, e, bDialog) {
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    var targetText = ( jQuery.trim(jQuery(target).text()) != '') ? jQuery.trim(jQuery(target).text()) : "Error";
    var elementToBlock = (target.nodeName != 'INPUT') ? jQuery(target) : jQuery(target).parent();
    jQuery('input[name="methodToCall"]').remove();
    jQuery('#' + id + '_form input[name="' + type + '"]').remove();
    jQuery('#' + id + '_form input[name="viewId"]').remove();
    jQuery("#" + id + "_form").append('<input type="hidden" name="methodToCall" value="' + methodToCall + '" /><input type="hidden" name="' + type + '" value="' + id + '" /><input type="hidden" name="viewId" value="PlannedCourse-FormView" />');
    var updateRefreshableComponentCallback = function (htmlContent) {
        var status = jQuery.trim(jQuery("span#request_status_item_key", htmlContent).text().toLowerCase());
        eval(jQuery("input[data-for='plan_item_action_response_page']", htmlContent).val().replace("#plan_item_action_response_page", "body"));
        elementToBlock.unblock();
        switch (status) {
            case 'success':
                var oMessage = { 'message':'<img src="/student/ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverInfo[0] + '</span>', 'cssClass':'myplan-feedback success' };
                var json = jQuery.parseJSON(jQuery.trim(jQuery("span#json_events_item_key", htmlContent).text()));
                for (var key in json) {
                    if (json.hasOwnProperty(key)) {
                        eval('jQuery.publish("' + key + '", [' + JSON.stringify(jQuery.extend(json[key], oMessage)) + ']);');
                    }
                }
                setUrlHash('modified', 'true');
                break;
            case 'error':
                var oMessage = { 'message':'<img src="/student/ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverErrors[0] + '</span>', 'cssClass':'myplan-feedback error' };
                if (!bDialog) {
                    var sContent = jQuery("<div />").append(oMessage.message).addClass("myplan-feedback error").css({"background-color":"#fff"});
                    var sHtml = jQuery("<div />").append('<div class="uif-headerField uif-sectionHeaderField"><h3 class="uif-header">' + targetText + '</h3></div>').append(sContent);
                    if (jQuery("body").HasBubblePopup()) jQuery("body").RemoveBubblePopup();
                    openDialog(sHtml.html(), e);
                } else {
                    eval('jQuery.publish("ERROR", [' + JSON.stringify(oMessage) + ']);');
                }
                break;
        }
    };
    var blockOptions = {
        message:'<img src="../ks-myplan/images/btnLoader.gif"/>',
        css:{
            width:'100%',
            border:'none',
            backgroundColor:'transparent'
        },
        overlayCSS:{
            backgroundColor:'#fff',
            opacity:0.6,
            padding:'0px 1px',
            margin:'0px -1px'
        }
    };
    myplanAjaxSubmitForm(methodToCall, updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:'false'}, elementToBlock, id, blockOptions);
}

/*Function used for moving the plan Item from planned to backup*/
function myPlanAjaxPlanItemMove(id, type, methodToCall, e) {
    stopEvent(e);
    var tempForm = jQuery('<form />').attr("id", id + "_form").attr("action", "plan").attr("method", "post").hide();
    jQuery("body").append(tempForm);
    myplanAjaxSubmitPlanItem(id, type, methodToCall, e, false);
    fnCloseAllPopups();
    jQuery("form#" + id + "_form").remove();
}

function myplanAjaxSubmitSectionItem(id, methodToCall, action, formData, e) {
    stopEvent(e);
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    var targetText = ( jQuery.trim(jQuery(target).text()) != '') ? jQuery.trim(jQuery(target).text()) : "Error";
    var elementToBlock = (target.nodeName != 'INPUT') ? jQuery(target) : jQuery(target).parent();
    var tempForm = '<form id="' + id + '_form" action="' + action + '" method="post" style="display:none;">';
    tempForm += '<input type="hidden" name="methodToCall" value="' + methodToCall + '" />';
    jQuery.each(formData, function (name, value) {
        tempForm += '<input type="hidden" name="' + name + '" value="' + value + '" />';
    });
    tempForm += '</form>';
    jQuery("body").append(tempForm);

    var updateRefreshableComponentCallback = function (htmlContent) {
        var status = jQuery.trim(jQuery("span#request_status_item_key", htmlContent).text().toLowerCase());
        eval(jQuery("input[data-for='plan_item_action_response_page']", htmlContent).val().replace("#plan_item_action_response_page", "body"));
        elementToBlock.unblock();
        switch (status) {
            case 'success':
                var oMessage = { 'message':'<img src="/student/ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverInfo[0] + '</span>', 'cssClass':'myplan-feedback success' };
                var json = jQuery.parseJSON(jQuery.trim(jQuery("span#json_events_item_key", htmlContent).text()));
                for (var key in json) {
                    if (json.hasOwnProperty(key)) {
                        eval('jQuery.publish("' + key + '", [' + JSON.stringify(jQuery.extend(json[key], oMessage)) + ']);');
                    }
                }
                setUrlHash('modified', 'true');
                break;
            case 'error':
                var oMessage = { 'message':'<img src="/student/ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverErrors[0] + '</span>', 'cssClass':'myplan-feedback error' };
                var sContent = jQuery("<div />").append(oMessage.message).addClass("myplan-feedback error").css({"background-color":"#fff"});
                var sHtml = jQuery("<div />").append('<div class="uif-headerField uif-sectionHeaderField"><h3 class="uif-header">' + targetText + '</h3></div>').append(sContent);
                if (jQuery("body").HasBubblePopup()) jQuery("body").RemoveBubblePopup();
                openDialog(sHtml.html(), e);
                break;
        }
    };
    var blockOptions = {
        message:'<img src="../ks-myplan/images/btnLoader.gif"/>',
        css:{
            width:'100%',
            border:'none',
            backgroundColor:'transparent'
        },
        overlayCSS:{
            backgroundColor:'#fff',
            opacity:0.6,
            padding:'0px 1px',
            margin:'0px -1px'
        }
    };
    myplanAjaxSubmitForm(methodToCall, updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:'false'}, elementToBlock, id, blockOptions);
    jQuery("form#" + id + "_form").remove();
}
/*
 ######################################################################################
 Function: Retrieve component content through ajax
 ######################################################################################
 */
function myplanRetrieveComponent(id, getId, methodToCall, action, retrieveOptions, highlightId, elementBlockingSettings) {
    var tempForm = '<form id="' + id + '_form" action="' + action + '" method="post" style="display:none;">'; //jQuery('<form />').attr("id", id + "_form").attr("action", action).attr("method", "post").hide();
    jQuery.each(retrieveOptions, function (name, value) {
        tempForm += '<input type="hidden" name="' + name + '" value="' + value + '" />';
    });
    tempForm += '</form>';
    jQuery("body").append(tempForm);

    var elementToBlock = jQuery("#" + id);

    var updateRefreshableComponentCallback = function (htmlContent) {
        var component = jQuery("#" + getId, htmlContent);
        elementToBlock.unblock({onUnblock:function () {
            // replace component
            if (jQuery("#" + id).length) {
                jQuery("#" + id).replaceWith(component);
            }

            runHiddenScripts(getId);

            if (jQuery("input[data-role='script'][data-for='" + getId + "']", htmlContent).length > 0) {
                eval(jQuery("input[data-role='script'][data-for='" + getId + "']", htmlContent).val());
            }

            if (highlightId) {
                jQuery("[id^='" + highlightId + "']").parents('li').animate({backgroundColor:"#ffffcc"}, 1).animate({backgroundColor:"#ffffff"}, 1500, function () {
                    jQuery(this).removeAttr("style");
                });
            }
        }});
    };

    if (!methodToCall) {
        methodToCall = "search";
    }

    myplanAjaxSubmitForm(methodToCall, updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:"false"}, elementToBlock, id, elementBlockingSettings);
    jQuery("form#" + id + "_form").remove();
}
/*
 ######################################################################################
 Function:   KRAD's ajax submit function modified to allow submission of a form
 other then the kuali form
 ######################################################################################
 */
function myplanAjaxSubmitForm(methodToCall, successCallback, additionalData, elementToBlock, formId, elementBlockingSettings) {
    var data = {};

    // methodToCall checks
    if (methodToCall == null) {
        var methodToCallInput = jQuery("input[name='methodToCall']");
        if (methodToCallInput.length > 0) {
            methodToCall = jQuery("input[name='methodToCall']").val();
        }
    }

    // check to see if methodToCall is still null
    if (methodToCall != null || methodToCall !== "") {
        data.methodToCall = methodToCall;
    }

    data.renderFullView = false;

    // remove this since the methodToCall was passed in or extracted from the page, to avoid issues
    jQuery("input[name='methodToCall']").remove();

    if (additionalData != null) {
        jQuery.extend(data, additionalData);
    }

    var viewState = jQuery(document).data(kradVariables.VIEW_STATE);
    if (!jQuery.isEmptyObject(viewState)) {
        var jsonViewState = jQuery.toJSON(viewState);

        // change double quotes to single because escaping causes problems on URL
        jsonViewState = jsonViewState.replace(/"/g, "'");
        jQuery.extend(data, {clientViewState:jsonViewState});
    }

    var submitOptions = {
        data:data,
        success:function (response) {
            var tempDiv = document.createElement('div');
            tempDiv.innerHTML = response;
            var hasError = handleIncidentReport(response);
            if (!hasError) {
                successCallback(tempDiv);
            }
            jQuery("#formComplete").empty();
        },
        error:function (jqXHR, textStatus) {
            alert("Request failed: " + textStatus);
        }
    };

    if (elementToBlock != null && elementToBlock.length) {
        var elementBlockingOptions = {
            beforeSend:function () {
                if (elementToBlock.hasClass("unrendered")) {
                    elementToBlock.append('<img src="' + getConfigParam("kradImageLocation") + 'loader.gif" alt="Loading..." /> Loading...');
                    elementToBlock.show();
                }
                else {
                    var elementBlockingDefaults = {
                        baseZ:500,
                        message:'<img src="../ks-myplan/images/ajaxLoader16.gif" alt="loading..." />',
                        fadeIn:0,
                        fadeOut:0,
                        overlayCSS:{
                            backgroundColor:'#fff',
                            opacity:0
                        },
                        css:{
                            border:'none',
                            width:'16px',
                            top:'0px',
                            left:'0px'
                        }
                    };
                    elementToBlock.block(jQuery.extend(elementBlockingDefaults, elementBlockingSettings));
                }
            },
            complete:function () {
                elementToBlock.unblock();
            },
            error:function () {
                if (elementToBlock.hasClass("unrendered")) {
                    elementToBlock.hide();
                }
                else {
                    elementToBlock.unblock();
                }
            }
        };
    }
    jQuery.extend(submitOptions, elementBlockingOptions);
    var form;
    if (formId) {
        form = jQuery("#" + formId + "_form");
    } else {
        form = jQuery("#kualiForm");
    }
    form.ajaxSubmit(submitOptions);
}
/*
 ######################################################################################
 Function:   Truncate (ellipse) a single horizontally aligned item so all items
 fit on one line.
 ######################################################################################
 */
function truncateField(id) {
    jQuery("#" + id + " .uif-horizontalFieldGroup").each(function () {
        jQuery(this).css("display", "block");
        var fixed = 0;
        var margin = 10;
        jQuery(this).find(".uif-boxLayoutHorizontalItem:not(.myplan-text-ellipsis)").each(function () {
            fixed = fixed + jQuery(this).width();
        });
        var ellipsis = jQuery(this).width() - ( ( fixed + 1 ) + margin );
        jQuery(this).find(".uif-boxLayoutHorizontalItem.myplan-text-ellipsis").width(ellipsis);
    });
}
function truncateAuditTitle(id) {
    jQuery("#" + id + " .myplan-audit-title").each(function () {
        if (readUrlParam("viewId") == "DegreeAudit-FormView") {
            if (
                (readUrlParam("auditId") == false && jQuery(this).siblings("div[id^='hidden_recentAuditId']").length > 0) ||
                    (readUrlParam("auditId") == jQuery(this).parents(".uif-verticalFieldGroup").attr("id"))
                ) {
                jQuery(this).find(".uif-label label").html("Viewing");
            }
        }

        var width = jQuery(this).width();
        var label = parseFloat(jQuery(this).find(".uif-label label").css({"color":"#777777"}).width()) + parseFloat(jQuery(this).find(".uif-label label").css("padding-right"));

        jQuery(this).find(".uif-label").next("span").width(width - label - 1).css({
            "text-overflow":"ellipsis",
            "white-space":"nowrap",
            "overflow":"hidden",
            "display":"block",
            "float":"left"
        });
    });
}
/*
 ######################################################################################
 Function:   Slide into view hidden horizontally aligned items specifying the id
 of the item being brought into view.
 ######################################################################################
 */
function fnPopoverSlider(showId, parentId, direction) {
    var newDirection;
    if (direction === 'left') {
        newDirection = 'right';
    } else {
        newDirection = 'left';
    }
    jQuery("#" + parentId + " > .uif-horizontalBoxLayout > div.uif-boxLayoutHorizontalItem:visible").hide("slide", {
        direction:direction
    }, 100, function () {
        jQuery("#" + parentId + " > .uif-horizontalBoxLayout > div.uif-boxLayoutHorizontalItem").filter("#" + showId).show("slide", {
            direction:newDirection
        }, 100, function () {
        });
    });
}
/*
 ######################################################################################
 Function:   Close all bubble popups
 ######################################################################################
 */
function fnCloseAllPopups() {
    if (jQuery("body").HasBubblePopup()) jQuery("body").RemoveBubblePopup();
    jQuery("div.jquerybubblepopup.jquerybubblepopup-myplan").remove();
    jQuery(document).off();
}
/*
 ######################################################################################
 Function:   Build Term Plan View heading
 ######################################################################################
 */
function fnBuildTitle(aView) {
    var sText = 'Academic Year';
    var aFirst = jQuery.trim(jQuery(aView[0]).find("div:hidden[id^='plan_base_atpId']").text()).split(".");
    var aLast = jQuery.trim(jQuery(aView[aView.length - 1]).find("div:hidden[id^='plan_base_atpId']").text()).split(".");
    jQuery("#planned_courses_detail .myplan-plan-header").html(sText + ' ' + aFirst[3] + '-' + aLast[3]);
}
/*
 ######################################################################################
 Function:   expand/collapse backup course set within plan view
 ######################################################################################
 */
function fnToggleBackup(e) {
    stopEvent(e);
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    if (!jQuery(target).hasClass("disabled")) {
        var oBackup = jQuery(target).parents(".myplan-term-backup").find(".uif-stackedCollectionLayout");
        var oQuarter = jQuery(target).parents("li");
        var iSpeed = 500;
        var iDefault = 26;
        if (jQuery(target).hasClass("expanded")) {
            var iAdjust = ( oBackup.height() - ( iDefault * 2 ) ) * -1;
            jQuery(target).removeClass("expanded");
            jQuery(target).find("span").html("Show");
        } else {
            var iAdjust = ( oBackup.find("span a").size() * iDefault ) - oBackup.height();
            jQuery(target).addClass("expanded");
            jQuery(target).find("span").html("Hide");
        }
        oBackup.animate({"height":oBackup.height() + iAdjust}, {duration:iSpeed});
        oQuarter.animate({"height":oQuarter.height() + iAdjust}, {duration:iSpeed});
    }
}
/*
 ######################################################################################
 Function:   expand/collapse backup course set within plan view
 ######################################################################################
 */
function myplanCreateLightBoxLink(controlId, options) {
    jQuery(function () {
        var showHistory = false;

        // Check if this is called within a light box
        if (!jQuery(".fancybox-wrap", parent.document).length) {

            // Perform cleanup when lightbox is closed
            options['beforeClose'] = cleanupClosedLightboxForms;

            // If this is not the top frame, then create the lightbox
            // on the top frame to put overlay over whole window
            if (top == self) {
                jQuery("#" + controlId).fancybox(options);
            } else {
                jQuery("#" + controlId).click(function (e) {
                    e.preventDefault();
                    top.jQuery.fancybox(options);
                });
            }
        } else {
            //jQuery("#" + controlId).attr('target', '_self');
            showHistory = true;
        }

        // Set the renderedInLightBox = true param
        if (options['href'].indexOf('&renderedInLightBox=true') == -1) {
            options['href'] = options['href'] + '&renderedInLightBox=true'
                + '&showHome=false' + '&showHistory=' + showHistory
                + '&history=' + jQuery('#formHistory\\.historyParameterString').val();
        }
    });
}

function myplanLightBoxLink(href, options, e) {
    stopEvent(e);
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    options['autoHeight'] = true;
    options['href'] = href;
    //options['beforeClose'] = cleanupClosedLightboxForms;
    top.jQuery.fancybox(options);
}

function myplanCreateTooltip(id, text, options, onMouseHoverFlag, onFocusFlag) {
    var elementInfo = getHoverElement(id);
    var element = elementInfo.element;
    if (typeof options['themePath'] === "undefined") options['themePath'] = "../krad/plugins/tooltip/jquerybubblepopup-theme/";

    // Check to see if a data attribute help is defined. Use that if defined.
    // This is built so that SpringEL can be used for generating the html. But it
    // also introduces a limitation of not allowing &quot; in the text
    if (jQuery("#" + id).data('help') && jQuery("#" + id).data('help').length > 0) {
        options['innerHtml'] = jQuery("#" + id).data('help');
    } else {
        options['innerHtml'] = text;
    }
    options['manageMouseEvents'] = false;
    if (onFocusFlag) {
        // Add onfocus trigger
        jQuery("#" + id).focus(function () {
            //            if (!jQuery("#" + id).IsBubblePopupOpen()) {
            // TODO : use data attribute to check if control
            if (!isControlWithMessages(id)) {
                if (!jQuery("#" + id).HasBubblePopup()) jQuery("#" + id).CreateBubblePopup(options);
                jQuery("#" + id).SetBubblePopupOptions(options, true);
                jQuery("#" + id).SetBubblePopupInnerHtml(options.innerHTML, true);
                jQuery("#" + id).ShowBubblePopup();
            }
            //            }
        });
        jQuery("#" + id).blur(function () {
            jQuery("#" + id).HideBubblePopup();
        });
    }
    if (onMouseHoverFlag) {
        // Add mouse hover trigger
        jQuery("#" + id).hover(function () {
            if (!jQuery("#" + id).IsBubblePopupOpen()) {
                if (!isControlWithMessages(id)) {
                    if (!jQuery("#" + id).HasBubblePopup()) jQuery("#" + id).CreateBubblePopup(options);
                    jQuery("#" + id).SetBubblePopupOptions(options, true);
                    jQuery("#" + id).SetBubblePopupInnerHtml(options.innerHTML, true);
                    jQuery("#" + id).ShowBubblePopup();
                }
            }
        }, function (event) {
            if (!onFocusFlag || !jQuery("#" + id).is(":focus")) {
                var result = mouseInTooltipCheck(event, id, element, this, elementInfo.type);
                if (result) {
                    mouseLeaveHideTooltip(id, jQuery("#" + id), element, elementInfo.type);
                }
            }
        });
    }
}

function degreeAuditButton() {
    if (jQuery.cookie('myplan_audit_running')) {
        return true;
    } else {
        var id = getAuditProgram("id");

        if (id) {
            return (id == 'default');
        } else {
            return true;
        }
    }
}

var blockPendingAuditStyle = {
    message:'<img src="../ks-myplan/images/ajaxAuditRunning32.gif" alt="" class="icon"/><div class="heading">We are currently running your degree audit for \'<span class="programName"></span>\'.</div><div class="content">Audits may take 1-5 minutes to load. Feel free to leave this page to explore MyPlan further while your audit is running. You will receive a browser notification when your report is complete.</div>',
    fadeIn:400,
    fadeOut:800,
    css:{
        padding:'30px 30px 30px 82px',
        margin:'30px',
        width:'auto',
        textAlign:'left',
        border:'solid 1px #ffd14c',
        backgroundColor:'#fffdd7',
        'border-radius':'15px',
        '-webkit-border-radius':'15px',
        '-moz-border-radius':'15px'
    },
    overlayCSS:{
        backgroundColor:'#fff',
        opacity:0.85,
        border:'none',
        cursor:'wait'
    }
};

var blockPendingAudit;

function changeLoadingMessage(selector) {
    blockPendingAudit = setInterval(function () {
        setLoadingMessage(selector)
    }, 100);
}

function setLoadingMessage(selector) {
    if (jQuery('.myplan-audit-report div.blockUI.blockMsg.blockElement').length > 0) {
        fnAddLoadingText(selector);
    }
}

function fnAddLoadingText(selector) {
    clearInterval(blockPendingAudit);
    jQuery(selector + " div.blockUI.blockOverlay").css(blockPendingAuditStyle.overlayCSS);
    jQuery(selector + " div.blockUI.blockMsg.blockElement").html(blockPendingAuditStyle.message).css(blockPendingAuditStyle.css).data("growl", "false");
    jQuery(selector + " div.blockUI.blockMsg.blockElement .programName").text(getAuditProgram("name"));
}

function removeCookie() {
    jQuery.cookie("myplan_audit_running", null, {expires:new Date().setTime(0)});
}

function getAuditProgram(param) {
    var id;
    switch (parseFloat(jQuery("input[name='campusParam']:checked").val())) {
        case 306:
            id = 'select_programParam_seattle_control';
            break;
        case 310:
            id = 'select_programParam_bothell_control';
            break;
        case 323:
            id = 'select_programParam_tacoma_control';
            break;
        default:
            id = null;
    }
    if (param == 'id') {
        return jQuery('select#' + id).val();
    } else {
        return jQuery('select#' + id + ' option:selected').text();
    }
}

function setPendingAudit(minutes) {
    if (jQuery.cookie('myplan_audit_running') == null) {
        var data = {};

        data.expires = new Date();
        data.expires.setTime(data.expires.getTime() + (minutes * 60 * 1000));
        data.programId = getAuditProgram('id');
        data.programName = getAuditProgram('name');
        data.recentAuditId = jQuery("input[id^='hidden_recentAuditId']").val();

        if (typeof data.recentAuditId === 'undefined') data.recentAuditId = '';

        if (data.programId != 'default') {
            jQuery.ajax({
                url:"/student/myplan/audit/status",
                data:{"programId":data.programId, "auditId":data.recentAuditId},
                dataType:"json",
                beforeSend:null,
                success:function (response) {
                    if (response.status == "PENDING") {
                        jQuery.cookie('myplan_audit_running', JSON.stringify(data), {expires:data.expires});
                        jQuery("button#degree_audit_run").attr("disabled", true);
                        jQuery.publish('REFRESH_AUDITS');
                    }
                },
                statusCode:{
                    500:function () {
                        sessionExpired();
                    }
                }
            });
        }
    } else {
        showGrowl("Another audit is currently pending.", "Degree Audit Error", "errorGrowl");
    }
}

function getPendingAudit(id) {
    if (jQuery.cookie('myplan_audit_running')) {
        var component = jQuery("#" + id + " ul");
        var data = jQuery.parseJSON(decodeURIComponent(jQuery.cookie('myplan_audit_running')));
        if (data) {
            var item = jQuery("<li />").addClass("pending").html('<img src="../ks-myplan/images/ajaxPending16.gif" class="icon"/><span class="title">Running <span class="program">' + data.programName + '</span></span>');
            component.prepend(item);
            pollPendingAudit(data.programId, data.recentAuditId);
        }
        if (component.find("li").size() > 0 && component.next("div.uif-boxGroup").length > 0) {
            component.next("div.uif-boxGroup").remove();
        }
    }
}

function blockPendingAudit(id) {
    if (readUrlParam("auditId") == false && jQuery.cookie('myplan_audit_running')) {
        var elementToBlock = jQuery("#" + id);
        var audit = jQuery.parseJSON(decodeURIComponent(jQuery.cookie('myplan_audit_running')));
        elementToBlock.block(blockPendingAuditStyle);
        jQuery("#" + id + " div.blockUI.blockMsg.blockElement").data("growl", "true");
        jQuery("#" + id + " div.blockUI.blockMsg.blockElement .programName").text(audit.programName);
        jQuery("#" + id).subscribe('AUDIT_COMPLETE', function () {
            window.location.assign(window.location.href.split("#")[0]);
        });
    }
}

function pollPendingAudit(programId, recentAuditId) {
    jQuery.ajaxPollSettings.pollingType = "interval";
    jQuery.ajaxPollSettings.interval = 250; // polling interval in milliseconds

    jQuery.ajaxPoll({
        url:"/student/myplan/audit/status",
        data:{"programId":programId, "auditId":recentAuditId},
        dataType:"json",
        beforeSend:null,
        successCondition:function (response) {
            return (response.status == 'DONE' || response.status == 'FAILED' || jQuery.cookie("myplan_audit_running") == null);
        },
        success:function (response) {
            var growl = true;
            if (readUrlParam("viewId") == "DegreeAudit-FormView") {
                growl = jQuery(".myplan-audit-report div.blockUI.blockMsg.blockElement").data("growl");
                if (readUrlParam("auditId") != false) jQuery("body").subscribe('AUDIT_COMPLETE', function () {
                    setUrlParam("auditId", "");
                });
            }

            if (jQuery.cookie("myplan_audit_running") == null || response.status == 'FAILED') {
                if (growl) showGrowl("Your audit was unable to complete.", "Degree Audit Error", "errorGrowl");
            } else {
                var data = jQuery.parseJSON(decodeURIComponent(jQuery.cookie("myplan_audit_running")));
                if (growl) showGrowl(data.programName + " audit is ready to view.", "Degree Audit Completed", "infoGrowl");
            }
            jQuery.cookie("myplan_audit_running", null, {expires:new Date().setTime(0)});
            jQuery.publish("AUDIT_COMPLETE");
        }
    });
}

function buttonState(jqueryObj, buttonId) {
    if (jqueryObj.val().length === 0) {
        jQuery("button#" + buttonId).attr('disabled', true);
    } else {
        jQuery("button#" + buttonId).attr('disabled', false);
    }
}

(function ($) {

    $.fn.characterCount = function (options) {

        var oDefaults = {
            maxLength:100,
            warningLength:20,
            classCounter:'counter',
            classWarning:'warning'
        };

        var options = $.extend(oDefaults, options);

        function calculate(obj, options) {
            var iCount = $(obj).val().length;
            var iAvailable = options.maxLength - iCount;
            var sValue = $(obj).val();
            if (iCount > options.maxLength) {
                $(obj).val(sValue.substr(0, options.maxLength));
            }
            if (iAvailable <= options.warningLength && iAvailable >= 0) {
                $('.' + options.classCounter).addClass(options.classWarning);
            } else {
                $('.' + options.classCounter).removeClass(options.classWarning);
            }
            $('.' + options.classCounter).html('<strong>' + $(obj).val().length + '</strong> / ' + options.maxLength + ' characters');
        }

        ;

        this.each(function () {
            calculate(this, options);
            $(this).keyup(function () {
                calculate(this, options);
            });
            $(this).change(function () {
                calculate(this, options);
            });
        });
    };

})(jQuery);

function fnCreateDate(sData) {
    var jTemp = jQuery(sData);
    jTemp.find("legend, .myplan-sort-remove").remove();
    var sDate = jQuery.trim(jTemp.text());

    if (sDate.length > 2) {
        return Date.parse(sDate);
    } else {
        return 0;
    }
}

jQuery.fn.dataTableExt.oSort['longdate-asc'] = function (x, y) {
    x = fnCreateDate(x);
    y = fnCreateDate(y);

    return ((x < y) ? -1 : ((x > y) ? 1 : 0));
};
jQuery.fn.dataTableExt.oSort['longdate-desc'] = function (x, y) {
    x = fnCreateDate(x);
    y = fnCreateDate(y);

    return ((x < y) ? 1 : ((x > y) ? -1 : 0));
};
Array.max = function (array) {
    return Math.max.apply(Math, array);
};


/*Quick Add*/

function openQuickAddPopUp(id, getId, retrieveOptions, e, selector, popupOptions, close) {
    stopEvent(e);

    var popupHtml = jQuery('<div />').attr("id", id + "_popup").css({
        width:"353px",
        height:"16px"
    });

    var popupOptionsDefault = {
        innerHtml:popupHtml.wrap("<div>").parent().clone().html(),
        themePath:'../ks-myplan/jquery-bubblepopup/jquerybubblepopup-theme/',
        manageMouseEvents:true,
        selectable:true,
        tail:{align:'middle', hidden:false},
        position:'left',
        align:'center',
        alwaysVisible:false,
        themeMargins:{total:'20px', difference:'5px'},
        themeName:'myplan',
        distance:'0px',
        openingSpeed:0,
        closingSpeed:0
    };

    var popupSettings = jQuery.extend(popupOptionsDefault, popupOptions);

    var popupBox;
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    if (selector === null) {
        popupBox = jQuery(target);
    } else {
        popupBox = jQuery(target).parents(selector);
    }

    fnCloseAllPopups();

    popupBox.CreateBubblePopup({manageMouseEvents:false});
    popupBox.ShowBubblePopup(popupSettings, false);
    var popupBoxId = popupBox.GetBubblePopupID();
    fnPositionPopUp(popupBoxId);
    popupBox.FreezeBubblePopup();

    jQuery(document).on('click', function (e) {
        var tempTarget = (e.target) ? e.target : e.srcElement;
        if (jQuery(tempTarget).parents("div.jquerybubblepopup.jquerybubblepopup-myplan").length === 0) {
            popupBox.RemoveBubblePopup();
            fnCloseAllPopups();
        }
    });

    var tempForm = jQuery('<form />').attr("id", id + "_form").attr("action", "quickAdd").attr("method", "post").hide();
    var tempFormInputs = '<div style="display:none;"><input type="hidden" name="viewId" value="QuickAdd-FormView" />';
    jQuery.each(retrieveOptions, function (name, value) {
        tempFormInputs += '<input type="hidden" name="' + name + '" value="' + value + '" />';
    });
    tempFormInputs += '</div>';
    jQuery(tempForm).append(tempFormInputs);
    jQuery("body").append(tempForm);

    var elementToBlock = jQuery("#" + id + "_popup");

    var updateRefreshableComponentCallback = function (htmlContent) {
        var component;
        if (jQuery("span#request_status_item_key", htmlContent).length <= 0) {
            component = jQuery("#" + getId, htmlContent);
            var quickAddForm = jQuery('<form />').attr("id", id + "_form").attr("action", "quickAdd").attr("method", "post");
        } else {
            eval(jQuery("input[data-for='quick_add_action_response_page']", htmlContent).val().replace("#quick_add_action_response_page", "body"));
            var sError = '<img src="../ks-myplan/images/pixel.gif" alt="" class="icon"/><span class="message">' + jQuery('body').data('validationMessages').serverErrors[0] + '</span>';
            component = jQuery("<div />").html(sError).addClass("myplan-feedback error").width(175);
        }
        elementToBlock.unblock({onUnblock:function () {
            if (jQuery("#" + id + "_popup").length) {
                popupBox.SetBubblePopupInnerHtml(component);
                fnPositionPopUp(popupBoxId);
                if (status != 'error') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").wrapInner(quickAddForm);
                if (close || typeof close === 'undefined') jQuery("#" + popupBoxId + " .jquerybubblepopup-innerHtml").append('<img src="../ks-myplan/images/btnClose.png" class="myplan-popup-close"/>');
                jQuery("#" + popupBoxId + " img.myplan-popup-close").on('click', function () {
                    popupBox.RemoveBubblePopup();
                    fnCloseAllPopups();
                });
            }
            runHiddenScripts(getId);
        }});
    };

    myplanAjaxSubmitForm("start", updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:"false"}, elementToBlock, id);
    jQuery("form#" + id + "_form").remove();
}

function myplanAjaxSubmitQuickAdd(id, submitOptions, methodToCall, e, bDialog) {
    var target = (e.currentTarget) ? e.currentTarget : e.srcElement;
    var targetText = ( jQuery.trim(jQuery(target).text()) != '') ? jQuery.trim(jQuery(target).text()) : "Error";
    var elementToBlock = (target.nodeName != 'INPUT') ? jQuery(target) : jQuery(target).parent();
    jQuery('input[name="methodToCall"]').remove();
    jQuery('#' + id + '_form input[name="viewId"]').remove();
    var formInputs = '<div style="display:none;"><input type="hidden" name="methodToCall" value="' + methodToCall + '" /><input type="hidden" name="viewId" value="QuickAdd-FormView" />';
    jQuery.each(submitOptions, function (name, value) {
        formInputs += '<input type="hidden" name="' + name + '" value="' + value + '" />';
        jQuery('#' + id + '_form input[name="' + name + '"]').remove();
    });
    formInputs += '</div>';
    jQuery("#" + id + "_form").append(formInputs);
    var updateRefreshableComponentCallback = function (htmlContent) {
        var status = jQuery.trim(jQuery("span#request_status_item_key", htmlContent).text().toLowerCase());
        eval(jQuery("input[data-for='quick_add_action_response_page']", htmlContent).val().replace("#quick_add_action_response_page", "body"));
        elementToBlock.unblock();
        switch (status) {
            case 'success':
                var oMessage = { 'message':'<img src="../ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverInfo[0] + '</span>', 'cssClass':'myplan-feedback success' };
                var json = jQuery.parseJSON(jQuery.trim(jQuery("span#json_events_item_key", htmlContent).text()));
                for (var key in json) {
                    if (json.hasOwnProperty(key)) {
                        eval('jQuery.publish("' + key + '", [' + JSON.stringify(jQuery.extend(json[key], oMessage)) + ']);');
                    }
                }
                setUrlHash('modified', 'true');
                break;
            case 'error':
                var oMessage = { 'message':'<img src="../ks-myplan/images/pixel.gif" alt="" class="icon"><span class="message">' + jQuery('body').data('validationMessages').serverErrors[0] + '</span>', 'cssClass':'myplan-feedback error' };
                eval('jQuery.publish("ERROR", [' + JSON.stringify(oMessage) + ']);');
                break;
        }
    };
    var blockOptions = {
        message:'<img src="../ks-myplan/images/btnLoader.gif"/>',
        css:{
            width:'100%',
            border:'none',
            backgroundColor:'transparent'
        },
        overlayCSS:{
            backgroundColor:'#fff',
            opacity:0.6,
            padding:'0px 1px',
            margin:'0px -1px'
        }
    };
    myplanAjaxSubmitForm(methodToCall, updateRefreshableComponentCallback, {reqComponentId:id, skipViewInit:'false'}, elementToBlock, id, blockOptions);
}
function autoCompleteText(atpId) {
    var sQuery = jQuery("input[id='search_text_box_control']").val();
    var emptySuggestions = ["No courses Found"];
    jQuery("#search_text_box_control").autocomplete({source:function (request, response) {
        jQuery.ajax({
            url:"/student/myplan/quickAdd/autoSuggestions?courseCd=" + sQuery + "&atpId=" + atpId,
            type:"GET",
            beforeSend:null,
            data:"list=" + '',
            dataType:"json",
            error:function () {
                jQuery("#search_text_box_control").autocomplete({source:emptySuggestions});
            },
            success:function (data) {
                if (data.aaData.length > 0) {
                    response(data.aaData);
                }
                else {
                    response(emptySuggestions)
                }
            }
        });
    }
    });
    jQuery(document).ajaxStart(jQuery.unblockUI).ajaxStop(jQuery.unblockUI);

}

function showDataTableDetail(actionComponent, tableId, useImages) {
    var oTable = null;
    var tables = jQuery.fn.dataTable.fnTables();
    jQuery(tables).each(function () {
        var dataTable = jQuery(this).dataTable();
        if (jQuery(actionComponent).closest(dataTable).length) {
            oTable = dataTable;
        }
    });

    if (oTable != null) {
        var nTr = jQuery(actionComponent).parents('tr')[0];
        if (useImages && jQuery(actionComponent).find("img").length) {
            jQuery(actionComponent).find("img").hide();
        } else {
            jQuery(actionComponent).hide();
        }
        var newRow = oTable.fnOpen(nTr, fnFormatDetails(actionComponent), "uif-rowDetails");
        var detailsId = jQuery(newRow).find(".uif-group").first().attr("id");
        jQuery(newRow).find(".uif-group").first().attr("id", detailsId + "_details")
        jQuery(newRow).find("a").each(function () {
            var linkId = jQuery(this).attr("id");
            jQuery(this).siblings("input[data-for='" + linkId + "']").removeAttr("script").attr("name", "script").val(function (index, value) {
                return value.replace("'" + linkId + "'", "'" + linkId + "_details'");
            });
            jQuery(this).attr("id", linkId + "_details");
        });
        runHiddenScripts(detailsId + "_details");
        jQuery(newRow).find(".uif-group").first().show();
    }
}

function expandDataTableDetail(actionComponent, tableId, useImages, expandText, collapseText) {
    var oTable = null;
    var tables = jQuery.fn.dataTable.fnTables();
    jQuery(tables).each(function () {
        var dataTable = jQuery(this).dataTable();
        //ensure the dataTable is the one that contains the action that was clicked
        if (jQuery(actionComponent).closest(dataTable).length) {
            oTable = dataTable;
        }
    });

    if (oTable != null) {
        var nTr = jQuery(actionComponent).parents('tr')[0];
        if (oTable.fnIsOpen(nTr)) {
            if (useImages && jQuery(actionComponent).find("img").length) {
                jQuery(actionComponent).find("img").replaceWith(detailsOpenImage.clone());
            }
            if (expandText) {
                jQuery(actionComponent).text(expandText);
            }
            jQuery(nTr).next().first().find(".uif-group").first().slideUp(function () {
                oTable.fnClose(nTr);
            });
        }
        else {
            if (useImages && jQuery(actionComponent).find("img").length) {
                jQuery(actionComponent).find("img").replaceWith(detailsCloseImage.clone());
            }
            if (collapseText) {
                jQuery(actionComponent).text(collapseText);
            }
            var newRow = oTable.fnOpen(nTr, fnFormatDetails(actionComponent), "uif-rowDetails");
            var detailsId = jQuery(newRow).find(".uif-group").first().attr("id");
            jQuery(newRow).find(".uif-group").first().attr("id", detailsId + "_details")
            jQuery(newRow).find("a").each(function () {
                var linkId = jQuery(this).attr("id");
                jQuery(this).siblings("input[data-for='" + linkId + "']").removeAttr("script").attr("name", "script").val(function (index, value) {
                    return value.replace("'" + linkId + "'", "'" + linkId + "_details'");
                });
                jQuery(this).attr("id", linkId + "_details");
            });
            runHiddenScripts(detailsId + "_details");
            jQuery(newRow).find(".uif-group").first().slideDown();
        }
    }
}

function expandHiddenSubcollection(actionComponent, expandText, collapseText) {
    var subcollection = jQuery(actionComponent).closest('.uif-group.uif-collectionItem').children('.uif-boxLayout').children('.uif-subCollection');

    if (subcollection.is(":visible")) {
        subcollection.slideUp(250, function () {
            if (expandText) {
                jQuery(actionComponent).text(expandText);
            }
        });
    } else {
        subcollection.slideDown(250, function () {
            if (collapseText) {
                jQuery(actionComponent).text(collapseText);
            }
        });
    }

}

function myplanReplaceWithJson(id, url, retrieveOptions) {
    jQuery.getJSON(url, retrieveOptions, function (response) {
        jQuery("#" + id).fadeOut(250, function () {
            jQuery(this).html("<strong>" + response.enrollment + "</strong> / " + response.limit).fadeIn(250);
        });
    });
}


/**
 *Function used to toggle the action buttons from add to delete or delete to add in single quarter view.
 */
function toggleButtons() {
    var id = null;
    jQuery('body')
        .subscribe('SECTION_ITEM_ADDED',function (data) {
            var value = "jQuery('#section_" + data.planItemId + "').click(function(e){myplanAjaxSubmitSectionItem('" + data.planItemId + "', 'removeItem', 'plan', {planItemId:'" + data.planItemId + "',sectionCode:'" + data.SectionCode + "',atpId:'" + data.atpId.replace(/-/g, '.') + "',instituteCode:'" + data.InstituteCode + "',viewId:'PlannedCourse-FormView', primary:'" + data.Primary + "'}, e);});"
            var onMouseHover = "jQuery('#section_" + data.planItemId + "').mouseover(function(e) {addDeleteHoverText(jQuery(this));});";
            jQuery('#section_' + data.InstituteCode + '_' + data.atpId + '_' + data.SectionCode).unbind('click').removeClass('myplan-add').addClass('myplan-delete').attr('title', 'Delete section ' + data.SectionCode).attr('data-coursesection', data.SectionCode).attr('data-primary', data.Primary).parent().removeClass('myplan-add').addClass('myplan-delete').attr('title', 'Delete section ' + data.SectionCode).attr('data-coursesection', data.SectionCode).attr('data-primary', data.Primary);
            jQuery('#section_' + data.InstituteCode + '_' + data.atpId + '_' + data.SectionCode).parent().find('input').data('for', 'section_' + data.planItemId).attr('value', value + onMouseHover).removeAttr('script').attr('name', 'script');
            jQuery('#section_' + data.InstituteCode + '_' + data.atpId + '_' + data.SectionCode).attr('id', 'section_' + data.planItemId);
            runScriptsForId('section_' + data.planItemId);
            if (data.PrimarySectionCode != null) {
                var value = "jQuery('#section_" + data.PrimaryPlanItemId + "').click(function(e){myplanAjaxSubmitSectionItem('" + data.PrimaryPlanItemId + "', 'removeItem', 'plan', {planItemId:'" + data.PrimaryPlanItemId + "',sectionCode:'" + data.PrimarySectionCode + "',atpId:'" + data.atpId.replace(/-/g, '.') + "',instituteCode:'" + data.InstituteCode + "',viewId:'PlannedCourse-FormView', primary:'true'}, e);});"
                var onMouseHover = "jQuery('#section_" + data.PrimaryPlanItemId + "').mouseover(function(e) {addDeleteHoverText(jQuery(this));});";
                jQuery('#section_' + data.InstituteCode + '_' + data.atpId + '_' + data.PrimarySectionCode).unbind('click').removeClass('myplan-add').addClass('myplan-delete').attr('title', 'Delete section ' + data.PrimarySectionCode).attr('data-coursesection', data.PrimarySectionCode).attr('data-primary', true).parent().removeClass('myplan-add').addClass('myplan-delete').attr('title', 'Delete section ' + data.PrimarySectionCode).attr('data-coursesection', data.PrimarySectionCode).attr('data-primary', true);
                jQuery('#section_' + data.InstituteCode + '_' + data.atpId + '_' + data.PrimarySectionCode).parent().find('input').data('for', 'section_' + data.PrimaryPlanItemId).attr('value', value + onMouseHover).removeAttr('script').attr('name', 'script');
                jQuery('#section_' + data.InstituteCode + '_' + data.atpId + '_' + data.PrimarySectionCode).attr('id', 'section_' + data.PrimaryPlanItemId);
                runScriptsForId('section_' + data.PrimaryPlanItemId);
            }
        }).subscribe('SECTION_ITEM_DELETED',function (data) {
            var courseId = data.courseDetails.courseId;
            var value = "jQuery('#section_" + data.InstituteCode + "_" + data.atpId + "_" + data.SectionCode + "').click(function(e) {myplanAjaxSubmitSectionItem('" + courseId + "', 'addPlannedCourse', 'plan', {courseId:'" + courseId + "',sectionCode:'" + data.SectionCode + "',atpId:'" + data.atpId.replace(/-/g, '.') + "',instituteCode:'" + data.InstituteCode + "',primary:'" + data.Primary + "',viewId:'PlannedCourse-FormView'}, e);});";
            jQuery('#section_' + data.planItemId).unbind('click').removeClass('myplan-delete').addClass('myplan-add').attr('title', 'Add section ' + data.SectionCode + ' to ' + data.shortTermName).parent().removeClass('myplan-delete').addClass('myplan-add').attr('title', 'Add section ' + data.SectionCode + ' to ' + data.shortTermName);
            jQuery('#section_' + data.planItemId).parent().find('input').data('for', 'section_' + data.InstituteCode + '_' + data.atpId + '_' + data.SectionCode).attr('value', value).removeAttr('script').attr('name', 'script');
            jQuery('#section_' + data.planItemId).attr('id', 'section_' + data.InstituteCode + '_' + data.atpId + '_' + data.SectionCode);
            runScriptsForId('section_' + data.InstituteCode + '_' + data.atpId + '_' + data.SectionCode);
            var object = data.PlanItemsDeleted;
            if (object != null) {
                for (planItemId in object) {
                    var sectionCode = object[planItemId];
                    var sectionValue = "jQuery('#section_" + data.InstituteCode + "_" + data.atpId + "_" + sectionCode + "').click(function(e) {myplanAjaxSubmitSectionItem('" + courseId + "', 'addPlannedCourse', 'plan', {courseId:'" + courseId + "',sectionCode:'" + sectionCode + "',atpId:'" + data.atpId.replace(/-/g, '.') + "',instituteCode:'" + data.InstituteCode + "',primary:'" + data.Primary + "',viewId:'PlannedCourse-FormView'}, e);});";
                    jQuery('#section_' + planItemId).unbind('click').removeClass('myplan-delete').addClass('myplan-add').attr('title', 'Add section ' + sectionCode + ' to ' + data.shortTermName).parent().removeClass('myplan-delete').addClass('myplan-add').attr('title', 'Add section ' + sectionCode + ' to ' + data.shortTermName);
                    jQuery('#section_' + planItemId).parent().find('input').data('for', 'section_' + data.InstituteCode + '_' + data.atpId + '_' + sectionCode).attr('value', sectionValue).removeAttr('script').attr('name', 'script');
                    jQuery('#section_' + planItemId).attr('id', 'section_' + data.InstituteCode + '_' + data.atpId + '_' + sectionCode);
                    runScriptsForId('section_' + data.InstituteCode + '_' + data.atpId + '_' + sectionCode);

                }
            }
        }).subscribe('PLAN_ITEM_DELETED',function (data) {
            id = data.planItemId;
            if (data.planItemType == 'planned') {
                jQuery('#' + data.planItemId + '_planned').parent().fadeOut('slow');
            } else if (data.planItemType == 'backup') {
                jQuery('#' + data.planItemId + '_backup').parent().fadeOut('slow');
            }
        }).subscribe('UPDATE_NEW_TERM_TOTAL_CREDITS', function (data) {
            var totalCredits = data.totalCredits;
            var credits = jQuery('.myplan-credit-total span.uif-message');
            jQuery.each(credits, function (index, value) {
                if (jQuery(credits[index]).text().trim() != '*') {
                    jQuery(credits[index]).text(totalCredits);
                }
            });
        });

}

/*This function is used for adding the delete hover text for primary section which are planned
 * changes to "Delete Section A, AA, AC and AD" if the size of the secondary section is less than 4
 * otherwise changes to "Delete Section A. All sections will be deleted as well." */
function addDeleteHoverText(element) {
    if (jQuery(element).data('primary') === true) {
        var section = jQuery(element).data('coursesection').toString();
        var sectionList = new Array();
        ;
        var obj = jQuery(element).closest('table').find('div.myplan-delete[data-primary=false]');
        if (obj != undefined) {
            jQuery.each(obj, function (index, value) {
                var sec = value.dataset.coursesection.toString();
                if (sec.match('^' + section) && sec != section) {
                    sectionList.push(obj[index]);
                }
            });
        }
        if (sectionList.length > 0) {
            var hoverText = 'Delete Section ' + jQuery(element).data('coursesection');
            if (sectionList.length >= 4) {
                hoverText = hoverText.concat('. All sections will be deleted as well.');
            } else {
                jQuery.each(sectionList, function (index, value) {
                    var sec = value.dataset.coursesection.toString();
                    if (index == sectionList.length - 1) {
                        hoverText = hoverText.concat(' and ' + value.dataset.coursesection);
                    } else {
                        hoverText = hoverText.concat(', ' + value.dataset.coursesection);
                    }
                });
            }
            jQuery(element).attr('title', hoverText);
            jQuery(element).parent().attr('title', hoverText);
        }
    }
}