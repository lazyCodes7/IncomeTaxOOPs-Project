package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import TaxPayers.TaxPayerDetails;

import java.sql.Connection;
import java.sql.DriverManager;

public class Register {
	static Connection c = null;
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static PreparedStatement stmt = null;
	static JLabel l = new JLabel("Register here");
	Font labelFont = l.getFont();
	String labelText = l.getText();
	static JLabel label = new JLabel("Username");
	
	static JLabel password = new JLabel("Password");
	static JLabel enterPasswordAgain = new JLabel("Enter Password again");
	static JTextField username = new JTextField(20);
	static JLabel TaxOfficers = new JLabel("Enter Tax Officer ID");
	static JTextField TaxOfficersTF = new JTextField(20);

	
	static JTextField password1 = new JTextField(20);
	static JTextField password2 = new JTextField(20);
	static JButton button1 = new JButton("Login");
	
	static JButton button2 = new JButton("For TaxOfficers");
	static JButton button3 = new JButton("Register");
	public static void tryTaxOfficerLogin(String tax_officer,String password,String id) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
		    String SQL = "INSERT INTO tax_officers "
	                + "VALUES(?,?,?)";
		    stmt = c.prepareStatement(SQL);
		    stmt.setString(1, tax_officer);
            stmt.setString(2, password);
            stmt.setString(3, id);
			System.out.println(SQL);
		    stmt.executeUpdate();
		      System.out.println("Inserted records into the table...");

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
	public static void tryConnections(String user, String password) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
		    String SQL = "INSERT INTO users "
	                + "VALUES(?,?)";
		    stmt = c.prepareStatement(SQL);
		    stmt.setString(1, user);
            stmt.setString(2, password);
			System.out.println(SQL);
		    stmt.executeUpdate();
		      System.out.println("Inserted records into the table...");

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
    public static void main(String args[])  
    {  
    	ActionListener registerButtonListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(button3.getText()=="Register") {
        			String user = username.getText();
            		String pass1 = password1.getText().toString();
            		String pass2 = password2.getText().toString();
            		System.out.println(pass1);
            		System.out.println(pass2);
            		if(pass1.contentEquals(pass2)) {
            			tryConnections(user, pass1);
            			JOptionPane.showMessageDialog(frame, "Successfully Registered");
            			frame.dispose();
            			TaxPayerDetails newuser = new TaxPayerDetails();
    	    			newuser.main(null);
            		}
            	}
    		}
    	};
    	ActionListener taxOfficerListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(button2.getText()=="For TaxOfficers") {
    				String pass1 = password1.getText().toString();
            		String pass2 = password2.getText().toString();
        			
        			if(pass1.contentEquals(pass2)) {
        				tryTaxOfficerLogin(username.getText(),password1.getText(),TaxOfficersTF.getText());
            			JOptionPane.showMessageDialog(frame, "Successfully Registered");
            			
            		}
        			else {
            			JOptionPane.showMessageDialog(frame, "Passwords Do Not Match");

        			}
            	}
    		}
    	};
    	ActionListener loginButtonListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(button1.getText()=="Login") {
        			Login login = new Login();
        			frame.dispose();
        			login.main(null);
        			
            	}
    		}
    	};
		frame.setTitle("Income Tax Management Corp");
		frame.add(panel);
		panel.setLayout(null);
		frame.setAlwaysOnTop(true);
		l.setBounds(320, 10, 100, 75);
		label.setBounds(200,120,80,25);
		password.setBounds(200,180,80,25);
		enterPasswordAgain.setBounds(200,240,200,25);
		username.setBounds(300, 120, 165, 25);
		password1.setBounds(300, 180, 165, 25);
		password2.setBounds(400, 240, 165, 25);
		button1.setBounds(100,350,150,25);
		button2.setBounds(300, 350, 150, 25);
		button3.setBounds(500, 350, 150, 25);
		TaxOfficers.setBounds(200,300,200,25);
		TaxOfficersTF.setBounds(350, 300, 165, 25);
		panel.add(TaxOfficers);
		panel.add(TaxOfficersTF);
		panel.add(l);
		panel.add(label);
		panel.add(password);
		panel.add(username);
		panel.add(password1);
		panel.add(enterPasswordAgain);
		panel.add(password2);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		frame.setVisible(true);
		
		frame.setSize(700,500);
		button3.addActionListener(registerButtonListener);
		button2.addActionListener(taxOfficerListener);
		button1.addActionListener(loginButtonListener);
		
    }

}
