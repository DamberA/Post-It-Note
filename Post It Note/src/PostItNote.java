import java.awt.Point;

public class PostItNote {

	public PostItNote() {
	}

	//Starts the application and opens the inital dialog.
	public static void main(String[] args) {
		System.out.println("Starting Post-It Note application...");
		
		PostItNoteFrame mainWindow = new PostItNoteFrame(new Point(200, 200));		
	}

	private static int postItNoteCount = 1;

	public static void decPostItNoteCount() {
		postItNoteCount--;
	}
	public static void incPostItNoteCount() {
		postItNoteCount++;
	}
	public static int getPostItNoteCount() {
		return postItNoteCount;
		
	}


}
