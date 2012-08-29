package com.sciencenetwork.data.type1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sciencenetwork.data.XmlFormatter;
import com.sixthcolumn.utils.json.JSONException;
import com.sixthcolumn.utils.json.JSONObject;
import com.sixthcolumn.utils.json.XML;

public class Type1 {

	private String scientificPerson;
	
	private List<String> discoveries;

	public Type1() {
		this.scientificPerson = "N/A";
		this.discoveries = new ArrayList<String>();
	}
	
	public String getScientificPerson() {
		return scientificPerson;
	}

	public void setScientificPerson(String scientificPerson) {
		this.scientificPerson = scientificPerson;
	}

	public List<String> getDiscoveries() {
		return discoveries;
	}

	public void setDiscoveries(List<String> discoveries) {
		this.discoveries = discoveries;
	}
	
	
	public Element toElement() {
        Element discoveriesEl = new Element("Discoveries");

        Element personEl = new Element("Person");
        personEl.addContent(this.scientificPerson);
        discoveriesEl.addContent(personEl);

        for(int i=0;i<discoveries.size();i++) {
        	Element discoveryEl = new Element("Discovery");
            discoveryEl.addContent(this.discoveries.get(i));
            discoveriesEl.addContent(discoveryEl);
        }
        
        return discoveriesEl;
	}
	
	/** Description of toXML()
	 * 
	 * @return
	 */
	public String toXML() {
	    String xml = "";
	    
	    Element servicesEl = this.toElement();
	
	    XMLOutputter outputter = new XMLOutputter();
	    xml = outputter.outputString(servicesEl);
	    
	    return xml;
	}
	

	/** Description of toFile()
	 * 
	 * @param file Filename of the output
	 */
	public void toFile(String file) {
		
	    try {
	        BufferedWriter out = new BufferedWriter(new FileWriter(file));
	        out.write(new XmlFormatter().format(this.toXML()));
	        out.close();
	    } 
	    catch (IOException e) { 
	        e.printStackTrace();
	        System.out.println("Exception ");
	
	    }
	 }
	
	
	/** Description of toJSONObject() 
     * 
     */
    public JSONObject toJSONObject() {
        JSONObject json = null;
        
        try {
            json = XML.toJSONObject(this.toXML());
        } catch (JSONException e) {
            System.out.println("Problem in toJSONObject");
            e.printStackTrace();
        }
        
        return json;
    }




    /** Description of toJSON() 
     * 
     */
    public String toJSON() {
        String json = null;
        
        try {
            json = this.toJSONObject().toString(3);
        } catch (JSONException e) {
            System.out.println("Problem in toJSON");
            e.printStackTrace();
        }
        
        return json;
    }

    public void fromFile(String file) {
        
		
    	this.discoveries = new ArrayList<String>();
    	this.scientificPerson = "";
    	
		File fXmlFile = new File(file);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            
            org.w3c.dom.Element type1Element = doc.getDocumentElement();
            
            this.readHelper(type1Element);
            
            
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
    }
    
    
    
    public void fromXML(String xmlStr) {

        try {

            DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlStr));

            Document doc = db.parse(is);
            
            doc.getDocumentElement().normalize();
            
            org.w3c.dom.Element docElement = doc.getDocumentElement();
            
            this.readHelper(docElement);
            
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
    
    
    
    
    public void readHelper(org.w3c.dom.Element type1Element) {
    	if(type1Element.getNodeName().equals("Discoveries")) {
    		NodeList type1List = type1Element.getChildNodes();
    		
    		List<String> discoveriesList = new ArrayList<String>();
    		String person = "";
    		
    		for(int j=0;j<type1List.getLength();j++) {
                
                Node node = type1List.item(j);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                	
                	System.out.println(node.getNodeName());
                	org.w3c.dom.Element element = (org.w3c.dom.Element) node;
                    
                	System.out.println("value: " + element.getTextContent());
                	
                	if(element.getNodeName().equals("Discovery")) {
                		discoveriesList.add(element.getTextContent());
                		System.out.println("Setting discovery to " + discoveriesList);
                	}
                	if(element.getNodeName().equals("Person")) {
                		person = element.getTextContent();
                		System.out.println("Setting person to " + person);
                	}
                }
                
            }
    		this.setDiscoveries(discoveriesList);
    		this.setScientificPerson(person);
    		
    		
    	}
	}
    
	
	
	
}
