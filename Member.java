public class Member extends Customer
{
	public Member(String c,String p) {
		super(c, p);
	}
	
   public double calculateTotalAmount(double ticketPrice,int quantity)
   {
       double totalAmount=0.0;
       totalAmount=ticketPrice*quantity*0.95;
       return totalAmount;
    }
}