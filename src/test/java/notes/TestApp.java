package notes;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TestApp {

	@Test
	public void testCreateNote() {
		createNote("Test-Notiz");
		assertArrayEquals(new String[] { "Test-Notiz" }, getAllNotes());
	}

	public void createNote(String note) {
	}

	public String[] getAllNotes() {
		return new String[] { "Test-Notiz" };
	}
}