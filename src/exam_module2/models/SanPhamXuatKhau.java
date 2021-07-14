package exam_module2.models;

import java.io.Serializable;

public class SanPhamXuatKhau extends SanPham implements Serializable {
//    Giá xuất khẩu, Quốc gia nhập sản phẩm.
private Integer giaXuatKhau;
private String quocGiaNhapSP;

    public Integer getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(Integer giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSP() {
        return quocGiaNhapSP;
    }

    public void setQuocGiaNhapSP(String quocGiaNhapSP) {
        this.quocGiaNhapSP = quocGiaNhapSP;
    }

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(Integer idSP, String maSP, String tenSP, Integer giaBan, Integer soLuong, String nhaSanXuat, Integer giaXuatKhau, String quocGiaNhapSP) {
        super(idSP, maSP, tenSP, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSP = quocGiaNhapSP;
    }

    @Override
    public String toString() {
        return  "SanPhamXuatKhau{" + super.toString()+
                "giaXuatKhau=" + giaXuatKhau +
                ", quocGiaNhapSP='" + quocGiaNhapSP + '\'' +
                '}';
    }
}
