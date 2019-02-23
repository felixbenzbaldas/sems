package sems;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

public class TestApp {

	private App app = new App();
	
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
	
	// test that app.getAllObjects() returns all created objects
	@Test
	public void testCanGetAllObjects() throws Exception {
		Note note = app.createNote("Test-Notiz");
		MyObject association = app.createAssociation(note, note);
		assertThat(app.getAllObjects(), hasItems(note, association));
	}
	
	@Test
	public void testDeleteNote() {
		Note note = app.createNote("toDelete");
		app.deleteNote(note);
		assertThat(app.getAllObjects(), not(hasItems(note)));
	}
	
	@Test
	public void testReference() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		app.createReference(source, target);
		assertThat(source.getAllRelationships(), hasItems(target));
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
		app.deleteAssociation(association);
		assertThat(source.getAllRelationships(), is(new LinkedList<>()));
	}
	
	@Test
	public void testCanDeleteAssociation_2() {
		Note source = app.createNote("source");
		Note target = app.createNote("target");
		Association association = app.createAssociation(source, target);
		app.deleteAssociation(association);
		assertThat(app.getAllObjects(), not(hasItems(association)));
	}
	
	@Test
	public void testCanCreateRemoteObject() {
		RemoteObject remoteObject = app.createRemoteObject("file:test/remote/object");
		assertThat(app.getAllObjects(), hasItems(remoteObject));
	}
	
	@Test
	public void createAFile() throws IOException {
		File file = new File("src/test/resources/test.txt");
		file.createNewFile();
		assertTrue(file.exists());
	}
}