import java.util.Scanner;
import java.lang.Character;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.Duration;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.*;
import java.text.*;
import java.io.*;

/**
 * @author andira
 * @version 12-05-2016
 */

public class Bank
{
   private static Date startTime;
   private static Date closeTime;
   private static double investmentInterestRate;
   private static double premiumInterestRate = 0.03;
   private static double creditInterestRate;
   private static int lastCustID;
   private static int nextCustID;
   public static String Name = "JBANK";
   private static String phone;
   public static String website;
   public static String Address = "1234 JavaStreet, AnyCity, ThisState, 34567";
   private static int numOfCurrentCustomers = 0;
   public static int MAX_NUM_OF_ACCTS_PER_CUSTOMER=4;
   private static int MAX_NUM_OF_CUSTOMERS = 20;
   
   /*static 
    *{
    *    Scanner scan = new Scanner(System.in);
    *    System.out.printf("Masukkan jumlah maksimum kostumer: ");
    *    int input = scan.nextInt();
    *    String input = JOptionPane.showInputDialog("Enter maximum number of customers");
    *    MAX_NUM_OF_CUSTOMERS = Integer.parseInt(input);
    *}
    */
   
   //private static Customer[] customers = new Customer[MAX_NUM_OF_CUSTOMERS];
   private static ArrayList<Customer> customer = new ArrayList<Customer>();
   
   /**
    * Method constructor Bank
    */
   public Bank()
   {    
   }
    
   /**
    * Method untuk menambahkan customer kedalam array
    * @param customer Customer yang akan ditambahkan
    */
   public static void addCustomer(Customer customer) throws MaxNumOfCustomersException
   {
       if(numOfCurrentCustomers<MAX_NUM_OF_CUSTOMERS)
       {
           Bank.customer.add (customer);
           System.out.println("customer berhasil ditambahkan!");
           numOfCurrentCustomers++;
       }
       else
       {
           throw new MaxNumOfCustomersException();
       }
   }
   
   /**
    * Method untuk mengambil data customers dari customer.dat
    * @return data customer yang diambil
    */
   public static boolean importCustomer()
   {
       try
       {
           CustomerFileReader cfr = new CustomerFileReader();
           customer = (ArrayList)cfr.readCustomers() ;
           customer.forEach(System.out::println);
           return true;
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
           return false;
       }
   }
   
   /**
    * Method untuk menyimpan data customers menjadi customer.dat
    * @return data customers yang tersimpan
    */
   public static boolean exportCustomer()
   {
       try
       {
            CustomerFileWriter fileWriter = new CustomerFileWriter();
            fileWriter.saveCustomers(customer);
            return true;
       }
       catch(Exception e)
       {
            System.out.println("Writer - " + e.getMessage());
            return false;
       }   
   }
   
   /**
    * Method untuk memanggil ArrayList yang berisi customers
    * @return customer
    */
   public static ArrayList getArray()
   {
       return customer;
   }
    
   /**
    * Method untuk mendapatkan customer dari array
    * @param custID yang ingin didapatkan
    * @throws CustomerNotFound 
    */
   public static Customer getCustomer(int custID) throws CustomerNotFoundException
    {      
        Customer c;
        Iterator itr = customer.iterator();
        while(itr.hasNext())
        {
            c = (Customer)itr.next();
            if(c.getCustID() == custID)
            {
                return c;
            }
        }
        throw new CustomerNotFoundException(custID);
   }
    
   /**
     * Method accessor untuk mendapatkan jumlah maksimum customer dalam bank
     * @return Jumlah maksimum customer
     */
   public static int getMaxCustomers() 
   {
       return MAX_NUM_OF_CUSTOMERS;
   }
    
    /**
     * Method accessor untuk mendapatkan alamat bank
     * @return Alamat bank
     */
    /*public static String getAddress()
    {
        return Address;
    }*/
    
   /**
    * Method accessor untuk mendapatkan credit rate dalam desimal
    * @return Suku bunga dalam desimal
    */
   public static double getCreditRate()
   {
      return creditInterestRate;
   }
    
   /**
    * Method accessor untuk mendapatkan investment rate dalam desimal
    * @return Besar tingkat investasi dalam desimal
    */
   public static double getInvestmentRate()
   {
      return investmentInterestRate;
   }
    
   /**
    * Method accessor untuk mendapatkan waktu kerja bank
    * @return Waktu kerja
    */
   public static String getHoursOfOperation()
   {
       SimpleDateFormat startTimeFormat = new SimpleDateFormat("hh:mm a");
       SimpleDateFormat closeTimeFormat = new SimpleDateFormat("hh:mm a");
       return startTimeFormat.format(Bank.getStartTime())+"   TO  "+closeTimeFormat.format(Bank.getCloseTime());
   }
    
   /**
    * Method accessor untuk mendapatkan nomor ID terakhir
    * @return No ID terakhir
    */
   public static int getLastID()
   {
       return lastCustID;
   }
    
   /*
    * Method accessor untuk mendapatkan nama bank
    * @return Nama bank
    *
   public static String getName()
   {
       return Name;
   }
   */
    
   /**
    * Method accessor untuk mendapatkan jumlah customer saat ini
    * @return Jumlah customer
    */
   public static int getNumOfCurrentCustomers()
   {
       return numOfCurrentCustomers;
   }
    
   /**
    * Method accessor untuk mendapatkan nomor ID selanjutnya
    * @return No ID selanjutnya
    */
   public static int getNextID()
   {
       int nextID=0;
       if(numOfCurrentCustomers>=MAX_NUM_OF_CUSTOMERS)
       {
       }
       else
       {
            if(nextCustID==0)
            {   
                nextCustID=1000;
                nextID=nextCustID;
            }
            else
            {   
                lastCustID=nextCustID;
                nextCustID++;
                nextID=nextCustID;
            }
       }
       return nextID;
   }
    
   /**
    * Method accessor untuk mendapatkan alamat website bank
    * @return Url website
    */
   public static String getWebsite()
   {
       return website;
   }
    
   /**
    * Method accessor untuk mendapatkan premium rate dalam desimal
    * @return Suku bunga premium dalam desimal
    */
   public static double getPremiumRate()
   {
       return premiumInterestRate;
   }
    
   /**
    * Method accessor untuk mendapatkan nomor telepon bank
    * @return No telepon
    */
   public static String getPhone()
   {
       return phone;
   }
    
   /**
    * Method untuk mendapatkan waktu buka bank
    * @return Waktu buka bank
    */
   public static Date getStartTime()
   {
       return startTime;
   }
    
   /**
    * Method untuk mendapatkan waktu tutup bank
    * @return Waktu tutup bank
    */
   public static Date getCloseTime()
   {
       return closeTime;
   }
    
   /**
    * Method untuk mengatur waktu buka bank
    * @param hour Jam
    * @param min Menit
    */
   public static void setStartTime(int hours, int minute)
   {
       startTime = new GregorianCalendar(1970,0,0,hours,minute).getTime();
   }
    
   /**
    * Method untuk mengatur waktu tutup bank
    * @param hour Jam
    * @param min Menit
    */
   public static void setCloseTime(int hours, int minute)
   {
       closeTime = new GregorianCalendar(1970,0,0,hours,minute).getTime();
   }
    
   /**
    * Method mutator untuk menentukan besar credit rate akhir
    * @param rate Persen suku bunga dalam desimal
    */
   public static void setCreditRate(double rate)
   {        
   }
    
   /**
    * Method mutator untuk menentukan besar investment rate akhir
    * @param rate Persen tingkat investasi dalam desimal
    */
   public static void setInvestmentRate(double rate)
   {        
   }
    
   /**
    * Method mutator untuk menentukan besar premium rate akhir
    * @param rate Persen suku bunga premium dalam desimal
    */
   public static void setPremium(double rate)
   {        
   }
}