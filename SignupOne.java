package bank.management.system;

import javax.swing.*;
import java.awt.*;  //For colors
import java.util.*;  //For randoms
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, numTextField, addTextField, cityTextField, stateTextField;
    JButton next;
    JRadioButton male, female, other;
    JDateChooser dateChooser;
    
    SignupOne() {
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);
        
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("DOB : ");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 100, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 100, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female =new JRadioButton("Female");
        female.setBounds(450, 290, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        other = new JRadioButton("Other");
        other.setBounds(600, 290, 60, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        //For selecting only one - either 'male' or 'female'
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        
        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel num = new JLabel("Phone Number: ");
        num.setFont(new Font("Raleway", Font.BOLD, 20));
        num.setBounds(100, 390, 200, 30);
        add(num);
        
        numTextField = new JTextField();
        numTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        numTextField.setBounds(300, 390, 400, 30);
        add(numTextField);
        
        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 100, 30);
        add(address);
        
        addTextField = new JTextField();
        addTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addTextField.setBounds(300, 440, 400, 30);
        add(addTextField);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 100, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 100, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
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
        String formno = "" + random;  //long
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if(female.isSelected()) {
            gender = "Female";
        } else {
            gender = "Other";
        }
        
        String email = emailTextField.getText();
        String num = numTextField.getText();
        String address =  addTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        
        try {
            if (name.equals("")){ //if 'name' is empty
              JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if (fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father name is required");
            }
            else if (dob.equals("")){
                JOptionPane.showMessageDialog(null, "DOB is required");
            }
            else if (gender.equals("")){
                JOptionPane.showMessageDialog(null, "Gender is required");
            }
            else if (email.equals("")){
                JOptionPane.showMessageDialog(null, "Email is required");
            }
            else if (num.equals("")){
                JOptionPane.showMessageDialog(null, "Number is required");
            }
            else if (address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required");
            }
            else if (city.equals("")){
                JOptionPane.showMessageDialog(null, "City is required");
            }
            else if (state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required");
            }
            else {
                Conn c = new Conn();
                String query = "INSERT INTO signup VALUES('"
                + formno + "', '"
                + name + "', '"
                + fname + "', '"
                + dob + "', '"
                + gender + "', '"
                + email + "', '"
                + num + "', '"
                + address + "', '"
                + city + "', '"
                + state + "')";
                c.st.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        } catch (Exception a){
            System.out.println(a);
        }
    }
    
    public static void main(String[] args){
        new SignupOne();
    }
}
