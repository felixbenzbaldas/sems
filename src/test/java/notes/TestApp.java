package notes;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestApp {

	@Test
	public void testCreateNote() throws Exception {
		app = new App();
		Note note = app.createNote("Test-Notiz");
		testHasNote(note);
	}
	
	private App app;
	
	private void testHasNote(Note note) {
		assertThat(app.getAllNotes(), hasItems(note));
	}
	
	@Test
	public void testSaveAndLoad() throws Exception {
		String path = "src/test/resources/testData/testFile-" + Math.random() + ".ser";
		App appSave = new App();
		Note note = appSave.createNote("test");
		appSave.save(path);
		//
		App appLoad = new App();
		appLoad.load(path);
		assertThat(appLoad.getAllNotes(), hasItems(note));
	}
	
	@Test
	public void testReference() {
		
		createNote();
		Note referencedNote = new Note();
		referencedNote.text = "referencedNote";
		createReference(referencedNote);
		testHasReference(referencedNote);
	}
	
	private Note myNote;

	private void createNote() {
		myNote = new Note();
		myNote.text = "myNote";
	}

	private void createReference(Note referencedNote) {
		new App().createReference(myNote, referencedNote);
	}
	
	private void testHasReference(Note referencedNote) {
		assertThat(myNote.allReferences, hasItems(referencedNote));
	}


}