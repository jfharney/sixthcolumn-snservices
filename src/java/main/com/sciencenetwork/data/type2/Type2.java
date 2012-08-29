package com.sciencenetwork.data.type2;

import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import com.sciencenetwork.data.ReturnedObjects;
import com.sixthcolumn.utils.json.JSONException;
import com.sixthcolumn.utils.json.JSONObject;
import com.sixthcolumn.utils.json.XML;

/**
 * 	<Discoveries>
		<Person>SAid</Person>	
		<TimeStamp>SAid</TimeStamp>
		<Discovery>SDid1</Discovery>
		<Discovery>SDid2</Discovery>
		...
	</Discoveries> 
 * @author 8xo
 *
 */
public class Type2 implements ReturnedObjects {

	private Discoveries discoveries;
	

	public Type2() {
		this.discoveries = new Discoveries();
	}

	@Override
	public Element toElement() {
		Element type2El = new Element("Type10");

		type2El.addContent(this.discoveries.toElement());
        
        return type2El;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void toDataStore(String type, String file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fromXML(String xmlStr) {
		// TODO Auto-generated method stub
		
	}

	public Discoveries getDiscoveries() {
		return discoveries;
	}

	public void setDiscoveries(Discoveries discoveries) {
		this.discoveries = discoveries;
	}

}
