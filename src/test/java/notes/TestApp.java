package notes;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestApp {

	@Test
	public void testCreateNote() throws Exception {
		createNote("Test-Notiz");
		testHasNote("Test-Notiz");
		
	}
	
	private App app;
	
	private void createNote(String note) {
		app = new App();
		app.createNote(note);
	}
	
	private void testHasNote(String note) {
		assertThat(app.getAllNotes(), hasItems("Test-Notiz"));
	}
	
	@Test
	public void testSaveAndLoad() throws Exception {
		String path = "src/test/resources/testData/testFile-" + Math.random() + ".ser";
		App app1 = new App();
		app1.createNote("test");
		app1.save(path);
		//
		App app2 = new App();
		app2.load(path);
		assertThat(app2.getAllNotes(), hasItems("test"));
	}
	
	@Test
	public void testCanHaveReference() {
		createNote();
		createReference();
		testHasReference();
	}
	
	private Object reference = "myReference";
	
	private void testHasReference() {
		assertTrue(reference != null);
	}

	private void createReference() {
		// TODO Auto-generated method stub
		
	}

	private void createNote() {
		// TODO Auto-generated method stub
		
	}
}