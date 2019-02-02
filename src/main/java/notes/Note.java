package notes;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Note implements Serializable {

	public String text;
	
	public List<Note> allReferences = new LinkedList<Note>();

	public Note(String text) {
		super();
		this.text = text;
	}
	
	public Note() {
	}
}
