import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Width(cm):");
		frame.getContentPane().add(lblNewLabel, "cell 0 0,alignx trailing,aligny baseline");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "cell 1 0");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Length(cm):");
		frame.getContentPane().add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 1 1");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Depht(cm):");
		frame.getContentPane().add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "cell 1 2");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Weight(Grams):");
		frame.getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		textField_3 = new JTextField();
		frame.getContentPane().add(textField_3, "cell 1 3");
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		frame.getContentPane().add(btnNewButton, "cell 0 4");
		
		textField_4 = new JTextField();
		frame.getContentPane().add(textField_4, "cell 1 4");
		textField_4.setColumns(10);
	}

}
