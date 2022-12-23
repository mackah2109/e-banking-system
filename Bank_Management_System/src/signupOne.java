import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.Border;
import com.toedter.calendar.*;
import java.awt.event.*;
import java.sql.*;

public class signupOne extends JFrame implements ActionListener{
    JTextField nameTextField , fnameTextField,emailTextField,addressTextField,cityTextField,
    stateTextField,pincodeTextField;

    JButton next;
    JRadioButton male,female,others, married ,unmarried;

    JDateChooser dobChooser;

    Random ran=new Random();
    String random=""+Math.abs((ran.nextLong()%9000L)+1000L);

    signupOne(){
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        

        Border border =BorderFactory.createLineBorder(Color.BLACK,1);

        JLabel formno = new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,1000,40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,160,100,30);
        add(name);

        nameTextField=new JTextField();
        nameTextField.setBounds(300,160,400,30);
        nameTextField.setFont(new Font ("Arial",Font.BOLD,16));
        nameTextField.setBorder(border);
        add(nameTextField);
        

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,210,300,30);
        add(fname);

        fnameTextField=new JTextField();
        fnameTextField.setBounds(300,210,400,30);
        fnameTextField.setFont(new Font ("Arial",Font.BOLD,16));
        fnameTextField.setBorder(border);
        add(fnameTextField);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,260,300,30);
        add(dob);

        dobChooser=new JDateChooser();
        dobChooser.setFont(new Font("Raleway",Font.BOLD,20));
        dobChooser.setBounds(300,260,400,30);
        dobChooser.setForeground(new Color(105,105,105));
        add(dobChooser);
              

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,310,300,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,310,100,30);
        male.setFont(new Font("Raleway",Font.BOLD,18));
        add(male);

        female=new JRadioButton("Female");
        female.setBounds(450,310,100,30);
        female.setFont(new Font("Raleway",Font.BOLD,18));
        add(female);

        others=new JRadioButton("Others");
        others.setBounds(600,310,100,30);
        others.setFont(new Font("Raleway",Font.BOLD,18));
        add(others);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(others);


        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,360,300,30);
        add(email);

        emailTextField=new JTextField();
        emailTextField.setBounds(300,360,400,30);
        emailTextField.setFont(new Font ("Arial",Font.BOLD,16));
        emailTextField.setBorder(border);
        add(emailTextField);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,410,300,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBounds(300,410,150,30);
        married.setFont(new Font("Raleway",Font.BOLD,18));
        add(married);

        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,410,150,30);
        unmarried.setFont(new Font("Raleway",Font.BOLD,18));
        add(unmarried);

        others=new JRadioButton("Others");
        others.setBounds(600,410,150,30);
        others.setFont(new Font("Raleway",Font.BOLD,18));
        add(others);

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,460,300,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setBounds(300,460,400,30);
        addressTextField.setFont(new Font ("Arial",Font.BOLD,16));
        addressTextField.setBorder(border);
        add(addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,510,300,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setBounds(300,510,400,30);
        cityTextField.setFont(new Font ("Arial",Font.BOLD,16));
        cityTextField.setBorder(border);
        add(cityTextField);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,560,300,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setBounds(300,560,400,30);
        stateTextField.setFont(new Font ("Arial",Font.BOLD,16));
        stateTextField.setBorder(border);
        add(stateTextField);

        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,610,300,30);
        add(pincode);

        pincodeTextField=new JTextField();
        pincodeTextField.setBounds(300,610,400,30);
        pincodeTextField.setFont(new Font ("Arial",Font.BOLD,16));
        pincodeTextField.setBorder(border);
        add(pincodeTextField);

        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,16));
        next.setBounds(620,680,80,30);
        next.addActionListener(this);
        add(next);

        setSize(850,825);
        setLocation(400,20);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno=""+random; //it is because to convert long random as string
        String name=nameTextField.getText();
        String fname =fnameTextField.getText();
        String dob =((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();
        //getuiComponent return text field
        //extract readio button detail
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        else if(others.isSelected()){
            gender="Others";
        }

        String email=emailTextField.getText();
        String martial=null;
        if(married.isSelected()){
            martial="Married";
        }
        else if(unmarried.isSelected()){
            martial="Unmarried";
        }
        else if(others.isSelected()){
            martial="Others";
        }

        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pincodeTextField.getText();


        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name not entered");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name not entered");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth not entered");
            }
            else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Email not entered");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address not entered");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City not entered");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State not entered");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Code not entered");
            }

            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+martial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }

        }catch(Exception e){
            System.out.println(e);
        }

    }

    public static void main(String args[]){
        new signupOne();
    }
}
