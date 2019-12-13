
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

public class FontFrame extends JInternalFrame {

	private static final String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	private Font selectedFont;

	public FontFrame(TextEditorFrame parent, Font currentFont) {
		super("Select Font");

		selectedFont = new Font(currentFont.getName(), Font.PLAIN, 24);

		JTextField sampleTextField = new JTextField("Sample Text");
		sampleTextField.setFont(selectedFont);
		sampleTextField.setPreferredSize(new Dimension(300, 50));
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setFontFamily(selectedFont.getName());
				parent.resetContentPane();
			}
		});


		JPanel fontPanel = new JPanel();
		fontPanel.setLayout(new GridLayout(0, 1));
		JList<String> fontList = new JList<String>(fonts);
		fontList.setFont(new Font("Sans-Serif", Font.PLAIN, 20));
		fontPanel.add(fontList);
		JScrollPane fontScrollPane = new JScrollPane(fontPanel);
		fontList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				selectedFont = new Font(fontList.getSelectedValue(), Font.PLAIN, 24);
				sampleTextField.setFont(selectedFont);
			}
		});

		
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(sampleTextField);
		bottomPanel.add(okButton);

		add(fontScrollPane, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.PAGE_END);

		setSize(400, 600);
		setResizable(false);
		setVisible(true);
	}
}