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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraireFormulaire extends JFrame {
	static LibraireFormulaire frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibraireFormulaire();
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
	public LibraireFormulaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddLibrarian = new JLabel("Ajouter un libraire");
		lblAddLibrarian.setBounds(195, 21, 256, 27);
		lblAddLibrarian.setForeground(Color.DARK_GRAY);
		lblAddLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(25, 82, 100, 23);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(25, 131, 100, 23);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(25, 184, 86, 23);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(25, 244, 115, 20);
		
		textField = new JTextField();
		textField.setBounds(198, 88, 177, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(198, 134, 177, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 187, 177, 20);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(198, 244, 177, 20);
		
		JButton btnNewButton = new JButton("Ajouter libraire");
		btnNewButton.setBounds(220, 305, 131, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String nom=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			String prenom=textField_1.getText();
			String login=textField_2.getText();
			

			int i=LibraireDao.sauvegardeLibraire(nom,prenom,login,password);
			 
			if(i>0){
				JOptionPane.showMessageDialog(LibraireFormulaire.this,"Libraire ajoute avec success!");
				AccessAdmin.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(LibraireFormulaire.this,"Desole, probleme de sauvegarde!");
			}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(243, 389, 95, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AccessAdmin.main(new String[]{});
			frame.dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(btnBack);
		contentPane.add(lblPassword);
		contentPane.add(lblPrenom);
		contentPane.add(lblNom);
		contentPane.add(lblLogin);
		contentPane.add(lblAddLibrarian);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(textField);
		contentPane.add(passwordField);
	}

}
