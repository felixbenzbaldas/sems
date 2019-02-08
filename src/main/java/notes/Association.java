package notes;

import java.io.Serializable;
import java.util.List;

public class Association implements MyObject, Serializable {
	private static final long serialVersionUID = 1L;
	private Note note1;
	private Note note2;
	public Association(Note note1, Note note2) {
		this.note1 = note1;
		this.note2 = note2;
	}
	@Override
	public String toString() {
		return "Association [note1=" + note1 + ", note2=" + note2 + "]";
	}
	@Override
	public String toStringBig() {
		return this.toString();
	}
	public void delete() {
		note1.getAllRelationships().remove(this);
		note2.getAllRelationships().remove(this);
	}
	@Override
	public List<MyObject> getAllRelationships() {
		// TODO Auto-generated method stub
		return null;
	}
}