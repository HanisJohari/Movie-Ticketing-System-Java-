import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

import javax.print.DocFlavor.INPUT_STREAM;

import java.io.PrintWriter;
import java.io.FileWriter;

public class movieMain {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);

    System.out.println("\t\t\t\t===========================================================");
    System.out.println("\t\t\t\t         WELCOME TO MOVIE TICKETING SYSTEM                 ");
    System.out.println("\t\t\t\t===========================================================");
    System.out.println("");
    
    System.out.println("\t\t\t\tPlease choose your role");
    System.out.println("\t\t\t\t[1] Customer");
    System.out.println("\t\t\t\t[2] Admin");
    
    System.out.print("\t\t\t\tChoose role: ");
    int role = input.nextInt();
    
    if(role == 1) {
    	boolean foundUser = false;
        String checkMembership = "";
        String phoneNo = "";
        String custName = "";
        Customer cust = null;

        while (!foundUser) {
          try {
            File f = new File("Customers.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            	
            input.nextLine();
            
            System.out.print("\t\t\t\tEnter username:");
            String username = input.nextLine();
            System.out.print("\t\t\t\tEnter password:");
            String password = input.nextLine();

            while ((line = br.readLine()) != null) {
              StringTokenizer st = new StringTokenizer(line, ";");
              String usernameFromUser = st.nextToken();
              String passwordFromUser = st.nextToken();
              checkMembership = st.nextToken();
              custName = st.nextToken();
              phoneNo = st.nextToken();

              if (username.equalsIgnoreCase(usernameFromUser) && password.equalsIgnoreCase(passwordFromUser)) {
                foundUser = true;
                break;
              }
            }

            if (!foundUser) {
              System.out.println("\t\t\t\t*****************************");
              System.out.println("\t\t\t\tUser not found!");
              System.out.println("\t\t\t\t*****************************");

            } else {

                if (checkMembership.equalsIgnoreCase("yes")) {
                  cust = new Member(custName, phoneNo);
                } else {
                  cust = new NonMember(custName, phoneNo);
                }
            }

          } catch (Exception e) {
            e.printStackTrace();
          }
        }

        Movie[] arrMovie = new Movie[30];
        int movieCount = 0;
        try {
          File f = new File("movies.txt");
          FileReader fr = new FileReader(f);
          BufferedReader br = new BufferedReader(fr);
          String line = "";

          while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ";");
            String movieName = st.nextToken();
            String genre = st.nextToken();
            double price = Double.parseDouble(st.nextToken());

            Movie myMovie = new Movie(movieName, genre, price);
            arrMovie[movieCount] = myMovie;
            movieCount++;
          }

        } catch (Exception e) {
          e.printStackTrace();
        }

        System.out.println("\t\t\t\t+------------------------+----------+---------+");
        System.out.println("\t\t\t\t|         MOVIE          |  GENRE   | PRICE   |");
        System.out.println("\t\t\t\t+------------------------+----------+---------+");
        for (int i = 0; i < movieCount; i++) {
          arrMovie[i].displayMovie(i);
        }
        System.out.println("\t\t\t\t+------------------------+----------+---------+");
        System.out.print("\t\t\t\tChoose your movie : ");
        int movie = input.nextInt();
        movie--; //movie=movie-1

        while (movie < 0 || movie > movieCount) {
          System.out.println("\t\t\t\tSorry, you entered the wrong number for movie. Please enter again.");
          System.out.print("\t\t\t\tChoose your movie : ");
          movie = input.nextInt();
          movie--;
        }

        //to get information about selected movie such as name,genre,price
        //will be used to display at the receipt
        Movie selectedMovie = arrMovie[movie];

        double ticketPrice = selectedMovie.getPrice(); // get the price of the selected movie

        //check condition untuk time
        String selectedTime;
        System.out.println("\t\t\t\t+-------------+");
        System.out.println("\t\t\t\t|    TIME     |");
        System.out.println("\t\t\t\t+-------------+");
        System.out.println("\t\t\t\t| [1]-10:00am |");
        System.out.println("\t\t\t\t| [2]-02:00pm |");
        System.out.println("\t\t\t\t| [3]-08:00pm |");
        System.out.println("\t\t\t\t+-------------+");
        System.out.print("\t\t\t\tChoose time (1/2/3): ");
        int time = input.nextInt();

        if (time == 1) {
          selectedTime = "10:00am";
        } else if (time == 2) {
          selectedTime = "02:00pm";
        } else {
          selectedTime = "08:00pm";
        }

        while (time < 1 || time > 3) {
          System.out.println("\t\t\t\tSorry you entered the wrong time. Please enter again.");
          System.out.print("\t\t\t\tChoose time (1/2/3): ");
          time = input.nextInt();
        }

        System.out.print("\t\t\t\tEnter number of ticket: ");
        int quantity = input.nextInt();

        //calculate ticket price
        double totalPrice = cust.calculateTotalAmount(ticketPrice, quantity);

        System.out.println("\t\t\t\t===========================================================");

        System.out.println("\t\t\t\t+-----------------------+");
        System.out.println("\t\t\t\t|    PAYMENT METHOD     |");
        System.out.println("\t\t\t\t+-----------------------+");
        System.out.println("\t\t\t\t| [1]-TOUCH N GO        |");
        System.out.println("\t\t\t\t| [2]-ONLINE BANKING    |");
        System.out.println("\t\t\t\t| [3]-DEBIT/CREDIT CARD |");
        System.out.println("\t\t\t\t+-----------------------+");
        System.out.print("\t\t\t\tChoose payment method (1/2/3):");
        int payment = input.nextInt();

        while (payment < 1 || payment > 3) {
          System.out.println("\t\t\t\tSorry you entered wrong payment method. Please enter again.");
          System.out.print("\t\t\t\tChoose payment method (1/2/3): ");
          payment = input.nextInt();
        }

        input.nextLine();

        String allPaymentMethods[] = {"TOUCH N GO", "ONLINE BANKING", "DEBIT/CREDIT CARD"};
        String paymentMethod = allPaymentMethods[payment];
        
        System.out.println("\t\t\t\tProcessing payment>>>>>>>>>>>>>>>>>>>>>>\n\n");
        
        System.out.println("\t\t\t\tPress enter once payment is done...");
        input.nextLine();
        
        //receipt object
        Receipt custReceipt = new Receipt(cust, selectedMovie, totalPrice, selectedTime, paymentMethod);

        //display receipt
        System.out.println("\t\t\t\t===========================================================");
        System.out.println("\t\t\t\t*********RECEIPT**************");
        custReceipt.displayReceipt();
        System.out.println("\t\t\t\t******************************");
        
        custReceipt.writeSaleToFile();
        
        System.out.println("\t\t\t\tThank you. Enjoy your movie!");
    } else {    	
    	Admin admin = new Admin();
    	while(!admin.login()) {
    		System.out.println("\t\t\t\t*****************************");
            System.out.println("\t\t\t\tWrong Admin Credentials");
            System.out.println("\t\t\t\t*****************************\n");
    	};
    	
    	while(true) {
    		System.out.println("\t\t\t\t===========================================================");
            System.out.println("\t\t\t\t         ADMIN MAIN MENU                 ");
            System.out.println("\t\t\t\t===========================================================\n");
            
            System.out.println("\t\t\t\t[1] - Insert New Movies");
            System.out.println("\t\t\t\t[2] - View Total Sales");
            
            System.out.print("\t\t\t\tEnter choice: ");
            int choice = input.nextInt();
            
            if(choice == 1) {
            	input.nextLine();
            	System.out.print("\t\t\t\tEnter new movie name: ");
            	String movieName = input.nextLine();
            	System.out.print("\t\t\t\tEnter new movie genre: ");
            	String movieGenre = input.nextLine();
            	System.out.print("\t\t\t\tEnter new movie price: RM");
            	int moviePrice = input.nextInt();
            	
            	Movie movie = new Movie(movieName, movieGenre, moviePrice);
            	movie.insertMovieIntoFile();        	
            } else {
            	admin.viewTotalSale();
            }
            
            System.out.println("\t\t\t\tChoose option:");
            System.out.println("\t\t\t\t[1] - Back to main menu");
            System.out.println("\t\t\t\t[2] - Log out");
            
            choice = input.nextInt();
            
            if(choice == 2) {
            	break;
            }
    	}
    	System.out.println("\t\t\t\tThank you for using our program!");
    	
    }
    
  }
}















