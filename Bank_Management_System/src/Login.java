
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame  implements ActionListener {
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logo.png"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(90,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,48));
        text.setBounds(320,40,500,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,40));
        cardno.setBounds(120,170,200,40);
        add(cardno);

        Border border =BorderFactory.createLineBorder(Color.BLACK,1);

        cardTextField =new JTextField();
        cardTextField.setBounds(350,170,320,40);
        cardTextField.setFont(new Font ("Arial",Font.BOLD,16));
        cardTextField.setBorder(border);
        add(cardTextField);


        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,40));
        pin.setBounds(120,250,200,40);
        add(pin);

        pinTextField =new JPasswordField();
        pinTextField.setBounds(350,250,320,40);
        pinTextField.setFont(new Font ("Arial",Font.BOLD,18));
        pinTextField.setBorder(border);
        add(pinTextField);

        login =new JButton("SIGN IN");
        login.setBounds(350,350,135,35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear =new JButton("CLEAR");
        clear.setBounds(530,350,135,35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup =new JButton("SIGN UP");
        signup.setBounds(350,400,315,35);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        setSize(900,580);
        setVisible(true);
        setLocation(350,140);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";  
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);;
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new signupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}

