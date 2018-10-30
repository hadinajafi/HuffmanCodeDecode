package huffman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	private JTextField inputString;
	private JButton btnCompress = new JButton("Compress");
	JTextArea textArea = new JTextArea();
	private JTextField compField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		initialize();
		btnCompress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Huffman h = new Huffman(inputString.getText());
				textArea.setText(h.gethuffmanCode());
				compField.setText(h.printHuffmanCompressedText());
			}
		});
	}
	private void initialize() {
		setTitle("Huffman Coding");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblInputTextHere = new JLabel("Input text here");
		lblInputTextHere.setBounds(10, 11, 83, 14);
		getContentPane().add(lblInputTextHere);
		
		inputString = new JTextField();
		inputString.setBounds(125, 8, 200, 20);
		getContentPane().add(inputString);
		inputString.setColumns(10);
		
		
		textArea.setBounds(125, 35, 300, 148);
		getContentPane().add(textArea);
		
		JLabel lblHuffmanCompress = new JLabel("Huffman Compress");
		lblHuffmanCompress.setBounds(10, 36, 104, 14);
		getContentPane().add(lblHuffmanCompress);
		
		
		btnCompress.setBounds(335, 7, 89, 23);
		getContentPane().add(btnCompress);
		
		compField = new JTextField();
		compField.setBounds(125, 194, 300, 20);
		getContentPane().add(compField);
		compField.setColumns(10);
		
		JLabel lblCompressedText = new JLabel("Compressed text");
		lblCompressedText.setBounds(10, 197, 104, 14);
		getContentPane().add(lblCompressedText);
	}
}
