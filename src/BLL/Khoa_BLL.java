package BLL;
import DAL.*;
import DTO.KhoaDTO;

import java.util.Vector;

public class Khoa_BLL {
    public Vector<KhoaDTO> getinfo_khoa()
    {
        return new Khoa_DAL().getinfokhoa();
    }
}
