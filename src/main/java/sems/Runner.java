package sems;

import java.io.File;

public class Runner {
	
	public static void main(String[] args) throws Exception {
		new Runner().run();
	}
	
	private App app = new App();
	
	private void run() throws Exception{
		if (new File("testFile.ser").exists()) app.load();
		Note source = app.createNote("note1");
		Note target = app.createNote("note2");
		app.createAssociation(source, target);
		App.writeToFile("test.txt", "test");
		RemoteObject remoteObject = app.createRemoteObject("file:test.txt");
		app.createReference(source, remoteObject);
		printAllObjects();
		app.save();
	}
	
	private void printAllObjects() {
		app.getAllObjects().stream().forEach(note -> System.out.println((note.toStringBig())));
	}
}