
package org.kuali.student.lum.course.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.2.9
 * Thu Nov 04 11:39:27 EDT 2010
 * Generated source version: 2.2.9
 */

@XmlRootElement(name = "createCourse", namespace = "http://student.kuali.org/wsdl/course")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createCourse", namespace = "http://student.kuali.org/wsdl/course")

public class CreateCourse {

    @XmlElement(name = "courseInfo")
    private org.kuali.student.lum.course.dto.CourseInfo courseInfo;

    public org.kuali.student.lum.course.dto.CourseInfo getCourseInfo() {
        return this.courseInfo;
    }

    public void setCourseInfo(org.kuali.student.lum.course.dto.CourseInfo newCourseInfo)  {
        this.courseInfo = newCourseInfo;
    }

}

