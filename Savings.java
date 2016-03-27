
import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;

/**
 * Abstract class Savings - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public class Savings extends Account
{
    // instance variables - replace the example below with your own
    
    protected double interestEarned;
   
    /**
     * Method Constructor dari Savings
     * @param cust customer account
     * @param amount saldo yang ingin di input
     */
    public Savings (Customer cust, double amount)
    {
      super();
      id = Double.toString(cust.getCustID());
      super.balance = amount;
     
      
    }
    
    
    public double getInterestEarned()
    {
        return interestEarned;
    }
    
     /**
     * Method withdraw Mengambil uang dari account savings 
     * @param amount jumlah saldo yang akan diambil 
     */
    public boolean withdraw(double amount)
    {
         
        if (balance - amount < 0)//cek nilai withdraw apakah akan menghasilkan deposit yang negatif
        {
            return false;
        } 
        else 
        {//mengurangi balance saat withdraw
            balance = balance - amount;
            return true;
        
        }
    }
    
    /**
     * Method addDailyInterest Menghitung fee yang didapatkan customer 
     * @param numberOfDays Banyaknya hari
     */
    public void addDailyInterest(int days)
    {
      double f, periode;
      int hari = 365;
      periode = days/hari;
      f = nilai(balance,0.03,360,periode);
      interestEarned = f - balance;
      balance = f;
    }
    
  
}
