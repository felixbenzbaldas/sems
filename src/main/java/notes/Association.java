package notes;

public class Association extends Note {
	private static final long serialVersionUID = 1L;
	private Note note1;
	private Note note2;
	public Association(Note note1, Note note2) {
		this.note1 = note1;
		this.note2 = note2;
	}
}
