package TaxSlab;

public class TaxSlabDriver {
	public static void main(String args[]) {
		CalTaxSlab slab = new CalTaxSlab();
		slab.main(null);
		slab.setInvestments(Double.parseDouble(args[0]));
		slab.setIncome(Double.parseDouble(args[1]));
		slab.setUser(args[2]);
	}
}
