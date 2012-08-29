package com.sciencenetwork.data.type2;

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

import com.sciencenetwork.data.ReturnedObjects;
import com.sciencenetwork.data.XmlFormatter;
import com.sciencenetwork.data.type10.Discovery;
import com.sixthcolumn.utils.json.JSONException;
import com.sixthcolumn.utils.json.JSONObject;
import com.sixthcolumn.utils.json.XML;

public class Discoveries implements ReturnedObjects {

	private String person;
	private String timestamp;
	private List<String> discoveries; 
	
	private static String DIRECTORY = ReturnedObjects.fileDirectoryLocation + "";
	
	
	public static void main(String [] args) {
		Discoveries discoveries = new Discoveries();
		
		List<String> discs = new ArrayList<String>();
		discs.add("discovery1");
		discs.add("discovery2");
		discoveries.setDiscoveries(discs);
		
		String timestamp = "timestamp22";
		discoveries.setTimestamp(timestamp);
		
		String person = "person";
		discoveries.setPerson(person);
		
		String xml = discoveries.toXML();
		
		Discoveries discoveries2 = new Discoveries();
		
		discoveries2.fromXML(xml);
		
		System.out.println(discoveries2.getTimestamp());
		
		String type = "file";
		String file = DIRECTORY + "type2.xml";
		discoveries2.toDataStore(type, file);
		
		
		Discoveries discoveries3 = new Discoveries();
		discoveries3.fromDataStore(type, file);
		
		System.out.println(discoveries.getPerson());
	}
	
	public Discoveries() {
		this.person = "";
		this.timestamp = "";
		this.discoveries = new ArrayList<String>();
	}
	
	@Override
	public Element toElement() {
		Element discoveriesEl = new Element("discoveries");

		Element personEl = new Element("person");
		personEl.addContent(this.person);
		discoveriesEl.addContent(personEl);
		
		Element timestampEl = new Element("timestamp");
		timestampEl.addContent(this.timestamp);
		discoveriesEl.addContent(timestampEl);
		
		for(int i=0;i<discoveries.size();i++) {
			Element discoveryEl = new Element("discovery");
			discoveryEl.addContent(this.discoveries.get(i));
			discoveriesEl.addContent(discoveryEl);
		}
        
        return discoveriesEl;
	}

	@Override
	public String toXML() {
		String xml = "";
	    
	    Element servicesEl = this.toElement();
	
	    XMLOutputter outputter = new XMLOutputter();
	    xml = outputter.outputString(servicesEl);
	    
	    return xml;
	}
	
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
    @Override
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

	@Override
	public void toDataStore(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromXML() {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromDataStore(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fromDataStore(String type, String file) {
		File fXmlFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();
            
            org.w3c.dom.Element docElement = doc.getDocumentElement();
            
            this.readHelper(docElement);
            
            
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	private void readHelper(org.w3c.dom.Element docElement) {

		System.out.println("in read helper");
		
		//Discovery discovery = new Discovery();
    	
		if(docElement.getNodeName().equals("discoveries")) { 
			NodeList docNodeList = docElement.getChildNodes();
	        
			List<String> discoveries = new ArrayList<String>();
			
			
			for(int i=0;i<docNodeList.getLength();i++) {
				Node topLevelDocNode = docNodeList.item(i);
                if (topLevelDocNode.getNodeType() == Node.ELEMENT_NODE) {
                	org.w3c.dom.Element topLevelElement = (org.w3c.dom.Element) topLevelDocNode;
                    System.out.println(topLevelElement.getNodeName());
                    if(topLevelElement.getNodeName().equals("discovery")) {
                    	String discovery = topLevelElement.getTextContent();
                    	discoveries.add(discovery);
                    } else if(topLevelElement.getNodeName().equals("person")) {
                    	String person = topLevelElement.getTextContent();
                    	this.setPerson(person);
                    } else if(topLevelElement.getNodeName().equals("timestamp")) {
                    	String timestamp = topLevelElement.getTextContent();
                    	this.setTimestamp(timestamp);
                }
                }	
			}
			
			this.setDiscoveries(discoveries);
			
			
		}
		
	}

	@Override
	public void toDataStore(String type, String file) {
		
		if(type.equals("file")) {
			try {
		        BufferedWriter out = new BufferedWriter(new FileWriter(file));
		        out.write(new XmlFormatter().format(this.toXML()));
		        out.close();
		    } 
		    catch (IOException e) { 
		        e.printStackTrace();
		        System.out.println("Exception ");
		
		    }
		} else {
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
		
	}

	@Override
	public void fromXML(String xmlStr) {
		
		this.discoveries = new ArrayList<String>();
		this.person = "";
		this.timestamp = "";
        
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

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getDiscoveries() {
		return discoveries;
	}

	public void setDiscoveries(List<String> discoveries) {
		this.discoveries = discoveries;
	}

}
