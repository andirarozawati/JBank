import java.util.*;
import java.text.*;
import java.math.*;
import java.io.IOException;
import java.text.ParseException;
/**
 * Kelas ini merupakan kelas utama dari program JBank.
 * Kelas ini memodelkan teller dalam suatu bank
 * 
 * @author andira   
 * @version 
 */
public class Teller
{
    public Account[] a1 = new Account [4];
   
    //private SortedSet customers = new TreeSet(CustomerFileReader.readCustomers());
    private String fullname;
    private String firstName;
    private String lastName;
    private Account acc;
    private Date startTime;
    private Date closeTime;
    private int balance;
    private double custID;
    public static Date stm, ctm;
    private static MathContext mc = new MathContext(5), mc1 = new MathContext(2);
    private static SortedSet<Customer> customers = new TreeSet<Customer>();
    
   
    
    /*
    /**
     * Method untuk memasukkan customer kedalam ArrayList dan write ke file
     * @param c Customer yang akan disimpan
     */
    /*
    public static void createNewCustomer(Customer c) 
    {
        customers.add(c);
        CustomerFileWriter writer = new CustomerFileWriter();
        writer.saveCustomer(customers);
    }
    */
   
   /*
    /**
     * Method untuk mencari customer dalam ArrayList
     * @param custID ID customer
     * @return Customer yang dicari
     */
    /*
    public static Customer getCustomer(int custID) 
    {
        Customer cust = null;
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            cust = itr.next();
            if(cust.getCustID() == custID) {
                return cust;
            }
            else {
                cust = null;
            }
        }
        return cust;
    }
    */
    /**
     * Main function
     */
    public static void main(String[] args)
    {
        SortedSet<Customer> customersa = new TreeSet<>(Comparator.comparing(Customer::getCustID));
       ArrayList<Customer> customers = new ArrayList<Customer>();
        
        CustomerFileWriter custWriter = new CustomerFileWriter();
        CustomerFileReader custReader = new CustomerFileReader();
        ArrayList<Customer> read;
        Teller teller = new Teller();
        Customer cust= new Customer("andira", "rozawati");
        Customer cust1= new Customer("lala", "lili");
        
        customers.add(cust);
        customers.add(cust1);
        /*
        //custWriter.saveCustomer(customers);
        try{
        read=custReader.readCustomers();
        System.out.println(read.get(0));
        System.out.println(read.get(1));
    }
    catch(IOException e){
        System.out.println(e.getMessage());
    }
    catch(ClassNotFoundException cnf){
        System.out.println(cnf.getMessage());
    }
    }*/
    }

    /**
     * method untuk mendapatkan customer berdasarkan ID
     * @param int CustID
     */
        public static Customer getCustomer(int custID) 
    {
        Customer cust = null;
        Iterator<Customer> itr = customers.iterator();
        while(itr.hasNext()) {
            cust = itr.next();
            if(cust.getCustID() == custID) {
                return cust;
            }
            else {
                cust = null;
            }
        }
        return cust;
    }
    
    /**
     * Method untuk mendapatkan waktu start time kerja jbank
     * @return stm waktu yang telah di set
     */
     public static Date getStartTime() {
        return stm;
    }
    
    /**
     * Method untuk set waktu tutup jbank
     * @param waktu dari tahun ke menit
     */
      public static void setCloseTime(int year,int month,int day,int hour, int min) {
        stm = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    /**
     * Method untuk set waktu awal jbank
     * @param waktu dari tahun ke menit
     */
      public static void setStartTime(int year,int month,int day,int hour, int min) {
        stm = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    /**
     * Method untuk print waktu
     * 
     */
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }
    
    /**
     * Method untuk membuat customer baru
     * @param nama depan
     * @param nama akhir
     * @param tanggal lahir
     */
    public Customer createNewCustomer(String fname, String lname, Date DOB) {
        return new Customer(fname, lname, DOB);
    }
    
    
    /**
     * Method mendapatkan account suatu customer
     * @param objek customernya
     */
     public static void getAccount(Customer customer)
    {
        for (int x = 0; x < customer.accounts.length; x++)
        {
            if (customer.accounts[x] != null)
            {
                System.out.println("Account : " + customer.accounts[0].getId());
                System.out.println("Balance : " + customer.accounts[0].getBalance());
            }
        }
    }

}
     