/**
 * class ini digunakan untuk user define error apabila
 * customer id tidak ditemukan di Customer GUI
 * @author andira
 * @version 12-05-2016
 */

public class CustomerNotFoundException extends Exception
{
    private int id;
    
    /**
     * Constructor for objects of class CustomerNotFound
     */
    public CustomerNotFoundException(int id)
    {
       super("Customer with id ");
       this.id = id;
    }

    /**
     * Pesan yang keluar bila id tidak ditemukan
     */
    public String getMessage()
    {       
        return super.getMessage() + id + " does not exist";
    }
}
