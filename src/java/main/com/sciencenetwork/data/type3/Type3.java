package com.sciencenetwork.data.type3;

import java.util.List;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

/**
 * 

<Parents>
	<Discovery>SDid</Discovery>
	<Parent>
		<Action>SAaid</Action>
		<Discovery>SDaid</Discovery>
	</Parent>
	<Parent>
		<Action>SAbid</Action>
		<Discovery>SDbid</Discovery>
	</Parent>
	...
</Parents> 
 */
public class Type3 implements ReturnedObjects {

	private String discovery;
	private List<Parent> parent;
	
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

	public String getDiscovery() {
		return discovery;
	}

	public void setDiscovery(String discovery) {
		this.discovery = discovery;
	}

	public List<Parent> getParent() {
		return parent;
	}

	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}

}
