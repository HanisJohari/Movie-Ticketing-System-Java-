import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Admin {
	public boolean login() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("\t\t\t\tEnter username: ");
    	String username = input.nextLine();
    	System.out.print("\t\t\t\tEnter username: ");
    	String password = input.nextLine();
    	
		return (username.equals("admin") && password.equals("1234"));
	}
	
	public void viewTotalSale() {
		
		try {
			File f = new File("Sales.txt");
		    FileReader fr;
		   
		    double currentSale;
		   
		    if(!f.exists()) {
			    System.out.println("No sales found!");
		    } else {
			    fr = new FileReader(f);
			    BufferedReader br = new BufferedReader(fr);
			    currentSale = Double.parseDouble(br.readLine());
			    
			    System.out.println("\t\t\t\t===========================================================");
	            System.out.println("\t\t\t\t         VIEWING TOTAL SALE               ");
	            System.out.println("\t\t\t\t===========================================================\n");
			    
			    System.out.println("\t\t\t\tTotal Sales: RM " + currentSale);
		    }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
