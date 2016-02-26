
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
    private static String closeTime;
    private static double investmentInterestRate;
    private static int lastCustID, numOfCurrentCustomer;
    private static int nextID, nextCustID;
    private static String phone;
    public static String website;
    public static String bankAddress = "1234 JavaStreet, AnyCity, ThisState,34567";
    public static int maxNumOfCustomers = 20;
    public static String bankName = "JBANK";
    
    public Bank()
    {
       
    }
   
    /**
     * method untuk mendapatkan get address
     */
    public static String getAddress()
    {
        return "";
    }
    
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
    public static int getMaxCustomers()
    {
        return 0;
    }
    
    /**
     * method untuk mendapatkan nama customer
     */
    public static String getName()
    {
        return null;
    }
    
    /**
     * method untuk mendapatkan nextID
     * @return nextCustID
     */
    public static int getNextID ()
    {
        if (nextCustID == 0)  //cek apakah nextCustID bernilai 0
        {
            lastCustID = 1000; //mulai perhitungan lastCustID
            nextCustID = 1000; //mulai perhitungan nextCustID
            return nextCustID;
        }
        else 
        {
            lastCustID = nextCustID; // lastCustID jadi acuan nextCustID
            nextCustID = lastCustID + 1;// perhitungan nextCustID
            return nextCustID;
        }
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
    
}
