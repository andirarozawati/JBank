
/**
 * Write a description of class customer here.
 * 
 * @author andirarozawati 
 * @version version1 
 */
public class Customer
{
    private Account accounts = new Account();
    private String cityAddress;
    private int custId;
    private String dtaeOfBirth;
    private String email;
    private String firstName;
    private String lastName;
    private int numberOfCurrentAccounts;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    
    /**
     * Constructor for objects of class Customer
     */
     public Customer() {
        // initialise instance variables
        
    }

    public Customer(String fname, String lname, String dob)
    {
      
    }
    
    public Customer(String firstName, String lastName, String dateOfBirth, int custId)
    {
   
    }
    
    private String getAddress()
    {
        return null;
    }
    
    private Account getAccount()
    {
        return null;
    }
    
    private int getCustomer()
    {
        return 0;
    }
    
    private String getEmail()
    {
        return null;
    }
    
    private String getCustomerName()
    {
        return null;
    }
    
    public int getNumOfAccount()
    {
        return 0;
    }
    
    private String getPhoneNumber()
    {
        return null;
    }
    
    private void setAddress(String street, String city, String code)
    {
        
    }
    
    private void setEmail(String emailAddress)
    {
    
    }
    
    private void setCustomerName (String lname, String fname)
    {
        
    }
    
    private void setPhoneNumber(String phoneNum)
    {
        
    }
    
    
}