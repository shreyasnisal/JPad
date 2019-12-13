
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.io.*;

public class PreferencesOperations {
	
	public static void showFontFrame(TextEditorFrame parent) {
		JDesktopPane tempDesktopPane = new JDesktopPane();
		FontFrame fontFrame = new FontFrame(parent, parent.getFont());
		tempDesktopPane.add(fontFrame);
		parent.setContentPane(tempDesktopPane);
	}

	public static void increaseFontSize(TextEditorFrame parent) {
		parent.increaseFont();
	}

	public static void decreaseFontSize(TextEditorFrame parent) {
		parent.decreaseFont();
	}

	public static void toggleBold(TextEditorFrame parent) {
		StyledDocument doc = (StyledDocument) parent.getTextArea().getDocument();
	    int selectionEnd = parent.getTextArea().getSelectionEnd();
	    int selectionStart = parent.getTextArea().getSelectionStart();
	    if (selectionStart == selectionEnd) {
	      return;
	    }
	    Element element = doc.getCharacterElement(selectionStart);
	    AttributeSet as = element.getAttributes();

	    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
	    StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
	    doc.setCharacterAttributes(selectionStart, parent.getTextArea().getSelectedText().length(), asNew, true);
	}

	public static void toggleItalic(TextEditorFrame parent) {
		StyledDocument doc = (StyledDocument) parent.getTextArea().getDocument();
	    int selectionEnd = parent.getTextArea().getSelectionEnd();
	    int selectionStart = parent.getTextArea().getSelectionStart();
	    if (selectionStart == selectionEnd) {
	      return;
	    }
	    Element element = doc.getCharacterElement(selectionStart);
	    AttributeSet as = element.getAttributes();

	    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
	    StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
	    doc.setCharacterAttributes(selectionStart, parent.getTextArea().getSelectedText().length(), asNew, true);
	}

	public static void toggleUnderline(TextEditorFrame parent) {
		StyledDocument doc = (StyledDocument) parent.getTextArea().getDocument();
	    int selectionEnd = parent.getTextArea().getSelectionEnd();
	    int selectionStart = parent.getTextArea().getSelectionStart();
	    if (selectionStart == selectionEnd) {
	      return;
	    }
	    Element element = doc.getCharacterElement(selectionStart);
	    AttributeSet as = element.getAttributes();

	    MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
	    StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
	    doc.setCharacterAttributes(selectionStart, parent.getTextArea().getSelectedText().length(), asNew, true);
	}
}