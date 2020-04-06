/*
 * Copyright (C) 2020 Dard
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.gcomputers.utilities.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
/**
 *
 * @author Dard
 */
public abstract class DomParserUtils {

    public static Object loadDocumentFile(String filePath){
        try {
            File DomXMLFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(DomXMLFile);

            doc.getDocumentElement().normalize();

            return doc;
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            Logger.getLogger(DomParserUtils.class.getName()).log(Level.SEVERE, null, e);
            System.exit(-1);
        }
        return null;
    }
    
    public static int getPrimaryObjectsNumber(Object doc, String primaryObjectName){
        Document document = (Document)doc;
        return document.getElementsByTagName(primaryObjectName).getLength();
    }
    
    public static int getPrimaryAttributesNumber(Object doc, String primaryObjectName){
        Document document = (Document)doc;
        return document.getElementsByTagName(primaryObjectName).item(0).getAttributes().getLength();
    }
    
    public static int getChildObjectsNumber(Object doc){
        Document document = (Document)doc;
        
        return (document.getDocumentElement().getChildNodes().item(1).getChildNodes().getLength() / 2);
    }
    
    public static String getPrimaryNodeName(Object doc){
        Document document = (Document)doc;
        return document.getDocumentElement().getChildNodes().item(1).getNodeName();
    }
    
    public static String[][] parseDomXML(Object doc, String primaryObjectName, int primaryObjectsNumber, int primaryAttributesNumber, int childElementsNumber) {     
        String[][] domFile;
        Document document = (Document)doc;
        
        NodeList nList = document.getElementsByTagName(primaryObjectName);
        
        domFile = new String[primaryObjectsNumber][primaryAttributesNumber + childElementsNumber];

        for (int x = 0; x < primaryObjectsNumber; x++) {

                Node nNode = nList.item(x);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    domFile[x][0] = nNode.getAttributes().item(0).getTextContent();

                    for (int y = 1; y < primaryAttributesNumber + childElementsNumber; y++){    
                        domFile[x][y] = nNode.getChildNodes().item(y + (y - 1)).getTextContent();
                    }
                }
        }
        return domFile;
    }
}
