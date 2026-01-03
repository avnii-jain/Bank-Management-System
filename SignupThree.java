package bank.management.system;

import javax.swing.*;
import java.awt.*; //for fonts
import java.awt.event.*; //for actions (ActionListener)
import java.util.*; //for random

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox s1, s2, s3, s4, s5, s6, s7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno) {
        
        this.formno = formno;
        setLayout(null); //for running 'setBounds'
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 140, 170, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 140, 210, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 180, 160, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 180, 250, 20);
        add(r4);
        
        ButtonGroup groupcount = new ButtonGroup(); //for selecting only 1 radio button at a time
        groupcount.add(r1);
        groupcount.add(r2);
        groupcount.add(r3);
        groupcount.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 230, 200, 30);
        add(card);
               
        JLabel number = new JLabel("XXXX-XXXX-XXXX-41e6y");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(310, 230, 300, 30);
        add(number);
        
        JLabel msg1 = new JLabel("Your 16 Digit Card Number");
        msg1.setFont(new Font("Raleway", Font.BOLD, 12));
        msg1.setBounds(100, 260, 300, 20);
        add(msg1);
        
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 300, 250, 40);
        add(pin);
                
        JLabel number2 = new JLabel("XXXX");
        number2.setFont(new Font("Raleway", Font.BOLD, 22));
        number2.setBounds(310, 300, 150, 40);
        add(number2);
        
        JLabel msg2 = new JLabel("Your 4 digit password");
        msg2.setFont(new Font("Raleway", Font.BOLD, 12));
        msg2.setBounds(100, 330, 200, 30);
        add(msg2);
        
        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 380, 250, 30);
        add(service);
        
        s1 = new JCheckBox("ATM Card");
        s1.setFont(new Font("Raleway", Font.BOLD, 16));
        s1.setBounds(100, 420, 110, 20);
        s1.setBackground(Color.WHITE);
        add(s1);
        
        s2 = new JCheckBox("Internet Banking");
        s2.setFont(new Font("Raleway", Font.BOLD, 16));
        s2.setBounds(350, 420, 160, 20);
        s2.setBackground(Color.WHITE);
        add(s2);
        
        s3 = new JCheckBox("Mobile Banking");
        s3.setFont(new Font("Raleway", Font.BOLD, 16));
        s3.setBounds(100, 460, 150, 20);
        s3.setBackground(Color.WHITE);
        add(s3);
        
        s4 = new JCheckBox("Email & SMS Alerts");
        s4.setFont(new Font("Raleway", Font.BOLD, 16));
        s4.setBounds(350, 460, 180, 20);
        s4.setBackground(Color.WHITE);
        add(s4);
        
        s5 = new JCheckBox("Cheque Book");
        s5.setFont(new Font("Raleway", Font.BOLD, 16));
        s5.setBounds(100, 500, 140, 20);
        s5.setBackground(Color.WHITE);
        add(s5);
        
        s6 = new JCheckBox("E-Statement");
        s6.setFont(new Font("Raleway", Font.BOLD, 16));
        s6.setBounds(350, 500, 130, 20);
        s6.setBackground(Color.WHITE);
        add(s6);
        
        s7 = new JCheckBox("I herby declares that the above enetered details are correct to the best of my knowledge");
        s7.setFont(new Font("Raleway", Font.BOLD, 12));
        s7.setBounds(100, 550, 600, 20);
        s7.setBackground(Color.WHITE);
        add(s7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.setBounds(240, 590, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        cancel.setBounds(420, 590, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType = "Current Account";
            }else if(r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            if(s1. isSelected()){
                facility = facility + "ATM Card";
            } else if(s2. isSelected()){
                facility = facility + "Internet Banking";
            } else if(s3. isSelected()){
                facility = facility + "Mobile Banking";
            } else if(s4. isSelected()){
                facility = facility + "Email & SMS Alerts";
            } else if(s5. isSelected()){
                facility = facility + "Cheque Book";
            } else if(s6.isSelected()){
                facility = facility + "E-Statement";
            }
            
            //Bofore giving items to DB, we have to handle its exception handling
            //as there are chances of getting runtime errors(bcz DB is external entity).
            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();  //Connection with Database
                    String query1 = "insert into signupThree values('" +formno+ "', '" +accountType+ "', '" +cardnumber+ "', '"+pinnumber+"', '" +facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    
                    conn.st.executeUpdate(query1);
                    conn.st.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number " + cardnumber + "\n Pin: " + pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(false);
                }
            } catch (Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
