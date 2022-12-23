import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;


public class withdrawal extends JFrame implements ActionListener{

    JTextField amountTextField;
    JButton withdraw, back;
    String pinnumber;

    withdrawal(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 825, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 825);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextField.setBounds(170, 340, 290, 25);
        image.add(amountTextField);

        withdraw = new JButton("Cash Withdrawal");
        withdraw.setBounds(335, 478, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(335, 512, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(850, 825);
        setLocation(400, 10);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == withdraw) {
            String amount = amountTextField.getText();
            Date date = new Date();
            try {
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the deposit amount you want to deposit");
                } else {

                    Conn c = new Conn();
                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdrawal','" + amount+ "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " Withdrawal Successfully");
                    setVisible(false);
                    new transaction(pinnumber).setVisible(true);
                }
            }

            catch (Exception e) {
                System.out.println(e);
            }

        } 
        else if (ae.getSource() == back) {
            setVisible(false);
            new transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String argss[]){
        new withdrawal("");
    }
}
