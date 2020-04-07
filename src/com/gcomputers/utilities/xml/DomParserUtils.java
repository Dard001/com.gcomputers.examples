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

    private static Document loadDocumentFile(String filePath){
        try {
            File domXMLFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(domXMLFile);

            doc.getDocumentElement().normalize();

            return doc;
        } catch (IOException | ParserConfigurationException | DOMException | SAXException e) {
            Logger.getLogger(DomParserUtils.class.getName()).log(Level.SEVERE, null, e);
            System.exit(-1);
        }
        return null;
    }
    
    public static String[][] toStringArray(NodeList nList){
        int primaryElementsNumber = nList.getLength();
        int primaryAttributesNumber = nList.item(0).getAttributes().getLength();
        int childNodesNumber = nList.item(0).getChildNodes().getLength() / 2;

        String[][] domFile = new String[primaryElementsNumber][primaryAttributesNumber + childNodesNumber];

        if(primaryAttributesNumber > 0){
            for (int x = 0; x < primaryElementsNumber; x++) {
                Node nNode = nList.item(x);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        domFile[x][0] = nNode.getAttributes().item(0).getTextContent();

                        for (int y = 1; y < primaryAttributesNumber + childNodesNumber; y++){    
                            domFile[x][y] = nNode.getChildNodes().item(y + (y - 1)).getTextContent();
                    } 
                } 
            }
        } else {
            for (int x = 0; x < primaryElementsNumber; x++) {
                Node nNode = nList.item(x);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        for (int y = 0, z = 1; y < childNodesNumber; y++, z++){    
                            domFile[x][y] = nNode.getChildNodes().item(y + z).getTextContent();
                    } 
                } 
            }
        }
        return domFile;
    }
    
    public static NodeList parseDomXML(String path) {     
        Document document = DomParserUtils.loadDocumentFile(path);
        String primaryElementName = document.getDocumentElement().getChildNodes().item(1).getNodeName();
        NodeList nList = document.getElementsByTagName(primaryElementName);
        
        return nList;
    }
}
