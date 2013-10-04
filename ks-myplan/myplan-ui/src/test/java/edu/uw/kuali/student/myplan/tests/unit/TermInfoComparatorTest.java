package edu.uw.kuali.student.myplan.tests.unit;

import edu.uw.kuali.student.myplan.util.TermInfoComparator;
import org.junit.Test;
import org.kuali.student.r2.core.atp.dto.AtpInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TermInfoComparatorTest {

    @Test
    public void circularTermListExerciseTerms() {
        AtpInfo t1 = new AtpInfo();
        t1.setId("kuali.uw.atp.type.Spring");

        AtpInfo t2 = new AtpInfo();
        t2.setId("kuali.uw.atp.type.Winter");

        AtpInfo t3 = new AtpInfo();
        t3.setId("kuali.uw.atp.type.Fall");

        AtpInfo t4 = new AtpInfo();
        t4.setId("kuali.uw.atp.type.Summer");

        List<AtpInfo> sorted = new ArrayList<AtpInfo>();
        sorted.add(t3);
        sorted.add(t2);
        sorted.add(t1);
        sorted.add(t4);
        sorted.add(t4);

        List<AtpInfo> mixed = new ArrayList<AtpInfo>();
        mixed.add(t4);
        mixed.add(t1);
        mixed.add(t2);
        mixed.add(t3);
        mixed.add(t4);

        Collections.sort(mixed, new TermInfoComparator());

        assertEquals(mixed, sorted);
    }
}
