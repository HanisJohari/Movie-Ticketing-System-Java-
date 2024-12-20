import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Movie
{
      
    private String name;
    private String genre;
    private double price;
    
    public Movie(String name,String genre,double price)
    {
        this.name=name; 
        this.genre=genre;
        this.price=price;
    }
    
    public void setName(String name){this.name=name;}
    public void setGenre(String genre){this.genre=genre;}
    public void setPrice(double price){this.price=price;}
    
    public String getName(){return name;}
    public String getGenre(){return genre;}
    public double getPrice(){return price;}
    
    public void displayMovie(int index) 
    {
    System.out.printf("\t\t\t\t|[%d] %-20s| %-9s| RM %.2f|\n", index + 1, name, genre, price);
}

    
    public String toString()
    {return("\nMovie:" + name + "\nGenre:" + genre + "\nPrice:" + price);}
    
    public void insertMovieIntoFile() {
    	FileWriter fw;
    	PrintWriter pw; 
		try {
			fw = new FileWriter("Movies.txt", true);
			pw = new PrintWriter(fw);
			
			pw.println(name + ";" + genre+ ";" + price);
			System.out.println("\t\t\t\tMovie Inserted Successfully!");
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    
}