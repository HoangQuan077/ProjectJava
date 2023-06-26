package DAL;

import DTO.MonHocDTO;
import DTO.NhomMHDTO;

import java.sql.*;
import java.util.Vector;

public class NhomMH_DAL {
    Connection con=new ConnectSQL().openConnect();
    //delete nhóm môn học theo mã nhóm
    public int deleteNhomMH(String manhom) {
        int result = 0;
        String sql = "Delete from nhommh where MaNhom='" + manhom + "'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            return -1;
        }
        return result;

    }
    // add nhóm môn học
    public int add_NhomMD(NhomMHDTO item) {
        int result = 0;
        try {

            String sql = "Insert into nhommh values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement rp=con.prepareStatement(sql);
            rp.setString(1, item.getMaNhom());
            rp.setString(2, item.getMaMH());
            rp.setString(3, item.getTenMH());
            rp.setInt(4, item.getSucchua());
            rp.setString(5, item.getTenGV());
            rp.setString(6, item.getTiethoc());
            rp.setInt(7, item.getSotuanhoc());
            rp.setInt(8, item.getTongphantiet());
            rp.setInt(9, item.getTongtiet());
            rp.setString(10, item.getHocki());
            rp.setString(11, item.getNamhoc()) ;
            result =rp.executeUpdate();
        } catch (SQLException ex) {
            return -1;

        }
        return result;
    }
    // lấy tất cả thông tin nhóm mh ra
    public Vector<NhomMHDTO> getNhomMH()
    {
        Vector<NhomMHDTO> list_NMH=new Vector<>();
        try {
            String sql="Select * from nhommh order by MaMH ASC";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list_NMH.add(new NhomMHDTO(rs.getString(1),
                        rs.getString(2)
                        ,rs.getString(3)
                        ,rs.getInt(4)
                        ,rs.getString(5)
                        ,rs.getString(6)
                        ,rs.getInt(7)
                        ,rs.getInt(8)
                        ,rs.getInt(9)
                        ,rs.getString(10)
                        ,rs.getString(11)));
            }
        }catch (SQLException ex)
        {
            return null;
        }
        return list_NMH;
    }
    //update
    public int updatenhomMH(String ma2,NhomMHDTO mh) {
        int result = 0;
        String sql = "Update nhommh set MaNhom='"+mh.getMaNhom()+"' , MaMH='"+mh.getMaMH()+"' , TenMH='"+mh.getTenMH()+"' , Succhua='"+mh.getSucchua()+"' ,TenGV='"+mh.getTenGV()+"' , tiethoc='"+mh.getTiethoc()+"' ,sotuanhoc='"+mh.getSotuanhoc()+"' , tongphantiet='"+mh.getTongphantiet()+"' , tongtiet='"+mh.getTongtiet()+"' , hocki='"+mh.getHocki()+"' , namhoc='"+mh.getNamhoc()+"' where MaNhom='"+ma2+"'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException e) {
            return -1;

        }
        return result;
    }
    //search mon hoc theo mã nhóm
//    public Vector<NhomMHDTO> searchNhomMH(String manhom)
//    {
//        Vector<NhomMHDTO> list=new Vector<>();
//        try {
//            String sql="Select * from nhommh where MaNhom='"+manhom+"'";
//            Statement st=con.createStatement();
//            ResultSet rs=st.executeQuery(sql);
//            while(rs.next())
//            {
//                list.add(new NhomMHDTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4),
//                        rs.getString(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9)
//                        ,rs.getString(10),rs.getString(11)));
//            }
//        }catch (SQLException ex)
//        {
//            return null;
//        }
//        return list;
//    }
    public Vector<NhomMHDTO> seacrhNMH(String ten)
    {
        Vector<NhomMHDTO> list_NhomMonhoc=null;
        String sql;
        sql= "Select * from nhommh where MaNhom LIKE '"+ten+"%'";
        try
        {
            list_NhomMonhoc=new Vector<>();
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list_NhomMonhoc.add(new NhomMHDTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),
                        rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list_NhomMonhoc;
    }
    // lấy data từ 1 nhóm MH
    public NhomMHDTO get1NMH(String manhom)
    {
        NhomMHDTO nmh=null;
        String sql;
        sql= "Select * from nhommh where MaNhom = '"+manhom+"'";
        try
        {
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                nmh=new NhomMHDTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),
                        rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10),rs.getString(11));
            }

        }catch(SQLException ex)
        {
        }
        return nmh;
    }

}