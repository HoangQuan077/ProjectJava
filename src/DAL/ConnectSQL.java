package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectSQL {

        public Connection  openConnect()
        {
        	final  String url="jdbc:mysql://localhost:3306/cnpm";
            final String user="root";
            final  String password="hoangquan";
            Connection con = null;
            try
            {
                    con= DriverManager.getConnection(url, user, password);
            }
            catch(SQLException e)
            {
               System.out.println("Kết nối thất bại");
            }
            return con;
        }
    

}
