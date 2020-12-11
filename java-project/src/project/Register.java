package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Register {
	
    public static void main(String args[])  
    {  
    	JFrame frame = new JFrame();
		frame.setTitle("Income Tax Management Corp");
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		frame.setAlwaysOnTop(true);
		JLabel l = new JLabel("Register here");
		l.setBounds(320, 10, 100, 75);
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel label = new JLabel("Username");
		label.setBounds(200,120,80,25);
		
		JLabel password = new JLabel("Password");
		password.setBounds(200,180,80,25);
		JLabel enterPasswordAgain = new JLabel("Enter Password again");
		enterPasswordAgain.setBounds(200,240,200,25);
		JTextField username = new JTextField(20);
		username.setBounds(300, 120, 165, 25);
		
		JTextField password1 = new JTextField(20);
		password1.setBounds(300, 180, 165, 25);
		JTextField password2 = new JTextField(20);
		password2.setBounds(400, 240, 165, 25);
		JButton button1 = new JButton("Taxpayers");
		button1.setBounds(100,300,150,25);
		
		JButton button2 = new JButton("For TaxOfficers");
		button2.setBounds(300, 300, 150, 25);
		JButton button3 = new JButton("Login");
		button3.setBounds(500, 300, 150, 25);
		
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
    }
	

}
