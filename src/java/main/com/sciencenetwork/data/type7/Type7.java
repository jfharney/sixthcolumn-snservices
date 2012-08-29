package com.sciencenetwork.data.type7;

import java.util.List;

import org.jdom.Element;

import com.sciencenetwork.data.ReturnedObjects;

/**
 * <Actions>
	<Discovery>SDaid</Discovery>
	<Action>
		<ActionId>SAaid</ActionId>
		<DiscoveryId>SDaid</DiscoveryId>
	</Action>
	<Action>
		<ActionId>SAbid</ActionId>
		<DiscoveryId>SDbid</DiscoveryId>
	</Action>
	...
</Actions> 
 * @author 8xo
 *
 */
public class Type7  implements ReturnedObjects  {

	private List<Action> actions;
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

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public String getDiscovery() {
		return discovery;
	}

	public void setDiscovery(String discovery) {
		this.discovery = discovery;
	}

}
