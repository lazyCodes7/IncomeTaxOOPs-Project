package Admin;
import project.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TaxPayers.TaxPayerDetails;

public class Admin {
	private static Connection c;
	private static PreparedStatement stmt = null;

	public static void main(String args[]) {
		System.out.println(args[0]+" at Admin");
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel l = new JLabel("Tax Slab Details");
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel incRange = new JLabel("Increase range for NIL Tax");
		JLabel incRate = new JLabel("Increase Tax Rate");
		JTextField rangeTF = new JTextField(20);
		JTextField rateTF = new JTextField(20);
		JButton button1 = new JButton("Save changes");
		JButton button2 = new JButton("Logout");
		frame.setTitle("Income Tax Management Corp");
		frame.add(panel);
		panel.setLayout(null);
		frame.setAlwaysOnTop(true);
		l.setBounds(320, 10, 150, 75);
		incRange.setBounds(200,120,150,25);
		incRate.setBounds(200,180,150,25);
		rangeTF.setBounds(400, 120, 165, 25);
		rateTF.setBounds(400, 180, 165, 25);	
		button1.setBounds(150,350,200,25);	
		button2.setBounds(450, 350, 150, 25);
		panel.add(l);
		panel.add(incRange);
		panel.add(incRate);
		panel.add(rangeTF);
		panel.add(rateTF);
		panel.add(button1);
		panel.add(button2);
		frame.setVisible(true);
		frame.setSize(700,500);
		ActionListener saveChangesListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Rates and Ranges Changed");
				String range = rangeTF.getText();
				String rate = rateTF.getText();
				try {
					Class.forName("org.postgresql.Driver");
					c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
				    String SQL = "INSERT INTO admin_settings "
			                + "VALUES(?,?)";
				    stmt = c.prepareStatement(SQL);
				    stmt.setString(1, rate);
		            stmt.setString(2, range);
					System.out.println(SQL);
				    stmt.executeUpdate();

				    try{
				         if(stmt!=null)
				            c.close();
				      }catch(SQLException se){
				      }// do nothing

				} catch (Exception err) {
					err.printStackTrace();
					System.err.println(err.getClass().getName() + ": " + err.getMessage());
					System.exit(0);
				}
	        		
	        		
	        }
			
		};
		button1.addActionListener(saveChangesListener);
		ActionListener logoutListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();
				Login.main(null);
			}
			
		};
		button2.addActionListener(logoutListener);

		
		
	}
}
