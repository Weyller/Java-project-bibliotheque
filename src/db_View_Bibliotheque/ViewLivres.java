package db_View_Bibliotheque;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import db_Controller.DB_Connection;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ViewLivres extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLivres frame = new ViewLivres();
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
	public ViewLivres() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 800, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB_Connection.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT livreexemplaire.NumExemplaire, livreedition.Titre,"
													+ " livreedition.DatePub, livreedition.NbPages"
													+ ",livreedition.IdTypeLivre,livreedition.ISBN,livreexemplaire.Disponibilite"
													+ " FROM livreexemplaire INNER JOIN livreedition on livreedition.ISBN"
													+ " = livreexemplaire.ISBN",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		contentPane.setLayout(null);
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(5, 39, 774, 287);
		
		contentPane.add(sp);
		
		lblNewLabel = new JLabel("Liste des livres");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(243, 0, 299, 28);
		contentPane.add(lblNewLabel);
		
		
	}
}
