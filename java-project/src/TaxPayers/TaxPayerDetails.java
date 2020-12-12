package TaxPayers;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class TaxPayerDetails {
	private String name;
	private int PanNo;
	private int AadharNo;
	private String Address;
	private int PhoneNo;
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Income Tax Management Corp");
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		frame.setAlwaysOnTop(true);
		JLabel l = new JLabel("Welcome user, Enter your credentials here!");
		l.setBounds(220, 10, 400, 75);
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel legalName = new JLabel("Legal Name");
		legalName.setBounds(200,120,80,25);
		
		JLabel panNo = new JLabel("PanNo");
		panNo.setBounds(200,180,80,25);
		JLabel adhaarNo = new JLabel("Adhaar No");
		adhaarNo.setBounds(200,240,200,25);
		JLabel address = new JLabel("Your Address");
		address.setBounds(200,300,200,25);
		JLabel phoneNo = new JLabel("Your Phone No");
		phoneNo.setBounds(200,360,200,25);
		JTextField legalNameTF = new JTextField(20);
		legalNameTF.setBounds(300, 120, 165, 25);
		
		JTextField panNoTF = new JTextField(20);
		panNoTF.setBounds(300, 180, 165, 25);
		JTextField adhaarNoTF = new JTextField(20);
		adhaarNoTF.setBounds(300, 240, 165, 25);
		JTextField addressTF = new JTextField(20);
		addressTF.setBounds(300, 300, 165, 25);
		JTextField phoneNoTF = new JTextField(20);
		phoneNoTF.setBounds(310, 360, 165, 25);
		JButton button1 = new JButton("Save Credentials");
		button1.setBounds(50,420,200,25);
		
		JButton button2 = new JButton("Edit Credentials");
		button2.setBounds(280, 420, 150, 25);
		JButton button3 = new JButton("Fill Income Details");
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
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPanNo() {
		return PanNo;
	}
	public void setPanNo(int panNo) {
		PanNo = panNo;
	}
	public int getAadharNo() {
		return AadharNo;
	}
	public void setAadharNo(int aadharNo) {
		AadharNo = aadharNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}
}