package notes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

public class App {

	private List<String> data = new LinkedList<String>();

	public void createNote(String note) throws IOException {
		data.add(note);
	}

	public List<String> getAllNotes() throws IOException, ClassNotFoundException {
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
		data = (List<String>) ois.readObject();
		ois.close();
	}

	public void load() throws Exception {
		load("testFile.ser");
	}
}