package notes;

import java.util.LinkedList;
import java.util.List;

public class Note {

	public String text;
	
	public List<Note> allReferences = new LinkedList<Note>();
}
