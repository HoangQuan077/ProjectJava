package BLL;

import DAL.MonHoc_DAL;
import DTO.MonHocDTO;

import java.util.Vector;

public class MonHoc_BLL {
    //gọi method bên pakage DAL

    //add MH
    public int add_MH(MonHocDTO item)
    {
        return new MonHoc_DAL().addMH(item);
    }
    // delete MH
    public int delete_MH(String ma)
    {
        return new MonHoc_DAL().deleteMH(ma);
    }
    //search MH
    public Vector<MonHocDTO> search_MH(String ten)
    {
        return new MonHoc_DAL().seacrhMH(ten);
    }
    // get data MH
    public Vector<MonHocDTO> getinfo_MH(){
        return new MonHoc_DAL().getinfoMH();
    }
    //get data theo MaMH
     public Vector<String> getMaMH(){
        return new MonHoc_DAL().getMaMH();
    }
     //get data theo MaMH
     public Vector<String> getTenMH1(){
        return new MonHoc_DAL().getTenMH();
    }
    //
    public  int update_MH(String ma, MonHocDTO mh)
    {
        return new MonHoc_DAL().updateMH(ma,mh);
    }
    public MonHocDTO search_indexMH(String ma)
    {
    	return new MonHoc_DAL().search_MHindex(ma);
    }
}
