package com.sciencenetwork.data.type10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;

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
import com.sixthcolumn.utils.json.JSONException;
import com.sixthcolumn.utils.json.JSONObject;
import com.sixthcolumn.utils.json.XML;

/**
 * Input:
<Type10>
	<Discovery>
		<Person>SPid</Person>
		<Action>SAid</Action>
		<SourceDiscovery>SDid1</SourceDiscovery>
		<TargetDiscovery>SDid2</TargetDiscovery>
	</Discovery> 
</Type10>
 * @author 8xo
 *
 */
public class Type10 implements ReturnedObjects {

	private Discovery discovery;
	
	private static String DIRECTORY = ReturnedObjects.fileDirectoryLocation + "Type10/";
	
	public static void main(String [] args) {
		Type10 type10 = new Type10();
		
		
		String discXML = "<Discovery><a></a><Person>p</Person><TargetDiscovery>td</TargetDiscovery></Discovery>";
		
		String xml = "<Type10>" + discXML + "</Type10>";
		
		type10.fromXML(xml);
		
		System.out.println("here: " + type10.getDiscovery().getPerson());
		
		String directory = DIRECTORY;
		String file = directory + "Type10.xml";
		String type = "file";
		
		type10.toDataStore(type,file);

		
		
	}
	
	
	@Override
	public Element toElement() {
		
		Element type1El = new Element("Type10");

		type1El.addContent(this.discovery.toElement());
        
        return type1El;
		
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
	public void fromDataStore(String type,String file) {
		
		this.discovery = null;
		
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
	public void fromDataStore(String type) {
		// TODO Auto-generated method stub
		
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
		this.discovery = null;
        
        
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

	public void readHelper(org.w3c.dom.Element discoveryElement) {
		Discovery discovery = new Discovery();
    	
		if(discoveryElement.getNodeName().equals("Type10")) { 
			NodeList docNodeList = discoveryElement.getChildNodes();
	        
            for(int i=0;i<docNodeList.getLength();i++) {
            	Node topLevelDocNode = docNodeList.item(i);
                if (topLevelDocNode.getNodeType() == Node.ELEMENT_NODE) {
                	org.w3c.dom.Element topLevelElement = (org.w3c.dom.Element) topLevelDocNode;
                    if(topLevelElement.getNodeName().equals("Discovery")) {
                    	discovery.readHelper(topLevelElement);
                    }
                }
            }
		}
		
		
		this.setDiscovery(discovery);
		
		
    }
	
	
	public Discovery getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Discovery discovery) {
		this.discovery = discovery;
	}

}
