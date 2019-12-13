
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.io.*;

public class TopMenuBar extends JMenuBar {

	Font menuBarFont = new Font("Sans-Serif", Font.PLAIN, 20);
	TextEditorFrame frame;

	public TopMenuBar(TextEditorFrame frame) {

		this.frame = frame;

		//File Menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(menuBarFont);

		//new file
		JMenuItem newFile = new JMenuItem("New File");
		newFile.setFont(menuBarFont);
		fileMenu.add(newFile);
		newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOperations.newFile(frame);
			}
		});


		//open file
		JMenuItem openFile = new JMenuItem("Open File");
		openFile.setFont(menuBarFont);
		fileMenu.add(openFile);
		openFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileOperations.openFile(frame);
			}
		});


		//save file
		JMenuItem saveFile = new JMenuItem("Save File");
		saveFile.setFont(menuBarFont);
		fileMenu.add(saveFile);
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOperations.saveFile(frame);
			}
		});


		//save file as
		JMenuItem saveFileAs = new JMenuItem("Save File As...");
		saveFileAs.setFont(menuBarFont);
		fileMenu.add(saveFileAs);
		saveFileAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOperations.saveFileAs(frame);
			}
		});


		//new window
		JMenuItem newWindow = new JMenuItem("New Window");
		newWindow.setFont(menuBarFont);
		fileMenu.add(newWindow);
		newWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOperations.newWindow();
			}
		});


		//exit
		JMenuItem exit = new JMenuItem("Exit");
		exit.setFont(menuBarFont);
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOperations.closeWindow(frame);
			}
		});


		//Edit menu
		JMenu editMenu = new JMenu("Edit");
		editMenu.setFont(menuBarFont);

		//Cut
		JMenuItem cut = new JMenuItem("Cut");
		cut.setFont(menuBarFont);
		editMenu.add(cut);
		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditOperations.cut(frame);
			}
		});

		//Copy
		JMenuItem copy = new JMenuItem("Copy");
		copy.setFont(menuBarFont);
		editMenu.add(copy);
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditOperations.copy(frame);
			}
		});


		//paste
		JMenuItem paste = new JMenuItem("Paste");
		paste.setFont(menuBarFont);
		editMenu.add(paste);
		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditOperations.paste(frame);
			}
		});



		//Preferences Menu
		JMenu preferencesMenu = new JMenu("Preferences");
		preferencesMenu.setFont(menuBarFont);

		//font
		JMenuItem font = new JMenuItem("Font");
		font.setFont(menuBarFont);
		preferencesMenu.add(font);
		font.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferencesOperations.showFontFrame(frame);
			}
		});

		//font size
		JMenu fontSize = new JMenu("Font Size");
		fontSize.setFont(menuBarFont);
		preferencesMenu.add(fontSize);
		JMenuItem increaseFont = new JMenuItem("Larger");
		increaseFont.setFont(menuBarFont);
		fontSize.add(increaseFont);
		JMenuItem decreaseFont = new JMenuItem("Smaller");
		decreaseFont.setFont(menuBarFont);
		fontSize.add(decreaseFont);
		increaseFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferencesOperations.increaseFontSize(frame);
			}
		});
		decreaseFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferencesOperations.decreaseFontSize(frame);
			}
		});

		//font style
		JMenu fontStyle = new JMenu("Font Style");
		fontStyle.setFont(menuBarFont);
		preferencesMenu.add(fontStyle);
		JMenuItem bold = new JMenuItem("Bold");
		bold.setFont(menuBarFont);
		fontStyle.add(bold);
		bold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferencesOperations.toggleBold(frame);
			}
		});
		JMenuItem italics = new JMenuItem("Italics");
		italics.setFont(menuBarFont);
		fontStyle.add(italics);
		italics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferencesOperations.toggleItalic(frame);
			}
		});
		JMenuItem underline = new JMenuItem("Underline");
		underline.setFont(menuBarFont);
		fontStyle.add(underline);
		underline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferencesOperations.toggleUnderline(frame);
			}
		});


		add(fileMenu);
		add(editMenu);
		add(preferencesMenu);
	}
}