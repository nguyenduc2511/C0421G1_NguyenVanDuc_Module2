package exam_module2.services;

import caseStudy.utils.Choice;
import exam_module2.dataStream.ReadAndWriteByteStreamExam;
import exam_module2.models.SanPhamNhapKhau;
import exam_module2.utils.CheckName;
import exam_module2.utils.ChoiceNumber;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NhapKhauServiceImpl implements NhapKhauService {
    private static final String filepath = "src\\exam_module2\\data\\NhapKhau.csv";
    private static List<SanPhamNhapKhau> nhapKhaus = new ArrayList<>();
    private static final ReadAndWriteByteStreamExam<SanPhamNhapKhau> readFileByteStream = new ReadAndWriteByteStreamExam<>();


    @Override
    public List<SanPhamNhapKhau> getAll() {
        nhapKhaus = readFileByteStream.readFileByteStream(filepath);
        return nhapKhaus;
    }

    @Override
    public void addNew() {
        new NhapKhauServiceImpl().getAll();
        int idSP = 0;
        if (nhapKhaus.isEmpty()) {
            idSP = 1;
        } else {
            idSP = nhapKhaus.get(nhapKhaus.size() - 1).getIdSP() + 1;
        }
        String maSP = "SPNK-0000";
        if (nhapKhaus.isEmpty()) {
            maSP = "SPNK-0000" + idSP;
        } else if (idSP < 10) {
            maSP = "SPNK-0000" + idSP;
        } else if (idSP >= 10) {
            maSP = "SPNK-000" + idSP;
        } else if (idSP >= 100) {
            maSP = "SPNK-00" + idSP;
        } else if (idSP >= 1000) {
            maSP = "SPNK-0" + idSP;
        } else if (idSP >= 10000) {
            maSP = "SPNK-" + idSP;
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

        System.out.println(" Nhập giá nhập khẩu ");
        int giaNK = 0;
        boolean check3 = true;
        while (check3) {
            giaNK = new Choice().choice();
            if (giaNK < 0) {
                System.out.println(" giá nhập khẩu phải lớn hơn 0");
            } else {
                check3 = false;
            }
        }
        System.out.println("nhập tỉnh nhập khẩu không dấu ");
        String tinhNK = new CheckName().checkTenSP();
        System.out.println(" Nhập thuế nhập khẩu ");
        int thueNK = 0;
        boolean check4 = true;
        while (check4) {
            thueNK = new Choice().choice();
            if (thueNK < 0) {
                System.out.println(" thuế nhập khẩu phải lớn hơn 0");
            } else {
                check4 = false;
            }
        }

        SanPhamNhapKhau nhapKhau = new SanPhamNhapKhau(idSP, maSP, nameSP, giaBan, soLuong, nhaSX, giaNK, tinhNK, thueNK);
        nhapKhaus.add(nhapKhau);
        readFileByteStream.writeFileByteStream(nhapKhaus, filepath);
    }


    @Override
    public void findData(String a) {
//        ma sp
        new NhapKhauServiceImpl().getAll();
        boolean check = false;
        for (SanPhamNhapKhau nhapKhau : nhapKhaus) {
            if (nhapKhau.getMaSP().equals(a)) {
                System.out.println(nhapKhau.toString());
                check = true;
            }
        }
        if( check){
            System.out.println("không có sản phẩm nào được tìm thấy ");
        }
    }
    public boolean checkData(String a) {
//        ma sp
        new NhapKhauServiceImpl().getAll();
        boolean check = false;
        for (SanPhamNhapKhau nhapKhau : nhapKhaus) {
            if (nhapKhau.getMaSP().equals(a)) {
                System.out.println(nhapKhau.toString());
                check = true;
            }
        }
        if(check){
            System.out.println("không có sản phẩm nào được tìm thấy ");
        }
        return check;
    }
    @Override
    public void disPlay() {
        new NhapKhauServiceImpl().getAll();
        for (SanPhamNhapKhau nhapKhau : nhapKhaus) {
            System.out.println(nhapKhau.toString());
        }
    }

    @Override
    public void removeData(String a) {
        new NhapKhauServiceImpl().getAll();
        Iterator<SanPhamNhapKhau> iterator = nhapKhaus.iterator();
        while (iterator.hasNext()) {
            SanPhamNhapKhau nhapKhau = iterator.next();
            if (nhapKhau.getMaSP().equals(a)) {
                iterator.remove();
                break;
            }
        }
        readFileByteStream.writeFileByteStream(nhapKhaus, filepath);
    }
}
