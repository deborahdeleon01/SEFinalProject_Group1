/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconverter;

import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.File;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts one html to pdf, or converts an array of html files to pdf.
 *
 * @author Stephen Lightcap
 */
public class PDFConverter {

    /**
     * Converts a given html file name and outputs a pdf file.
     *
     * @param htmlFileName
     * @param pdfFileName
     * @return
     */
  
    
    public static void convert2Pdf(String htmlFileName, String pdfFileName) {
        try {
            String url = new File(htmlFileName).toURI().toURL().toString();
            //Debugging: System.out.println(""+url);
            OutputStream os = new FileOutputStream(pdfFileName);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            renderer.layout();
            renderer.createPDF(os);
            os.close();
        } catch (DocumentException e) {
            System.out.println("Error in the html to pdf converter" + e);
        } catch (IOException e) {
            System.out.println("Error in the html to pdf converter" + e);
        } catch (Exception e) {
            System.out.println("Error in the html to pdf converter" + e);
        }
    }

    
     public static void testConvert2Pdf() {
        System.out.println("convert2Pdf");
        String htmlFileName = "HTML/csci-1170.html";
        String pdfFileName = "PDF/EmailAttachment/CombinedPDFFiles.pdf";
        PDFConverter.convert2Pdf(htmlFileName, pdfFileName);
      
    
    }

    /**
     * Converts a list of PDF files and outputs them to the given directory with
     * the outName String
     *
     *
     * @param list
     * @param outName
     * @throws DocumentException
     * @throws IOException
     */
    public static void combinePDFFiles(List<String> list, String outName) throws DocumentException, IOException {
        OutputStream out = null;
        Document document = null;
        PdfWriter writer = null;
        FileInputStream in = null;
        try {
            // Resulting pdf
            out = new FileOutputStream(new File(outName));
            document = new Document();
            writer = PdfWriter.getInstance(document, out);
            document.open();
            PdfContentByte cb = writer.getDirectContent();
            for (String inFile : list) {
                in = new FileInputStream(new File(inFile));
                PdfReader reader = new PdfReader(in);
                for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                    document.newPage();
                    //import the page from source pdf
                    PdfImportedPage page = writer.getImportedPage(reader, i);
                    //add the page to the destination pdf
                    cb.addTemplate(page, 0, 0);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.flush();
            document.close();
            out.close();
            in.close();
        }

    }
    public void testCombinePDFFiles() throws Exception {
        System.out.println("combinePDFFiles");
        List<String> list = new ArrayList<>();
        
        list.add("csci-1101.pdf");
        list.add("csci-1105.pdf");
        list.add("csci-1170.pdf");
        
        String outName = "combinedPDFTest.pdf";
        PDFConverter.combinePDFFiles(list, outName);
  
        
      
    }

}
