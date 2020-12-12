package TaxPayers;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaxPayerInvestments {
	private double HousingLoan;
	private double OtherLoan;
	private double Rent;
	private double ProvidedFund;
	private double Policies;
	public static void main(String args[]) {
		new TaxPayerInvestmentsLayout();
		
	}
	static class TaxPayerInvestmentsLayout {
		ActionListener saveCredentials  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			JOptionPane.showMessageDialog(frame, "Credentials Saved");

            }
    		
    	};
    	
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel l = new JLabel("Your Investments");
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel housingLoans = new JLabel("Housing Loan");
		JLabel otherLoans = new JLabel("Other Loans");
		JLabel rent = new JLabel("Rent");
		JLabel providedFunds = new JLabel("Provided Funds");
		JLabel policies = new JLabel("Policies?");
		JTextField housingLoansTF = new JTextField(20);
		JTextField otherLoansTF = new JTextField(20);
		JTextField rentTF = new JTextField(20);
		JTextField providedFundsTF = new JTextField(20);
		JTextField policiesTF = new JTextField(20);
		JButton button1 = new JButton("Save Credentials");
		JButton button2 = new JButton("Edit Credentials");
		TaxPayerInvestmentsLayout() {
			frame.setTitle("Income Tax Management Corp");
			frame.add(panel);
			panel.setLayout(null);
			frame.setAlwaysOnTop(true);
			l.setBounds(300, 10, 400, 75);
			
			housingLoans.setBounds(200,120,150,25);
			
			otherLoans.setBounds(200,180,80,25);
			rent.setBounds(200,240,200,25);
			providedFunds.setBounds(200,300,200,25);
			policies.setBounds(200,360,200,25);
			housingLoansTF.setBounds(330, 120, 165, 25);
			otherLoansTF.setBounds(330, 180, 165, 25);
			rentTF.setBounds(330, 240, 165, 25);
			providedFundsTF.setBounds(330, 300, 165, 25);
			policiesTF.setBounds(330,360,165,25);
			button1.setBounds(50,420,200,25);
			
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
			button1.addActionListener(saveCredentials);
			frame.setVisible(true);
			frame.setSize(700,500);
		}


	}
	
}
