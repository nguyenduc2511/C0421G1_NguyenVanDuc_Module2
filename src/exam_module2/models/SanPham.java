package exam_module2.models;

import java.io.Serializable;

public abstract class SanPham implements Serializable {
//    Id sản phẩm, Mã sản phẩm, Tên sản phẩm, Giá bán, Số lượng, Nhà sản xuất.
    private Integer idSP;
    private String maSP;
    private String tenSP;
    private Integer giaBan;
    private Integer soLuong;
    private String nhaSanXuat;

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
    public SanPham(){};

    public SanPham(Integer idSP, String maSP, String tenSP, Integer giaBan, Integer soLuong, String nhaSanXuat) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return
                "idSP=" + idSP +
                ", maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }
}
