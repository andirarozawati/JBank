/**
 * class untuk error handling di CustomerGUI apabila saat pembuatan account sudah melebihi maksmimum account
 * @author  Andira
 * @version 12-05-2016
 */

public class MaxNumOfCustomersException extends Exception
{   
    /**
     * Constructor for objects of class MaxNumOfCustomers
     */
    public MaxNumOfCustomersException()
    {
        super("Anda sudah mencapai maksimal customer!");
    }
    
    
    public String getMessage()
    {
        return  super.getMessage();
    }
}