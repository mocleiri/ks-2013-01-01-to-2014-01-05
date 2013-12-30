/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kuali.student.r2.core.process.service.decorators;

import org.kuali.student.enrollment.class2.courseregistration.service.decorators.CourseRegistrationServiceDecorator;
import org.kuali.student.enrollment.courseregistration.service.CourseRegistrationService;
import org.kuali.student.r2.common.dto.ContextInfo;
import org.kuali.student.r2.common.dto.ValidationResultInfo;
import org.kuali.student.r2.common.exceptions.DoesNotExistException;
import org.kuali.student.r2.common.exceptions.InvalidParameterException;
import org.kuali.student.r2.common.exceptions.MissingParameterException;
import org.kuali.student.r2.common.exceptions.OperationFailedException;
import org.kuali.student.r2.common.exceptions.PermissionDeniedException;
import org.kuali.student.r2.common.infc.ValidationResult;
import org.kuali.student.r2.core.constants.ProcessServiceConstants;
import org.kuali.student.r2.core.process.context.ProcessContextInfo;
import org.kuali.student.r2.core.process.evaluator.ProcessEvaluator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nwright
 */
public class CourseRegistrationServiceProcessCheckDecorator
        extends CourseRegistrationServiceDecorator {

    public CourseRegistrationServiceProcessCheckDecorator() {
    }

    public CourseRegistrationServiceProcessCheckDecorator(CourseRegistrationService nextDecorator) {
        setNextDecorator(nextDecorator);
    }
    private ProcessEvaluator processEvaluator;

    public ProcessEvaluator getProcessEvaluator() {
        return processEvaluator;
    }

    public void setProcessEvaluator(ProcessEvaluator processEvaluator) {
        this.processEvaluator = processEvaluator;
    }

    @Override
    public List<ValidationResultInfo> checkStudentEligibility(String studentId, ContextInfo context)
            throws DoesNotExistException,
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        ProcessContextInfo processContext = new ProcessContextInfo(ProcessServiceConstants.PROCESS_KEY_BASIC_ELIGIBILITY,
                studentId, null);
        List<? extends ValidationResult> results = this.processEvaluator.evaluate(processContext, context);
        List<ValidationResultInfo> infos = new ArrayList<ValidationResultInfo>(results.size());
        for (ValidationResult vr : results) {
            infos.add(new ValidationResultInfo(vr));
        }
        return infos;
    }

    @Override
    public List<ValidationResultInfo> checkStudentEligibilityForTerm(String studentId, String termKey, ContextInfo context) throws
            InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        ProcessContextInfo processContext = new ProcessContextInfo(ProcessServiceConstants.PROCESS_KEY_ELIGIBILITY_FOR_TERM, 
                studentId, termKey);
        List<? extends ValidationResult> results;
        results = this.processEvaluator.evaluate(processContext, context);
        List<ValidationResultInfo> infos = new ArrayList<ValidationResultInfo>(results.size());
        for (ValidationResult vr : results) {
            infos.add(new ValidationResultInfo(vr));
        }
        return infos;

    }

    @Override
    public List<ValidationResultInfo> checkStudentEligibiltyForCourseOffering(String studentId, String courseOfferingId,
            ContextInfo context) throws InvalidParameterException,
            MissingParameterException,
            OperationFailedException,
            PermissionDeniedException {
        // TODO: implement in phase II
        return new ArrayList();
    }
}
