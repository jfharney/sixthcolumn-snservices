package com.sciencenetwork.data.type4;

import java.util.List;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

/**
 * <Parents>
	<Discovery>SDid</Discovery>
	<Parent-1d>
		<Parent>
			<Action>SAaid</Action>
			<Discovery>SDaid</Discovery>
		</Parent>
		<Parent>
			<Action>SAbid</Action>
			<Discovery>SDbid</Discovery>
		</Parent>
	</Parent-1d>
	<Parent-2d>
		<Parent>
			<Action>SAaid</Action>
			<Discovery>SDaid</Discovery>
		</Parent>
		<Parent>
			<Action>SAbid</Action>
			<Discovery>SDbid</Discovery>
		</Parent>
		É
	</Parent-nd>
		<Parent-2d>
		<Parent>
			<Action>SAaid</Action>
			<Discovery>SDaid</Discovery>
		</Parent>
		<Parent>
			<Action>SAbid</Action>
			<Discovery>SDbid</Discovery>
		</Parent>
	</Parent-3d>
</Parents> 

 * @author 8xo
 *
 */
public class Type4 implements ReturnedObjects {

	private String discovery;
	private List<Parent_d> parent_d;
	
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

}
