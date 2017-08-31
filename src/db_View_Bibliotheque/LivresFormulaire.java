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
import db_Controller.LivresDao;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class LivresFormulaire extends JFrame {
	static LivresFormulaire frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textFNom;
	private JTextField textFPrenom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LivresFormulaire();
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
	public LivresFormulaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 957, 823);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAjouter = new JLabel("Ajouter un Livre");
		lblAjouter.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouter.setBounds(355, 11, 257, 36);
		lblAjouter.setForeground(Color.BLACK);
		lblAjouter.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setBounds(23, 67, 191, 14);
		
		JLabel lblDate = new JLabel("Date de publication:");
		lblDate.setBounds(23, 117, 191, 14);
		
		JLabel lblPages = new JLabel("Nombre de pages:");
		lblPages.setBounds(23, 173, 191, 14);
		
		JLabel lblQuant = new JLabel("Quantite:");
		lblQuant.setBounds(23, 223, 191, 14);
		
		JLabel lblEdit = new JLabel("Nom Editeur:");
		lblEdit.setBounds(23, 269, 191, 14);
		
		textField = new JTextField();
		textField.setBounds(300, 58, 312, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 108, 312, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(300, 164, 312, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(300, 214, 312, 20);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(300, 260, 312, 20);
		textField_4.setColumns(10);
		
		JButton btnAjoutButton = new JButton("AJOUTER");
		btnAjoutButton.setBounds(331, 667, 228, 31);
		btnAjoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String sIsbn=textField.getText();
			long isbn=Long.parseLong(sIsbn);
			
			String date=textField_1.getText();
			
			String spages=textField_2.getText();
			int pages=Integer.parseInt(spages);
			
			String sNb=textField_3.getText();
			int nombre =Integer.parseInt(sNb);
			
			
			//String sEditeur=textField_4.getText();
			//int editeur =Integer.parseInt(sEditeur);
			
			String titre=textField_5.getText();
			
			//String sIdAuteur=textField_6.getText();
			//int idAuteur=Integer.parseInt(sIdAuteur);
			
			String stype=textField_7.getText();
			int type=Integer.parseInt(stype);
			//--------------------------------------------
			
			String NomEditeur = textField_4.getText();
			
			String NomAuteur = textFNom.getText();
			
			String PrAuteur = textFPrenom.getText();
			
			
			int i=LivresDao.sauvegardeLivre(isbn, date, pages, nombre, NomEditeur, titre,NomAuteur, PrAuteur, type);
			if(i>0){
				JOptionPane.showMessageDialog(LivresFormulaire.this,"Livre ajoute avec success!");
				AccessLibraire.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(LivresFormulaire.this,"Desole, erreur de sauvegarde!");
			}
			}
		});
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(656, 671, 78, 23);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AccessLibraire.main(new String[]{});
				frame.dispose();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblAjouter);
		contentPane.add(lblDate);
		contentPane.add(lblIsbn);
		contentPane.add(lblQuant);
		contentPane.add(lblEdit);
		contentPane.add(lblPages);
		contentPane.add(textField_4);
		contentPane.add(textField_3);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(textField);
		contentPane.add(btnAjoutButton);
		contentPane.add(btnBack);
		
		JLabel lblTitre = new JLabel("Titre du livre:");
		lblTitre.setBounds(23, 333, 191, 14);
		contentPane.add(lblTitre);
		
		textField_5 = new JTextField();
		textField_5.setBounds(300, 327, 312, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblIdTypeDe = new JLabel("Id Type de livre:");
		lblIdTypeDe.setBounds(23, 549, 191, 14);
		contentPane.add(lblIdTypeDe);
		
		textField_7 = new JTextField();
		textField_7.setBounds(300, 543, 312, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textFNom = new JTextField();
		textFNom.setBounds(300, 404, 312, 20);
		contentPane.add(textFNom);
		textFNom.setColumns(10);
		
		textFPrenom = new JTextField();
		textFPrenom.setBounds(298, 449, 314, 20);
		contentPane.add(textFPrenom);
		textFPrenom.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom de l'auteur");
		lblNom.setBounds(23, 410, 191, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom de l'auteur");
		lblPrenom.setBounds(23, 458, 191, 14);
		contentPane.add(lblPrenom);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setSelectedIcon(new ImageIcon(LivresFormulaire.class.getResource("/db_View_Bibliotheque/images/books.png")));
		btnNewButton.setIcon(new ImageIcon(LivresFormulaire.class.getResource("/db_View_Bibliotheque/images/books.png")));
		btnNewButton.setBounds(720, 211, 159, 237);
		contentPane.add(btnNewButton);
	}
}
