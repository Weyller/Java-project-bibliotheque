package db_View_Bibliotheque;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AccessLibraire extends JFrame {
	static AccessLibraire frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AccessLibraire();
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
	public AccessLibraire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 655);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibrarianSection = new JLabel("Menu Libraire");
		lblLibrarianSection.setBounds(285, 16, 246, 27);
		lblLibrarianSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnNewButton = new JButton("Ajouter un livre");
		btnNewButton.setBounds(407, 74, 191, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LivresFormulaire.main(new String[]{});
			frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnViewBooks = new JButton("Consulter livres");
		btnViewBooks.setBounds(407, 244, 191, 37);
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewLivres.main(new String[]{});
			}
		});
		btnViewBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnIssueBook = new JButton("Preter un livre");
		btnIssueBook.setBounds(407, 154, 191, 37);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PretsLivresFormulaire.main(new String[]{});
				frame.dispose();
			}
		});
		btnIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnViewIssuedBooks = new JButton("Consulter liste de prets");
		btnViewIssuedBooks.setBounds(407, 330, 191, 37);
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPretsLivres.main(new String[]{});
			}
		});
		btnViewIssuedBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnReturnBook = new JButton("Retourner livre");
		btnReturnBook.setBounds(407, 433, 191, 37);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetourLivres.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnLogout = new JButton("Sortir");
		btnLogout.setBounds(246, 520, 191, 37);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuDepart.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.setLayout(null);
		contentPane.add(lblLibrarianSection);
		contentPane.add(btnLogout);
		contentPane.add(btnReturnBook);
		contentPane.add(btnViewIssuedBooks);
		contentPane.add(btnIssueBook);
		contentPane.add(btnViewBooks);
		contentPane.add(btnNewButton);
		
		JButton btnAjoutClient = new JButton("Inscrire client");
		btnAjoutClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ClientFormulaire.main(new String[]{});
				frame.dispose();
				
			}
		});
		btnAjoutClient.setBounds(61, 75, 211, 37);
		contentPane.add(btnAjoutClient);
		
		JButton btnNewButton_1 = new JButton("Consulter liste de clients");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewClient.main(new String[]{});
				
				
			}
		});
		btnNewButton_1.setBounds(61, 155, 211, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(AccessLibraire.class.getResource("/db_View_Bibliotheque/images/User_Account.png")));
		btnNewButton_2.setSelectedIcon(new ImageIcon(AccessLibraire.class.getResource("/db_View_Bibliotheque/images/User_Account.png")));
		btnNewButton_2.setBounds(61, 273, 211, 172);
		contentPane.add(btnNewButton_2);
	}
}
