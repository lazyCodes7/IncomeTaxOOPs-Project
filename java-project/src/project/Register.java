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
    static class RegisterLayout implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		// TODO Auto-generated method stub
    		Connection connect = null;
    		if(button3.getText()=="Register") {
    			String user = username.getText();
        		String pass1 = password1.getText().toString();
        		String pass2 = password2.getText().toString();
        		System.out.println(pass1);
        		System.out.println(pass2);
        		if(pass1.contentEquals(pass2)) {
        			String sql = "INSERT INTO users VALUES(?,?);";
        			System.out.println("Passwords Match");
        			try {
						Class.forName("org.postgresql.Driver");
					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
        			try {
						connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test", "postgres", "spaces");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			System.out.println("connect done");
        			try {
						PreparedStatement st = (PreparedStatement) connect
						        .prepareStatement(sql);
						st.setString(1, user);
						st.setString(2,pass1);
			            ResultSet rs = st.executeQuery();
			            if (rs.next()) {
			            	System.out.println("User " + user + " logged in");
			            }
			            
			            
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}
        	}
    		
    	}
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
		JButton button1 = new JButton("Taxpayers");
		
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
			button1.setBounds(100,300,150,25);
			button2.setBounds(300, 300, 150, 25);
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
			button1.addActionListener(this);
			button2.addActionListener(this);
			button3.addActionListener(this);
		}
    	
    }

	
	

}
