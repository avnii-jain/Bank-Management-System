package bank.management.system;

import javax.swing.*;
import java.awt.*; //for image class
import java.awt.event.*; //for ActionListener(button clicks)

public class PinChange extends JFrame implements ActionListener {
    
    JLabel text, pinText, repinText;
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, -80, 900, 900);
        add(image);
              
        text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBounds(380, 160, 400, 20);
        image.add(text);
        
        pinText = new JLabel("New PIN: ");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(280, 200, 140, 30);
        image.add(pinText);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(400, 200, 230, 25);
        image.add(pin);
        
        repinText = new JLabel("Re-enter PIN: ");
        repinText.setForeground(Color.WHITE);
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setBounds(280, 240, 140, 30);
        image.add(repinText);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(400, 240, 230, 25);
        image.add(repin);
         
        change = new JButton("CHANGE");
        change.setBounds(500, 280, 130, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(500, 310, 130, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent qw){
        if(qw.getSource() == change){
            try {
                String npin = new String(pin.getPassword());
                String rpin = new String(repin.getPassword());
            
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                if(rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String query3 = "update signupthree set pinnumber = '"+ rpin+"' where pinnumber = '"+pinnumber+"' ";
                
                conn.st.executeUpdate(query1);
                conn.st.executeUpdate(query2);
                conn.st.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            } catch(Exception e){
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
        public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
    
}
