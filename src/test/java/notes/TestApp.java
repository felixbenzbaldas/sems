package notes;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;

import org.junit.Test;

public class TestApp {

	private App app = new App();
	
	@Test
	public void canGetAllObjects() throws Exception {
		Note note = app.createNote("Test-Notiz");
		MyObject association = app.createAssociation(note, note);
		assertThat(app.getAllObjects(), hasItems(note, association));
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
		assertThat(appLoad.getAllObjects(), hasItems(note));
	}
	
	@Test
	public void testReference() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		app.createReference(source, target);
		assertThat(source.allRelationships, hasItems(target));
	}
	
	@Test
	public void testDeleteNote() {
		Note note = app.createNote("toDelete");
		app.deleteNote(note);
		assertThat(app.getAllObjects(),not(hasItems(note)));
	}
	
	@Test
	public void testDeleteReference() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		app.createReference(source, target);
		app.deleteReference(source, target);
		assertThat(source.allRelationships, not(hasItems(target)));
	}
	
	@Test
	public void testCanCreateAssociation() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		app.createAssociation(source, target);
		assertThat(source.allRelationships, is(not(new LinkedList<>())));
	}
}