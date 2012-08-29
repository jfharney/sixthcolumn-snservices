package com.sciencenetwork.data.type6;

import java.util.List;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

public class Child_d implements ReturnedObjects {

	private List<Child> child;

	
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

	public List<Child> getChild() {
		return child;
	}

	public void setChild(List<Child> child) {
		this.child = child;
	}

}
