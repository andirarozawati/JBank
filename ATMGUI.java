import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author AndiraRozawati
 * @version 
 */

public class ATMGUI extends JFrame implements Runnable, FocusListener
{
   private JPanel topPanel;
   private JPanel bottomPanel;
   private JPanel buttonPanel;
   private JPanel JRadioButtonPanel;
   private JPanel infoPanel;
   private JPanel textPanelOne;
   private JPanel textPanelTwo;
   private JLabel enterCustIDLabel;
   private JTextField enterCustIDTextField;
   private JLabel enterAmountHereLabel;
   private JTextField enterAmountHereTextField;
   private ButtonGroup group;
   private JRadioButton savingsButton;
   private JRadioButton InvestmentButton;
   private JRadioButton LOCButton;
   private JRadioButton OverdraftButton;
   private JButton depositButton;
   private JButton withdrawButton;
   private JButton exitButton;
   private JButton totalButton;
   private JTextArea infoTextArea;
   private JScrollPane vScroll;
   private JScrollPane hScroll;
   private ButtonHandler buttonHandler;
   
   public void run()
   {
   }
   
   /**
    * Constructor for objects of class ATMGUI
    */
   public ATMGUI()
   {
      super("ATMGUI Layout");
      buildGUI();
   }

   /**
    * Method fungsi untuk membuat GUI
    */
   private void buildGUI()
   {
        setSize(700,300);
        setResizable(false);
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowHandler(this) );        
        makeTopPanel(); 
        makeBottomPanel();            
        add(topPanel);    
        add(bottomPanel);
        setVisible(true);  //menampilkan frame keseluruhan       
   }
    
   /**
    * Method fungsi untuk membuat top panel
    * @param membuat tombol radio button
    * @param membuat label "enter customer id"" dan textfieldnya
    * @param membuat label "enter amount"" dan textfieldnya
    * @param menambahkan setiap radio button ke buttonPanel
    * @param memasukkan panel dan setiap komponen ke topPanel
    */
   private void makeTopPanel()
   {    
        JRadioButtonPanel = new JPanel(new GridLayout(4,1));
        
        savingsButton = new JRadioButton("Savings");
        savingsButton.setToolTipText("<html>--" + "Savings" + "--<br> Untuk menyimpan uang standar dengan bunga dan balance non negatif" + "</html>");
        savingsButton.setBackground(Color.WHITE);
        
        InvestmentButton = new JRadioButton("Investment");
        InvestmentButton.setToolTipText("<html>--" + "Investment" + "--<br> Untuk menyimpan uang jangka panjang, minimal 6 bulan. <br>Penarikan prematur akan terkena penalti 20% dari jumlah yang ditarik." + "</html>");
        InvestmentButton.setBackground(Color.WHITE);
               
        LOCButton     = new JRadioButton("Line Of Credit");
        LOCButton.setToolTipText("<html>--" + "Line Of Credit" + "--<br> Untuk menyimpan uang dengan mengijinkan balance negatif <br> selama tidak melebihi credit limit" + "</html>");
        LOCButton.setBackground(Color.WHITE);
               
        OverdraftButton = new JRadioButton("Overdraft");
        OverdraftButton.setToolTipText("<html>--" + "Overdraft" + "--<br> Untuk menyimpan uang dengan terhubung ke akun Saving <br> mengijinkan penarikan melebihi balance akun ini selama <br> penarikan tidak melebihi total balance pada akun <br> saving yang terhubung. <br>Penarikan melebihi balance overdraft akan kena fee sebesar 3." + "</html>");
        OverdraftButton.setBackground(Color.WHITE);
               
        group = new ButtonGroup();
        group.add(savingsButton);
        group.add(InvestmentButton);
        group.add(LOCButton);
        group.add(OverdraftButton);

        enterCustIDLabel        = new JLabel("Enter Customer ID");
        enterCustIDTextField    = new JTextField("",10);
        enterCustIDTextField.setToolTipText("Enter Customer ID");
        enterCustIDTextField.addFocusListener(this);
        
        enterAmountHereLabel        = new JLabel("Enter amount here");
        enterAmountHereTextField    = new JTextField("0",10);
        enterAmountHereTextField.setToolTipText("Enter amount here");
        
        JRadioButtonPanel.add(savingsButton);
        JRadioButtonPanel.add(InvestmentButton);
        JRadioButtonPanel.add(LOCButton);
        JRadioButtonPanel.add(OverdraftButton);
        
        topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(Color.WHITE);
        topPanel.add(enterCustIDLabel);
        topPanel.add(enterCustIDTextField);
        topPanel.add(JRadioButtonPanel);
        topPanel.add(enterAmountHereLabel);
        topPanel.add(enterAmountHereTextField);
   }
    
    /**
     * Method fungsi untuk membuat bottom panel: tampilan bagian setengah ke bawah
     * @param membuat buttonPanel dan memasukkan setiap button ke panel
     * @param membuat textArea dan mengatur menjadi warna gray
     * @param membuat bottomPanel dan memasukkan panel
     */
   private void makeBottomPanel()
   {
        buttonHandler = new ButtonHandler(this);
        
        depositButton = new JButton("Deposit");
        depositButton.setActionCommand("deposit");
        depositButton.addActionListener(buttonHandler);
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setActionCommand("withdraw");
        withdrawButton.addActionListener(buttonHandler);
        
        exitButton     = new JButton("Exit");
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(buttonHandler);
        
        totalButton     = new JButton("Total");
        totalButton.setActionCommand("total");
        totalButton.addActionListener(buttonHandler);
        
        buttonPanel   = new JPanel(new GridLayout(4,1));
        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(totalButton);
        buttonPanel.add(exitButton);
        
        infoTextArea = new JTextArea("Welcome");
        infoTextArea.setEditable(false);
        infoTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
        infoTextArea.setBackground(Color.GRAY);
        
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.GRAY);
        bottomPanel.add(infoTextArea,BorderLayout.CENTER);
        bottomPanel.add(buttonPanel,BorderLayout.LINE_END);    
   }
   
   public void focusGained(FocusEvent e)
   {  
   }
   
   /**
    * Method fungsi untuk melakukan fungsi tertentu bila focus hilang
    */
   public void focusLost(FocusEvent e)
   {
       if(!getCustIDText().equals(""))
       {
           try
           {
               setTextArea("Nama customer " + Bank.getCustomer(Integer.parseInt(getCustIDText())).getCustName());
               setTextAreaColor(Color.WHITE);
           }
           catch(CustomerNotFoundException cnf)
           {
               setTextArea("Customer tidak ketemu");
               setTextAreaColor(Color.WHITE);
               warning("Customer tidak ketemu");
           }
           catch(NumberFormatException pe)
           {
               warning("Enter Customer ID tidak diisi dengan angka !!\n\nIsinya : " + enterCustIDTextField.getText() );
               enterCustIDTextField.setText("");
           }
       }
   }
   
   /**
    * Method menampilkan dialog warning dengan message
    */
   private void warning(String s)
   {
       JOptionPane.showMessageDialog(this,s,"Error !!",JOptionPane.ERROR_MESSAGE);
   }
   
   /**
    * Method untuk mendapatkan ButtonGroup
    */
   public ButtonGroup getButtonGroup()
   {
       return group;
   } 
   
   /**
    * Method untuk mendapatkan custID
    */
   public String getCustIDText()
   {
       return enterCustIDTextField.getText();
   }
    
   /**
    * MEethod untuk mendapatkan cust ID dalam format angka
    * @throws NumberFormatException
    */
   public int getCustID() throws NumberFormatException
   {
       try
       {
           return Integer.parseInt( enterCustIDTextField.getText());
       }
       catch(NumberFormatException e)
       {
           if(enterCustIDTextField.getText().equals(""))
           {
               throw new NumberFormatException("Enter Customer ID masih kosong!!");
           }
           else
           {
               throw new NumberFormatException("Enter Customer ID tidak diisi dengan angka !!\n\nIsinya : " + enterCustIDTextField.getText());
           }
       }       
   }
   
   /**
    * Method untuk mendapatkan amount
    */
   public String getAmountText()
   {
       return enterAmountHereTextField.getText();
   }
   
   /**
    * Method untuk mendapatkan amount dalam format angka
    * @throws NumberFormatException
    */
   public double getAmount() throws NumberFormatException
   {       
       try
       {
           return Double.parseDouble( enterAmountHereTextField.getText());
       }
       catch(NumberFormatException e)
       {
           if(enterAmountHereTextField.getText().equals(""))
           {
               throw new NumberFormatException("Enter Amount masih kosong !!");
           }
           else
           {
               throw new NumberFormatException("Enter Amount tidak diisi dengan angka !!\n\nIsinya : " + enterAmountHereTextField.getText());
           }
       }
   }
   
   /**
    * Method fungsi untuk menset text area
    */
   public void setTextArea(String s)
   {
       infoTextArea.setText(s);
   }
   
   /**
    * Method fungsi untuk menset warna text area
    */
   public void setTextAreaColor(Color c)
   {
       infoTextArea.setBackground(c);
   }  
}