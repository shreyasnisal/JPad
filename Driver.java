
public class Driver {

	private static int frameCount = 0;

	public static void main(String[] args) {
		TextEditorFrame frame = new TextEditorFrame("JPad");
		frameCount++;
		frame.setVisible(true);
	}

	public static void incrementFrameCount() {
		frameCount++;
	}

	public static void decrementFrameCount() {
		frameCount--;

		if (frameCount == 0) System.exit(0);
	}
}