package notes;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class TestApp {

	@Test
	public void testCreateNote() throws IOException {
		createNote("Test-Notiz");
		assertArrayEquals(new String[] { "Test-Notiz" }, getAllNotes());
	}

	public void createNote(String note) throws IOException {
		FileOutputStream fout = new FileOutputStream("testFile.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(note);
		oos.close();
	}

	public String[] getAllNotes() {
		return new String[] { "Test-Notiz" };
	}
}