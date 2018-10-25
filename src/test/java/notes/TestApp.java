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
		String path = "src/test/resources/testData/testFile-" + Math.random() + ".ser";
		save(path);
		assertTrue(new File(path).exists());
	}
	
	@Test
	public void testLoad() throws Exception {
		String path = "src/test/resources/testData/testFile-" + Math.random() + ".ser";
		TestApp app1 = new TestApp();
		app1.createNote("test");
		app1.save(path);
		//
		TestApp app2 = new TestApp();
		app2.load(path);
		assertEquals("test", app2.getAllNotes().get(0));
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

	public void load(String path) throws Exception {
		FileInputStream fin = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fin);
		data = (List<String>) ois.readObject();
	}

	public void load() throws Exception {
		load("testFile.ser");
	}
	
}