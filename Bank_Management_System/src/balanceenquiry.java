import javax.swing.*;
import javax.swing.text.LabelView;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;


public class balanceenquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;


    balanceenquiry(String pinnumber){

        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850, 825, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,850,825);
        add(image);

        back=new JButton("BACK");
        back.setBounds(335,512,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn c=new Conn();
        int balance=0;
        try{
            
            ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        JLabel text=new JLabel("Your Current Account Balance is: ");
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);

        JLabel balances=new JLabel(""+balance);
        balances.setForeground(Color.WHITE);
        balances.setBounds(170,340,400,30);
        balances.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(balances);

        setSize(850,825);
        setLocation(400,10);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new transaction(pinnumber).setVisible(true);
    }
    public static void main(String args[]){
        new balanceenquiry("");
    }
}
