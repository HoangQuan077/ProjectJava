package BLL;

import DAL.*;
import DTO.*;

import java.util.Vector;

public class SinhVien_BLL {
    //add sinhvien
    public int add_SV(SinhVienDTO item)
    {
        return  new SinhVien_DAL().addSV(item);
    }
    //search
    public Vector<SinhVienDTO> search_SV(String ten)
    {
        return new SinhVien_DAL().seacrhSV(ten);
    }
    // get data SV
    public Vector<SinhVienDTO> getinfo_SV()
    {
        return new SinhVien_DAL().getinfoSV();
    }
    // delete SV
    public int delete_SV(String ma )
    {
        return new SinhVien_DAL().deleteSV(ma);
    }
    //dem sosv trong lớp
    public int count_SV(String malop)
    {
        return new SinhVien_DAL().countSV(malop);
    }
     public  int update_sv(String ma, SinhVienDTO sv)
    {
        return new SinhVien_DAL().updateSV(ma,sv);
    }
}

