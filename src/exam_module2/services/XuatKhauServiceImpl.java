package exam_module2.services;

import caseStudy.utils.Choice;
import exam_module2.dataStream.ReadAndWriteByteStreamExam;
import exam_module2.models.SanPhamXuatKhau;
import exam_module2.utils.CheckName;
import exam_module2.utils.ChoiceNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XuatKhauServiceImpl implements XuatKhauService {
    private static final String filepath = "src\\exam_module2\\data\\XuatKhau.csv";
    private static List<SanPhamXuatKhau> xuatKhaus = new ArrayList<>();
    private static final ReadAndWriteByteStreamExam<SanPhamXuatKhau> readFileByteStream = new ReadAndWriteByteStreamExam<>();


    @Override
    public List<SanPhamXuatKhau> getAll() {
        xuatKhaus = readFileByteStream.readFileByteStream(filepath);
        return xuatKhaus;
    }

    @Override
    public void addNew() {
        new XuatKhauServiceImpl().getAll();
        int idSP = 0;
        if (xuatKhaus.isEmpty()) {
            idSP = 1;
        } else {
            idSP = xuatKhaus.get(xuatKhaus.size() - 1).getIdSP() + 1;
        }
        String maSP = "SPXK-0000";
        if (xuatKhaus.isEmpty()) {
            maSP = "SPXK-0000" + idSP;
        } else if (idSP < 10) {
            maSP = "SPXK-0000" + idSP;
        } else if (idSP >= 10) {
            maSP = "SPXK-000" + idSP;
        } else if (idSP >= 100) {
            maSP = "SPXK-00" + idSP;
        } else if (idSP >= 1000) {
            maSP = "SPXK-0" + idSP;
        } else if (idSP >= 10000) {
            maSP = "SPXK-" + idSP;
        } else {
            System.out.println(" mã sản phẩm đạt giới hạn. ");
        }
        System.out.println("nhập tên sản phẩm không dấu ");
        String nameSP = new CheckName().checkTenSP();
        System.out.println(" Nhập giá bán ");
        int giaBan = 0;
        boolean check = true;
        while (check) {
            giaBan = new ChoiceNumber().choice();
            if (giaBan < 0) {
                System.out.println(" giá bán phải lớn hơn 0");
            } else {
                check = false;
            }
        }
        System.out.println(" Nhập Số lượng ");
        int soLuong = 0;
        boolean check2 = true;
        while (check2) {
            soLuong = new ChoiceNumber().choice();
            if (soLuong < 0) {
                System.out.println(" số lượng phải lớn hơn 0");
            } else {
                check2 = false;
            }
        }
        System.out.println("nhập tên nhà sản xuất không dấu ");
        String nhaSX = new CheckName().checkTenSP();

        System.out.println(" Nhập giá xuất khẩu ");
        int giaXK = 0;
        boolean check3 = true;
        while (check3) {
            giaXK = new Choice().choice();
            if (giaXK < 0) {
                System.out.println(" giá Xuất khẩu phải lớn hơn 0");
            } else {
                check3 = false;
            }
        }
        System.out.println("nhập quốc gia nhập sản phẩm không dấu ");
        String tinhNK = new CheckName().checkTenSP();

        SanPhamXuatKhau xuatKhau = new SanPhamXuatKhau(idSP, maSP, nameSP, giaBan, soLuong, nhaSX, giaXK, tinhNK);
        xuatKhaus.add(xuatKhau);
        readFileByteStream.writeFileByteStream(xuatKhaus, filepath);
    }


    @Override
    public void findData(String a) {
//        ma sp
        boolean check = false;
        new XuatKhauServiceImpl().getAll();
        for (SanPhamXuatKhau xuatKhau : xuatKhaus) {
            if (xuatKhau.getMaSP().equals(a)) {
                System.out.println(xuatKhau.toString());
                check = true;
            }
        }
        if(!check){
            System.out.println(" không có sản phẩm nào được tìm thấy ");
        }
    }
    public boolean checkData(String a) {
//        ma sp
        boolean check = false;
        new XuatKhauServiceImpl().getAll();
        for (SanPhamXuatKhau xuatKhau : xuatKhaus) {
            if (xuatKhau.getMaSP().equals(a)) {
                System.out.println(xuatKhau.toString());
                check = true;
            }
        }
        if(!check){
            System.out.println(" không có sản phẩm nào được tìm thấy ");
        }
        return check;
    }

    @Override
    public void disPlay() {
        new XuatKhauServiceImpl().getAll();
        for (SanPhamXuatKhau xuatKhau : xuatKhaus) {
            System.out.println(xuatKhau.toString());
        }
    }

    @Override
    public void removeData(String a) {
        new XuatKhauServiceImpl().getAll();
        Iterator<SanPhamXuatKhau> iterator = xuatKhaus.iterator();
        while (iterator.hasNext()) {
            SanPhamXuatKhau xuatKhau = iterator.next();
            if (xuatKhau.getMaSP().equals(a)) {
                iterator.remove();
                break;
            }
        }
        readFileByteStream.writeFileByteStream(xuatKhaus, filepath);
    }
}
