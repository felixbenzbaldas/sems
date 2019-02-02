package notes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class App {

	private List<Note> data = new LinkedList<Note>();

	public Note createNote(String note) {
		Note noteObject = new Note(note);
		data.add(noteObject);
		return noteObject;
	}
	
	public void createReference(Note source, Note target) {
		source.allReferences.add(target);
	}

	public List<Note> getAllNotes() {
		return data;
	}

	public void save(String path) throws Exception{
		FileOutputStream fout = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(data);
		oos.close();
	}
	
	public void save() throws Exception{
		save("testFile.ser");
	}

	public void load(String path) throws Exception {
		FileInputStream fin = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fin);
		data = (List<Note>) ois.readObject();
		ois.close();
	}

	public void load() throws Exception {
		load("testFile.ser");
	}

	public void deleteNote(Note note) {
		data.remove(note);
	}

	public void deleteReference(Note source, Note target) {
		source.allReferences.remove(target);
	}

	public void createAssociation(Note source, Note target) {
		source.allReferences.add(target);
		target.allReferences.add(source);
	}
}