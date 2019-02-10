package sems;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Association implements MyObject, Serializable {
	private static final long serialVersionUID = 1L;
	private MyObject obj1;
	private MyObject obj2;
	public Association(MyObject obj1, MyObject obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	@Override
	public String toString() {
		return "Association [obj1=" + obj1 + ", obj2=" + obj2 + "]";
	}
	@Override
	public String toStringBig() {
		return this.toString();
	}
	public List<MyObject> getViewOnAssociatedObjects() {
		return Arrays.asList(obj1, obj2); 
	}
	
	@Override
	public List<MyObject> getAllRelationships() {
		throw new RuntimeException("not implemented for this class");
	}
}