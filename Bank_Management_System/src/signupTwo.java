import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.sql.*;

public class signupTwo extends JFrame implements ActionListener{
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton yes,no;
    JComboBox occupation1,religion1,category1,income1,education1;
    String formno;

    signupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        Border border =BorderFactory.createLineBorder(Color.BLACK,1);

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,160,100,30);
        add(religion);

        String valreligion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion1=new JComboBox(valreligion);
        religion1.setBounds(300,160,400,30);
        religion1.setBackground(Color.WHITE);
        religion1.setBorder(border);
        add(religion1);

        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,210,300,30);
        add(category);

        String valcategory[]={"General","OBC","SC","ST","Others"};
        category1=new JComboBox(valcategory);
        category1.setBounds(300,210,400,30);
        category1.setBackground(Color.WHITE);
        category1.setBorder(border);
        add(category1);

        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,260,300,30);
        add(income);

        String valincome[]={"Null","Below 1.5 Lakh","Below 2.5 Lakh","Below 5 Lakh","Upto 10 Lakh","Above 10 Lakh"};
        income1=new JComboBox(valincome);
        income1.setBounds(300,260,400,30);
        income1.setBackground(Color.WHITE);
        income1.setBorder(border);
        add(income1);

        JLabel education=new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,310,300,30);
        add(education);

        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,340,300,30);
        add(qualification);

        String valeducation[]={"Non-Graduation","Graduation","Post-Graduation","Others"};
        education1=new JComboBox(valeducation);
        education1.setBounds(300,340,400,30);
        education1.setBorder(border);
        education1.setBackground(Color.WHITE);
        add(education1);

        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,410,300,30);
        add(occupation);

        String valoccupation[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation1=new JComboBox(valoccupation);
        occupation1.setBounds(300,410,400,30);
        occupation1.setBorder(border);
        occupation1.setBackground(Color.WHITE);
        add(occupation1);

        JLabel pannumber=new JLabel("Pan Number:");
        pannumber.setFont(new Font("Raleway",Font.BOLD,20));
        pannumber.setBounds(100,460,300,30);
        add(pannumber);

        panTextField=new JTextField();
        panTextField.setBounds(300,460,400,30);
        panTextField.setFont(new Font ("Arial",Font.BOLD,16));
        panTextField.setBorder(border);
        add(panTextField);

        JLabel aadharnumber=new JLabel("Aadhar Number:");
        aadharnumber.setFont(new Font("Raleway",Font.BOLD,20));
        aadharnumber.setBounds(100,510,300,30);
        add(aadharnumber);

        aadharTextField=new JTextField();
        aadharTextField.setBounds(300,510,400,30);
        aadharTextField.setFont(new Font ("Arial",Font.BOLD,16));
        aadharTextField.setBorder(border);
        add(aadharTextField);

        JLabel seniorcitizen=new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorcitizen.setBounds(100,560,300,30);
        add(seniorcitizen);

        yes=new JRadioButton("Yes");
        yes.setBounds(300,560,100,30);
        yes.setFont(new Font("Raleway",Font.BOLD,18));
        add(yes);

        no=new JRadioButton("No");
        no.setBounds(450,560,100,30);
        no.setFont(new Font("Raleway",Font.BOLD,18));
        add(no);

        ButtonGroup seniorcitizengroup=new ButtonGroup();
        seniorcitizengroup.add(yes);
        seniorcitizengroup.add(no);

        JLabel existing=new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100,610,300,30);
        add(existing);

        yes=new JRadioButton("Yes");
        yes.setBounds(300,610,100,30);
        yes.setFont(new Font("Raleway",Font.BOLD,18));
        add(yes);

        no=new JRadioButton("No");
        no.setBounds(450,610,100,30);
        no.setFont(new Font("Raleway",Font.BOLD,18));
        add(no);

        ButtonGroup existinggroup=new ButtonGroup();
        existinggroup.add(yes);
        existinggroup.add(no);


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
        String religion=(String)religion1.getSelectedItem();
        String category=(String)category1.getSelectedItem();
        String income =(String)income1.getSelectedItem();
        String education=(String)education1.getSelectedItem();
        String occupation=(String)occupation1.getSelectedItem();
        String pan=panTextField.getText();
        String aadhar=aadharTextField.getText();

        String seniorcitizen=null;
        if(yes.isSelected()){
            seniorcitizen="Yes";
        }
        else if(no.isSelected()){
            seniorcitizen="No";
        }

        String existing=null;
        if(yes.isSelected()){
            existing="Yes";
        }
        else if(no.isSelected()){
            existing="No";
        }
        
        try{
            if(aadharTextField.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Fill all required details");
            }
            else{
                Conn c1=new Conn();
                String query1="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+seniorcitizen+"','"+existing+"')";
                c1.s.execute(query1);

                setVisible(false);
                new signupThree(formno).setVisible(true);
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }


    }
    
    public static void main(String args[]){
        new signupTwo("");
    }
}
