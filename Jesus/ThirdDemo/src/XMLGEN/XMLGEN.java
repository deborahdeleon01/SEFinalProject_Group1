/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLGEN;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Gonzalo
 */

public class XMLGEN {
    private String[] NodeName = null;
    private String[] NodeText = null;
    private ArrayList<String> NodeNameList = null;
    private ArrayList<String> NodeTextList = null;
    private String newfilename;

    public XMLGEN() {
    }

    public XMLGEN(ArrayList<String> NewNodeNameList, ArrayList<String> NewNodeTextList) {
        generateWithArraylists(NodeNameList, NodeTextList, newfilename);
    }

    public XMLGEN(String[] NewNodeName, String[] NewNodeText) {
        generateWithArrays(NodeName, NodeText, newfilename);
    }


    private void generateWithArraylists(ArrayList<String> NodeNameList, ArrayList<String> NodeTextList, String filename) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Course");
            doc.appendChild(rootElement);

            for (int i = 0; i < NodeNameList.size(); i++) {
                Element e = doc.createElement(NodeNameList.get(i));
                e.appendChild(doc.createTextNode(NodeTextList.get(i)));
                rootElement.appendChild(e);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename + ".xml"));


            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }


    private void generateWithArrays(String[] NodeName, String[] NodeText, String filename) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Course");
            doc.appendChild(rootElement);

            for (int i = 0; i < NodeName.length; i++) {
                Element e = doc.createElement(NodeName[i]);
                e.appendChild(doc.createTextNode(NodeText[i]));
                rootElement.appendChild(e);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filename + ".xml"));


            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    public void generateXMLWithArrayLists(ArrayList<String> NewNodeNamesList, ArrayList<String> NewNodeTextstList, String FileName) {
        generateWithArraylists(NewNodeNamesList, NewNodeTextstList, FileName);
    }

    public void generateXMLWithArrays(String[] NodeNames, String[] NodeTexts, String FileName) {
        generateWithArrays(NodeNames, NodeTexts, FileName);
    }


    public String[] getNodeName() {
        return NodeName;
    }

    public void setNodeName(String[] NodeName) {
        this.NodeName = NodeName;
    }

    public String[] getNodeText() {
        return NodeText;
    }

    public void setNodeText(String[] NodeText) {
        this.NodeText = NodeText;
    }

    public ArrayList<String> getNodeNameList() {
        return NodeNameList;
    }

    public void setNodeNameList(ArrayList<String> NodeNameList) {
        this.NodeNameList = NodeNameList;
    }

    public ArrayList<String> getNodeTextList() {
        return NodeTextList;
    }

    public void setNodeTextList(ArrayList<String> NodeTextList) {
        this.NodeTextList = NodeTextList;
    }

}
