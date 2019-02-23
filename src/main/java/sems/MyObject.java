package sems;

import java.io.Serializable;
import java.util.List;

public interface MyObject extends Serializable {
	public String toStringBig();
	public List<MyObject> getAllRelationships();
}