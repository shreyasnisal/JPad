
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
		else if (e.getKeyCode() == KeyEvent.VK_N && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			//ctrl + n
			FileOperations.newFile(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_O && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			//ctrl + o
			FileOperations.openFile(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_B && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			//ctrl + b
			PreferencesOperations.toggleBold(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_I && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			//ctrl + i
			PreferencesOperations.toggleItalic(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_U && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			//ctrl + u
			PreferencesOperations.toggleUnderline(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_EQUALS && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			System.out.println("Font+");
			PreferencesOperations.increaseFontSize(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_MINUS && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			System.out.println("Font-");
			PreferencesOperations.decreaseFontSize(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_Z && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			EditOperations.undo(frame);
		}
		else if (e.getKeyCode() == KeyEvent.VK_Y && (e.getModifiers() & KeyEvent.CTRL_MASK) != 0) {
			EditOperations.redo(frame);
		}
	}
}