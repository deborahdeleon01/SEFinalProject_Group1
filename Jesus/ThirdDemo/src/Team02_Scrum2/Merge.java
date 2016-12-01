/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Team02_Scrum2;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Germex
 */
public class Merge {

    public static void mergeMultipleXMLDocs(List<File> list, String jointXmlRootNode, String outName) {
        File in;

        //String xmlFileName;
        try {
            DocumentBuilderFactory dbFactory;
            DocumentBuilder dBuilder;

            Document mergedDoc;

            FileOutputStream fos = new FileOutputStream(outName);
            StreamResult xmlStreamSourceObject = new StreamResult(fos);

            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();

            mergedDoc = dBuilder.newDocument();
            Element mainRootElement = mergedDoc.createElement(jointXmlRootNode); // doc.createElementNS();
            mergedDoc.appendChild(mainRootElement);

            //Get Top Level Node
            for (File inFile : list) {
                in = new File(inFile.getAbsolutePath());
                Document current_doc1 = dBuilder.parse(in);
                Node n = mergedDoc.importNode(current_doc1.getFirstChild(), true);
                mainRootElement.appendChild(n);
            }

            // Output DOM XML to xml file 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(mergedDoc);
            transformer.transform(source, xmlStreamSourceObject);

            System.out.println("The Merged xml is:" + outName);
            

        } catch (Exception e) {
        }

    }
}
