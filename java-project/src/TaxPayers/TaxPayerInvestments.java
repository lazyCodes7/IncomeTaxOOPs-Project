package TaxPayers;
import TaxSlab.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaxPayerInvestments {
	private static double HousingLoan;
	private static double OtherLoan;
	private static double Rent;
	private static double ProvidedFund;
	private static double Policies;
	private static double totalIncome;
	private static double totalInvestments;
	private static String user;
	private static Connection c;
	private static PreparedStatement stmt = null;
	public static void main(String args[]) {
		new TaxPayerInvestmentsLayout();
		
	}
		public static void saveCredentials(String users,String housingLoans, String otherLoan, String rent, String providedFund, String policy) {
			try {
				Class.forName("org.postgresql.Driver");
				c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
			    String SQL = "INSERT INTO tax_payer_loans_details "
		                + "VALUES(?,?,?,?,?)";
			    stmt = c.prepareStatement(SQL);
			    stmt.setString(1, users);
			    stmt.setString(2, housingLoans);
	            stmt.setString(3, otherLoan);
	            stmt.setString(4, rent);
	            stmt.setString(5, providedFund);
	            stmt.setString(6, policy);

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
	
	public double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
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
		JButton button3 = new JButton("Tax Slab");
		ActionListener saveCredentialsListener  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			String users = user;
    			String hLoans = housingLoansTF.getText();
    			String otherLoan = otherLoansTF.getText();
    			String rents = rentTF.getText();
    			String providedFund = providedFundsTF.getText();
    			String policy = policiesTF.getText();
    			saveCredentials(users,hLoans,otherLoan,rents,providedFund,policy);
    			
            }
    		
    	};
    	ActionListener goToTaxSlabListener  = new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			HousingLoan = Double.parseDouble(housingLoansTF.getText());
    			OtherLoan = Double.parseDouble(housingLoansTF.getText());
    			ProvidedFund = Double.parseDouble(housingLoansTF.getText());
    			Rent = Double.parseDouble(housingLoansTF.getText());
    			Policies = Double.parseDouble(housingLoansTF.getText());
    			totalInvestments = HousingLoan+OtherLoan+ProvidedFund+Rent+Policies;
            	JOptionPane.showMessageDialog(frame, "Total Investments are " + totalInvestments);
            	frame.dispose();
    			String[] investments = {Double.toString(totalInvestments),Double.toString(totalIncome),user};
            	TaxSlabDriver driver = new TaxSlabDriver();
            	driver.main(investments);
    			
            }
    		
    	};
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
			button3.addActionListener(goToTaxSlabListener);
			frame.setVisible(true);
			frame.setSize(700,500);
		}
		

	}
	
}
class TaxPayerInvestmentsDriver{
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		TaxPayerInvestments user_investments = new TaxPayerInvestments();
		user_investments.main(null);
		user_investments.setTotalIncome(Double.parseDouble(args[0]));
		user_investments.setUser(args[1]);
		System.out.println(user_investments.getTotalIncome());
		System.out.println(user_investments.getUser());
		
		
	}
}

