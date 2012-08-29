package com.sciencenetwork.data.type10;

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

import com.sciencenetwork.data.XmlFormatter;

import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sciencenetwork.data.ReturnedObjects;
import com.sixthcolumn.utils.json.JSONException;
import com.sixthcolumn.utils.json.JSONObject;
import com.sixthcolumn.utils.json.XML;

public class Discovery implements ReturnedObjects {
	private String person;
	private String action;
	private String sourceDiscovery;
	private String targetDiscovery;
	
	public Discovery() {
		this.person = "";
		this.action = "";
		this.sourceDiscovery = "";
		this.targetDiscovery = "";
	}
	
	public static void main(String [] args) {
		Discovery discovery = new Discovery();

		discovery.setAction("action2");
		discovery.setPerson("person2");
		discovery.setSourceDiscovery("source2");
		discovery.setTargetDiscovery("target2");
		
		
		System.out.println(discovery.toXML());
		
		String directory = ReturnedObjects.fileDirectoryLocation;
		String file = directory + "Discovery.xml";
		String type = "file";
		
		
		
		discovery.toDataStore(type,file);

		discovery.setTargetDiscovery("target22");
		
		String discXML = discovery.toXML();
		
		Discovery discovery2 = new Discovery();
		
		discXML = "<Discovery><a></a><Person>p</Person><TargetDiscovery>td</TargetDiscovery></Discovery>";
		
		discovery2.fromXML(discXML);
		
		System.out.println(discovery2.getSourceDiscovery());
		
		System.out.println(discovery2.toJSON());
	}
	
	
	@Override
	public Element toElement() {
		
		Element discoveryEl = new Element("Discovery");

		Element personEl = new Element("Person");
		personEl.addContent(this.person);
		discoveryEl.addContent(personEl);

		Element actionEl = new Element("Action");
		actionEl.addContent(this.action);
		discoveryEl.addContent(actionEl);

		Element sourceDiscoveryEl = new Element("SourceDiscovery");
		sourceDiscoveryEl.addContent(this.sourceDiscovery);
		discoveryEl.addContent(sourceDiscoveryEl);

		Element targetDiscoveryEl = new Element("TargetDiscovery");
		targetDiscoveryEl.addContent(this.targetDiscovery);
		discoveryEl.addContent(targetDiscoveryEl);
        
        return discoveryEl;
		
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
	public void toDataStore(String type,String file) {
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
		

		this.action = null;
        this.sourceDiscovery = null;
        this.targetDiscovery = null;
        this.person = null;
        
        
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
	
	
	
	


	@Override
	public void fromDataStore(String type, String file) {
		
		
		this.action = null;
        this.sourceDiscovery = null;
        this.targetDiscovery = null;
        this.person = null;
		
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


	@Override
	public void toDataStore(String type) {
		// TODO Auto-generated method stub
		
	}
	
	public void readHelper(org.w3c.dom.Element discoveryElement) {
		
		if(discoveryElement.getNodeName().equals("Discovery")) {
	        NodeList docNodeList = discoveryElement.getChildNodes();
	        
            for(int i=0;i<docNodeList.getLength();i++) {
            	Node topLevelDocNode = docNodeList.item(i);
                if (topLevelDocNode.getNodeType() == Node.ELEMENT_NODE) {
                	
                	org.w3c.dom.Element topLevelElement = (org.w3c.dom.Element) topLevelDocNode;
                    if(topLevelElement.getTagName().equals("Action")) {
                        this.action = topLevelElement.getTextContent();
                    } else if(topLevelElement.getTagName().equals("Person")) {
                        this.person = topLevelElement.getTextContent();
                    } else if(topLevelElement.getTagName().equals("SourceDiscovery")) {
                        this.sourceDiscovery = topLevelElement.getTextContent();
                    } else if(topLevelElement.getTagName().equals("TargetDiscovery")) {
                        this.targetDiscovery = topLevelElement.getTextContent();
                    } 
                
                }
            }
		}
		
    }
	
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getSourceDiscovery() {
		return sourceDiscovery;
	}
	public void setSourceDiscovery(String sourceDiscovery) {
		this.sourceDiscovery = sourceDiscovery;
	}
	public String getTargetDiscovery() {
		return targetDiscovery;
	}
	public void setTargetDiscovery(String targetDiscovery) {
		this.targetDiscovery = targetDiscovery;
	}


	@Override
	public void fromXML() {
		// TODO Auto-generated method stub
		
	}
	

	
	@Override
	public void fromDataStore(String type) {
		// TODO Auto-generated method stub
		
	}
    

	
	
}
