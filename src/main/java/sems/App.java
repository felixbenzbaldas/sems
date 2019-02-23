package sems;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class App {
	
	public static void writeToFile(String path, String string) throws IOException {
		File file = new File(path);
		file.createNewFile();
		try (PrintWriter out = new PrintWriter(file)) {
		    out.println(string);
		}
	}
	
	public static String readFromFile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

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

	public void createReference(MyObject source, MyObject target) {
		source.getAllRelationships().add(target);
	}

	public void deleteReference(MyObject source, MyObject target) {
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

	public RemoteObject createRemoteObject(String address) {
		RemoteObject remoteObject = new RemoteObject(address);
		data.add(remoteObject);
		return remoteObject;
	}
}