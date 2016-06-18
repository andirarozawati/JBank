import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedOutputStream;
import java.util.*;

/**
 * @author andira 
 * @version 12-05-2016
 */

public class CustomerFileWriter implements Serializable
{
    private File objectFile;
    private FileOutputStream fileOutputStream;
    private ObjectOutputStream objectOutputStream;
    /**
     * Constructor untuk CustomerFileWriter
     */
    public CustomerFileWriter()
    {
        objectFile = new File("blabla.dat");
    }
    
    /**
     * Method untuk menyimpan file customers menjadi .dat
     */
    public void saveCustomers(Object customer) throws IOException
    { 
       fileOutputStream = new FileOutputStream("blabla.dat");
       objectOutputStream = new ObjectOutputStream(fileOutputStream);
       try
       {
           objectFile.delete();
       }
       catch(SecurityException e)
       {
           System.out.println("Customer File Writer - " + e.getMessage()); 
       }
       finally
       {
           objectOutputStream.writeObject(customer);
           objectOutputStream.close();
           fileOutputStream.close();
           System.out.println("Customer File Writer - berhasil export");
       }
    }
}