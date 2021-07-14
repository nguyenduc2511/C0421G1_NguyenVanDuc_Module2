package exam_module2.controllers;

import exam_module2.services.SanPham;
import exam_module2.utils.ChoiceNumber;

public class ControllerSanPham {
    public void controller() {

        boolean check = true;
        while (check) {
            System.out.println("1. Thêm mới sản phẩm ");
            System.out.println("2. Xóa sản Phẩm");
            System.out.println("3. Hiển thị Danh sách sản phẩm ");
            System.out.println("4. Tìm kiếm sản phẩm ");
            System.out.println("5. Thoát");
            System.out.println("Nhập lựa chọn của bạn ");
            int choice = new ChoiceNumber().choice();
            switch (choice) {
                case 1:
                    new SanPham().addNew();
                    break;
                case 2:
                    new SanPham().removeData();
                    break;
                case 3:
                    new SanPham().disPlay();
                    break;
                case 4:
                    new SanPham().findData();
                    break;
                case 5:
                    check = false;
                    break;
                default:
                    System.out.println("Hãy nhập lựa chọn đúng");
            }
        }
    }
}
