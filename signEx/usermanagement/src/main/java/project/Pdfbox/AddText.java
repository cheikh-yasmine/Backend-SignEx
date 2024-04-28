package project.Pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class AddText {
        public static void main(String[] args) throws IOException {

            try {


                ////Loading an existing document | if the file is new omit PDDocument document = PDDocument.load (file);
                File file = new File("C:\\Users\\SOFTWARE2\\Desktop\\3. JEE Mapeo de entidades.pdf");
                PDDocument document = PDDocument.load(file);

                //Retrieving the pages of the document
                PDPage page = document.getPage(0);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);

                //Begin the Content stream
                contentStream.beginText();

                //Setting the font to the Content stream
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

                //Setting the position for the line
                contentStream.newLineAtOffset(25, 500);

                String text = "This is the sample document and we are adding content to it.";

                //Adding text in the form of string
                contentStream.showText(text);

                //Ending the content stream
                contentStream.endText();

                System.out.println("content add");

                //Closing the content stream
                contentStream.close();

                // Saving the document | if it is new the file omit File file = new File in row 26
                document.save(new File("C:\\Users\\SOFTWARE2\\Desktop\\NewC04.pdf"));

                //Closing the document
                document.close();

            } catch (IOException e) {
                System.out.println("exception" + e);
            }

        }

    }

