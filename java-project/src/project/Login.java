package project;
import javax.swing.*;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login{
	static class LoginLayout{
		ActionListener taxOfficerLogin  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			JLabel TaxOfficers = new JLabel("Enter Tax Officer ID");
    			TaxOfficers.setBounds(200,300,200,25);
    			JTextField TaxOfficersTF = new JTextField(20);
    			TaxOfficersTF.setBounds(400, 300, 165, 25);
    			panel.add(TaxOfficers);
    			panel.add(TaxOfficersTF);
            }
    		
    	};
    	ActionListener loginListener = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			JOptionPane.showMessageDialog(frame, "Logged In");
    		}
    	};
		JFrame frame = new JFrame();
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
		LoginLayout(){
			frame.setTitle("Income Tax Management Corp");
			frame.add(panel);
			panel.setLayout(null);
			frame.setAlwaysOnTop(true);
			l.setBounds(320, 10, 80, 75);
			label.setBounds(200,120,80,25);
			
			password.setBounds(200,180,80,25);
			
			username.setBounds(300, 120, 165, 25);
			
			password1.setBounds(300, 180, 165, 25);
			
			button1.setBounds(200,300,150,25);
			
			button2.setBounds(400, 300, 150, 25);
			
			panel.add(l);
			panel.add(label);
			panel.add(password);
			panel.add(username);
			panel.add(password1);
			panel.add(button1);
			panel.add(button2);
			button2.addActionListener(taxOfficerLogin);
			button1.addActionListener(loginListener);
			frame.setVisible(true);
			frame.setSize(700,500);
		}
	}
	public static void main(String args[]) {
		
		
	}

}
