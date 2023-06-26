package DAL;
import DTO.MonHocDTO;
import java.awt.List;

import java.sql.*;
import java.util.Vector;

public class MonHoc_DAL {
    Connection con=new ConnectSQL().openConnect();
    //delete môn học
    public int deleteMH(String ma) {
        int result = 0;
        String sql = "Delete from monhoc where MaMH ='" + ma + "'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;

    }
    //update môn học
    public int updateMH(String ma, MonHocDTO mh) {
        int result = 0;
        String sql = "Update monhoc set TenMH='"+mh.getTenMH()+"' , SoTc='"+mh.getSoTc()+"' , ThucHanh='"+mh.getThucHanh()+ "' , LiThuyet = '"+mh.getLiThuyet()+"'  where MaMH='"+ma+"'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException e) {
            return -1;

        }
        return result;
    }
    //add môn học
    public int addMH(MonHocDTO item) {
        
        try {

            String sql = "Insert into monhoc values(?,?,?,?,?)";
            PreparedStatement rp=con.prepareStatement(sql);
            rp.setString(1, item.getMaMH());
            rp.setString(2, item.getTenMH());
            rp.setInt(3, item.getSoTc());
            rp.setInt(4, item.getThucHanh());
            rp.setInt(5, item.getLiThuyet());
            return rp.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }
    //s search các chuỗi con có trong tên môn học
    public Vector<MonHocDTO> seacrhMH(String ten)
    {
        Vector<MonHocDTO> list_Monhoc=null;
        String sql;
        sql= "Select * from monhoc where TenMH LIKE '"+ten+"%'";
        try
        {
            list_Monhoc=new Vector<>();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list_Monhoc.add(new MonHocDTO(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list_Monhoc;
    }
    public MonHocDTO search_MHindex(String ma)
    {
         MonHocDTO list=null;
        try
        {
            String sql;
            sql= "Select * from monhoc where MaMH ='"+ma+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list = new MonHocDTO(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
    // lấy tất cả tt môn học
    public Vector<MonHocDTO> getinfoMH()
    {
        Vector<MonHocDTO> list=new Vector<>();
        try {
            String sql="Select * from monhoc";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new MonHocDTO(rs.getString(1), rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)));
            }
        }catch (SQLException ex)
        {
            return null;
        }
        return list;
    }

public Vector<String> getMaMH()
{
Vector<String> list=new Vector<>();
        try {
            String sql="Select MaMH from monhoc";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(rs.getString(1));
            }
        }catch (SQLException ex)
        {
            return null;
        }
        return list;
}

public Vector<String> getTenMH()
{
Vector<String> list=new Vector<>();
   
        try {
            String sql="Select TenMH from monhoc " ;
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            
               while(rs.next())
            {
                list.add(rs.getString(1));
            }
            
        }catch (SQLException ex)
        {
             return null;
        }
        return list;
     
}
}
