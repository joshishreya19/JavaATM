 
package atm;
 
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        // Inserting Icon
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(100,100,100,100);
        add(label);
        
        //Inserting Text
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,50));
        text.setBounds(300,100,450,50);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,35));
        cardno.setBounds(180,250,180,50);
        add(cardno);
        
         cardTextField=new JTextField();
        cardTextField.setBounds(350,263,280,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,35));
        pin.setBounds(180,350,180,50);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(350,350,280,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(pinTextField);
        
        login =new JButton("SIGN IN");
        login.setBounds(350,430,125,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear =new JButton("CLEAR");
        clear.setBounds(502,430,125,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup =new JButton("SIGN UP");
        signup.setBounds(350,480,280,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        // Farem setting
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,800);
        setVisible(true);
        setLocation(300,0);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==clear){
           cardTextField.setText("");
           pinTextField.setText("");
       } 
       else if(ae.getSource()==login){
           conn conn=new conn();
           String cardnumber=cardTextField.getText();
           String pinnumber=pinTextField.getText();
           String query="select * from login where cardnumber='"+cardnumber+"' and pin='"+pinnumber+"'";
           try{
                ResultSet rs= conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card number or pin");
                }
               
           }
           catch(Exception e){
               System.out.println(e);
           }
       }
       else if(ae.getSource()==signup){
           setVisible(false);
           new signup1().setVisible(true);
       }
    }
       
    public static void main(String[] args) {
        new Login();
    }
    
}
