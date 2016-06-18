import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;

/**
 * Write a description of class Investment here.
 * 
 * @author andira 
 * @version (a version number or a date)
 */
public class Investment extends Savings
{
    // instance variables - replace the example below with your own
    private Date endDate;
    private double interestRate;
    private Date startDate;
    private int term;
    private int localTerm;
    /**
     * Constructor for objects of class Investment
     */
    public Investment(Customer cust, double amount, int term)
    {
        // initialise instance variables
        super(cust,amount);
        this.term = term ;
        id = String.valueOf(cust.getCustID());
        Calendar cal = new GregorianCalendar();
        startDate = cal.getTime();
        cal.add(Calendar.MONTH, localTerm);
        endDate = cal.getTime();
        if (term >= 6)
        {
            localTerm = 6;
        }
        else {
            localTerm = term;
            }       
           
            
        if (term > 0 || term <= 6)
        {
            interestRate =0.05;
        }
        else if (term >6 || term <=12)
        {
            interestRate = 0.06;
        }
            else
            {
                interestRate = 0.07;
            }
                   
            
          
    }
    
     public void addDailyInterest(int days)
    {
      double f, periode;
      int hari = 365;
      periode = days/hari;
      f = nilai(balance,0.03,360,periode);
      interestEarned = (balance * f) - balance;
      balance = balance * f;
    }

    /**
     * Metode untuk melakukan pengambilan uang
     * @param amount Jumlah uang yang akan diambil
     * @throws AmountOverDrawnException Apabila jumlah uang yang akan diambil melebihi jumlah uang dalam akun
     */
    @Override
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount>balance)      
        {
             throw new AmountOverDrawnException(this);
        }
        else if(Calendar.getInstance().after(endDate))  //bila pada saat penarikan sudah melewati waktu
        {                                               // term maka tidak dikenanakan penalti
            balance -= amount;
        }
        else if(balance>(amount*1.2))       //waktu penarikan sebelum endDate, maka kena penalti
        {
            balance -= (amount*1.2);
        }
        else
        {
            throw new AmountOverDrawnException(this, amount*1.2);
        }
    }
    
    public void setTerm(int term)
    {
        this.term = term;
    }
}
