package DAL;

import DTO.GiangVienDTO;
import DTO.MonHocDTO;
import DTO.SinhVienDTO;

import java.sql.*;
import java.util.Vector;

public class SinhVien_DAL {
    Connection con=new ConnectSQL().openConnect();
    //lấy data sinh viên
    public Vector<SinhVienDTO> getinfoSV()
    {
        Vector<SinhVienDTO> list=new Vector<>();
        try
        {
            String sql= "Select * from sinhvien";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new SinhVienDTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
    //xóa sv
    public int deleteSV(String ma) {
        int result = 0;
        String sql = "Delete from sinhvien where MaSV='" + ma + "'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);
        } catch (SQLException ex) {
            return -1;
        }
        return result;

    }
    // add sinh viên
    public int addSV(SinhVienDTO item) {
       
        try {
            
            String sql = "Insert into sinhvien values(?,?,?,?,?)";
            PreparedStatement rp=con.prepareStatement(sql);
            rp.setString(1, item.getMaSV());
            rp.setString(2, item.getHoTen());
            rp.setString(3, item.getNgaySinh());
            rp.setString(4, item.getGioiTinh());
            rp.setString(5, item.getMaLop());
            return rp.executeUpdate();
        } catch (SQLException ex) {
        }
        return -1;
    }
    //s search các chuỗi con có trong tên môn học
     public int updateSV(String ma, SinhVienDTO sv) {
        int result = 0;
        String sql = "Update sinhvien set MaSV='"+sv.getMaSV()+"' , HoTen='"+sv.getHoTen()+"' , NgaySinh='"+sv.getNgaySinh()+ "' , GioiTinh = '"+sv.getGioiTinh()+"' , MaLop = '"+sv.getMaLop()+"'  where MaSV='"+ma+"'";
        try {
            Statement st = con.createStatement();
            result = st.executeUpdate(sql);

        } catch (SQLException e) {
            return -1;

        }
        return result;
    }
    public Vector<SinhVienDTO> seacrhSV(String ten)
    {
        Vector<SinhVienDTO> list=null;
        try
        {
            String sql;
            sql= "Select * from sinhvien where HoTen LIKE '"+ten+"%'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                list.add(new SinhVienDTO(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }

        }catch(SQLException ex)
        {
            return null;
        }
        return list;
    }
    public int countSV(String malop)
    {
        int result=0;
        try
        {
            String sql;
            sql= "Select * from sinhvien where MaLop = '"+malop+"'";
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next())
            {
                result++;
            }

        }catch(SQLException ex)
        {
        }
        return result;
    }
}
