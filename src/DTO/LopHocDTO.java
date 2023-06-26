package DTO;

public class LopHocDTO {
    private String MaLop;
    private String TenLop;
    private String MaKhoa;

    public LopHocDTO(String maLop, String tenLop, String maKhoa) {
        MaLop = maLop;
        TenLop = tenLop;
        MaKhoa = maKhoa;
    }

    public LopHocDTO() {
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }
}
