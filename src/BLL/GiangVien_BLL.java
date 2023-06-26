package BLL;
import DTO.*;
import DAL.*;

import java.util.Vector;

public class GiangVien_BLL {
    //add GV
    public int add_GV(GiangVienDTO item)
    {
        return new GiangVien_DAL().addGV(item);
    }
    // delete GV
    public int delete_GV(String ma)
    {
        return new GiangVien_DAL().deleteGV(ma);
    }
    //search GV
    public Vector<GiangVienDTO> search_GV(String ma)
    {
        return new GiangVien_DAL().seacrhGV(ma);
    }
    // get data GV
    public Vector<GiangVienDTO> getinfo_GV(){
        return new GiangVien_DAL().getinfoGV();
    }
    //update
    public int update_GV(String ma, GiangVienDTO gv)
    {
    	return new GiangVien_DAL().updateGV(ma, gv);
    }
}
