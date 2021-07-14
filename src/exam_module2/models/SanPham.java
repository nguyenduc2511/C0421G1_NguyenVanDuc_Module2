package exam_module2.models;

import java.io.Serializable;

public abstract class SanPham implements Serializable {
//    Id sản phẩm, Mã sản phẩm, Tên sản phẩm, Giá bán, Số lượng, Nhà sản xuất.
    private int idSP;
    private String maSP;
    private String tenSP;
    private int giaBan;
    private int soLuong;
    private String nhaSanXuat;

    public int getIdSP() {
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

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }
    public SanPham(){};

    public SanPham(int idSP, String maSP, String tenSP, int giaBan, int soLuong, String nhaSanXuat) {
        this.idSP = idSP;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "idSP=" + idSP +
                ", maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }
}
