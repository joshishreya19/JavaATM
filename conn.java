package atm;

 import java.sql.*;
public class conn {
    
    Connection c;
    Statement s;
    public conn(){
        try{
//            Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection( "jdbc:mysql://localhost:3308/bankmanagementsystem","root","Zozo@7020");
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
