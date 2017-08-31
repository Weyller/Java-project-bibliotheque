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
import db_Controller.PretsLivresDao;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PretsLivresFormulaire extends JFrame {
	static PretsLivresFormulaire frame;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PretsLivresFormulaire();
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
	public PretsLivresFormulaire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Pret de Livres");
		lblNewLabel.setBounds(213, 42, 238, 22);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.GRAY);
		
		JLabel lblNumEx = new JLabel("Numero d'exemplaire");
		lblNumEx.setBounds(76, 110, 130, 14);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 104, 172, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 152, 172, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(216, 200, 172, 20);
		textField_3.setColumns(10);
		
		JLabel lblClientId = new JLabel("Id Client");
		lblClientId.setBounds(76, 158, 55, 14);
		
		JLabel lblAdminId = new JLabel("Id Libraire");
		lblAdminId.setBounds(76, 206, 108, 14);
		
		JButton btnIssueBook = new JButton("Proceder");
		btnIssueBook.setBounds(237, 263, 100, 31);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String sNum=textField_1.getText();
			int numExemplaire = Integer.parseInt(sNum);
			
			int idClient=Integer.parseInt(textField_2.getText());
			
			int idAdmin=Integer.parseInt(textField_2.getText());
			
			
			
			if(PretsLivresDao.checkLivre(numExemplaire)){
			
				int i=PretsLivresDao.sauvegardePretLivre(numExemplaire, idClient, idAdmin);
				
				//System.out.println("status from pretDao " + i);
				
				if(i>0){
					JOptionPane.showMessageDialog(PretsLivresFormulaire.this,"Pret effectue avec success!");
					AccessLibraire.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(PretsLivresFormulaire.this,"Desole, probleme de sauvegarde!");
				}//end of save if-else
				
			}else{
				JOptionPane.showMessageDialog(PretsLivresFormulaire.this,"Desole, numero d'Exemplaire inexsitant!");
			}//end of checkbook if-else
			
			}
		});
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(433, 271, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessLibraire.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Note: SVP Verifiez bien les infos avant de faire un pret!!!");
		lblNewLabel_1.setBounds(74, 319, 345, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
		contentPane.setLayout(null);
		contentPane.add(lblNumEx);
		contentPane.add(lblClientId);
		contentPane.add(lblAdminId);
		contentPane.add(textField_2);
		contentPane.add(textField_1);
		contentPane.add(textField_3);
		contentPane.add(lblNewLabel_1);
		contentPane.add(btnIssueBook);
		contentPane.add(btnBack);
		contentPane.add(lblNewLabel);
	}
}
