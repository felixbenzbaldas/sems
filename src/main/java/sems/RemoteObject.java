package sems;

import java.io.File;
import java.io.IOException;
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
		if (address.startsWith("file:")) {
			File file = new File(address.substring(5));
			if (file.exists()) {
				try {
					return toString() + " ; content = " + App.readFromFile(file.getAbsolutePath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				return "RemoteObject - object doen't exist!";
			}
		}
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