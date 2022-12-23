/* steps to create connection 
1) Register the Driver
2) Create connection
3) Create Statement
4) Execute Query
5) Close connection
*/

import java.sql.*;

public class Conn {
    
    Connection c=null;
    Statement s=null;
    public Conn(){
        try{
            // Class.forName(com.mysql.jdbc.Driver);
            //create connection
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Ishwari@2109@");
            //System.out.println("Success");
            s=c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
}
