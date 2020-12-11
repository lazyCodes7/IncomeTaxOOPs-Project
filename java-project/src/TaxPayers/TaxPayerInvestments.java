package TaxPayers;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaxPayerInvestments {
	private double HousingLoan;
	private double OtherLoan;
	private double Rent;
	private double ProvidedFund;
	private double Policies;
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Income Tax Management Corp");
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		frame.setAlwaysOnTop(true);
		JLabel l = new JLabel("Your Investments");
		l.setBounds(300, 10, 400, 75);
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel housingLoans = new JLabel("Housing Loan");
		housingLoans.setBounds(200,120,150,25);
		
		JLabel otherLoans = new JLabel("Other Loans");
		otherLoans.setBounds(200,180,80,25);
		JLabel rent = new JLabel("Rent");
		rent.setBounds(200,240,200,25);
		JLabel providedFunds = new JLabel("Provided Funds");
		providedFunds.setBounds(200,300,200,25);
		JLabel policies = new JLabel("Policies?");
		policies.setBounds(200,360,200,25);
		JTextField housingLoansTF = new JTextField(20);
		housingLoansTF.setBounds(330, 120, 165, 25);
		JTextField otherLoansTF = new JTextField(20);
		otherLoansTF.setBounds(330, 180, 165, 25);
		JTextField rentTF = new JTextField(20);
		rentTF.setBounds(330, 240, 165, 25);
		JTextField providedFundsTF = new JTextField(20);
		providedFundsTF.setBounds(330, 300, 165, 25);
		JTextField policiesTF = new JTextField(20);
		policiesTF.setBounds(330,360,165,25);
		JButton button1 = new JButton("Save Credentials");
		button1.setBounds(50,420,200,25);
		
		JButton button2 = new JButton("Edit Credentials");
		button2.setBounds(280, 420, 150, 25);
		JButton button3 = new JButton("Go Back");
		button3.setBounds(450, 420, 200, 25);
		
		panel.add(l);
		panel.add(housingLoans);
		panel.add(otherLoans);
		panel.add(rent);
		panel.add(providedFunds);
		panel.add(policies);
		panel.add(housingLoansTF);
		panel.add(otherLoansTF);
		panel.add(rentTF);
		panel.add(providedFundsTF);
		panel.add(policiesTF);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		frame.setVisible(true);
		frame.setSize(700,500);
	}
}
