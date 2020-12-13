package TaxPayers;
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

public class TaxPayerIncomeDetails{
	private static double Job;
	private static double Buisness;
	private static String user;
	private static double Property;
	private static double TotalIncome;
	private static double miscellanous;
	private static Connection c;
	private static PreparedStatement stmt = null;
	public void setlegalName(String users) {
		user = users;
	}
	public void getlegalName() {
		System.out.println(user);
	}
	public double getJob() {
		return Job;
	}
	public void setJob(double job) {
		Job = job;
	}
	public double getBuisness() {
		return Buisness;
	}
	public void setBuisness(double buisness) {
		Buisness = buisness;
	}
	public double getProperty() {
		return Property;
	}
	public void setProperty(double property) {
		Property = property;
	}
	public double getTotalIncome() {
		return TotalIncome;
	}
	public void setTotalIncome(double totalIncome) {
		TotalIncome = totalIncome;
	}
	public static void saveCredentials(String username,String jobEarning,String propertyEarning,String businessEarning,String totalEarning) {
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "spaces");
		    String SQL = "INSERT INTO tax_payer_income_details "
	                + "VALUES(?,?,?,?,?)";
		    stmt = c.prepareStatement(SQL);
		    stmt.setString(1, username);
            stmt.setString(2, jobEarning);
            stmt.setString(3, propertyEarning);
            stmt.setString(4, businessEarning);
            stmt.setString(5, totalEarning);

			System.out.println(SQL);
		    stmt.executeUpdate();
		      System.out.println(username);

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
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Income Tax Management Corp");
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		frame.setAlwaysOnTop(true);
		JLabel l = new JLabel("Enter your income sources");
		l.setBounds(220, 10, 400, 75);
		Font labelFont = l.getFont();
		String labelText = l.getText();
		JLabel jobEarnings = new JLabel("Job Earnings");
		jobEarnings.setBounds(200,120,200,25);
		
		JLabel buisnessEarnings = new JLabel("Buisness Earnings");
		buisnessEarnings.setBounds(200,180,80,25);
		JLabel propertyEarnings = new JLabel("Property Earnings");
		propertyEarnings.setBounds(200,240,200,25);
		JLabel totalIncome = new JLabel("Miscallenous Earnings");
		totalIncome.setBounds(200,300,200,25);
		JTextField jobEarningsTF = new JTextField(20);
		jobEarningsTF.setBounds(350, 120, 165, 25);
		
		JTextField buisnessEarningsTF = new JTextField(20);
		buisnessEarningsTF.setBounds(350, 180, 165, 25);
		JTextField TF = new JTextField(20);
		TF.setBounds(350, 240, 165, 25);
		JTextField propertyEarningsTF = new JTextField(20);
		propertyEarningsTF.setBounds(350, 240, 165, 25);
		JTextField totalEarningsTF = new JTextField(20);
		totalEarningsTF.setBounds(350, 300, 165, 25);
		JButton button1 = new JButton("Save Credentials");
		button1.setBounds(50,420,200,25);
		
		JButton button2 = new JButton("Edit Credentials");
		button2.setBounds(280, 420, 150, 25);
		JButton button3 = new JButton("Investments");
		
		button3.setBounds(450, 420, 200, 25);
		ActionListener saveCredentialsListener  = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String legalname = user;
				String jobEarning = jobEarningsTF.getText();
				String totalEarning = totalEarningsTF.getText();
				String propertyEarning = propertyEarningsTF.getText();
				String buisnessEarning = buisnessEarningsTF.getText();
				Job = Double.parseDouble(jobEarning);
				Buisness = Double.parseDouble(buisnessEarning);
				Property = Double.parseDouble(propertyEarning);
				miscellanous = Double.parseDouble(totalEarning);
				TotalIncome = Job+Buisness+Property+miscellanous;
				saveCredentials(legalname,jobEarning,propertyEarning,buisnessEarning,totalEarning);
				JOptionPane.showMessageDialog(frame, "Credentials Saved");

	        }
			
		};
		ActionListener goToInvestmentsListener  = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(frame, "Total Income amount is " + TotalIncome);
				frame.dispose();
    			String[] incomes = {Double.toString(TotalIncome),user};
            	TaxPayerInvestmentsDriver driver = new TaxPayerInvestmentsDriver();
            	driver.main(incomes);

	        }
			
		};
		panel.add(l);
		panel.add(jobEarnings);
		panel.add(buisnessEarnings);
		panel.add(propertyEarnings);
		panel.add(totalIncome);
		panel.add(jobEarningsTF);
		panel.add(buisnessEarningsTF);
		panel.add(totalEarningsTF);
		panel.add(propertyEarningsTF);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		frame.setVisible(true);
		frame.setSize(700,500);
		button1.addActionListener(saveCredentialsListener);
		button3.addActionListener(goToInvestmentsListener);
	}
	

}
class TaxPayerIncomeDriver{
	public static void main(String args[]) {
		TaxPayerIncomeDetails user_income = new TaxPayerIncomeDetails();
		user_income.main(null);
		user_income.setlegalName(args[0]);
		user_income.getlegalName();

	}
	
}
