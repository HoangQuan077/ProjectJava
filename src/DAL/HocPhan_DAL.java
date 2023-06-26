package DAL;

import java.sql.*;
import java.util.Vector;
import DTO.*;
public class HocPhan_DAL {
    Connection con=new ConnectSQL().openConnect();
    public Vector<HocPhanDTO> getinfoHophan()
    {
        Vector<HocPhanDTO> list=new Vector<>();
        try
        {
            String sql= "Select * from dkmonhoc";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new HocPhanDTO(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getString(7), rs.getString(8)));
            }
        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
    public int addhocphan(HocPhanDTO item) {
        try {

            String sql = "Insert into dkmonhoc values(?,?,?,?,?,?,?,?)";
            PreparedStatement rp=con.prepareStatement(sql);
            rp.setString(1, item.getMaNhom());
            rp.setString(2, item.getMaLop());
            rp.setString(3, item.getTenMH());
            rp.setInt(4, item.getSoLuongDK());
            rp.setInt(5, item.getSoTc());
            rp.setInt(6, item.getSoTiet());
            rp.setString(7, item.getTenGV());
            rp.setString(8,item.getTiethoc());
            return rp.executeUpdate();
        } catch (SQLException ex) {
        }
        return -1;
    }
    public Vector<HocPhanDTO> seacrhHP1(String ten)
    {
        Vector<HocPhanDTO> list=new Vector<>();
        String sql;
        sql= "Select * from dkmonhoc where TenMH LIKE '"+ten+"%'";
        try
        {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new HocPhanDTO(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getInt(5), rs.getInt(6),rs.getString(7), rs.getString(8)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
//    public int updateHP(String manhom, MonHocDTO mh) {
//        int result = 0;
//        String sql = "Update hocphan set Ma='"+mh.getTenMH()+"' , SoTc='"+mh.getSoTc()+"' , ThucHanh='"+mh.getThucHanh()+ "' , LiThuyet = '"+mh.getLiThuyet()+"'  where MaMH='"+ma+"'";
//        try {
//            Statement st = con.createStatement();
//            result = st.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            return -1;
//
//        }
//        return result;
//    }
    //delete học phần theo mã nhóm
    public int deleteHP(String ma) {
        int result = 0;
        String sql = "Delete from dkmonhoc where MaNhom='" + ma + "'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            return -1;
        }
        return result;

    }

}
