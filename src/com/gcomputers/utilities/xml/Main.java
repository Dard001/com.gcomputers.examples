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

/**
 *
 * @author Dard
 */
public abstract class Main {
    private static final String FILE_PATH = "src\\com\\gcomputers\\utilities\\xml\\DomXML_1.xml";
   
    public static void main(String[] args){
        Object doc = DomParserUtils.loadDocumentFile(FILE_PATH);
        String primaryNodeName = DomParserUtils.getPrimaryNodeName(doc);
        int numberOfPrimaryObjects = DomParserUtils.getPrimaryObjectsNumber(doc, primaryNodeName);
        int numberOfPrimaryAttributes = DomParserUtils.getPrimaryAttributesNumber(doc, primaryNodeName);
        int numberOfChildElements = DomParserUtils.getChildObjectsNumber(doc);

        String[][] domFile = DomParserUtils.parseDomXML(doc, primaryNodeName, numberOfPrimaryObjects, numberOfPrimaryAttributes, numberOfChildElements);
        
        for (int x = 0; x < numberOfPrimaryObjects; x++){
            for(int y = 0; y < numberOfPrimaryAttributes + numberOfChildElements; y++){
                System.out.println(domFile[x][y]);

            }
            System.out.println("---------------------");
        }
    }
}
