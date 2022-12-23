import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ministatement extends JFrame{

    String pinnumber;
    ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        setTitle("MINI STATEMENT");

        JLabel mini=new JLabel();
        add(mini);


        JLabel bankname=new JLabel("Bank");
        bankname.setBounds(168,20,100,20);
        bankname.setFont(new Font("Raleway",Font.BOLD,18));
        add(bankname);

        JLabel ministat=new JLabel("MINI STATEMENT");
        ministat.setBounds(120,60,400,20);
        ministat.setFont(new Font("Raleway",Font.BOLD,18));
        add(ministat);

        JLabel card=new JLabel();
        card.setBounds(20,100,300,20);
        card.setFont(new Font("Raleway",Font.BOLD,16));
        add(card);

        JLabel bal=new JLabel();
        bal.setBounds(20,400,700,20);
        bal.setFont(new Font("Raleway",Font.BOLD,17));
        add(bal);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin='"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));

            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c=new Conn();
            int balance=0;
            ResultSet rs=c.s.executeQuery("Select * from bank where pin='"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                //html tag for providing space &nbsp is for space taken from html
                if(rs.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-= Integer.parseInt(rs.getString("amount"));
                }

            }
            bal.setText("Your Current Account Balance is: Rs. "+balance);

        }
        
        catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,185);

        setSize(420,600);
        setLocation(20,20);
        setVisible(true);
    }
    public static void main(String args[]){
        new ministatement("");
    }
}
