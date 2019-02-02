package notes;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
}