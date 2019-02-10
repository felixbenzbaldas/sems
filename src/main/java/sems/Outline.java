package sems;

import java.util.LinkedList;
import java.util.List;

public class Outline implements MyObject {

	private String name;
	
	public Outline(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toStringBig() {
		return this.toString();
	}

	public String getName() {
		return name;
	}

	@Override
	public List<MyObject> getAllRelationships() {
		return allRelationships;
	}

	public List<MyObject> allRelationships = new LinkedList<MyObject>();

}
