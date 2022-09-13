package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectMysql {
    Connection connection;
    String dbname="workmanager";
    String username="root";
    String pasword="";

    public java.sql.Connection getConnection(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbname,username,pasword);

        }catch (Exception e){
            e.printStackTrace();
        }


        return connection;
    }


}