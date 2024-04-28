package project.Pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadText {


        public static void main(String[] args) {


            try {
                File file = new File("C:\\Users\\SOFTWARE2\\Desktop\\3. JEE Mapeo de entidades.pdf");
                PDDocument document = PDDocument.load(file);

                PDFTextStripper pdfStripper = new PDFTextStripper();

                String text=pdfStripper.getText(document);
                System.out.println("que tengo :"+text);

                document.close();


            } catch (IOException ex) {
                Logger.getLogger(Read_Text.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

