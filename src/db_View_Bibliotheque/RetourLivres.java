package db_View_Bibliotheque;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db_Controller.RetourLivresDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RetourLivres extends JFrame {
	static RetourLivres frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RetourLivres();
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
	public RetourLivres() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReturnBook = new JLabel("Retouner un Emprunt");
		lblReturnBook.setBounds(175, 16, 232, 20);
		lblReturnBook.setForeground(Color.GRAY);
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNumEx = new JLabel("Numero d'exemplaire");
		lblNumEx.setBounds(41, 73, 124, 14);
		
		JLabel lblAdminId = new JLabel("Id Libraire");
		lblAdminId.setBounds(41, 127, 78, 14);
		
		textField = new JTextField();
		textField.setBounds(175, 70, 181, 20);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 124, 181, 20);
		textField_1.setColumns(10);
		
		JButton btnReturnBook = new JButton("Retourner");
		btnReturnBook.setIcon(new ImageIcon(RetourLivres.class.getResource("/db_View_Bibliotheque/images/borrow_book_256.png")));
		btnReturnBook.setBounds(175, 173, 181, 80);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int numExemplaire=Integer.parseInt(textField.getText());
				int idAdmin=Integer.parseInt(textField_1.getText());
				
				int i=RetourLivresDao.retourPretLivre(numExemplaire, idAdmin);
				
				System.out.println("status from retourDao " + i);
				if(i>0){
					JOptionPane.showMessageDialog(RetourLivres.this,"Livre retourne avec succes!");
					AccessLibraire.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(RetourLivres.this,"Desole, erreur dans le retour!");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Note: Verfier le livre proprement avant le retour!!!");
		lblNewLabel.setBounds(24, 282, 347, 20);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnBack = new JButton("Retour");
		btnBack.setBounds(394, 230, 78, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccessLibraire.main(new String[]{});
				frame.dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(lblAdminId);
		contentPane.add(lblNumEx);
		contentPane.add(textField_1);
		contentPane.add(textField);
		contentPane.add(btnReturnBook);
		contentPane.add(lblReturnBook);
		contentPane.add(lblNewLabel);
		contentPane.add(btnBack);
	}

}
