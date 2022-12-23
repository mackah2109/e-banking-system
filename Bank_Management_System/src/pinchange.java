import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class pinchange extends JFrame implements ActionListener {
    String pinnumber;
    JPasswordField newpinTextField, repinTextField;
    JButton change, back;

    pinchange(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(850, 825, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 850, 825);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN:");
        text.setBounds(230, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setBounds(165, 340, 200, 16);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(pintext);

        newpinTextField = new JPasswordField();
        newpinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        newpinTextField.setBounds(360, 340, 100, 25);
        image.add(newpinTextField);

        JLabel repintext = new JLabel("RE-ENTER NEW PIN:");
        repintext.setBounds(165, 380, 700, 35);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        image.add(repintext);

        repinTextField = new JPasswordField();
        repinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        repinTextField.setBounds(360, 380, 100, 25);
        image.add(repinTextField);

        change = new JButton("CHANGE");
        change.setBounds(335, 478, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(335, 512, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(850, 825);
        setLocation(400, 10);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            String newpin = newpinTextField.getText();
            String repin = repinTextField.getText();

            if (!newpin.equals(repin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if (ae.getSource() == change) {
                if (newpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                }
                if (repin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                }

                Conn c = new Conn();
                String query1 = "update bank set pin = '" + repin + "' where pin='" + pinnumber + "'";
                String query2 = "update login set pin = '" + repin + "' where pin='" + pinnumber + "'";
                String query3 = "update signup3 set pin_number = '" + repin + "' where pin_number='" + pinnumber + "'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                setVisible(false);
                new transaction(repin).setVisible(true);
            } else if (ae.getSource() == back) {
                setVisible(false);
                new transaction(pinnumber).setVisible(true);
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    

    public static void main(String args[]) {
        new pinchange("");
    }

}
