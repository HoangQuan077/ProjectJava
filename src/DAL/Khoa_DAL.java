package DAL;

import DTO.KhoaDTO;
import DTO.LopHocDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Khoa_DAL {
    Connection con=new ConnectSQL().openConnect();
    public Vector<KhoaDTO> getinfokhoa()
    {
        Vector<KhoaDTO> list=new Vector<>();
        try
        {
            String sql= "Select * from khoa";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new KhoaDTO(rs.getString(1), rs.getString(2)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
}
