package db_View_Bibliotheque;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.SwingConstants;

import db_Controller.DB_Connection;
import db_Controller.DB_Setup;

import java.awt.event.ActionListener;
import java.nio.charset.MalformedInputException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MenuDepart extends JFrame {

	private JFrame frame;
	private static MenuDepart window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					
					window = new MenuDepart();
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
	public MenuDepart() {
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 665, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//-----------------------------------------------------
		JButton btnGo = new JButton("Login libraire");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				LoginLibraire.main(new String[]{});
				window.frame.dispose();
				window.frame.setVisible(false);

			}
		});
		btnGo.setBounds(265, 220, 158, 30);
		frame.getContentPane().add(btnGo);
		
		
		//------------------------------------------------------
		JLabel lblNewLabel = new JLabel("Menu Administration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 133, 179, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Menu Libraire");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(47, 220, 158, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bienvenue - Bibliotheque Georges-Etienne Cartier");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(82, 31, 513, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		//-----------------------------------------------------
		JButton btnNewButton = new JButton("Login admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				LoginAdmin.main(new String[]{});
				window.frame.dispose();
				window.frame.setVisible(false);
			
				
			}
		});
		btnNewButton.setBounds(265, 136, 158, 30);
		frame.getContentPane().add(btnNewButton);
	}
}
