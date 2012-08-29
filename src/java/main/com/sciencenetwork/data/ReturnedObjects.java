package com.sciencenetwork.data;

import org.jdom.Element;

public interface ReturnedObjects {

	public Element toElement();
	public String toXML();
	public String toJSON();
	public void toDataStore(String type);
	
	public void fromXML();
	public void fromDataStore(String type);
	
	public static String fileDirectoryLocation  = "/Users/8xo/esgProjects/sixthcolumn-snservices/DB/";

	public void fromDataStore(String type, String file);
	public void toDataStore(String type, String file);
	void fromXML(String xmlStr);
	
}
