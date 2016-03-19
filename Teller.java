
import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;


/**
 * kelas teller merupakan titik awal program JBank berjalan.
 * kelas teller akan menjalankan method main.
 * kelas ini bertanggung jawab atas data awal customer.
 * @author andirarozawati 
 * @version 27/02/2016
 */
public class Teller
{
    private Customer c1 = new Customer ();
    /*
    private Account a1 = new Account ();
    */
    private String fullname;
    private String firstName;
    private String lastName;
    private Account acc;
    private Bank b = new Bank();
    private Date startTime;
    private Date closeTime;
    private int balance;
    public static Date stm, ctm;
    private static MathContext mc = new MathContext(5), mc1 = new MathContext(2);
    
    public void main(String[] args)
    {
       Scanner input = new Scanner(System.in);//scan input user
       String fname, lname;
       int year = GregorianCalendar.YEAR; 
       int month = GregorianCalendar.MONTH;
       int day = GregorianCalendar.DAY_OF_MONTH;
       String no_tlp, answer,acct_Type;
         Customer c1 = new Customer (firstName,lastName, (new GregorianCalendar(year,month,day).getTime()));
       do
       {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Selamat datang di JBank! Apakah anda ingin mendaftar menjadi customer kami? ('yes'/'no') ? ");
           answer = input.nextLine();//scan input
           if (answer.equals("yes||y"))
           {
                System.out.print("Masukkan nama depan anda: ");
            fname = input.nextLine();
            System.out.print("Masukkan nama belakang anda : ");
            lname = input.nextLine();
            System.out.println("Masukkan tanggal lahir anda  : ");
            String expectedPattern = ("MM/dd/yyyy");
            String tgl = input.nextLine();
            SimpleDateFormat dateOfBirth = new SimpleDateFormat("MM/dd/yyyy");
             Date date = dateOfBirth.parse(tgl);
            Calendar calender = new GregorianCalendar();
            calender.setTime(date);
            c1.setDateOfBirth(date);
           
            
            System.out.print("Masukkan nomor telepon anda : ");
            no_tlp = input.nextLine();
            
            c1.setName(fname,lname);//set customer name
            c1.setPhoneNumber(no_tlp);//set no tekp cutomer
            //c1.setDateOfBirth(dateOfBirth);//set tanggal lahir customer
            int custId = new Bank().getNextID(); //set ID
            c1.setCustID(custId);
            String ID = Integer.toString(custId);
            System.out.println("Masukkan jenis Account yang anda inginkan S,O,I,C ?");
            
           acct_Type = input.nextLine(); //baca input tipe char user
            
             if(acct_Type.equals("S") || acct_Type.equals("O") || acct_Type.equals("I") || acct_Type.equals("C") )
             {
                        do{
                            System.out.println("Masukkan saldo awal yang diinginkan:");
                            balance = input.nextInt();
                            if(balance<=0){
                                System.out.println("Input harus diatas 0");
                        } else {
                                break;
                        }
                        }while(true);
                       
                        a1 = new Account(acct_Type.charAt(0),balance);
                    } else if (acct_Type.equals("N") || acct_Type.equals("n")){
                        //return false;
                               
                    } else {
                        System.out.println("Maaf input anda salah massukan S/O/C/I");
                    }
             
           //print semua informasi yang sudah di input user
            System.out.println("Nama = \t\t:"+c1.getName());
            System.out.println("Customer ID = \t:"+c1.getCustID());
            System.out.println("Tanggal = \t:"+calender.getTime());
            System.out.println("No telepon = \t:"+c1.getPhoneNumber());
            System.out.println("Saldo = \t:"+a1.getBalance());
            System.out.println("Tipe Akun \t:"+a1.getAcctType());
              
        } 
        
         if (answer.equals("No")){
                System.out.println("Terima Kasih");
                System.exit(0);}
    }while(true);
   
        
        
    }
    
    public Teller ()
    {
      

    }

    /**
     * method main
     * membuat object tipe akun tertentu
     * membuat object customer beserta data diri
     */
    
 /* 
    public void main(String[] args) throws ParseException
    {/*
        // initialise instance variables
        c1.setName("Sutandi", "Sanadhi");//nama dari customer c1
        fullname = c1.getName();//assign full name sebagai nama customer c1
        System.out.println(fullname);//print nama customer c1
        
        a1.setBalance(150000);//deposit customer c1
        c1.setAccount(a1);//assign customer c1 sebagai akun a1
        acc = c1.getAccount();//account akan mendapat informasi dari c1
        balance = acc.getBalance();//assign balance account a1
        
        System.out.println(balance);//print
        
 
       Scanner input = new Scanner(System.in);//scan input user
       String fname, lname;
       
       String no_tlp, answer,acct_Type;
       Date d1,d2;
       d1 = new GregorianCalendar(2016, 3, 10, 8, 0).getTime();//buat waktu operational awal
       d2 = new GregorianCalendar(2016, 3, 10, 15, 30).getTime();//buat waktu operational akhir
       System.out.println(d1 + "to" +d2);
       int year = GregorianCalendar.YEAR; 
       int month = GregorianCalendar.MONTH;
       int day = GregorianCalendar.DAY_OF_MONTH;
       Customer c1 = new Customer (firstName,lastName, (new GregorianCalendar(year,month,day).getTime()));
       Account saving = new Account ('S', 1000);//set salod awal saving
       Account invest = new Account ('I', 1000);
       Account creditline = new Account ('C', 500);
       BigDecimal saldoS = new BigDecimal (saving.getBalance());
        BigDecimal saldoI = new BigDecimal (invest.getBalance());
        BigDecimal saldoC = new BigDecimal (creditline.getBalance());
        
        BigDecimal rS = new BigDecimal (.03); //perhitungan bunga 3% per hari
        BigDecimal rI = new BigDecimal (.07);
        BigDecimal rC = new BigDecimal (.18);
        BigDecimal n = new BigDecimal (360); 
        BigDecimal t = new BigDecimal (1.0); //perhitungan rate tahunan
        
        BigDecimal f1Saving = rS.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f1Investement = rI.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f1Credit = rC.divide(n, mc).add(new BigDecimal(1.0));
        BigDecimal f2 = n.multiply(t, mc);
        
        BigDecimal f3Saving = new BigDecimal (Math.pow(f1Saving.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3Investement = new BigDecimal (Math.pow(f1Investement.doubleValue(), f2.doubleValue()),mc);
        BigDecimal f3Credit = new BigDecimal (Math.pow(f1Credit.doubleValue(), f2.doubleValue()),mc);
        
        
        
        BigDecimal f4Saving = f3Saving.multiply(saldoS, mc);
        BigDecimal f4Investement = f3Investement.multiply(saldoI, mc);
        BigDecimal f4Credit = f3Credit.multiply(saldoI, mc);
     
        System.out.println("Saldo awal Saving : " +saving.getBalance());
        System.out.println("Saldo awal Investment : "+invest.getBalance());
        System.out.println("Saldo awal Credit : "+creditline.getBalance());
        System.out.println("Saldo Saving : " +f4Saving.doubleValue());
        System.out.println("Saldo Investment : " +f4Investement.doubleValue());
        System.out.println("Saldo Credit : " +f4Credit.doubleValue());
        //mulai pendataan new customer
       
         //selama jawaban yes melakukan hal berikut   
        do {
        System.out.println("Selamat datang di JBank! Apakah anda ingin mendaftar menjadi customer kami? ('yes'/'no') ? ");
        answer = input.nextLine();//scan input
        if (answer.equals("yes"))//apabila jawaban yes
        {
            
            System.out.print("Masukkan nama depan anda: ");
            fname = input.nextLine();
            System.out.print("Masukkan nama belakang anda : ");
            lname = input.nextLine();
            System.out.println("Masukkan tanggal lahir anda  : ");
            String expectedPattern = ("MM/dd/yyyy");
            String tgl = input.nextLine();
            SimpleDateFormat dateOfBirth = new SimpleDateFormat("MM/dd/yyyy");
             Date date = dateOfBirth.parse(tgl);
            Calendar calender = new GregorianCalendar();
            calender.setTime(date);
            c1.setDateOfBirth(date);
           
            
            System.out.print("Masukkan nomor telepon anda : ");
            no_tlp = input.nextLine();
            
            c1.setName(fname,lname);//set customer name
            c1.setPhoneNumber(no_tlp);//set no tekp cutomer
            //c1.setDateOfBirth(dateOfBirth);//set tanggal lahir customer
            int custId = new Bank().getNextID(); //set ID
            c1.setCustID(custId);
            String ID = Integer.toString(custId);
            System.out.println("Masukkan jenis Account yang anda inginkan S,O,I,C ?");
            
           acct_Type = input.nextLine(); //baca input tipe char user
            
             if(acct_Type.equals("S") || acct_Type.equals("O") || acct_Type.equals("I") || acct_Type.equals("C") )
             {
                        do{
                            System.out.println("Masukkan saldo awal yang diinginkan:");
                            balance = input.nextInt();
                            if(balance<=0){
                                System.out.println("Input harus diatas 0");
                        } else {
                                break;
                        }
                        }while(true);
                       
                        a1 = new Account(acct_Type.charAt(0),balance);
                    } else if (acct_Type.equals("N") || acct_Type.equals("n")){
                        //return false;
                               
                    } else {
                        System.out.println("Maaf input anda salah massukan S/O/C/I");
                    }
             
           //print semua informasi yang sudah di input user
            System.out.println("Nama = \t\t:"+c1.getName());
            System.out.println("Customer ID = \t:"+c1.getCustID());
            System.out.println("Tanggal = \t:"+calender.getTime());
            System.out.println("No telepon = \t:"+c1.getPhoneNumber());
            System.out.println("Saldo = \t:"+a1.getBalance());
            System.out.println("Tipe Akun \t:"+a1.getAcctType());
              
        } 
        
         if (answer.equals("No")){
                System.out.println("Terima Kasih");
                System.exit(0);}
    }while(true);
   
    
    
}
*/

    public static Date getCloseTime() {
        return ctm;
    }
    
     public static Date getStartTime() {
        return stm;
    }
    
      public static void setCloseTime(int year,int month,int day,int hour, int min) {
        stm = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
      public static void setStartTime(int year,int month,int day,int hour, int min) {
        stm = new GregorianCalendar(year, month, day, hour, min).getTime();
    }
    
    public static void printTime() {
        System.out.println(Bank.getHoursOfOperation());
    }
    
    

    
    }
   

 