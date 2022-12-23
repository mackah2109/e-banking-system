import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class transaction extends JFrame implements ActionListener{

    JButton deposit,withdrawal,fastcash,exit,clear,balanceenquiry,ministatement,pinchange;
    String pinnumber;

    transaction(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850, 825, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,850,825);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(150,410,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal =new JButton("Cash Withdrawal");
        withdrawal.setBounds(335,410,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(150,444,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(335,444,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("PIN Change");
        pinchange.setBounds(150,478,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(335,478,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        /*clear =new JButton ("Clear");
        clear.setBounds(150,512,150,30);
        clear.addActionListener(this);
        image.add(clear);*/

        exit=new JButton("Exit");
        exit.setBounds(335,512,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(850,825);
        setLocation(400,10);
        setUndecorated(true);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawal){
            setVisible(false);
            new withdrawal(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new balanceenquiry(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            setVisible(false);
            new ministatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new transaction("");
    }
}
