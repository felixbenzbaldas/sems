package notes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
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
		assertEquals("Test-Notiz", getAllNotes().get(0));
	}
	
	@Test
	public void testSave() throws Exception {
		String randomName = "src/test/resources/testData/testFile-" + Math.random() + ".ser";
		save(randomName);
		assertTrue(new File(randomName).exists());
	}
	
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
	
	public void load() throws Exception {
		FileInputStream fin = new FileInputStream("testFile.ser");
		ObjectInputStream ois = new ObjectInputStream(fin);
		data = (List<String>) ois.readObject();
	}
	
}