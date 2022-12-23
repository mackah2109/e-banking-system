import javax.swing.JLabel;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.TabSet;

import java.awt.event.*;
import java.sql.*;


public class signupThree extends JFrame implements ActionListener {

    JRadioButton saving,fixed,current,recurring;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit,cancel;
    String formno;

    signupThree(String formno){
        this.formno=formno;
        setLayout(null);

        JLabel page=new JLabel("Page 3: Account Details");
        page.setFont(new Font("Raleway",Font.BOLD,22));
        page.setBounds(290,80,400,30);
        add(page);

        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,160,200,30);
        add(type);

        saving=new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setBounds(100,200,200,30);
        add(saving);

        fixed=new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway",Font.BOLD,16));
        fixed.setBounds(380,200,200,30);
        add(fixed);

        current=new JRadioButton("Current Account");
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBounds(100,230,200,30);
        add(current);

        recurring=new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setBounds(380,230,350,30);
        add(recurring);

        ButtonGroup accounttype=new ButtonGroup();
        accounttype.add(saving);
        accounttype.add(current);
        accounttype.add(fixed);
        accounttype.add(recurring);

        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel cnumber=new JLabel("XXXX-XXXX-XXXX-2109");
        cnumber.setFont(new Font("Raleway",Font.BOLD,22));
        cnumber.setBounds(330,300,500,30);
        add(cnumber);

        JLabel carddetail=new JLabel("Your 16 Digit Card Number:");
        carddetail.setFont(new Font("Raleway",Font.BOLD,14));
        carddetail.setBounds(100,340,500,30);
        add(carddetail);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,380,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,380,500,30);
        add(pnumber);

        JLabel pindetail=new JLabel("Your 4 Digit PIN Number:");
        pindetail.setFont(new Font("Raleway",Font.BOLD,14));
        pindetail.setBounds(100,420,500,30);
        add(pindetail);

        JLabel services=new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,460,200,30);
        add(services);

        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(380,500,200,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,540,200,30);
        add(c3);

        c4=new JCheckBox("Email & SMS Alert");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(380,540,200,30);
        add(c4);

        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,580,200,30);
        add(c5);

        c6=new JCheckBox("e-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(380,580,200,30);
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of muy knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,660,800,30);
        add(c7);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,20));
        cancel.setBounds(300,700,150,30);
        cancel.addActionListener(this);
        add(cancel);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBounds(500,700,150,30);
        submit.addActionListener(this);
        add(submit);


        setSize(850,825);
        setLocation(400,20);
        setVisible(true);
        //getContentPane().setBackground(Color.WHITE); to color background of the frame
    }

    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype=null;
            if(saving.isSelected()){
                accounttype="Saving Account";
            }
            else if(fixed.isSelected()){
                accounttype="Fixed Deposit Account";
            }
            else if(current.isSelected()){
                accounttype="Current Account";
            }
            else if(recurring.isSelected()){
                accounttype="Recurring Deposit Account";
            }

            Random random=new Random();//in util package
            String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);

            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);

            String facility="";
            if(c1.isSelected()){
                facility=facility+" ATM Card";
            }
            else if(c2.isSelected()){
                facility=facility+" Internet Banking";
            }
            else if(c3.isSelected()){
                facility=facility+" Mobile Banking";
            }
            else if(c4.isSelected()){
                facility=facility+" Email & SMS Alert";
            }
            else if(c5.isSelected()){
                facility=facility+" Cheque Book";
            }
            else if(c6.isSelected()){
                facility=facility+" e-Statement";
            }

            try{
               
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type cannot be null");
                }
                else if(!c7.isSelected()){
                    JOptionPane.showMessageDialog(null,"Declaration not checked");
                }
                else{
                    Conn c=new Conn();
                    String query1="insert into signup3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n"+ "Pin Number: "+pinnumber);
                    
                    setVisible(false);
                    new deposit(pinnumber).setVisible(true);
                
                }
                

            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String args[]){
        new signupThree("");
    }
}
