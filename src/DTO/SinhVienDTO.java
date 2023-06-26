package DTO;

public class SinhVienDTO {
    private String MaSV;
    private String HoTen;
    private String NgaySinh;
    private String GioiTinh;
    private String MaLop;
    public SinhVienDTO() {
    }

    public SinhVienDTO(String maSV, String hoTen, String ngaySinh, String gioiTinh, String maLop) {
        MaSV = maSV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        GioiTinh = gioiTinh;
        MaLop = maLop;
    }

    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String maSV) {
        MaSV = maSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }



}
