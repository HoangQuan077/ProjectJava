package DAL;
import DTO.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class LopHoc_DAL {
    Connection con=new ConnectSQL().openConnect();
    public Vector<LopHocDTO> getinfolop()
    {
        Vector<LopHocDTO> list=new Vector<>();
        try
        {
            String sql= "Select * from lop";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new LopHocDTO(rs.getString(1), rs.getString(2),rs.getString(3)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
}
