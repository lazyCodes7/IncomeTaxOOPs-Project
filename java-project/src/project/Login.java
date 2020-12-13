package project;
import TaxPayers.*;
import javax.swing.*;
import Admin.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Login{
	
	static class LoginLayout{
		static JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel l = new JLabel("Login");
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel label = new JLabel("Username");
		JLabel password = new JLabel("Password");
		JTextField username = new JTextField(20);
		JTextField password1 = new JTextField(20);
		JButton button1 = new JButton("Login");
		JButton button2 = new JButton("TaxOfficer Login");
		JButton button3 = new JButton("Register");

		JLabel TaxOfficers = new JLabel("Enter Tax Officer ID");
		JTextField TaxOfficersTF = new JTextField(20);
		
		static Connection c = null;
		static PreparedStatement stmt = null;
		public static void tryLogin(String username, String password) {
			try {
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
				String SQL = "SELECT * FROM users WHERE username=? AND user_password=?";
				stmt = c.prepareStatement(SQL);
				stmt.setString(1, username);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	            	System.out.println("User " + username + " logged in");
	            	frame.dispose();
	            	JOptionPane.showMessageDialog(frame, "Logged In");
	            	TaxPayerDetails newuser = new TaxPayerDetails();
	    			newuser.main(null);
	            }
	            else {
	            	JOptionPane.showMessageDialog(frame, "Invalid Details");
	            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ActionListener taxOfficerLogin  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
    				try {
    					Class.forName("org.postgresql.Driver");
    				} catch (ClassNotFoundException err) {
    					// TODO Auto-generated catch block
    					err.printStackTrace();
    				}
    				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
    				String SQL = "SELECT * FROM tax_officers WHERE tax_officer=? AND user_password=? AND uid=?";
    				stmt = c.prepareStatement(SQL);
    				stmt.setString(1, username.getText());
    	            stmt.setString(2, password1.getText());
    	            stmt.setString(3, TaxOfficersTF.getText());
    	            ResultSet rs = stmt.executeQuery();
    	            if (rs.next()) {
    	            	System.out.println("User" +" logged in");
    	            	frame.dispose();
    	            	JOptionPane.showMessageDialog(frame, "Logged In");
    	            	String[] admin_detail = {username.getText()};
    	            	Admin newadmin = new Admin();
    	    			newadmin.main(admin_detail);
    	            }
    	            else {
    	            	JOptionPane.showMessageDialog(frame, "Invalid Details");
    	            }
    			} catch (SQLException err) {
    				// TODO Auto-generated catch block
    				err.printStackTrace();
    			}
            }
    		
    	};
    	ActionListener loginListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String password = password1.getText();
    			String name = username.getText();
    			tryLogin(name,password);
    			
    		}
    	};
    	ActionListener registerListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			new Register();
    			Register.main(null);
    			frame.dispose();
    			
    		}
    	};
		LoginLayout(){
			frame.setTitle("Income Tax Management Corp");
			frame.add(panel);
			panel.setLayout(null);
			frame.setAlwaysOnTop(true);
			l.setBounds(320, 10, 80, 75);
			label.setBounds(200,120,80,25);
			
			password.setBounds(200,180,80,25);
			
			username.setBounds(350, 120, 165, 25);
			
			password1.setBounds(350, 180, 165, 25);
			
			button1.setBounds(100,300,150,25);
			
			button2.setBounds(300, 300, 150, 25);
			button3.setBounds(500,300,150,25);
			TaxOfficers.setBounds(200,240,200,25);
			TaxOfficersTF.setBounds(350, 240, 165, 25);
			panel.add(TaxOfficers);
			panel.add(TaxOfficersTF);
			panel.add(l);
			panel.add(label);
			panel.add(password);
			panel.add(username);
			panel.add(password1);
			panel.add(button1);
			panel.add(button2);
			panel.add(button3);
			button3.addActionListener(registerListener);
			button2.addActionListener(taxOfficerLogin);
			button1.addActionListener(loginListener);
			frame.setVisible(true);
			frame.setSize(700,500);
		}
	}
	public static void main(String args[]) {
		new LoginLayout();
		
	}

}
