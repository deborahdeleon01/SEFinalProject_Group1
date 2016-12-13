/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLGEN;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Gonzalo
 */

public class XMLGEN {
    private String[] NodeName = null;
    private String[] NodeText = null;
    private ArrayList<String> NodeNameList = null;
    private ArrayList<String> NodeTextList = null;
    private String newfilename;

    /**
     * 
     */
    public XMLGEN() {
    
    }
    
    /**
     * 
     * @param NewNodeNameList
     * @param NewNodeTextList 
     */
    public XMLGEN(ArrayList<String> NewNodeNameList, ArrayList<String> NewNodeTextList) {
        generateWithArraylists(NodeNameList, NodeTextList, newfilename);
    }
    
    /**
     * 
     * @param NewNodeName
     * @param NewNodeText 
     */
    public XMLGEN(String[] NewNodeName, String[] NewNodeText) {
        generateWithArrays(NodeName, NodeText, newfilename);
    }

    /**
     * 
     * @param NodeNameList
     * @param NodeTextList
     * @param filename 
     */
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

    /**
     * 
     * @param NodeName
     * @param NodeText
     * @param filename 
     */
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
    
    /**
     * 
     * @param NewNodeNamesList
     * @param NewNodeTextstList
     * @param FileName 
     */
    public void generateXMLWithArrayLists(ArrayList<String> NewNodeNamesList, ArrayList<String> NewNodeTextstList, String FileName) {
        generateWithArraylists(NewNodeNamesList, NewNodeTextstList, FileName);
    }
    
    /**
     * 
     * @param NodeNames
     * @param NodeTexts
     * @param FileName 
     */
    public void generateXMLWithArrays(String[] NodeNames, String[] NodeTexts, String FileName) {
        generateWithArrays(NodeNames, NodeTexts, FileName);
    }

    /**
     * 
     * @return NodeName
     */
    public String[] getNodeName() {
        return NodeName;
    }
    
    /**
     * 
     * @param NodeName set
     */
    public void setNodeName(String[] NodeName) {
        this.NodeName = NodeName;
    }
    
    /**
     * 
     * @return NodeText
     */
    public String[] getNodeText() {
        return NodeText;
    }
    
    /**
     * 
     * @param NodeText set
     */
    public void setNodeText(String[] NodeText) {
        this.NodeText = NodeText;
    }
    
    /**
     * 
     * @return NodeNameList ArrayList
     */
    public ArrayList<String> getNodeNameList() {
        return NodeNameList;
    }
    
    /**
     * 
     * @param NodeNameList set ArrayList 
     */
    public void setNodeNameList(ArrayList<String> NodeNameList) {
        this.NodeNameList = NodeNameList;
    }
    
    /**
     * 
     * @return NodeTextList ArrayList
     */
    public ArrayList<String> getNodeTextList() {
        return NodeTextList;
    }
    
    /**
     * 
     * @param NodeTextList set ArrayList
     */
    public void setNodeTextList(ArrayList<String> NodeTextList) {
        this.NodeTextList = NodeTextList;
    }

}
