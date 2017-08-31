/*
 * TP2 Base de données II
 * 
 * @Auteurs
 * 
 * Weyller Desir
 * Koffi Joachim
 * Antoine Robitaille  
 * 
 * */

package db_View_Bibliotheque;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginAdmin extends JFrame {

	private JFrame frame;
	private JTextField txtEntrezIdentifiant;
	private static LoginAdmin window ;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoginAdmin();
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
	public LoginAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 671, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usager");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(146, 117, 101, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(146, 184, 132, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Access Adminstration - Bibliotheque Georges-Etienne Cartier");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(27, 26, 557, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtEntrezIdentifiant = new JTextField();
		txtEntrezIdentifiant.setBounds(274, 112, 217, 37);
		frame.getContentPane().add(txtEntrezIdentifiant);
		txtEntrezIdentifiant.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(274, 184, 217, 37);
		frame.getContentPane().add(passwordField);
		
		//----------------------------------------------------------
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=txtEntrezIdentifiant.getText();
				String password=String.valueOf(passwordField.getPassword());
				if(name.equals("admin")&&password.equals("admin123")){
					new AccessAdmin().setVisible(true);
//					AdminSuccess.main(new String[]{});
					frame.dispose();
				}else{
					JOptionPane.showMessageDialog(LoginAdmin.this, "Desole, Erreur Login","ou Mot de passe!", JOptionPane.ERROR_MESSAGE);
					txtEntrezIdentifiant.setText("");
					passwordField.setText("");
				}	
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(262, 257, 165, 42);
		frame.getContentPane().add(btnNewButton);
		
		
		//------------------------------------------------
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuDepart.main(new String[]{});
				window.frame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(550, 317, 95, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
