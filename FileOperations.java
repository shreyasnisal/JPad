
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.io.*;

public class FileOperations {

	public static void newFile(TextEditorFrame parent) {
		parent.setCurrentFile(null);
		parent.clearTextArea();
	}

	public static void openFile(TextEditorFrame parent) {
		JFileChooser chooser = new JFileChooser();
	    chooser.showOpenDialog(parent);
	    File fileToOpen = new File(chooser.getSelectedFile().getAbsolutePath());
	    parent.setCurrentFile(fileToOpen);
	}

	public static void saveFile(TextEditorFrame parent) {
		if (parent.getCurrentFile() == null) {
			JFileChooser chooser = new JFileChooser(); 
			chooser.setDialogTitle("Save File");
			if (chooser.showDialog(parent, "Save") != JFileChooser.APPROVE_OPTION) { 
		       	return;
			}
			parent.setCurrentFile(chooser.getSelectedFile());
		}

		try {
	       	BufferedWriter b = new BufferedWriter(new FileWriter(parent.getCurrentFile()));
	       	b.write(parent.getTextArea().getText());
	    	b.close();
		}
		catch (IOException ex) {

		}
	}

	public static void saveFileAs(TextEditorFrame parent) {
		JFileChooser chooser = new JFileChooser(); 
		chooser.setDialogTitle("Save File");
		if (chooser.showDialog(parent, "Save") != JFileChooser.APPROVE_OPTION) { 
	       	return;
		}
		parent.setCurrentFile(chooser.getSelectedFile());

		try {
	       	BufferedWriter b = new BufferedWriter(new FileWriter(parent.getCurrentFile()));
	       	b.write(parent.getTextArea().getText());
	    	b.close();
		}
		catch (IOException ex) {

		}
	}

	public static void newWindow() {
		TextEditorFrame newFrame = new TextEditorFrame("JPad");
		newFrame.setVisible(true);
		Driver.incrementFrameCount();
	}

	public static void closeWindow(TextEditorFrame parent) {
		parent.dispatchEvent(new WindowEvent(parent, WindowEvent.WINDOW_CLOSING));
	}
}