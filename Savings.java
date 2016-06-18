/**
 * @author andira
 * @version 12-05-2016
 */

public class Savings extends Account
{
    protected double interestEarned;    
    
    /**
     * Constructor for objects of class Savings
     */
    public Savings(Customer cust, double amount)
    {
        super();
        id   = Integer.toString(cust.getCustID());
        balance   = amount;
    }
    
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount>=0&&amount<=balance)
        {
            balance-=amount;
        }
        else
        {
            throw new AmountOverDrawnException(this);           
        }
    }
    
    /**
     * Method menghitung bunga
     * @param 
     */
    public void addDailyInterest(int days)
    { 
        double interestRate = Bank.getPremiumRate();
        System.out.println(interestRate);
        double f = Math.pow( (1 + (interestRate/365)), days); 
        System.out.println(f);                                           
        interestEarned = balance * (f-1);             
        balance *= f;                       
    }
    
    public double getInterestEarned()
    {
        return interestEarned;
    }
}