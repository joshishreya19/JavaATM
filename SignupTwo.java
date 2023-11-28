package atm;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
   
    JTextField religionTextField,categoryTextField,incomeTextField,emailTextField, pann , aadharc,stateTextField,pinTextField;
    JButton next;
    JRadioButton syes,sno,cyes,cno;
    JDateChooser dateChooser;
    JComboBox edu,Occu,religion,in,cat;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel rel=new JLabel("Religion: ");
        rel.setFont(new Font("Raleway",Font.BOLD,20));
       rel.setBounds(100,140,100,30);
        add(rel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
          religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
         
        
        JLabel category=new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        cat=new JComboBox(valCategory);
        cat.setBounds(300,190,400,30);
        cat.setBackground(Color.WHITE);
        add( cat);
                
        JLabel income=new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);
        
        String valIncome[]={"Null","<1,50,000","< 2,50,000","<5,00,000","Upto 10,00,000 "};
         in=new JComboBox(valIncome);
        in.setBounds(300,240,400,30);
        in.setBackground(Color.WHITE);
        add( in);
         
        JLabel  education=new JLabel("Educational: ");
        education.setFont(new Font("Raleway",Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
         JLabel email=new JLabel("Qualification: ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
         String valEdu[]={"Non Graduation","Graduate","Doctrate","Other"};
          edu=new JComboBox(valEdu);
        edu.setBounds(300, 300,400,30);
        edu.setBackground(Color.WHITE);
        add( edu);
        
         
        JLabel mStatus=new JLabel("Occupation: ");
        mStatus.setFont(new Font("Raleway",Font.BOLD,20));
        mStatus.setBounds(100,360,200,30);
        add(mStatus);
        
        String valOccu[]={"Salaried","Self Employed","Business","Retired","Other"};
         Occu=new JComboBox(valOccu);
        Occu.setBounds(300,360,400,30);
        Occu.setBackground(Color.WHITE);
        add( Occu);
        
        JLabel pan=new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,430,200,30);
        add(pan);
        
        pann =new JTextField();
        pann.setFont(new Font("Raleway",Font.BOLD,14));
       pann .setBounds(300,430,400,30);
        add(pann);
        
        JLabel aadhar=new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);
        
        aadharc=new JTextField();
        aadharc.setFont(new Font("Raleway",Font.BOLD,14));
        aadharc.setBounds(300,490,400,30);
        add(aadharc);
        
        JLabel state=new JLabel("Senior Citizen: ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sGroup=new ButtonGroup();
        sGroup.add(syes);
        sGroup.add(sno);
        
        JLabel pincode=new JLabel("Exisiting Account: ");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        cyes=new JRadioButton("Yes");
        cyes.setBounds(300,590,100,30);
        cyes.setBackground(Color.WHITE);
        add(cyes);
        
        cno=new JRadioButton("No");
        cno.setBounds(450,590,100,30);
        cno.setBackground(Color.WHITE);
        add(cno);
        
        ButtonGroup cGroup=new ButtonGroup();
        cGroup.add(cyes);
        cGroup.add(cno);
        
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,900);
        setLocation(300,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        String sreligion= (String)religion.getSelectedItem();
        String scategory=(String)cat.getSelectedItem();
        String sincome=(String) in.getSelectedItem();
        String seducation=(String)edu.getSelectedItem();
        String soccu=(String) Occu.getSelectedItem();
       
        String scitizen= null;
        
        if(syes.isSelected()){
            scitizen="Yes";
            
        }
        else if(sno.isSelected()){
            scitizen="No";
        }
 
        String existingAccount=null;
        if(cyes.isSelected()){
            existingAccount="Yes";
        }
        else if(cno.isSelected()){
            existingAccount="No";
            
        }
    
        String span=pann.getText();
        String saadhar=aadharc.getText();
 
        
        try{
              conn c=new conn();
                String query="Insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccu+"','"+scitizen+"','"+span+"','"+saadhar+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
             
             setVisible(false);
             new SignupThree(formno).setVisible( true);
        }
        catch(Exception t){
            System.out.println(t);
  }
    }
    
    public static void main(String []args){
        new SignupTwo("");
    }
}
