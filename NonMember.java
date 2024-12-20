public class NonMember extends Customer
{
	public NonMember(String c,String p) {
		super(c, p);
	}
	
    public double calculateTotalAmount(double ticketPrice,int quantity)
    {
        double totalAmount=0.0;
        totalAmount=ticketPrice*quantity;
        return totalAmount;
    }
}