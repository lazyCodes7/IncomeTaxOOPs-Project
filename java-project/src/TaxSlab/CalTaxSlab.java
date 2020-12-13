package TaxSlab;

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
    			JOptionPane.showMessageDialog(frame, "Tax Slab is "+ slab);
            }
    		
    	};
    	ActionListener goBack = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			JOptionPane.showMessageDialog(frame, "Success");
    		}
    	};
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel l = new JLabel("Tax Slab Details");
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel TotalIncome = new JLabel("Total Income");
		JLabel TotalInvestment = new JLabel("Investments");
		JLabel totalIncomeTF = new JLabel("Your Income");
		JLabel totalInvestmentTF = new JLabel("Your Investments");
		JButton button1 = new JButton("Check Tax Slab Amount");
		JButton button2 = new JButton("Go back");
		CalTaxSlabLayout(){
			frame.setTitle("Income Tax Management Corp");
			frame.add(panel);
			panel.setLayout(null);
			frame.setAlwaysOnTop(true);
			l.setBounds(320, 10, 150, 75);
			TotalIncome.setBounds(200,120,80,25);
			
			TotalInvestment.setBounds(200,180,80,25);
			
			
			totalIncomeTF.setBounds(300, 120, 165, 25);
			totalInvestmentTF.setBounds(300, 180, 165, 25);
			

			
			button1.setBounds(150,350,200,25);
			
			button2.setBounds(450, 350, 150, 25);
			
			panel.add(l);
			panel.add(TotalIncome);
			panel.add(TotalInvestment);
			
			panel.add(totalIncomeTF);
			panel.add(totalInvestmentTF);
			panel.add(button1);
			panel.add(button2);
			button2.addActionListener(goBack);
			button1.addActionListener(checkTaxSlabAmt);
			frame.setVisible(true);
			frame.setSize(700,500);
		}
	}
}

