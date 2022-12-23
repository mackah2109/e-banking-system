import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener{

    JButton withdrawal1,withdrawal2,withdrawal3,back,withdrawal4,withdrawal5,withdrawal6;
    String pinnumber;

    fastcash(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(850, 825, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,850,825);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT:");
        text.setBounds(190,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        withdrawal1=new JButton("Rs. 100");
        withdrawal1.setBounds(150,410,150,30);
        withdrawal1.addActionListener(this);
        image.add(withdrawal1);

        withdrawal2 =new JButton("Rs. 500");
        withdrawal2.setBounds(335,410,150,30);
        withdrawal2.addActionListener(this);
        image.add(withdrawal2);

        withdrawal3=new JButton("Rs. 1000");
        withdrawal3.setBounds(150,444,150,30);
        withdrawal3.addActionListener(this);
        image.add(withdrawal3);

        withdrawal4=new JButton("Rs. 2000");
        withdrawal4.setBounds(335,444,150,30);
        withdrawal4.addActionListener(this);
        image.add(withdrawal4);

        withdrawal5=new JButton("Rs. 5000");
        withdrawal5.setBounds(150,478,150,30);
        withdrawal5.addActionListener(this);
        image.add(withdrawal5);

        withdrawal6=new JButton("Rs. 10000");
        withdrawal6.setBounds(335,478,150,30);
        withdrawal6.addActionListener(this);
        image.add(withdrawal6);

        back=new JButton("BACK");
        back.setBounds(335,512,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(850,825);
        setLocation(400,10);
        setUndecorated(true);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
        else{
            
            try{
                String amount=((JButton)ae.getSource()).getText().substring(4);//Rs. 200
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+ " Debited Successfully");


                setVisible(false);
                new transaction(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new fastcash("");
    }
}
