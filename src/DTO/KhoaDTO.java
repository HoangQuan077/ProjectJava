package DTO;

public class KhoaDTO {
    private String MaKhoa,TenKhoa;

    public KhoaDTO(String maKhoa, String tenKhoa) {
        MaKhoa = maKhoa;
        TenKhoa = tenKhoa;
    }

    public KhoaDTO() {
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        TenKhoa = tenKhoa;
    }
}
