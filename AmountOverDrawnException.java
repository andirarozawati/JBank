import java.lang.Exception;

/**
 * class untuk error handling apabila saat mengambil uang saldo kurang
 * @author andira
 * @version 24-4-2016
 */

public class AmountOverDrawnException extends Exception
{
    private Account account;
    private double p = 0;
    
    /**
     * Constructor for objects of class AmountOverDrawnException
     * @param acct Account
     */
    public AmountOverDrawnException(Account account)
    {
        super("Insufficient funds");
        this.account = account;
    }
    
    public AmountOverDrawnException(Account account , double i)
    {
        super("MAAF SANKSI PENALTI, penarikan ditambah 20% menjadi");
        this.account = account;
        p = i;
    }
    
    /**
     * Method to get error message
     * @return Error message
     */
    public String getMessage()
    {
        String message = super.getMessage() + " ";      
        if(account instanceof Investment && p == 0)
        {
            message += "In Investment Account , balance " + account.getBalance() ;
        }        
        if(account instanceof Investment && p != 0)
        {
            message += p + " , balance " + account.getBalance();
        }        
        if(account instanceof Savings && account instanceof Savings == false)
        {
            message += "In Savings Account , balance " + account.getBalance();
        }
        else if(account instanceof LineOfCredit)
        {
            LineOfCredit l = (LineOfCredit)account;
            double cr = l.getCreditLeft();
            message += "In Line-Of-Credit Account , balance " + account.getBalance() +" , allowable credit left " + cr;
        }
        else if(account instanceof OverDraftProtect)
        {
            message += "In Overdraft Protection Account , balance " + account.getBalance();
        }        
        return message;
    }
}