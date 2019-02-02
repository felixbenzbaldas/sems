package notes;

public class Runner {
	
	public static void main(String[] args) {
		new Runner().run();
	}
	
	private App app = new App();
	
	private void run() {
		app.createNote("note1");
		app.createNote("note2");
		printAllNotes();
	}
	
	private void printAllNotes() {
		app.getAllNotes().stream().forEach(note -> System.out.println(note));
	}
}
