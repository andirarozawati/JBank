import java.util.*;
import java.io.*;
/**
 * Write a description of class AmountOverDrawnException here.
 * 
 * @Andirarozawati 
 * @4/14/2016
 */
public class AmountOverDrawnException extends Exception
{
    // instance variables - replace the example below with your own
    protected Account acct;

    /**
     * Constructor for objects of class AmountOverDrawnException
     */
    public AmountOverDrawnException(Account acct)
    {
        // initialise instance variables
        super("Insufficient Funds");
    }

    public String getMessage()
    {
        if (acct instanceof Savings)
        {
            return super.getMessage()+"in Savings Account";}
            else if (acct instanceof Investment)
            {
                return super.getMessage()+"in Investment Account";}
            else if (acct instanceof LineOfCredit)
            {
                return super.getMessage()+"in Line-Of-Credit Account";}
            else {
                    return super.getMessage()+"in Overdrat Protection Account";
                }
            
            
            }
        }
