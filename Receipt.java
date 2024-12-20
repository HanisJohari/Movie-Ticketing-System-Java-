import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Receipt 
{
  private Customer cust;
  private Movie selectedMovie;
  private double totalPrice;
  private String selectedTime;
  private String paymentMethod;
  
  public Receipt(Customer cust,Movie selectedMovie,double totalPrice,String selectedTime, String paymentMethod)
  {
      this.cust=cust;
      this.selectedMovie=selectedMovie;
      this.totalPrice=totalPrice;
      this.selectedTime=selectedTime;
      this.paymentMethod = paymentMethod;
  }
  
   //buat file receipt
   public void displayReceipt() 
   {
    System.out.printf("\t\t\t\tName        : %s\n",cust.getCustName());
    System.out.printf("\t\t\t\tPhone no    : %s\n",cust.getPhoneNo());
    System.out.printf("\t\t\t\tMovie       : %s\n",selectedMovie.getName()); 
    System.out.printf("\t\t\t\tTotal Price : RM%.2f\n",totalPrice);
    System.out.printf("\t\t\t\tTime        : %s\n",selectedTime);
    System.out.printf("\t\t\t\tPay. Method : %s\n",paymentMethod);
   }
   
   public void writeSaleToFile() {
	   
	   try {
		   // Read the current total sale
		   File f = new File("Sales.txt");
		   FileReader fr;
	       
		   double currentSale;
		   
		   if(!f.exists()) {
			   f.createNewFile();
			   currentSale = 0;
		   } else {
			   fr = new FileReader(f);
			   BufferedReader br = new BufferedReader(fr);
			   currentSale = Double.parseDouble(br.readLine());
		   }
		  
		   FileWriter fw = new FileWriter("Sales.txt");
		   PrintWriter pw = new PrintWriter(fw);
		   
		   double newTotalSale = currentSale + this.totalPrice;
		   
		   pw.println(newTotalSale);
		   pw.close();
		   fw.close();
		   
	   } catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   
   }

}