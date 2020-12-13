package TaxSlab;
import TaxPayers.*;
import project.Login;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalTaxSlab {
	private static double income;
	private static double investments;
	private static String user;
	private static double slab;
	public static void main(String args[]) {
		new CalTaxSlabLayout();
	}
	public static double getIncome() {
		return income;
	}
	public static void setIncome(double income) {
		CalTaxSlab.income = income;
	}
	public static double getInvestments() {
		return investments;
	}
	public static void setInvestments(double investments) {
		CalTaxSlab.investments = investments;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		CalTaxSlab.user = user;
	}
	static class CalTaxSlabLayout{
		ActionListener checkTaxSlabAmt  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			slab = income - investments;
    			if(slab<250000) {
        			JOptionPane.showMessageDialog(frame, "Tax Rate is "+ "NIL");
        			

    			}
    			else if(slab<250000 && slab>500000) {
        			JOptionPane.showMessageDialog(frame, "You have to pay "+ "10% tax");

    			}
    			else if(slab>500000 && slab<1000000) {
        			JOptionPane.showMessageDialog(frame, "You have to pay "+ "20% tax");

    			}
    			else if(slab>1000000) {
        			JOptionPane.showMessageDialog(frame, "You have to pay "+ "30% tax");

    			}
    			JOptionPane.showMessageDialog(frame, "Tax Slab is "+ slab);
            }
    		
    	};
    	ActionListener goBack = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			TaxPayerDetails home = new TaxPayerDetails();
    			home.main(null);
    			frame.dispose();
    			
    		}
    	};
    	ActionListener logoutListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();
				Login.main(null);
			}
			
		};
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel l = new JLabel("Tax Slab Details");
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel TotalIncome = new JLabel("Total Income");
		JLabel TotalInvestment = new JLabel("Investments");
		JLabel totalIncomeTF = new JLabel();
		JLabel totalInvestmentTF = new JLabel();
		JButton button1 = new JButton("Check Tax Slab Amount");
		JButton button2 = new JButton("Go back");
		JButton button3 = new JButton("Logout");

		CalTaxSlabLayout(){
			frame.setTitle("Income Tax Management Corp");
			frame.add(panel);
			panel.setLayout(null);
			frame.setAlwaysOnTop(true);
			l.setBounds(320, 10, 150, 75);
			TotalIncome.setBounds(200,120,80,25);
			
			TotalInvestment.setBounds(200,180,80,25);
			
			
			totalIncomeTF.setBounds(300, 120, 400, 25);
			totalIncomeTF.setText(Double.toString(getIncome()));
			totalInvestmentTF.setBounds(300, 180, 400, 25);
			totalInvestmentTF.setText(Double.toString(getInvestments()));


			
			button1.setBounds(50,350,200,25);
			
			button2.setBounds(300, 350, 150, 25);
			button3.setBounds(500,350,150,25);
			panel.add(l);
			panel.add(TotalIncome);
			panel.add(TotalInvestment);
			
			panel.add(totalIncomeTF);
			panel.add(totalInvestmentTF);
			panel.add(button1);
			panel.add(button2);
			panel.add(button3);
			button2.addActionListener(goBack);
			button1.addActionListener(checkTaxSlabAmt);
			button3.addActionListener(logoutListener);

			frame.setVisible(true);
			frame.setSize(700,500);
		}
	}
}

