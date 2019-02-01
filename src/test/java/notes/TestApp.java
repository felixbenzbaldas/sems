package notes;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Ref;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.Is;
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
	public void testReference() {
		createNote();
		String referencedNote = "referencedNote";
		createReference(referencedNote);
		testHasReference(referencedNote);
	}
	
	private String myNote;
	private Map<String, String> allReferences = new HashMap<String, String>();

	private void createNote() {
		myNote = "test";
	}

	private void createReference(String referencedNote) {
		allReferences.put(myNote, referencedNote);
	}
	
	private void testHasReference(String referencedNote) {
		assertThat(allReferences.get(myNote), is(referencedNote));
	}


}