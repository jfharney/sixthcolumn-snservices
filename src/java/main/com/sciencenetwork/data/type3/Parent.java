package com.sciencenetwork.data.type3;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

public class Parent implements ReturnedObjects {

	private String action;
	private String discovery;
	
	@Override
	public Element toElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toXML() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toJSON() {
		// TODO Auto-generated method stub
		return null;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDiscovery() {
		return discovery;
	}

	public void setDiscovery(String discovery) {
		this.discovery = discovery;
	}

}
