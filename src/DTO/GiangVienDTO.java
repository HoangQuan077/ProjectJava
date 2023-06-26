package DTO;

public class GiangVienDTO {
    private String MaGV;
    private String HoTen;
    private String NgaySinh;
    private String NamBoNhiem;
    private String MaKhoa;
    private String Email;
    private String ChucVu;

    public GiangVienDTO(String maGV, String hoTen, String ngaySinh, String namBoNhiem, String maKhoa, String email, String chucVu) {
        MaGV = maGV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        NamBoNhiem = namBoNhiem;
        MaKhoa = maKhoa;
        Email = email;
        ChucVu = chucVu;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String maGV) {
        MaGV = maGV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String chucVu) {
        ChucVu = chucVu;
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

    public String getNamBoNhiem() {
        return NamBoNhiem;
    }

    public void setNamBoNhiem(String namBoNhiem) {
        NamBoNhiem = namBoNhiem;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }
}
