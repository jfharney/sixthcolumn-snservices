package com.sciencenetwork.data.type7;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

public class Action implements ReturnedObjects {

	private String actionId;
	private String discoveryId;
	
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

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getDiscoveryId() {
		return discoveryId;
	}

	public void setDiscoveryId(String discoveryId) {
		this.discoveryId = discoveryId;
	}

}
