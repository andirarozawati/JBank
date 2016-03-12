import java.util.Date;
/**
 * kelas bank yang akan menghasilkan object customer
 * 
 * @author andirarozawati 
 * @version 27/02/16
 */
public class Bank
{
    // instance variables - replace the example below with your own
    private static double creditInterestRate ;
    private static Date closeTime;
    private static Date startTime;
    private static double investmentInterestRate;
    private static int lastCustID = 1000, numOfCurrentCustomer;
    private static int nextID, nextCustID = 1000;
    private static String phone;
    public static String website;
    public static String Address = "1234 JavaStreet, AnyCity, ThisState,34567";
    public static int maxNumOfCustomers = 20;
    public static final String Name = "JBANK";
   
   
  
     
    public Bank()
    {
       
    }
   
    /**
     * method untuk mendapatkan get address
     */
    
    /*public static String getAddress()
    {
        return "";
    }
   */
    
    /**
     * method untuk mendapatkan get credit rate
     */
    public static double getCreditRate ()
    {
        return 0;
    }
    
    
    /**
     * method untuk mendapatkan get investement rate
     */
    public static double getInvestmentRate()
    {
        return 0;
    }
    
    /**
     * method untuk mendapatkan jam operasi kerja
     */
    public static String getHoursOfOperation()
    {
        return null;
    }
    
    /**
     * method untuk mendapatkan ID terakhir customer
     */
    public static int getLastID()
    {
        return 0;
    }
    
    /**
     * method untuk mendapatkan maximun customer
     */
    
    /*public static int getMaxNumOfCustomers()
    {
        return 0;
    }
    */
 
    
    /**
     * method untuk mendapatkan nama customer
     */
    
    /*public static String getName()
    {
        return null;
    }
    */
   
    /**
     * method untuk mendapatkan nextID
     * @return nextCustID
     */
    public static int getNextID ()
    {
       int NextCustIDs;
        NextCustIDs = nextCustID;
        if (nextCustID == 0)  //cek apakah nextCustID bernilai 0
        {
           
            
            lastCustID = 1000; //mulai perhitungan lastCustID
            numOfCurrentCustomer = numOfCurrentCustomer;
            
            return NextCustIDs;
        }
        
        else if ( numOfCurrentCustomer == maxNumOfCustomers)
        {//cek apakah cutomer sudah memiliki max account
         
            return 0;
        }
        
        else if (nextCustID != 0)
        {//apabil customer masih bisa memiliki akun
            lastCustID = nextCustID; // lastCustID jadi acuan nextCustID
            nextCustID += 1;// perhitungan nextCustID
           
            numOfCurrentCustomer += 1;
        }
        return NextCustIDs;
    }
    
    /**
     * method untuk mendapatkan website
     */
    public static String getWebsite()
    {
        return "";
    }
    
    /**
     * method untuk mendapatkan premium rate customer
     */
    public static double getPremiumRate()
    {
        return 0;
    }
    
    /**
     * Method untuk getNumOfCurrentCustomers
     * @return nilai jumlah pelanggan
     */
    public static int getNumOfCurrentCustomers() 
    {
        return numOfCurrentCustomer;
    }
    
    /**
     * method untuk mendapatkan phone number
     */
    public static String getPhone()
    {
        return "";
    }
    
    /**
     * method untuk assign creditrate
     */
    public static void setCreditRate (double rate)
    {
        
    }
    
    /**
     * method untuk assign investment rate
     */
    public static void setInvestmentRate (double rate)
    {
        
    }
    
    /**
     * method untuk assign premium 
     */
    public static void setPremium (double rate)
    {
        
    }
    
    public Date getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime()
    {
        
    }
    
    public Date getCloseTime()
    {
        return closeTime;
    }
    
    public void setCloseTime()
    {
        
    }
    
}
