package com.sciencenetwork.data.type8;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

/**
 * <Discovery>
	<Action>SAid</Action>
	<SourceDiscovery>SDid1</SourceDiscovery>
	<TargetDiscovery>SDid2</TargetDiscovery>
	</Discovery> 
 * @author 8xo
 *
 */
public class Type8 implements ReturnedObjects {

	private String action;
	private String sourceDiscovery;
	private String targetDiscovery;
	
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

}
