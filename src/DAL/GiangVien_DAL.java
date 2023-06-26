package DAL;

import DTO.GiangVienDTO;
import DTO.MonHocDTO;
import DTO.SinhVienDTO;

import java.sql.*;
import java.util.Vector;

public class GiangVien_DAL {
    Connection con=new ConnectSQL().openConnect();
    public Vector<GiangVienDTO> getinfoGV()
    {
        Vector<GiangVienDTO> list=new Vector<>();
        try
        {
            String sql= "Select * from giangvien";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new GiangVienDTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
    public int deleteGV(String ma) {
        int result = 0;
        String sql = "Delete from giangvien where MaGV='" + ma + "'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            return -1;
        }
        return result;
    }
    public int updateGV(String ma, GiangVienDTO sv) {
        int result = 0;
        String sql = "Update giangvien set  HoTen='"+sv.getHoTen()+"' , NgaySinh='"+sv.getNgaySinh()+ "' , MaKhoa = '"+sv.getMaKhoa()+"' , Email = '"+sv.getEmail()+"' , ChucVu='"+sv.getHoTen()+"'  where MaGV='"+ma+"'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException e) {
            return -1;

        }
        return result;
    }
    // add sinh viên
    public int addGV(GiangVienDTO item) {
        try {

            String sql = "Insert into giangvien values(?,?,?,?,?,?,?)";
            PreparedStatement rp=con.prepareStatement(sql);
            rp.setString(1, item.getMaGV());
            rp.setString(2, item.getHoTen());
            rp.setString(3, item.getNgaySinh());
            rp.setString(4, null);
            rp.setString(5, item.getMaKhoa());
            rp.setString(6, item.getEmail());
            rp.setString(7, item.getChucVu());
            return rp.executeUpdate();
        } catch (SQLException ex) {
        }
        return -1;
    }
    //search giảng viên theo mã
    public Vector<GiangVienDTO> seacrhGV(String ma)
    {
        Vector<GiangVienDTO> list=new Vector<>();
        try
        {
            String sql;
            sql=  "Select * from giangvien where MaGV LIKE '"+ma+"%'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new GiangVienDTO(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
}
