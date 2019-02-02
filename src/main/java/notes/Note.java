package notes;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Note implements MyObject, Serializable {

	private static final long serialVersionUID = 1L;

	private String text;
	
	public List<MyObject> allReferences = new LinkedList<MyObject>();

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
		result = prime * result + ((allReferences == null) ? 0 : allReferences.hashCode());
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
		if (allReferences == null) {
			if (other.allReferences != null)
				return false;
		} else if (!allReferences.equals(other.allReferences))
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
		allReferences.forEach(note -> toReturn.append("\n  " + note));
		return toReturn.toString();
	}
}
