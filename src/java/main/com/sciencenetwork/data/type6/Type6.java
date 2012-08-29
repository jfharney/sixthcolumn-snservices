package com.sciencenetwork.data.type6;

import java.util.List;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

/**
 * <Children>
	<Discovery>SDid</Discovery>
	<Child1d>
		<Child>
			<Action>SAaid</Action>
			<Discovery>SDaid</Discovery>
		</Child>
		<Child>
			<Action>SAbid</Action>
			<Discovery>SDbid</Discovery>
		</Child>
	</Child-1d>
	<Child-2d>
		<Child>
			<Action>SAaid</Action>
			<Discovery>SDaid</Discovery>
		</Child>
		<Child>
			<Action>SAbid</Action>
			<Discovery>SDbid</Discovery>
		</Child>
		É
	</Child-nd>
	<Child-2d>
		<Child>
			<Action>SAaid</Action>
			<Discovery>SDaid</Discovery>
		</Child>
		<Child>
			<Action>SAbid</Action>
			<Discovery>SDbid</Discovery>
		</Child>
	</Child-3d>
</Children> 

 * @author 8xo
 *
 */
public class Type6 implements ReturnedObjects  {

	List<Child_d> child_d;
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

}
