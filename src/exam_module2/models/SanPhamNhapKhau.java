package exam_module2.models;

import java.io.Serializable;

public class SanPhamNhapKhau extends SanPham implements Serializable {
//    Giá nhập khẩu, Tỉnh thành nhập, Thuế nhập khẩu.
    private Integer giaNhap;
    private String tinhNhapKhau;
    private Integer thueNhapKhau;

    public Integer getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Integer giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getTinhNhapKhau() {
        return tinhNhapKhau;
    }

    public void setTinhNhapKhau(String tinhNhapKhau) {
        this.tinhNhapKhau = tinhNhapKhau;
    }

    public Integer getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(Integer thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }
    public SanPhamNhapKhau(){};
    public SanPhamNhapKhau(Integer idSP, String maSP, String tenSP, Integer giaBan, Integer soLuong, String nhaSanXuat, Integer giaNhap, String tinhNhapKhau, Integer thueNhapKhau) {
        super(idSP, maSP, tenSP, giaBan, soLuong, nhaSanXuat);
        this.giaNhap = giaNhap;
        this.tinhNhapKhau = tinhNhapKhau;
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return "SanPhamNhapKhau{" + super.toString()+
                "giaNhap=" + giaNhap +
                ", tinhNhapKhau='" + tinhNhapKhau + '\'' +
                ", thueNhapKhau=" + thueNhapKhau +
                '}';
    }
}
