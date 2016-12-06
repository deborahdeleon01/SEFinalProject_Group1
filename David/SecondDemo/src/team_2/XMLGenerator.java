/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team_2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Germex
 */
public class XMLGenerator {
    
    private String xmlFileName; 
    
    //TODO Everything
     public XMLGenerator(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }
    
    
    public String readNodes() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException{
//        XPath xpath = XPathFactory.newInstance().newXPath();
//                InputSource inputSource = new InputSource("D:/Software Engineering/Projects/Final Project Preliminary Work/FirstGUI/CoursesXML/csci-3340.xml");
//                try {
//                    department = xpath.evaluate("/Course/Department", inputSource);
//                    prefix = xpath.evaluate("/Course/Prefix", inputSource);
//                    number = xpath.evaluate("/Course/Number", inputSource);
//                    name = xpath.evaluate("/Course/Name", inputSource);
//                    description = xpath.evaluate("/Course/Description", inputSource);
//                    creditHours = xpath.evaluate("/Course/Credit-hours", inputSource);
//                    lectureHours = xpath.evaluate("/Course/Lecture-hours", inputSource);
//                    labHours = xpath.evaluate("/Course/Lab-hours", inputSource);
//                    level = xpath.evaluate("/Course/Level", inputSource);
//                    scheduleType = xpath.evaluate("/Course/Schedule-type", inputSource);
//                    prerequistie = xpath.evaluate("/Course/Prerequisite", inputSource);
//                    coRequisite = xpath.evaluate("/Course/Co-requisite", inputSource);
//                    legacyNumber = xpath.evaluate("/Course/Legacy-number", inputSource);
//                    crossListed = xpath.evaluate("/Course/Cross-listed", inputSource);
//                    Restrictions = xpath.evaluate("/Course/Restrictions", inputSource);
//                    courseAttributes = xpath.evaluate("/Course/CourseAttributes", inputSource);
//                    ///*/book[1]/title/@lang
//                } catch (XPathExpressionException ex) {
//                    Logger.getLogger(Team_2.class.getName()).log(Level.SEVERE, null, ex);
//                }
        return "NADA";
    }
    
}
