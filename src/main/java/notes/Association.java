package notes;

import java.io.Serializable;
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
	public void delete() {
		obj1.getAllRelationships().remove(this);
		obj2.getAllRelationships().remove(this);
	}
	@Override
	public List<MyObject> getAllRelationships() {
		// TODO Auto-generated method stub
		return null;
	}
}