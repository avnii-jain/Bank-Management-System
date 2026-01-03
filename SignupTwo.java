package bank.management.system;

import javax.swing.*;
import java.awt.*;  //For colors
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panText, aadharText;
    JButton next;
    JComboBox rel,cat,inc, eduquali, occu, existing;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
       
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[] = {"Hinduism", "Jainism", "Sikhism", "Christian", "Muslim", "Other"};
        rel = new JComboBox(valReligion);
        rel.setBounds(300, 140, 400, 30);
        rel.setBackground(Color.WHITE);
        add(rel);
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valCategory[] = {"General", "OBC", "SC/ST"};
        cat = new JComboBox(valCategory);
        cat.setBounds(300, 190, 400, 30);
        cat.setBackground(Color.WHITE);
        add(cat);
        
        JLabel income = new JLabel("Income : ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 100, 30);
        add(income);
        
        String valIncome[] = {"<1lac", "1-2lac", "2-5lac", "5-10lac", ">10lac"};
        inc = new JComboBox(valIncome);
        inc.setBounds(300, 240, 400, 30);
        inc.setBackground(Color.WHITE);
        add(inc);
        
        JLabel edu = new JLabel("Educational: ");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 290, 200, 30);
        add(edu);    
        JLabel quali = new JLabel("Qualification: ");
        quali.setFont(new Font("Raleway", Font.BOLD, 20));
        quali.setBounds(100, 315, 200, 30);
        add(quali);
        
        String valeduquali[] = {"Graduate", "Post-Graduate", "Doctrate", "Other"};
        eduquali= new JComboBox(valeduquali);
        eduquali.setBounds(300, 315, 400, 30);
        eduquali.setBackground(Color.WHITE);
        add(eduquali);
                
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String valoccu[] = {"Salaried", "Self-Emloyed", "Business", "Student", "Retired", "Others"};
        occu = new JComboBox(valoccu);
        occu.setBounds(300, 390, 400, 30);
        occu.setBackground(Color.WHITE);
        add(occu);
        
        JLabel pan = new JLabel("PAN No: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        
        panText = new JTextField();
        panText.setBounds(300, 440, 400, 30);
        add(panText);
        
        JLabel aadhar = new JLabel("Aadhar No: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 490, 400, 30);
        add(aadhar);
        
        aadharText = new JTextField();
        aadharText.setBounds(300, 490, 400, 30);
        add(aadharText);
        
        JLabel acc = new JLabel("Existing Account: ");
        acc.setFont(new Font("Raleway", Font.BOLD, 20));
        acc.setBounds(100, 540, 180, 30);
        add(acc);
        
        String valExisting[] = {"Yes", "No"};
        existing = new JComboBox(valExisting);
        existing.setBounds(300, 540, 400, 30);
        existing.setBackground(Color.WHITE);
        add(existing);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 590, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        String sreligion = (String) rel.getSelectedItem();
        String scategory = (String) cat.getSelectedItem();
        String sincome = (String) inc.getSelectedItem();
        String sedu = (String) eduquali.getSelectedItem();
        String soccupation = (String) occu.getSelectedItem();
        String span = panText.getText();
        String saadhar = aadharText.getText();
        String sexisting = (String) existing.getSelectedItem();
              
       //Putting values in DBs
        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+sedu+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+sexisting+"')"; 
            c.st.executeUpdate(query);
            
            //Signup3 Object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception a){
            System.out.println(a);
        }
    }
    
    public static void main(String[] args){
        new SignupTwo("");
    }
}
