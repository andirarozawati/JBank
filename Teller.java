
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
    private double balance;

    /**
     * method main
     * membuat object akun a1 
     * membuat object customer c1
     */
    
    public void main(String args[])
    {
        // initialise instance variables
        c1.setName("Sutandi", "Sanadhi");//nama dari customer c1
        fullname = c1.getName();//assign full name sebagai nama customer c1
        System.out.println(fullname);//print nama customer c1
        
        a1.setBalance(150000);//deposit customer c1
        c1.setAccount(a1);//assign customer c1 sebagai akun a1
        acc = c1.getAccount();//account akan mendapat informasi dari c1
        balance = acc.getBalance();//assign balance account a1
        
        System.out.println(balance);//print 
    }

    public Teller ()
    {
      

    }
}
