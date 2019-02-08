package notes;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Note implements MyObject, Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	
	private List<MyObject> allRelationships = new LinkedList<MyObject>();

	public Note(String text) {
		super();
		this.text = text;
	}
	
	public Note() {
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allRelationships == null) ? 0 : allRelationships.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (allRelationships == null) {
			if (other.allRelationships != null)
				return false;
		} else if (!allRelationships.equals(other.allRelationships))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Note [" + text + "]";
	}
	
	public String toStringBig() {
		final StringBuilder toReturn = new StringBuilder(text);
		allRelationships.forEach(note -> toReturn.append("\n  " + note));
		return toReturn.toString();
	}

	@Override
	public List<MyObject> getAllRelationships() {
		return allRelationships;
	}
}
