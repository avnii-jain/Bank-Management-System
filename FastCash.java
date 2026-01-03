package bank.management.system;

import javax.swing.*; //for JFrame
import java.awt.*;
import java.awt.event.*; //ActionListener
import java.sql.*; //for ResultSet
import java.util.Date; //for Date

public class FastCash extends JFrame implements ActionListener{

    JButton oneHund, fiveHund, oneThous, twoThous, fiveThous, tenThous, back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, -70, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(320, 155, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        image.add(text);
        
        fiveHund = new JButton("Rs 500");
        fiveHund.setBounds(480, 210, 120, 25);
        fiveHund.addActionListener(this);
        image.add(fiveHund);
        
        oneHund = new JButton("Rs 100");
        oneHund.setBounds(320, 210, 120 , 25);
        oneHund.addActionListener(this);
        image.add(oneHund);
        
        oneThous = new JButton("Rs 1000");
        oneThous.setBounds(320, 245, 120, 25);
        oneThous.addActionListener(this);
        image.add(oneThous);
        
        twoThous= new JButton("Rs 2000");
        twoThous.setBounds(480, 245, 120, 25);
        twoThous.addActionListener(this);
        image.add(twoThous);
        
        fiveThous = new JButton("Rs 5000");
        fiveThous.setBounds(320, 280, 120, 25);
        fiveThous.addActionListener(this);
        image.add(fiveThous);
        
        tenThous = new JButton("Rs 10000");
        tenThous.setBounds(480, 280, 120, 25);
        tenThous.addActionListener(this);
        image.add(tenThous);
        
        back = new JButton("BACK");
        back.setBounds(480, 315, 120, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent aee){
        if(aee.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)aee.getSource()).getText().substring(3); //substring-> deletes first 3 chars -> 'Rs '
            Conn c = new Conn();
            try{
                ResultSet rs = c.st.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Rs 100")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (aee.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    return; //as user have insufficient balance, so return
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + "Debited Successfully!");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
        
    }
    
}
