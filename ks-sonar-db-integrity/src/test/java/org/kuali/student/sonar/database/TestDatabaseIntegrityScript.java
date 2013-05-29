package org.kuali.student.sonar.database;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.kuali.student.sonar.database.exception.*;
import org.kuali.student.sonar.database.plugin.ForeignKeyConstraint;
import org.kuali.student.sonar.database.utility.FKConstraintReport;
import org.kuali.student.sonar.database.utility.FKConstraintValidator;
import org.kuali.student.sonar.database.utility.FKGenerationUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: lsymms
 * Date: 5/17/13
 * Time: 12:08 AM
 *
 * Runs Database integrity checks by searching for unconstrained FK Relationships.
 * Finds Problems with the Mappings that are returned by the search.  It then attempts
 * to create the FK Constraint.  The addConstraint method will throw excetpions if
 * there are any issues which get handled here by adding to lists of Constraint
 * Issues.  At the end of the test the report is sent to System.out
 */
public class TestDatabaseIntegrityScript {

    private FKConstraintValidator validator;

    @Before
    public void init() {
        validator = new FKConstraintValidator();
        validator.setDbDriver("oracle.jdbc.driver.OracleDriver");
        validator.setDbUrl("jdbc:oracle:thin:@lsymms-dev.no-ip.org:1521:xe");
        validator.setDbUser("KSBUNDLED");
        validator.setDbPassword("KSBUNDLED");
    }

    @Test
    public void testFKSQL() throws SQLException {

        FKConstraintReport report = validator.runFKSQL();

        System.out.println("\n****    Done Adding constraints and Detecting Orphaned Data    *****\n");

        System.out.println("\nReporting Issues\n");
        for (ForeignKeyConstraint constraint : report.getFieldMappingIssues()) {
            System.out.println("FIELD MAPPING ISSUE: Field does not exists (" +
                    constraint.foreignTable + "." +
                    constraint.foreignColumn + ")");
        }

        for (ForeignKeyConstraint constraint : report.getTableMappingIssues()) {
            System.out.println("TABLE MAPPING ISSUE: table " +
                    constraint.foreignTable +
                    " not found in constraint: " + constraint.toString());
        }

        for (ForeignKeyConstraint constraint : report.getColumnTypeIncompatabilityIssues()) {
            System.out.println("COLUMN TYPE INCOMPATIBILITY ISSUE: " +
                    constraint.toString());
        }

        for (ForeignKeyConstraint constraint : report.getOrphanedDataIssues()) {
            System.out.println("ORPHANED DATA FOR RELATIONSHIP: " +
                    constraint.toString());
        }

        for (ForeignKeyConstraint constraint : report.getOtherIssues()) {
            System.out.println("UNHANDLED CONSTRAINT MAPPING ISSUE: " +
                    constraint.toString() + " (see log for more details)");
        }
    }

    @After
    public void cleanup() throws MissingFieldException, SQLException {
        validator.revert();
    }

}