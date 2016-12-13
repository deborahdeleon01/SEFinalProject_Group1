/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlconverter;

import java.io.*;
import java.util.ArrayList;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * XML 2 HTML converter. 
 *
 * @author Stephen Lightcap
 */
public class XML2HTML {

    //List of files of the given direcotry
    private static ArrayList<File> filesGathered = new ArrayList<>();


    /**
     * Converts one xml file to an html file w/ the given xsl file.
     *
     * @param xmlFileName
     * @param xslFileName
     * @param htmlFileName
     */
    public static void convert2Html(String xmlFileName, String xslFileName, String htmlFileName) {
        try {
            // Obtain transformer object
            TransformerFactory tFactory = TransformerFactory.newInstance();

            // Get a stream sources / results
            // xsl
            StreamSource xslStreamSourceObject = new StreamSource(xslFileName);

            //xml
            StreamSource xmlStreamSourceObject = new StreamSource(xmlFileName);

            //html
            FileOutputStream fos = new FileOutputStream(htmlFileName);
            StreamResult htmlStreamSourceObject = new StreamResult(fos);

            //Transform & results
            Transformer transformer = tFactory.newTransformer(xslStreamSourceObject);
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

            transformer.transform(xmlStreamSourceObject, htmlStreamSourceObject);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Takes a directory name, an xsl file sytlesheet, and output directory name = ex. 'TEMP/'. 'XML/' etc. Any files in sub folders in the directory
     * will also be converted.
     *
     * @param directoryName
     * @param xslFileName
     * @param outputDirectoryName
     */
    public static void convertDirectory2Html(String directoryName, String xslFileName, String outputDirectoryName) {

        //Get all files and put them into a arraylist
        generateAllFilesInDirectory(directoryName, filesGathered);

        //Loop thorugh all files and generate a html for them
        for (int i = 0; i < filesGathered.size(); i++) {
            try {
                // Obtain transformer object
                TransformerFactory tFactory = TransformerFactory.newInstance();

                // Get a stream sources / results
                // xsl
                StreamSource xslStreamSourceObject = new StreamSource(xslFileName);

                //xml
                StreamSource xmlStreamSourceObject = new StreamSource(filesGathered.get(i).getPath());

                //Output HTML with corresponding XML name: csci-xxxx.xml -> csci-xxxx.html
                FileOutputStream fos = new FileOutputStream(outputDirectoryName + filesGathered.get(i).getName().substring(0, filesGathered.get(i).getName().length() - 4) + ".html");
                StreamResult htmlStreamSourceObject = new StreamResult(fos);

                //Transform & results
                Transformer transformer = tFactory.newTransformer(xslStreamSourceObject);
                transformer.setOutputProperty(OutputKeys.METHOD, "xml");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

                transformer.transform(xmlStreamSourceObject, htmlStreamSourceObject);
            } catch (Exception e) {
                System.out.println("Error" + filesGathered.get(i).toString() + e);
            }

        }

        //Remove all files from list
        clearFileList();

    }

    /**
     * Recursively get all files in any given directory that is of the 'type'
     * the user specified.
     *
     * @param directoryName
     * @param filesGathered
     */
    private static void generateAllFilesInDirectory(String directoryName, ArrayList<File> filesGathered) {

        try {
            File directory = new File(directoryName);

            // get all the files from a directory
            File[] fList = directory.listFiles();

            for (File file : fList) {
                if (file.isFile()) {

                    filesGathered.add(file);

                } else if (file.isDirectory()) {
                    //Recursively call in for any sub directories
                    generateAllFilesInDirectory(file.getAbsolutePath(), filesGathered);
                }

            }
        } catch (NullPointerException e) {
            System.out.print("Error in generateAllFilesInDirectory method " + e);
        }
    }

    /**
     * Clears list after it is used. Avoids memory leaks and an overly large
     * list from being made and continually added to.
     */
    private static void clearFileList() {
        filesGathered.clear();
    }

}
