package notes;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TestApp {

	private App app = new App();
	
	@Test
	public void testCreateNote() throws Exception {
		Note note = app.createNote("Test-Notiz");
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
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		app.createReference(source, target);
		assertThat(source.allReferences, hasItems(target));
	}
	
	@Test
	public void testDeleteNote() {
		Note note = app.createNote("toDelete");
		app.deleteNote(note);
		assertThat(app.getAllNotes(),not(hasItems(note)));
	}
	
	@Test
	public void testDeleteReference() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		app.createReference(source, target);
		app.deleteReference(source, target);
		assertThat(source.allReferences, not(hasItems(target)));
	}
}