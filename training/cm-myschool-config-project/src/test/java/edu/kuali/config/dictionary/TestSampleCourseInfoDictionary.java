/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kuali.config.dictionary;

import org.kuali.student.common.dictionary.service.impl.DictionaryTesterHelper;
import org.kuali.student.lum.course.dto.CourseInfo;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestSampleCourseInfoDictionary
{

 @Test
 public void testLoadCourseInfoDictionary ()
 {
  Set<String> startingClasses = new LinkedHashSet ();
  startingClasses.add (CourseInfo.class.getName ());
//  startingClasses.add (CluCluRelationInfo.class.getName ());
  String contextFile = "ks-sample-courseInfo-dictionary-context";
  String outFile = "target/" + contextFile + ".txt";
  DictionaryTesterHelper helper = new DictionaryTesterHelper (outFile,
                                                              startingClasses,
                                                              contextFile
                                                             + ".xml",
                                                              false);
  List<String> errors = helper.doTest ();
  if (errors.size () > 0)
  {
   fail ("failed dictionary validation:\n" + formatAsString (errors));
  }
 }

 private String formatAsString (List<String> errors)
 {
  int i = 0;
  StringBuilder builder = new StringBuilder ();
  for (String error : errors)
  {
   i ++;
            builder.append(i).append(". ").append(error).append ("\n");
  }
  return builder.toString ();
 }


 
}

