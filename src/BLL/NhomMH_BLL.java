package BLL;
import DAL.*;
import DTO.*;

import java.util.Vector;

public class NhomMH_BLL {
    //gọi bên DAL
    //add sinh viên
    public int add_NhomMH1(NhomMHDTO item)
    {

        return new NhomMH_DAL().add_NhomMD(item);
    }
    //search
    public Vector<NhomMHDTO> search_NhomMH(String manhom)
    {
        return new NhomMH_DAL().seacrhNMH(manhom);
    }
    // get data nhommh
    public Vector<NhomMHDTO> getinfo_NhomMH()
    {
        return new NhomMH_DAL().getNhomMH();
    }
    // delete nhóm MH
    public int delete_NhomMH(String ma)
    {
        return new NhomMH_DAL().deleteNhomMH(ma);
    }

    public int update_nhomMH(String ma, NhomMHDTO mh){
        return new NhomMH_DAL().updatenhomMH(ma,mh);
    }
    // lấy 1 nhóm mh duy nhất bằng mã nhóm
    public NhomMHDTO get_data1NMH(String manhom)
    {
        return new NhomMH_DAL().get1NMH(manhom);
    }
}