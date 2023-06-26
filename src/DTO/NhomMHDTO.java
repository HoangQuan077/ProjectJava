package DTO;

public class NhomMHDTO {
    private String MaNhom;
    private String MaMH;
    private String TenMH;
    private int Succhua;
    private String TenGV;
    private  String tiethoc;
    private int sotuanhoc;
    private int tongphantiet;
    private int tongtiet;
    private String hocki;
    private String namhoc;

    public NhomMHDTO(String maNhom, String maMH, String tenMH, int succhua, String tenGV, String tiethoc, int sotuanhoc, int tongphantiet, int tongtiet, String hocki, String namhoc) {
        MaNhom = maNhom;
        MaMH = maMH;
        TenMH = tenMH;
        Succhua = succhua;
        TenGV = tenGV;
        this.tiethoc = tiethoc;
        this.sotuanhoc = sotuanhoc;
        this.tongphantiet = tongphantiet;
        this.tongtiet = tongtiet;
        this.hocki = hocki;
        this.namhoc = namhoc;
    }

    public String getMaMH() {
        return MaMH;
    }

    public String getTiethoc() {
        return tiethoc;
    }

    public void setTiethoc(String tiethoc) {
        this.tiethoc = tiethoc;
    }



    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public String getMaNhom() {
        return MaNhom;
    }

    public void setMaNhom(String maNhom) {
        MaNhom = maNhom;
    }

    public int getSucchua() {
        return Succhua;
    }

    public void setSucchua(int succhua) {
        Succhua = succhua;
    }

    public String getTenGV() {
        return TenGV;
    }

    public void setTenGV(String tenGV) {
        TenGV = tenGV;
    }

    public int getSotuanhoc() {
        return sotuanhoc;
    }

    public void setSotuanhoc(int sotuanhoc) {
        this.sotuanhoc = sotuanhoc;
    }

    public int getTongphantiet() {
        return tongphantiet;
    }

    public void setTongphantiet(int tongphantiet) {
        this.tongphantiet = tongphantiet;
    }

    public int getTongtiet() {
        return getSotuanhoc()*getTongphantiet();
    }

    public void setTongtiet(int tongtiet) {
        this.tongtiet = tongtiet;
    }

    public String getHocki() {
        return hocki;
    }

    public void setHocki(String hocki) {
        this.hocki = hocki;
    }

    public NhomMHDTO() {
    }
}