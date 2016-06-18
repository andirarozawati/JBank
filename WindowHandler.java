import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.border.Border;

/**
 * @author andira
 * @version 12-05-2016
 */

public class WindowHandler extends  WindowAdapter
{
    private JFrame frame;
    
    /**
     * Constructor for objects of class WindowHandler
     */
    public WindowHandler(JFrame frame)
    {
        this.frame = frame;
    }
    
    /**
     * Method fungsi untuk menampilkan dialog konfirmasi ingin exit
     */
    public void windowClosing(WindowEvent windowEvent)
    {
        int result = JOptionPane.showConfirmDialog(frame, "Do you want to exit?", "Alert!", JOptionPane.OK_CANCEL_OPTION);
        if(result == JOptionPane.OK_OPTION)
        {
            Bank.exportCustomer();
            frame.dispose();
        }
    }
}