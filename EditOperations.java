
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.io.*;

public class EditOperations {
	
	public static void cut(TextEditorFrame parent) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		TransferHandler transferHandler = parent.getTextArea().getTransferHandler();
		transferHandler.exportToClipboard(parent.getTextArea(), clipboard, TransferHandler.COPY);
		parent.getTextArea().replaceSelection("");
	}

	public static void copy(TextEditorFrame parent) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		TransferHandler transferHandler = parent.getTextArea().getTransferHandler();
		transferHandler.exportToClipboard(parent.getTextArea(), clipboard, TransferHandler.COPY);
	}

	public static void paste(TextEditorFrame parent) {
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		TransferHandler transferHandler = parent.getTextArea().getTransferHandler();
		transferHandler.importData(parent.getTextArea(), clipboard.getContents(null));
	}

}