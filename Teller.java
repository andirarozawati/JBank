import java.util.Scanner;

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
    private Account a1 = new Account ();
    private String fullname;
    private Account acc;
    private int balance;
    
    public Teller ()
    {
      

    }

    /**
     * method main
     * membuat object tipe akun tertentu
     * membuat object customer beserta data diri
     */
    
    
    public void main(String[] args)
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
        */
       
       Scanner input = new Scanner(System.in);//scan input user
       String fname, lname, dob, no_tlp, answer;
       
        //mulai pendataan new customer
        System.out.println("Selamat datang di JBank! Apakah anda ingin mendaftar menjadi customer kami? ('yes'/'no') ? ");
        answer = input.nextLine();//scan input
        if (!answer.equals("yes"))//apabila jawaban yes
        {
            System.exit(0);;
        }
        
         //selama jawaban yes melakukan hal berikut   
        do {
            System.out.print("Masukkan nama depan anda: ");
            fname = input.nextLine();
            System.out.print("Masukkan nama belakang anda : ");
            lname = input.nextLine();
            System.out.print("Masukkan tempat tanggal lahir anda : ");
            dob = input.nextLine();
            System.out.print("MAsukkan nomor telepon anda : ");
            no_tlp = input.nextLine();
            
            c1.setName(fname,lname);//set customer name
            c1.setPhoneNumber(no_tlp);//set no tekp cutomer
            c1.setDateOfBirth(dob);//set tanggal lahir customer
            int custId = new Bank().getNextID(); //set ID
            c1.setCustID(custId);
            String ID = Integer.toString(custId);
            System.out.println("Masukkan jenis Account yang anda inginkan S,O,I,C ?");
            Scanner reader = new Scanner(System.in);
            char acct_Type = reader.next().trim().charAt(0); //baca input tipe char user
            System.out.print("Masukkan saldo awal yang anda inginkan : ");
             if (acct_Type == 'S')
             {//apabila tipe akun savings
                balance = input.nextInt();
                a1 = new Account('S', balance);
                while (balance < 10)
                {
                    System.out.println("Maaf, saldo minimun untuk tipe account ini adalah 10$");
                    balance = input.nextInt();
                    a1 = new Account('S', balance);
                }
             }
            
            else if (acct_Type == 'O') 
            {//apabila tipe akun Overdraft
                balance = input.nextInt();
                a1 = new Account('O', balance);
                while (balance <= 0)
                {
                     System.out.println("Maaf, masukkan kembali saldo anda");
                     balance = input.nextInt();
                     a1 = new Account('O', balance);
                }
            }
            
            else if (acct_Type == 'C')
            {//apabila tipe akun credit
                balance = input.nextInt();
                a1 = new Account('C', balance);
                while (balance <= 0)
                {
                     System.out.println("Maaf, masukkan kembali saldo anda");
                     balance = input.nextInt();
                     a1 = new Account('C', balance);
                }
            }
            
            else if (acct_Type == 'I') 
                {//apabila tipe akun Investment
                balance = input.nextInt();
                a1 = new Account('C', balance);
                while (balance < 100) 
                {
                    System.out.println("Maaf. saldo minimun untuk tipe account ini 100$");
                    balance = input.nextInt();
                    a1 = new Account('I', balance);
                }
            }
           //print semua informasi yang sudah di input user
            System.out.println("Nama = \t\t:"+c1.getName());
            System.out.println("Customer ID = \t:"+c1.getCustID());
            System.out.println("No telepon = \t:"+c1.getPhoneNumber());
            System.out.println("Saldo = \t:"+a1.getBalance());
            System.out.println("Tipe Akun \t:"+a1.getAcctType());
              
        } while (!answer.equals("no"));
    
    
    }
    
    }
   

 