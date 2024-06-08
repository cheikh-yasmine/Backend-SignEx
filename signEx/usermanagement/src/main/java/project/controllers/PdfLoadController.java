package project.controllers;


import org.apache.pdfbox.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class PdfLoadController
{
    @RequestMapping(value = "/loadPdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public void loadPdf(HttpServletResponse response) throws IOException
    {
        File pdfFile = new File("<Project base folder full path>/test1.pdf");

        if (pdfFile.exists())
        {
            long fileSize = pdfFile.length();
            response.setContentLengthLong(fileSize);
            response.setContentType("application/pdf");

            FileInputStream fs =  null;
            try
            {
                fs = new FileInputStream(pdfFile);
                IOUtils.copy(fs, response.getOutputStream());
                response.flushBuffer();
            }
            finally
            {
                if (fs != null)
                {
                    fs.close();
                }
            }
        }
    }
}
