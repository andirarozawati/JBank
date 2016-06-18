/**
 * @author andira
 * @version 12-05-2016
 */

public abstract class Checking extends Account 
{
    protected double monthlyFee;
    
    /**
     * Method abstrak untuk mengecek biaya Checking Account
     */
    protected abstract void feeAssessment();
    
    /**
     * Method reset biaya bulanan
     */
    public void resetMonthlyFee() 
    {
        monthlyFee = 0;
    }
    
    public double getMonthlyFee() 
    {
        return monthlyFee;
    }
}