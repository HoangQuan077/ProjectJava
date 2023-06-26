
package DTO;

public class MonHocDTO {
    private String MaMH;
    private String TenMH;
    private int SoTc;
    private int ThucHanh;
    private int LiThuyet;

    public MonHocDTO() {
    }

    public MonHocDTO(String maMH, String tenMH, int soTc, int thucHanh, int liThuyet) {
        MaMH = maMH;
        TenMH = tenMH;
        SoTc = soTc;
        ThucHanh = thucHanh;
        LiThuyet = liThuyet;
    }

    public String getMaMH() {
        return MaMH;
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

    public int getSoTc() {
        return SoTc;
    }

    public void setSoTc(int soTc) {
        SoTc = soTc;
    }

    public int getThucHanh() {
        return ThucHanh;
    }

    public void setThucHanh(int thucHanh) {
        ThucHanh = thucHanh;
    }

    public int getLiThuyet() {
        return LiThuyet;
    }

    public void setLiThuyet(int liThuyet) {
        LiThuyet = liThuyet;
    }
}
