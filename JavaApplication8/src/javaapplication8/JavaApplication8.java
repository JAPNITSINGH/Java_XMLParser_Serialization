/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Mahe
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
       //Parse the xml
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = f.newDocumentBuilder();
        Document doc = builder.parse("myFile.xml");
      // Extract with tags
        NodeList studentList = doc.getElementsByTagName("student");
        for(int i = 0 ; i < studentList.getLength() ; i++)
        {   // Get every node from NodeList
            Node n = studentList.item(i);
            if(n.getNodeType() == Node.ELEMENT_NODE)
            { // Convert Node to an element and extract informtion
                Element e = (Element) n; // Note your element now contains <student>.....</student>
//                String name = e.getAttribute("name"); //this would work if name tag was something like <student name="">.....
//                System.out.println(name); // try replacing this with System.out.println(e.getTextContent)
                NodeList nameList = e.getChildNodes();
                for(int j = 0 ; j < nameList.getLength() ; j++)
                {   Node n2 = nameList.item(j); // Now n2 has <name>...</name> or <major>...</major> it occours alterntely as nodes
                    if(n2.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element e2 = (Element) n2;
                        System.out.println(e2.getTextContent());
                    }
                }
                
            }
        }
        
    }
// NOTE : System.out.println(e.getTextContent()); also does the same thing by printing all the info in the tags.
    //But nested for loops or recursion is required to access infromation regrding specific tags.
    // To print only names use if(e2.getTagName().equals("name")) before printing.
}
