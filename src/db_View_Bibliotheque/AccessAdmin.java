
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
import db_Controller.DB_Setup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;

public class AccessAdmin extends JFrame {
	static AccessAdmin frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AccessAdmin();
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
	public AccessAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAdminSection = new JLabel("Section Administration");
		lblAdminSection.setBounds(120, 5, 222, 40);
		lblAdminSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAdminSection.setForeground(Color.GRAY);
		
		JButton btnNewButton = new JButton("Ajouter Libraire");
		btnNewButton.setBounds(131, 183, 181, 49);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibraireFormulaire.main(new String[]{});
			//frame.dispose();
			}
		});
		
		JButton btnViewLibrarian = new JButton("Consulter Libraire");
		btnViewLibrarian.setBounds(131, 250, 181, 49);
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewLibraire.main(new String[]{});
			}
		});
		btnViewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnDeleteLibrarian = new JButton("Retirer Libraire");
		btnDeleteLibrarian.setBounds(131, 317, 181, 49);
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			RetirerLibraire.main(new String[]{});
			frame.setVisible(false);
			}
		});
		btnDeleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnLogout = new JButton("Retour");
		btnLogout.setBounds(131, 384, 181, 49);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuDepart.main(new String[]{});
				frame.dispose();
			}
		});
		contentPane.setLayout(null);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(btnLogout);
		contentPane.add(btnDeleteLibrarian);
		contentPane.add(btnViewLibrarian);
		contentPane.add(btnNewButton);
		contentPane.add(lblAdminSection);
		
		JButton btnNewButton_1 = new JButton("Charger la Base de Donn\u00E9es");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DB_Setup.main(new String[]{});
				if(DB_Setup.success == true){
					
					JOptionPane.showMessageDialog(AccessAdmin.this,"Base de Données téléchargée avec success!");
				}
				
				
				
				}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(90, 83, 263, 49);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("ATTENTION: Une seule fois en d\u00E9but d'installation !");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(31, 143, 381, 14);
		contentPane.add(lblNewLabel);
	}
}
