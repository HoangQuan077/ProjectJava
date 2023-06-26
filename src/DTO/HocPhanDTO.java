package DTO;

public class HocPhanDTO {
    private String MaNhom;
    private String MaLop;
    private String TenMH;
    private int SoLuongDK;
    private int SoTc;
    private int SoTiet;
    private String TenGV;
    private String tiethoc;

    public HocPhanDTO() {
    }

    public HocPhanDTO(String maNhom, String maLop, String tenMH, int soLuongDK, int soTc, int soTiet, String tenGV, String tiethoc) {
        MaNhom = maNhom;
        MaLop = maLop;
        TenMH = tenMH;
        SoLuongDK = soLuongDK;
        SoTc = soTc;
        SoTiet = soTiet;
        TenGV = tenGV;
        this.tiethoc = tiethoc;
    }

    public String getMaNhom() {
        return MaNhom;
    }

    public void setMaNhom(String maNhom) {
        MaNhom = maNhom;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public int getSoLuongDK() {
        return SoLuongDK;
    }

    public void setSoLuongDK(int soLuongDK) {
        SoLuongDK = soLuongDK;
    }

    public int getSoTc() {
        return SoTc;
    }

    public void setSoTc(int soTc) {
        SoTc = soTc;
    }

    public int getSoTiet() {
        return SoTiet;
    }

    public void setSoTiet(int soTiet) {
        SoTiet = soTiet;
    }

    public String getTenGV() {
        return TenGV;
    }

    public void setTenGV(String tenGV) {
        TenGV = tenGV;
    }

    public String getTiethoc() {
        return tiethoc;
    }

    public void setTiethoc(String tiethoc) {
        this.tiethoc = tiethoc;
    }
}
