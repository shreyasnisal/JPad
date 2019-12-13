
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class KeyboardShortcutsListener extends KeyAdapter {

	TextEditorFrame frame;

	public KeyboardShortcutsListener(TextEditorFrame parent) {
		this.frame = parent;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_S && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			FileOperations.saveFile(frame);
		}

	}
}