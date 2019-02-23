package sems;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class App {

	private List<MyObject> data = new LinkedList<MyObject>();

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
		data = (List<MyObject>) ois.readObject();
		ois.close();
	}

	public void load() throws Exception {
		load("testFile.ser");
	}

	public List<MyObject> getAllObjects() {
		return data;
	}

	public Note createNote(String note) {
		Note noteObject = new Note(note);
		data.add(noteObject);
		return noteObject;
	}

	public void deleteNote(Note note) {
		data.remove(note);
	}

	public void createReference(Note source, Note target) {
		source.getAllRelationships().add(target);
	}

	public void deleteReference(Note source, Note target) {
		source.getAllRelationships().remove(target);
	}

	public Association createAssociation(MyObject source, MyObject target) {
		Association association = new Association(source, target);
		source.getAllRelationships().add(association);
		target.getAllRelationships().add(association);
		data.add(association);
		return association;
	}

	public void deleteAssociation(Association association) {
		association.getViewOnAssociatedObjects().stream()
			.forEach(obj -> obj.getAllRelationships().remove(association));
		this.data.remove(association);
	}

	public RemoteObject createOutline(String name) {
		RemoteObject outline = new RemoteObject(name);
		data.add(outline);
		return outline;
	}
}