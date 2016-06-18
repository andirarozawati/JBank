/**
 * @author andira
 * @version 12-05-2016
 */

public class OverDraftProtect extends Checking 
{
    private Savings savingsAccount;
    
    /**
     * Method Constructor dari OverDraftProtect
     * @param cust Obyek Customer yang bersangkutan
     * @param amount Jumlah saldo yang ingin dimasukkan
     * @param save Obyek Savings Account sebagai acuan
     */
    public OverDraftProtect(Customer cust, double amount, Savings savingsAccount) 
    {
        super();
        balance = amount;
        this.savingsAccount = savingsAccount;
        id = Integer.toString(cust.getCustID());
    }
    
    /**
     * Method feeAssessment Perhitungan biaya proteksi Overdraft
     */
    public void feeAssessment() 
    {
        monthlyFee = monthlyFee + 3;
        //balance = balance - monthlyFee;
    }
    
    /**
     * Method withdraw Menarik sejumlah Saldo dari Overdraft Account
     * @param amount Jumlah Saldo
     */
    public void withdraw(double amount) throws AmountOverDrawnException
    {
        if(amount > balance + savingsAccount.getBalance() - 10) 
        {
            throw new AmountOverDrawnException(this);
        }
        else if(amount > balance) 
        {
            savingsAccount.withdraw(amount - balance);
            balance = 0;
            feeAssessment();
        }
        else 
        {
            balance -= amount;
        }
    }
}