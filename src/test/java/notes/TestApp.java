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
	public void testCanGetAllObjects() throws Exception {
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
		assertThat(source.getAllRelationships(), hasItems(target));
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
		assertThat(source.getAllRelationships(), not(hasItems(target)));
	}
	
	@Test
	public void testCanCreateAssociation() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		app.createAssociation(source, target);
		assertThat(source.getAllRelationships(), is(not(new LinkedList<>())));
	}
	
	
	@Test
	public void testCanDeleteAssociation() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		Association association = app.createAssociation(source, target);
		association.delete();
		assertThat(source.getAllRelationships(), is(new LinkedList<>()));
	}
	
	
	@Test
	public void testCanDeleteAssociation2() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		Association association = app.createAssociation(source, target);
		app.deleteAssociation(association);
		assertThat(app.getAllObjects(), not(hasItems(association)));
	}
	
	@Test
	public void testCanCreateOutline() {
		Outline outline = app.createOutline("testOutline");
		assertThat(app.getAllObjects(), hasItems(outline));
	}
	
	@Test
	public void testOutlineName() {
		Outline outline = app.createOutline("testOutline");
		assertThat(outline.getName(), is("testOutline"));
	}
	
	public void testAssocationToOutline() {
		Note source = app.createNote("source");
		Outline target = app.createOutline("outline");
		app.createAssociation(source, target);
		assertThat(target.getAllRelationships(), is(not(new LinkedList<>())));
	}
}