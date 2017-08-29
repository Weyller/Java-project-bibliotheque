package db_View_Bibliotheque;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db_Controller.LibraireDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class LoginLibraire extends JFrame {
	static LoginLibraire frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginLibraire();
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
	public LoginLibraire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdminLoginForm = new JLabel("Access Libraire - Bibliotheque Georges-Etienne Cartier");
		lblAdminLoginForm.setBounds(71, 5, 481, 42);
		lblAdminLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLoginForm.setForeground(Color.GRAY);
		lblAdminLoginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblEnterName = new JLabel("Entrez login");
		lblEnterName.setBounds(105, 94, 125, 20);
		
		JLabel lblEnterPassword = new JLabel("Entrez mot de passe");
		lblEnterPassword.setBounds(105, 142, 125, 20);
		
		textField = new JTextField();
		textField.setBounds(248, 94, 172, 20);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Acceder");
		btnLogin.setBounds(366, 195, 93, 37);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			//System.out.println(name+" "+password);
			if(LibraireDao.validerLibraire(name, password)){
				AccessLibraire.main(new String[]{});
				frame.dispose();
			}else{
				JOptionPane.showMessageDialog(LoginLibraire.this, "Desole, nomAdmin ou Password Erreur","Login Erreur!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 142, 172, 20);
		contentPane.setLayout(null);
		contentPane.add(lblEnterName);
		contentPane.add(lblEnterPassword);
		contentPane.add(passwordField);
		contentPane.add(textField);
		contentPane.add(lblAdminLoginForm);
		contentPane.add(btnLogin);
	}
}
