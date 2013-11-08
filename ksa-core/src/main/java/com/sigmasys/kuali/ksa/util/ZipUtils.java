package com.sigmasys.kuali.ksa.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * This class contains methods for compressing or decompressing text.
 *
 * Created with IntelliJ IDEA.
 * User: Sergey
 * Date: 11/7/13
 * Time: 11:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ZipUtils {

    private ZipUtils() {}

    /**
     * Compresses a String with GZIP.
     * @param str   String to compress.
     * @return      Compressed String.
     * @throws Exception    If compression fails.
     */
    public static String compress(String str) throws Exception {
        if (str == null || str.length() == 0) {
            return str;
        }

        ByteArrayOutputStream obj=new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(obj);

        gzip.write(str.getBytes("UTF-8"));
        gzip.close();

        String outStr = obj.toString("UTF-8");

        return outStr;
    }

    /**
     * Decompresses a String using GZIP.
     * @param str   String to decompress.
     * @return      Decompressed String.
     * @throws Exception    If decompression fails.
     */
    public static String decompress(String str) throws Exception {
        if (str == null || str.length() == 0) {
            return str;
        }

        GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(str.getBytes("UTF-8")));
        BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
        String outStr = "";
        String line;

        while ((line=bf.readLine())!=null) {
            outStr += line;
        }

        return outStr;
    }

    /**
     * Adds the specified entries to a ZIP file. Returns the created ZIP file.
     *
     * @param entries       Entries to add to the new ZIP file.
     * @param zipFileName   Name for a ZIP file to generate. If omitted, a default name will be generated.
     * @return          The newly generated ZIP file or null if ZIP creation failed.
     */
    public static File createZip(List<ZipFileEntry> entries, String zipFileName) {
        File zipFile = null;
        ZipOutputStream out = null;

        try  {
            zipFileName = System.getProperty("user.dir") + File.separator
                    + StringUtils.defaultString(zipFileName, RandomStringUtils.randomAlphanumeric(15) + ".zip");
            zipFile = new File(zipFileName);
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(zipFile);
            out = new ZipOutputStream(new BufferedOutputStream(dest));
            int buffSize = 1024;
            byte data[] = new byte[buffSize];

            for(ZipFileEntry entry : entries) {
                ByteArrayInputStream inputStream = new ByteArrayInputStream(entry.getContent());
                origin = new BufferedInputStream(inputStream, buffSize);
                ZipEntry zipEntry = new ZipEntry(entry.getName());

                out.putNextEntry(zipEntry);
                int count;
                while ((count = origin.read(data, 0, buffSize)) != -1) {
                    out.write(data, 0, count);
                }

                try {
                    origin.close();
                } catch (Exception e) {}
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {}
        }

        return zipFile;
    }

}
