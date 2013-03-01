package com.sigmasys.kuali.ksa.krad.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


/**
 * This controller enables its subclasses to start downloading process
 * by writing the specified content into the provided <code>HttpServletResponse</code>
 * 
 * @author Sergey Godunov
 */
public abstract class DownloadController extends GenericSearchController {

    /**
     * Sends content as a String to the ServletResponse output stream.  Typically
     * you want the browser to receive a different name than the
     * name the file has been saved in your local database, since
     * your local names need to be unique.
     *
     * @param content	Content to be sent to the client for downloading.
     * @param fileName	Name of the file to save the content as. 
     * @param mimeType	MIME type of the file to download.
     * @param response 	Response to send content to.
     */
    protected void doDownload(String content, String fileName, String mimeType, HttpServletResponse response) throws IOException {
        response.setContentType(mimeType);
        response.setContentLength(content.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        ByteArrayInputStream inputStream = new ByteArrayInputStream(content.getBytes());
        ServletOutputStream outputStream = response.getOutputStream();

        try {
            int length;
            int bufSize = 1024;
            byte[] buffer = new byte[bufSize];
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
        } finally {
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }
    }

}
