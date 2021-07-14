package exam_module2.services;

import exam_module2.utils.CheckMa;
import exam_module2.utils.ChoiceNumber;

public class SanPham implements SanPhamService {

    @Override
    public void addNew() {
//        boolean check = true;
        while (true) {
            System.out.println("bạn muốn thêm mới sản phẩm: ");
            System.out.println("1. Sản phẩm xuất khẩu ");
            System.out.println("2. Sản phẩm nhập khẩu ");
            System.out.println("3. quay lại ");
            int choice = new ChoiceNumber().choice();
            switch (choice) {
                case 1:
                    new XuatKhauServiceImpl().addNew();
                    break;
                case 2:
                    new NhapKhauServiceImpl().addNew();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("bạn hãy nhập đúng số lựa chọn");
            }
        }
    }

    @Override
    public void findData() {
        System.out.println("nhập mã sản phẩm bạn muốn tìm ");
        String maSp = new CheckMa().checkTenSP();
        String[] maSPS = maSp.split("-");
        if (maSPS[0].equals("SPNK")) {
            if (new NhapKhauServiceImpl().checkData(maSp)) {
                new NhapKhauServiceImpl().findData(maSp);
            }
        } else if (maSPS[0].equals("SPSK")) {
            if (new XuatKhauServiceImpl().checkData(maSp)) {
                new NhapKhauServiceImpl().findData(maSp);
            }
        }
    }

    @Override
    public void disPlay() {
        System.out.println("sản phẩm nhập khẩu ");
        new NhapKhauServiceImpl().disPlay();
        System.out.println("sản phẩm xuất khẩu ");
        new XuatKhauServiceImpl().disPlay();
    }

    @Override
    public void removeData() {
        System.out.println("nhập mã sản phẩm bạn muốn xóa ");
        String maSp = new CheckMa().checkTenSP();
        String[] maSPS = maSp.split("-");
        if (maSPS[0].equals("SPNK")) {
            if (new NhapKhauServiceImpl().checkData(maSp)) {
                boolean check = true;
                while (check) {
                    System.out.println("chọn 1 nếu bạn muốn xóa");
                    System.out.println("chọn 2 để bỏ qua ");
                    int choice = new ChoiceNumber().choice();
                    switch (choice) {
                        case 1:
                            new NhapKhauServiceImpl().removeData(maSp);
                            break;
                        case 2:
                            check = false;
                            break;
                        default:
                            System.out.println("Hãy nhập đúng lựa chọn");
                            break;
                    }
                }
            }
        } else if (maSPS[0].equals("SPSK")) {
            if (new XuatKhauServiceImpl().checkData(maSp)) {
                boolean check = true;
                while (check) {
                    System.out.println("chọn 1 nếu bạn muốn xóa");
                    System.out.println("chọn 2 để bỏ qua ");
                    int choice = new ChoiceNumber().choice();
                    switch (choice) {
                        case 1:
                            new XuatKhauServiceImpl().removeData(maSp);
                            break;
                        case 2:
                            check = false;
                            break;
                        default:
                            System.out.println("Hãy nhập đúng lựa chọn");
                            break;
                    }
                }
            }
        }
    }
}
