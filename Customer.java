
/**
 * kelas yang menghasilkan object customer 
 * berisikan data diri customer
 * @author andirarozawati 
 * @version 27/02/2016
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Customer
{
    private Account accounts = new Account();
    private String cityAddress;
    private int custId;
    private String dateOfBirth;
    private String email;
    private String firstName;
    private String lastName;
    private String cityName;
    private int numberOfCurrentAccounts;
    private String streetAddress;
    private String phoneNumber;
    private String zipOrPostalCode;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    /**
     * constructor object class
     */
     public Customer() {
        // initialise instance variables
        
    }
    
    /**
     * method contructor customer
     * @param fname first name customer
     * @param lname last name customer
     * @param dob date of birth customer
     */
    public Customer(String fname, String lname, String dob)
    {
      
    }
    
    /**
     * method contructor customer
     * @param fname first name customer
     * @param lname last name customer
     * @param dob date of birth customer
     * @param custId id customer
     */
    public Customer(String firstName, String lastName, String dateOfBirth, int custId)
    {
   
    }
    
    /**
     * untuk mendapatkan alamat customer
     * @return alamat nama dan postalcode customer
     */
    public String getAddress()
    {
        return streetAddress+cityName+zipOrPostalCode;
    }
    
    /**
     * mendapatkan alamat customer
     * @return all account customer
     */
    public Account getAccount()
    {
        return accounts;
    }
    
    /**
     * untuk assign update jumlah akun customer
     * @param akun milik customer
     */
    public void setAccount(Account akun)
    {
      accounts = akun;
    }
    
    /**
     * untuk mendapatkan ID customer 
     * @return custID nilai id 
     */
    public int getCustomer()
    {
        return custId;
    }
    
    /**
     * untuk mendapatkan email customer
     * @return email customer
     */
    private String getEmail()
    {
        return email;
    }
    
    /**
     * method untuk mendapatkan firsname dan lastname dari customer
     * @return nama lengkap customer
     */
    public String getName()
    {
        return lastName + "," + firstName;
    }
    
    /**
     * method untuk mendapatkan banyakya account seorang customer
     * @return nilai banyaknya account
     */
    public int getNumOfAccount()
    {
        return numberOfCurrentAccounts;
    }
    
     
    /**
     * method untuk mendapatkan no telepon customer
     * @return string no telepon
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
     
    /**
     * method untuk assign lokasi alamat
     * @param street nama jalan
     * @param city nama kota
     * @param code zip code
     */
    public void setAddress(String street, String city, String code)
    {
        this.streetAddress = street;
        this.cityName = city;
        this.zipOrPostalCode = code;
    }
    
     
    /**
     * method untuk assign email customer
     * @return matcher.matches
     */
    public boolean setEmail(String emailAddress)
    {
       this.email = emailAddress;
                
       Pattern pattern = Pattern.compile(EMAIL_PATTERN);//pattern email dari java 
       Matcher matcher = pattern.matcher(emailAddress);//assign pattern email ke matcher
       return matcher.matches(); // validasi email customer
    }
    
     
    /**
     * method untuk assign nama lengkap customer
     * @return lname nama belakang
     * @return fname nama depan
     */
    public void setName (String lname, String fname)
    {
        this.lastName = lname;
        this.firstName = fname;
    }
    
     
    /**
     * method set no telepon customer
     * @return phoneNum telepon customer
     */
    public void setPhoneNumber(String phoneNum)
    {
        this.phoneNumber = phoneNum;
    }
    
    
}