package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Register {
	
    public static void main(String args[])  
    {  
    	new RegisterLayout();
    }
    static class RegisterLayout{
    	ActionListener registerButtonListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(button3.getText()=="Register") {
        			String user = username.getText();
            		String pass1 = password1.getText().toString();
            		String pass2 = password2.getText().toString();
            		System.out.println(pass1);
            		System.out.println(pass2);
            		if(pass1.contentEquals(pass2)) {
            			JOptionPane.showMessageDialog(frame, "Successfully Registered");
            		}
            	}
    		}
    	};
    	ActionListener taxOfficerListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(button2.getText()=="For TaxOfficers") {
    				JLabel TaxOfficers = new JLabel("Enter Tax Officer ID");
        			TaxOfficers.setBounds(200,300,200,25);
        			JTextField TaxOfficersTF = new JTextField(20);
        			TaxOfficersTF.setBounds(400, 300, 165, 25);
        			panel.add(TaxOfficers);
        			panel.add(TaxOfficersTF);
            	}
    		}
    	};
    	ActionListener loginButtonListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(button1.getText()=="Login") {
    				frame.dispose();
        			new Login();
            	}
    		}
    	};
    	
    	JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		JLabel l = new JLabel("Register here");
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel label = new JLabel("Username");
		
		JLabel password = new JLabel("Password");
		JLabel enterPasswordAgain = new JLabel("Enter Password again");
		JTextField username = new JTextField(20);
		
		JTextField password1 = new JTextField(20);
		JTextField password2 = new JTextField(20);
		JButton button1 = new JButton("Login");
		
		JButton button2 = new JButton("For TaxOfficers");
		JButton button3 = new JButton("Register");
		RegisterLayout(){
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

	
	

}
