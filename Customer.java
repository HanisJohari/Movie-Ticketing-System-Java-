public abstract class Customer
{
    private String custName;
    private String phoneNo;
    
    public Customer()
    {
        custName="";
        phoneNo="";
    }
    
    public Customer(String c,String p)
    {
        custName=c;
        phoneNo=p;
    }
    

    public String getCustName(){return custName;}
    public String getPhoneNo(){return phoneNo;}
    
    public void setCustName(String c){custName=c;}
    public void setPhoneNo(String p){phoneNo=p;}
    
    public abstract double calculateTotalAmount(double ticketPrice,int quantity);
}