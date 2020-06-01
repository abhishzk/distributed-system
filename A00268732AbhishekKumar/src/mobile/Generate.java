package mobile;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;

public class Generate extends JFrame {

	private JFrame frame;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Generate window = new Generate();
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
	public Generate() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 577, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Show All");
		btnNewButton.setForeground(Color.LIGHT_GRAY);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DefaultTableModel  model = new DefaultTableModel();
				Report repo = new Report();
				try {
					model = repo.showall();
					table.setModel(model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(39, 50, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(287, 51, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JButton btnShowById = new JButton("Show By ID");
		btnShowById.setForeground(Color.LIGHT_GRAY);
		btnShowById.setBackground(Color.DARK_GRAY);
		btnShowById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel  model = new DefaultTableModel();
				Report repo = new Report();
				try {
					model = repo.show(Integer.parseInt(textField.getText()));
					table.setModel(model);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnShowById.setBounds(415, 50, 97, 25);
		frame.getContentPane().add(btnShowById);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 122, 473, 196);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(Color.LIGHT_GRAY);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new MainFrame();
			frame.dispose();
			}
		});
		btnNewButton_1.setBounds(39, 13, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Export");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					File file = new File("C:\\eclipse-workspace\\A00268732AbhishekKumar\\Details.txt");
					if(!file.exists()) {
						
							file.createNewFile();
						}
					
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw); 
					
					for(int i = 0; i<table.getRowCount(); i++) {
						for(int j = 0; j< table.getColumnCount(); j++) {
							bw.write(table.getModel().getValueAt(i, j)+ " ");
						}
						bw.write("\n______\n");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, "Data Exported");
					}
						
						
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				
			});
				
				
				
		
		
		btnNewButton_2.setForeground(Color.LIGHT_GRAY);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setBounds(39, 88, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		
	}
}
