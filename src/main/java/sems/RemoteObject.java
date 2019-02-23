package sems;

import java.util.LinkedList;
import java.util.List;

public class RemoteObject implements MyObject{

	private static final long serialVersionUID = 1L;
	private String address;
	
	public RemoteObject(String address) {
		this.address = address;
	}

	@Override
	public String toStringBig() {
		return this.toString();
	}

	public String getAddress() {
		return address;
	}

	// always empty - cannot add relationship to a remote object
	@Override
	public List<MyObject> getAllRelationships() {
		return new LinkedList<>();
	}
	
	@Override
	public String toString() {
		return "RemoteObject with address = " + address;
	}
}
