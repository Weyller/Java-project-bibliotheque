package db_View_Bibliotheque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import db_Controller.ClientDao;
import db_Controller.LivresDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientFormulaire {

	private JFrame frame;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldAddres;
	private JTextField textFieldTel;
	private JTextField textFieldEmail;
	private JLabel lblNom;
	private JLabel lblAdresse;
	private JLabel lblTel;
	private JLabel lblEmail;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFormulaire window = new ClientFormulaire();
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
	public ClientFormulaire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 698, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscrire  un client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(269, 11, 176, 53);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(397, 108, 138, 32);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setBounds(397, 177, 138, 32);
		frame.getContentPane().add(textFieldPrenom);
		textFieldPrenom.setColumns(10);
		
		textFieldAddres = new JTextField();
		textFieldAddres.setBounds(397, 244, 138, 32);
		frame.getContentPane().add(textFieldAddres);
		textFieldAddres.setColumns(10);
		
		textFieldTel = new JTextField();
		textFieldTel.setBounds(397, 322, 138, 32);
		frame.getContentPane().add(textFieldTel);
		textFieldTel.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(397, 412, 138, 32);
		frame.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("Inscrire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String NomClient = textFieldNom.getText();
				
				String PrClient = textFieldPrenom.getText();
				String AdrClient = textFieldAddres.getText();
				String CelClient = textFieldTel.getText();
				String EmailClient = textFieldEmail.getText();
				
				int i=ClientDao.sauvegardeClient(NomClient, PrClient, AdrClient, CelClient, EmailClient);
				if(i>0){
					JOptionPane.showMessageDialog( frame,"Client ajoute avec success!");
					System.out.println("Inscription du client");
					AccessLibraire.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(frame,"Desole, erreur de sauvegarde!");
				}
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(256, 482, 142, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(156, 183, 126, 17);
		frame.getContentPane().add(lblPrenom);
		
		lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(157, 114, 138, 17);
		frame.getContentPane().add(lblNom);
		
		lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdresse.setBounds(151, 258, 86, 17);
		frame.getContentPane().add(lblAdresse);
		
		lblTel = new JLabel("Telephone");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTel.setBounds(151, 340, 86, 14);
		frame.getContentPane().add(lblTel);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(157, 424, 104, 20);
		frame.getContentPane().add(lblEmail);
		
		btnNewButton_1 = new JButton("< Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AccessLibraire.main(new String[]{});
				frame.dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(528, 521, 126, 32);
		frame.getContentPane().add(btnNewButton_1);
	}
}
