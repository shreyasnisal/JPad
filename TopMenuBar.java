
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class TopMenuBar extends JMenuBar {

	Font menuBarFont = new Font("Sans-Serif", Font.PLAIN, 20);
	TextEditorFrame frame;

	public TopMenuBar(TextEditorFrame frame) {

		this.frame = frame;

		// JTextArea textArea = frame.getTextArea();

		//File Menu
		JMenu fileMenu = new JMenu("File");
		fileMenu.setFont(menuBarFont);

		//new file
		JMenuItem newFile = new JMenuItem("New File");
		newFile.setFont(menuBarFont);
		fileMenu.add(newFile);
		newFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setCurrentFile(null);
				frame.clearTextArea();
			}
		});


		//open file
		JMenuItem openFile = new JMenuItem("Open File");
		openFile.setFont(menuBarFont);
		fileMenu.add(openFile);
		openFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    chooser.showOpenDialog(frame);
			    File fileToOpen = new File(chooser.getSelectedFile().getAbsolutePath());
			    frame.setCurrentFile(fileToOpen);
			}
		});


		//save file
		JMenuItem saveFile = new JMenuItem("Save File");
		saveFile.setFont(menuBarFont);
		fileMenu.add(saveFile);
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getCurrentFile() == null) {
					JFileChooser chooser = new JFileChooser(); 
					chooser.setDialogTitle("Save File");
					if (chooser.showDialog(frame, "Save") != JFileChooser.APPROVE_OPTION) { 
				       	return;
					}
					frame.setCurrentFile(chooser.getSelectedFile());
				}

				try {
			       	BufferedWriter b = new BufferedWriter(new FileWriter(frame.getCurrentFile()));
			       	b.write(frame.getTextArea().getText());
			    	b.close();
				}
				catch (IOException ex) {

				}
			}
		});


		//save file as
		JMenuItem saveFileAs = new JMenuItem("Save File As...");
		saveFileAs.setFont(menuBarFont);
		fileMenu.add(saveFileAs);
		saveFileAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser(); 
				chooser.setDialogTitle("Save File");
				if (chooser.showDialog(frame, "Save") != JFileChooser.APPROVE_OPTION) { 
			       	return;
				}
				frame.setCurrentFile(chooser.getSelectedFile());

				try {
			       	BufferedWriter b = new BufferedWriter(new FileWriter(frame.getCurrentFile()));
			       	b.write(frame.getTextArea().getText());
			    	b.close();
				}
				catch (IOException ex) {

				}
			}
		});


		//new window
		JMenuItem newWindow = new JMenuItem("New Window");
		newWindow.setFont(menuBarFont);
		fileMenu.add(newWindow);
		newWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TextEditorFrame newFrame = new TextEditorFrame("JPad");
				newFrame.setVisible(true);
			}
		});


		//exit
		JMenuItem exit = new JMenuItem("Exit");
		exit.setFont(menuBarFont);
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
		});



		//Preferences Menu
		JMenu preferencesMenu = new JMenu("Preferences");
		preferencesMenu.setFont(menuBarFont);

		//font
		JMenuItem font = new JMenuItem("Font");
		font.setFont(menuBarFont);
		font.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDesktopPane tempDesktopPane = new JDesktopPane();
				FontFrame fontFrame = new FontFrame(frame, frame.getFont());
				tempDesktopPane.add(fontFrame);
				frame.setContentPane(tempDesktopPane);
			}
		});

		preferencesMenu.add(font);



		add(fileMenu);
		add(preferencesMenu);
	}
}