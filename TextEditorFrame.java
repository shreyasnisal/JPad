
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class TextEditorFrame extends JFrame {

	File currentFile = null;
	JTextPane textArea = new JTextPane();
	Container defaultContentPane;


	public TextEditorFrame() {
		this("");
	}

	public TextEditorFrame(String title) {

		super(title);

		defaultContentPane = getContentPane();

		JScrollPane textAreaScroll = new JScrollPane(textArea);

		Font textAreaFont = new Font("Sans-Serif", Font.PLAIN, 24);
		textArea.setFont(textAreaFont);
		textArea.setMargin(new Insets(10, 10, 10, 0));

		add(textAreaScroll, BorderLayout.CENTER);

		setJMenuBar(new TopMenuBar(this));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Driver.decrementFrameCount();
			}
		});

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(600, 800);
		setLocationRelativeTo(null);
	}

	public JTextPane getTextArea() { return textArea; }

	public File getCurrentFile() { return currentFile; }

	public void setCurrentFile(File f) {
		currentFile = f;

		if (currentFile == null) {
			textArea.setText(null);
			return;
		}

		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(currentFile));

	    	textArea.setText(null);
	    	String line;
	    	while ((line = fileReader.readLine()) != null)
	    		textArea.setText(textArea.getText() + line + "\n");
		}
		catch (IOException ex) {

		}
	}

	public void clearTextArea() { textArea.setText(null); }

	public Font getFont() { return textArea.getFont(); }

	public void setFontFamily(String name) {
		textArea.setFont(new Font(name, textArea.getFont().getStyle(), textArea.getFont().getSize()));
	}

	public void resetContentPane() {
		setContentPane(defaultContentPane);
	}

	public void increaseFont() {
		textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea.getFont().getSize() + 2));
	}

	public void decreaseFont() {
		textArea.setFont(new Font(textArea.getFont().getName(), textArea.getFont().getStyle(), textArea.getFont().getSize() - 2));
	}


}