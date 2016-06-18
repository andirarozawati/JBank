import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.lang.Character;
import java.io.*;
import java.text.*;
import java.util.*;

/**
 * class untuk pembuatan customer baru
 * @author andira
 * @version 
 */

public class Customer implements Comparator<Customer>, Serializable
{
    public Account[] accounts = new Account[4];
    private int custID;
    private int numOfAccounts;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String cityAddress;
    private String streetAddress;
    private String state;
    private String zip;
    private Pattern pattern;
    private Matcher matcher;
    private static String cek = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static java.util.regex.Pattern p = java.util.regex.Pattern.compile(cek);
    private static DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
    
    public Customer()
    {
    }
    
    /**
     * Method Constructor Customer
     * @param fname Nama depan nasabah
     * @param lname Nama belakang nasabah
     */
    public Customer(String fname, String lname)
    {
        this(fname, lname, (new GregorianCalendar().getTime()));
    }
    
    /**
     * Method Constructor Customer
     * @param firstName Nama depan nasabah
     * @param lastName Nama belakang nasabah
     * @param DOB Tanggal lahir nasabah
     */
    public Customer(String firstName, String lastName, Date dateOfBirth)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        custID = Bank.getNextID();
    }
    
    public Customer(String firstname, String lastname, String dob)
    {
       SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
       this.firstName = firstName;
       this.lastName = lastName;
       try
       {
           dateOfBirth = df.parse(dob);
       }
       catch(Exception e){}
       custID = Bank.getNextID();
    } 
    
    /**
     * Method override untuk membandingkan ID customer
     * @param c Customer
     * @return 1, 0, atau -1 apabila ID lebih besar, sama dengan, atau lebih kecil
     */
    public int compareTo(Customer c)
    {
        if(custID > c.getCustID())
        {
            return 1;
        }
        else if(custID < c.getCustID()) 
        {
            return -1;
        }
        else if(custID == c.getCustID())
        {
            return 0;
        }
        else 
        {
            return 0;
        }
    }
    
    public int compare(Customer a, Customer c)
    {
        if(a.getCustID() > c.getCustID())
        {
            return 1;
        }
        if(a.getCustID() < c.getCustID())
        {
            return -1;
        }
        if(a.getCustID() == c.getCustID())
        {
            return 0;
        }
        else 
        {
            return 0;
        }
    } 
    
    /**
     * Method untuk menambahkan account
     * @param acct Account yang ingin ditambahkan
     * @throws AccountTypeAlreadyExistsException Apabila tipe akun sudah ada dalam array
     */
    public boolean addAccount(double balance, char type) throws AccountTypeAlreadyExistsException,AccountTypeNotFoundException
    {
        boolean accountAdded=false;
        int notUsed = -1;
        if(numOfAccounts<5)
        {
            for(int i=0;i<accounts.length;i++)
            {
                if(accounts[i]==null && notUsed==-1)
                {
                    notUsed=i;
                }
                else if(accounts[i] != null)
                {
                    if(type =='S' && accounts[i] instanceof Savings && accounts[i] instanceof Investment == false )
                    {
                        throw new AccountTypeAlreadyExistsException('S');
                    }
                    if(type =='I' && accounts[i] instanceof Investment)
                    {
                        throw new AccountTypeAlreadyExistsException('I');
                    }
                    if(type =='L' && accounts[i] instanceof LineOfCredit)
                    {
                        throw new AccountTypeAlreadyExistsException('L');
                    }
                    if(type =='O' && accounts[i] instanceof OverDraftProtect)
                    {
                        throw new AccountTypeAlreadyExistsException('O');
                    }
                }
            }        
            if(notUsed!=-1 && !accountAdded)
            {
                if(type=='S')
                {               
                    accounts[notUsed] = new Savings(this,balance);
                }
                if(type=='I')
                {
                    accounts[notUsed] = new Investment(this,balance,6);
                }
                if(type=='L')
                {
                    accounts[notUsed] = new LineOfCredit(this,balance,1000);
                }          
                if(type=='O')
                {
                    accounts[notUsed] = new OverDraftProtect(this,balance,(Savings)getAccount('S'));
                }            
                numOfAccounts++;
                accountAdded=true;
            }      
        }
        return accountAdded;
    }
    
    /**
     * Method untuk mendapatkan informasi akun
     * @param type Tipe akun (S/O/I/L)
     * @return Informasi akun
     * @throws AccountTypeNotFoundException Apabila akun dengan tipe tersebut tidak ada dalam array
     */
    public Account getAccount(char type) throws AccountTypeNotFoundException
    {
        for(int i=0;i<accounts.length;i++)
        {
           if(accounts[i] !=null)
           {
               if(type =='I' && accounts[i] instanceof Investment)
               {
                   return accounts[i];
               }
               if(type =='S' && accounts[i] instanceof Savings && accounts[i] instanceof Investment == false )
               {
                   return accounts[i];
               }
               if(type =='L' && accounts[i] instanceof LineOfCredit)
               {
                   return accounts[i];
               }
               if(type =='O' && accounts[i] instanceof OverDraftProtect)
               {
                   return accounts[i];
               }
           } 
        }
        throw new AccountTypeNotFoundException(type);
    }
    
    /**
     * Method untuk menghapus account
     * @param type Tipe akun (S/O/I/L)
     * @return True jika berhasil dan false jika tidak
     * @throws AccountTypeNotFoundException Apabila akun dengan tipe tersebut tidak ada dalam array
     */
    public boolean removeAccount(char type) throws AccountTypeNotFoundException
    {
        for(int i=0;i<accounts.length;i++)
        {
           if(accounts[i] !=null)
           {
               if(type =='S' && accounts[i] instanceof Savings && accounts[i] instanceof Investment == false )
               {
                   accounts[i] = null;
                   numOfAccounts--;
                   return true;
               }
               if(type =='I' && accounts[i] instanceof Investment)
               {
                   accounts[i] = null;
                   numOfAccounts--;
                   return true;
               }
               if(type =='L' && accounts[i] instanceof LineOfCredit)
               {
                   accounts[i] = null;
                   numOfAccounts--;
                   return true;
               }
               if(type =='O' && accounts[i] instanceof OverDraftProtect)
               {
                   accounts[i] = null;
                   numOfAccounts--;
                   return true;
               }
           } 
        }
        throw new AccountTypeNotFoundException(type);
    }
    
    /**
     * @return String:lastName
     */
    public String getLastName()
    {
        return lastName;
    }
  
    /**
     * @return String:firstName
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Method accessor alamat nasabah
     * @return Alamat
     */
    public String getAddress()
    {
       return streetAddress;   
    }
    
    public String getCity()
    {
       return cityAddress;
    }
   
    public String getState()
    {
       return state;
    }
   
    public String getZip()
    {
       return zip;
    }
    
    /**
     * Method accessor ID nasabah
     * @return Nomor ID
     */
    public int getCustID()
    {
        return custID;
    }
    
    /**
     * Method accessor email nasabah
     * @return Alamat email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Method accessor nama nasabah
     * @return Nama
     */
    public String getCustName()
    {
       return lastName+ ',' +firstName;
    }
    
    /**
     * Method accessor jumlah akun
     * @return Jumlah akun
     */
    public int getNumOfAccounts()
    {
        return numOfAccounts;
    }
    
    /**
     * Method accessor nomor telepon nasabah
     * @return Nomor telepon
     */
    public String getPhone()
    {
        return phone;
    }
    
    /**
     * Method accessor DOB
     * @return DOB
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
   
    public String getDateOfBirthInString()
    {
        return df.format(dateOfBirth);
    }
    
    /**
     * Method mutator DOB
     * @param DOB DOB
     */
    
    public void setDateOfBirth(Date dateOfBirth)
    {
      this.dateOfBirth = dateOfBirth;
    }
    
    public void setDateOfBirthInString(String s)
    {
      try
      {
          dateOfBirth = df.parse(s);
      }
      catch(Exception e)
      {
          dateOfBirth = new Date();
      }
    }
    
    /**
     * Method mutator alamat nasabah
     * @param street Alamat jalan
     * @param city Kota tinggal
     * @param code Kode daerah
     */
    public void setAddress(String streetAddress, String cityAddress, String state, String zip)
    {
        this.streetAddress = streetAddress;
        this.cityAddress = cityAddress;
        this.state = state;
        this.zip = zip;
    }
    
    /**
     * Method mutator email
     * @param emailAddress Alamat email
     */
    public boolean setEmail(String emailAddress)
    {
        java.util.regex.Matcher m = p.matcher(emailAddress);
        if(m.matches())
        {
            email=emailAddress;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Method mutator nama
     * @param lname Nama belakang
     * @param fname Nama depan
     */
    public void setName(String lastName, String firstName)
    {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    
    /**
     * Method mutator nomor telepon
     * @param phoneNum Nomor telepon
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    /**
     * Method mutator ID
     * @param id Nomor ID
     */
    public void setCustID(int custID)
    {
        this.custID = custID;
    }
    
    /**
     * Method toString untuk menampilkan info customer
     * @return String
     */
    public String toString()
    {
        return firstName +" "+lastName+" "+custID;
    }
}