package org.kuali.student.core.dictionary.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.kuali.student.common.dictionary.dto.ObjectStructureDefinition;
import org.kuali.student.common.dictionary.service.impl.DictionaryTesterHelper;
import org.kuali.student.common.exceptions.OperationFailedException;
import org.kuali.student.common.validation.dto.ValidationResultInfo;
import org.kuali.student.common.validator.DefaultValidatorImpl;
import org.kuali.student.common.validator.ServerDateParser;
import org.kuali.student.core.atp.dto.AtpInfo;
import org.kuali.student.core.atp.dto.DateRangeInfo;
import org.kuali.student.core.atp.dto.MilestoneInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

public class TestAtpDictionary {

	@Test
	public void testLoadAtpDictionary() {
  System.out.println ("testing atp dictionary");
		Set<String> startingClasses = new LinkedHashSet();
		startingClasses.add(AtpInfo.class.getName ());
		startingClasses.add(MilestoneInfo.class.getName ());
		startingClasses.add(DateRangeInfo.class.getName ());
		String contextFile = "ks-atp-dictionary-context";
		String outFile = "target/" + contextFile + ".txt";
		DictionaryTesterHelper helper = new DictionaryTesterHelper(outFile,
				startingClasses, contextFile + ".xml", false);
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
   builder.append (i + ". " + error + "\n");
  }
  return builder.toString ();
 }


	@Test
	public void testAtpInfoValidation() throws OperationFailedException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:ks-atp-dictionary-context.xml");
		System.out.println("h2. Validation Test");
		DefaultValidatorImpl val = new DefaultValidatorImpl();
		val.setDateParser(new ServerDateParser());
		val.setSearchDispatcher(new MockSearchDispatcher());
		AtpInfo info = new AtpInfo ();
		ObjectStructureDefinition os = (ObjectStructureDefinition) ac.getBean(info.getClass().getName());
		List<ValidationResultInfo> validationResults = val.validateObject(info,	os);
		System.out.println("h3. With just a blank StatementInfo");
		for (ValidationResultInfo vr : validationResults)
  {
   System.out.println (vr.getElement () + " " + vr.getMessage ());
  }
		assertEquals(3, validationResults.size());
	}

}
