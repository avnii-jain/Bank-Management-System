package bank.management.system;

import javax.swing.*; //for JFrame
import java.awt.*;
import java.awt.event.*; //ActionListener

public class Transactions extends JFrame implements ActionListener{

    JButton deposit, withdrawal, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, -80, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(330, 155, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);
        
        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(480, 210, 140, 25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(320, 210, 140 , 25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(320, 245, 140, 25);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement= new JButton("Mini Statement");
        miniStatement.setBounds(480, 245, 140, 25);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(320, 280, 140, 25);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(480, 280, 140, 25);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(480, 315, 140, 25);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(300, 0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent aee){
        if(aee.getSource() == exit){
            System.exit(0);
        } else if (aee.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (aee.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        } else if (aee.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (aee.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (aee.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalEnquiry(pinnumber).setVisible(true);
        } else if (aee.getSource() == miniStatement) {
            setVisible(false);
            new miniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transactions("");
        
    }
    
}
