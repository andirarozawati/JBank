import java.util.*;
import java.io.*;

/**
 * Write a description of class AccountTypeAlreadyExistsException here.
 * 
 * @andirarozawati
 * @4/14/2016
 */

public class AccountTypeNotFoundException extends Exception
{
    // instance variables - replace the example below with your own
   protected char acctType;

    /**
     * Constructor for objects of class AccountTypeNotFoundException
     */
    public AccountTypeNotFoundException(char acctType)
    {
        // initialise instance variables
        super("Account does not exist");
        
    }
    
    
      public String getMessage()
    {
       switch (acctType)
       {
           case 'S' : 
            return super.getMessage()+"Savings";
           case 'I' : 
            return super.getMessage()+"Investment";
           case 'O' : 
            return super.getMessage()+"Overdraft Protection";
          case 'L' : 
            return super.getMessage()+"Line of Credit";
            default :
           return super.getMessage();
            
            } 
        
        }
    
    

   
}
