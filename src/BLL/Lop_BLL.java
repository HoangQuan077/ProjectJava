package BLL;
import DAL.*;
import DTO.*;

import java.util.Vector;

public class Lop_BLL {
    public Vector<LopHocDTO> getinfo_lop()
    {
        return new LopHoc_DAL().getinfolop();
    }
}
