package TaxPayers;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class TaxPayerDetails {
	private static Connection c;
	private static PreparedStatement stmt = null;

	
	
	public static void saveCredentials(String legalname,String panno,String adhaar,String user_address,String phoneno) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
		    String SQL = "INSERT INTO tax_payer_details "
	                + "VALUES(?,?,?,?,?)";
		    stmt = c.prepareStatement(SQL);
		    stmt.setString(1, legalname);
            stmt.setString(2, panno);
            stmt.setString(3, adhaar);
            stmt.setString(4, user_address);
            stmt.setString(5, phoneno );

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
	static class TaxPayerDetailsLayout{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel l = new JLabel("Welcome user, Enter your credentials here!");
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel legalName = new JLabel("Legal Name");
		JLabel panNo = new JLabel("PanNo");
		JLabel adhaarNo = new JLabel("Adhaar No");
		JLabel address = new JLabel("Your Address");
		JLabel phoneNo = new JLabel("Your Phone No");
		JTextField legalNameTF = new JTextField(20);
		JTextField panNoTF = new JTextField(20);
		JTextField adhaarNoTF = new JTextField(20);
		JTextField addressTF = new JTextField(20);
		JTextField phoneNoTF = new JTextField(20);
		JButton button1 = new JButton("Save Credentials");
		JButton button2 = new JButton("Edit Credentials");
		JButton button3 = new JButton("Fill Income Details");
		ActionListener saveCredentialsListener  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String legalname = legalNameTF.getText();
    			String pan = panNoTF.getText();
    			String adhaar = adhaarNoTF.getText();
    			String user_address = addressTF.getText();
    			String phoneno = phoneNoTF.getText();
    			saveCredentials(legalname,pan,adhaar,user_address,phoneno);
    			
            }
    		
    	};
    	ActionListener goToIncomeListener  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			String[] name = {legalNameTF.getText()};
            	TaxPayerIncomeDriver driver = new TaxPayerIncomeDriver();
            	driver.main(name);
    			
            }
    		
    	};
		TaxPayerDetailsLayout(){
			frame.setTitle("Income Tax Management Corp");
			frame.add(panel);
			panel.setLayout(null);
			frame.setAlwaysOnTop(true);
			l.setBounds(220, 10, 400, 75);
			legalName.setBounds(200,120,80,25);
			
			panNo.setBounds(200,180,80,25);
			adhaarNo.setBounds(200,240,200,25);
			address.setBounds(200,300,200,25);
			phoneNo.setBounds(200,360,200,25);
			legalNameTF.setBounds(300, 120, 165, 25);
			
			panNoTF.setBounds(300, 180, 165, 25);
			adhaarNoTF.setBounds(300, 240, 165, 25);
			addressTF.setBounds(300, 300, 165, 25);
			phoneNoTF.setBounds(310, 360, 165, 25);
			button1.setBounds(50,420,200,25);
			
			button2.setBounds(280, 420, 150, 25);
			button3.setBounds(450, 420, 200, 25);
			
			panel.add(l);
			panel.add(legalName);
			panel.add(panNo);
			panel.add(adhaarNo);
			panel.add(address);
			panel.add(phoneNo);
			panel.add(panNoTF);
			panel.add(adhaarNoTF);
			panel.add(legalNameTF);
			panel.add(addressTF);
			panel.add(phoneNoTF);
			panel.add(button1);
			panel.add(button2);
			panel.add(button3);
			frame.setVisible(true);
			frame.setSize(700,500);
			button1.addActionListener(saveCredentialsListener);
			button3.addActionListener(goToIncomeListener);
		}

	}
	
	public static void main(String args[]) {
		new TaxPayerDetailsLayout();
	}
	
}