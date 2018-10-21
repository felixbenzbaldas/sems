package notes;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestApp {

	@Test
	public void testCreateNote() throws Exception {
		createNote("Test-Notiz");
		assertArrayEquals(new String[] { "Test-Notiz" }, getAllNotes());
	}
	
	private List<String> data = new LinkedList<String>();

	public void createNote(String note) throws IOException {
		data.add(note);

	}

	public String[] getAllNotes() throws IOException, ClassNotFoundException {
		return new String[] { data.get(0) };
	}
	
	public void save() throws Exception{
		FileOutputStream fout = new FileOutputStream("testFile.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(data);
		oos.close();
	}
	
	public void load() throws Exception {
		FileInputStream fin = new FileInputStream("testFile.ser");
		ObjectInputStream ois = new ObjectInputStream(fin);
		data = (List<String>) ois.readObject();
	}
	
}