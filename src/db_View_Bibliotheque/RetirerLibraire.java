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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RetirerLibraire extends JFrame {
	static RetirerLibraire frame;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RetirerLibraire();
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
	public RetirerLibraire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterId = new JLabel("Entrer Id:");
		lblEnterId.setBounds(71, 84, 83, 14);
		
		textField = new JTextField();
		textField.setBounds(175, 84, 178, 20);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Retirer");
		btnDelete.setBounds(214, 138, 109, 33);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=textField.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(RetirerLibraire.this,"Id ne peut etre vide");
				}else{
					int id=Integer.parseInt(sid);
					int i=LibraireDao.retirerLibraire(id);
					if(i>0){
						textField.setText(" ");
						JOptionPane.showMessageDialog(RetirerLibraire.this,"Entrer retiree avec success!");
					}else{
						JOptionPane.showMessageDialog(RetirerLibraire.this,"Erreur sur Id!");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(332, 226, 92, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessAdmin.main(new String[]{});
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Retirer un libraire");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(133, 11, 190, 33);
		contentPane.add(lblNewLabel);
		contentPane.add(lblEnterId);
		contentPane.add(textField);
		contentPane.add(btnDelete);
		contentPane.add(btnNewButton);
	}
}
