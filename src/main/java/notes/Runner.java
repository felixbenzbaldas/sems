package notes;

public class Runner {
	
	public static void main(String[] args) throws Exception {
		new Runner().run();
	}
	
	private App app = new App();
	
	private void run() throws Exception{
		app.load();
		app.createNote("note1");
		app.createNote("note2");
		printAllNotes();
		app.save();
	}
	
	private void printAllNotes() {
		app.getAllNotes().stream().forEach(note -> System.out.println(note));
	}
}