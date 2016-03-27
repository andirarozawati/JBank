import java.text.*;
import java.util.*;
import java.io.*;
import java.time.*;
import java.lang.Math;
import java.math.*;


/**
 * Abstract class Checking - digunakan untuk perhitungan fee yang akan ditambahkan tiap bulannya.
 * 
 * @andirarozawati
 * @26 maret 2016
 */
public abstract class Checking extends Account
{
    // instance variables - replace the example below with your own
    
     protected double monthlyFee;
   
    /**
     * Method abstract untuk pengecekan biaya Account
     */
    protected abstract void feeAssessment();
    
 /**
  * method ini digunakan untuk menghapus jumlah monthlyFee.
  * 
  */
    public void resetMonthlyFee(){
        
        monthlyFee = 0;
    }
    
    /**
     * method ini digunakan untuk mengambil banyaknya fee perbulan pada JBank.
     * 
     */
    public double getMonthlyFee()
    {
        return monthlyFee;
    }
    
    
   
}
