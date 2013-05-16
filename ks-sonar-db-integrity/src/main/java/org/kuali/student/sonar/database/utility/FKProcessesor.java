package org.kuali.student.sonar.database.utility;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: lsymms
 * Date: 5/16/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class FKProcessesor {
    public static int fKseq = 0;

    public static String getFKSQL(String filename) {
        InputStream is = null;
        String sql = null;
        byte[] b = null;

        is = ClassLoader.getSystemResourceAsStream(filename);
        if (is == null) {
            throw new RuntimeException("error reading file " + filename);
        }

        try {
            b = new byte[is.available()];
            is.read(b);
            sql = new String(b);
        } catch (IOException e) {
            throw new RuntimeException("error reading file " + filename, e);
        }
        return sql;
    }

    public static String getAlterStmt(String localTable, String localColumn, String foreignTable, String foreignColumn) {
        fKseq++;

        return "ALTER TABLE " + localTable +
                " ADD CONSTRAINT DB_INGRTY_CHK_FK_" + fKseq +
                " FOREIGN KEY (" + localColumn + ") " +
                "REFERENCES " + foreignTable + " (" + foreignColumn + " )";
    }
}
