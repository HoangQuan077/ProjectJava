package BLL;
import DAL.*;
import DTO.HocPhanDTO;

import java.util.Vector;

public class HocPhan_BLL {
    public int add_hocphan(HocPhanDTO hp)
    {
        return new HocPhan_DAL().addhocphan(hp);
    }
    public int delete_hocphan(String manhom)
    {
        return new HocPhan_DAL().deleteHP(manhom);
    }
    public Vector<HocPhanDTO> getinfo_hocphan()
    {
        return new HocPhan_DAL().getinfoHophan();
    }
    public Vector<HocPhanDTO> search_HP(String ten)
    {
        return new HocPhan_DAL().seacrhHP1(ten);
    }
}
