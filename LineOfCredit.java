import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author andira
 * @version 24-4-2016
 */

public class LineOfCredit extends Checking 
{
    private double creditBalance, creditLimit;
    
    /**
     * Method Constructor LineOfCredit 
     * @param Customer, double amount, double limit
     */
    public LineOfCredit(Customer cust, double amount, double limit)
    {
       super();
       balance = amount;
       creditLimit = limit;
       id = Integer.toString(cust.getCustID());
    }
    
    /**
     * Method feeAssessment Perhitungan biaya kredit
     */
    public void feeAssessment() 
    {
        int days = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        double deficit = -creditBalance;
        System.out.println("deficit " +deficit);
        double amt = deficit * Math.pow( (1 + .21/365) , (days) );
        monthlyFee = amt - deficit;
    }
    
    /**
     * Method withdraw Menarik sejumlah Saldo dari Line-of-Credit Account
     * @param amount Jumlah Saldo
     */
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount <= balance) //bila amount di bawah balance, langsung tarik
        {
            balance -= amount;
        }
        else if(amount > balance && amount-balance <= creditLimit + creditBalance)
        {
            creditBalance -= (amount - balance);
            balance = 0;
            
        }
        else
        {
            throw new AmountOverDrawnException(this);
        }
    }
    
    /**
     * Method memberikan nilai saldo kredit
     * @return Nilai saldo kredit
     */
    public double getCreditBalance() 
    {
        return creditBalance;
    }
    
    /**
     * Method memberikan nilai limit kredit
     * @return Nilai limit kredit
     */
    public double getCreditLimit() 
    {
        return creditLimit;
    }
    
    /**
     * Method untuk mengetahui sisa kredit yang dapat digunakan
     * @return double credit
     */
    public double getCreditLeft()
    {
        return creditBalance + creditLimit;
    }
    
    /**
     * Method setCreditBalance Menentukan nilai saldo kredit
     * @param amount Jumlah nilai untuk saldo kredit
     */
    public void setCreditBalance(double amount) 
    {
        creditBalance = amount;
    }
    
    /**
     * Method setCreditLimit Menentukan nilai limit kredit
     * @param amount Jumlah nilai untuk limit kredit
     */
    public void setCreditLimit(double amount) 
    {
        creditLimit = amount;
    }
}