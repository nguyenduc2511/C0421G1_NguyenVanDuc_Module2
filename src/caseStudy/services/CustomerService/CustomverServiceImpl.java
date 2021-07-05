package caseStudy.services.CustomerService;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.Scan;
import caseStudy.controllers.Choice;
import caseStudy.models.Customer.Customer;
import caseStudy.models.Customer.TypeCustomer;
import caseStudy.models.employee.Gioitinh;
import caseStudy.services.employeeService.CheckDateOfBirth;

import java.util.LinkedList;
import java.util.List;

public class CustomverServiceImpl implements CustomerService {
    private static final String filepath = "src\\caseStudy\\data\\Customer.csv";
    public static List<Customer> customers = new LinkedList<>();
    public static final ReadAndWriteByteStream<Customer> readAndWriteByteStream = new ReadAndWriteByteStream<Customer>();

    @Override
    public List<Customer> getAll() {
        customers = readAndWriteByteStream.readFileByteStream(filepath);
        return customers;
    }

    @Override
    public void addNew() {
        new CustomverServiceImpl().getAll();
        int id = 0;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            id = customers.get(customers.size() - 1).getCode() + 1;
        }
        System.out.println(" nhap ten  ");
        String name = new Scan().input().nextLine();
        System.out.println(" nhap ngay sinh  ");
        String dateBirth = new CheckDateOfBirth().CheckDateOfBirth();
        System.out.println(" chon gioi tinh  ");
        String gender = new Gioitinh().gender();
        System.out.println(" nhap so CMND  ");
        String cmnd = new Scan().input().nextLine();
        System.out.println(" nhap so dien thoai  ");
        String numPhone = new Scan().input().nextLine();
        System.out.println(" nhap email  ");
        String email = new Scan().input().nextLine();
        System.out.println(" chon loai customer ");
        String typeCustomer = new TypeCustomer().choiCustomer();
        System.out.println(" nhap dia chi   ");
        String address = new Scan().input().nextLine();

        Customer customer = new Customer(id, name, dateBirth, gender, cmnd, numPhone, email, typeCustomer, address);
        customers.add(customer);
        readAndWriteByteStream.writeFileByteStream(customers, filepath);
    }

    @Override
    public void editData() {
        new CustomverServiceImpl().getAll();
        System.out.println("nhap id ban muon sua");
        int id = new Choice().choice();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCode() == id) {
                boolean check = true;
                while (check) {
                    System.out.println("Bạn muốn sửa thông tin nào cho " + customers.get(i).getFullName());
                    System.out.println("1. Name customers");
                    System.out.println("2. Ngày sinh");
                    System.out.println("3. Giới tính");
                    System.out.println("4. Số Chứng minh nhân dân");
                    System.out.println("5. Số điện thoại");
                    System.out.println("6. Địa chỉ email");
                    System.out.println("7. loai customers");
                    System.out.println("8. dia chi ");
                    System.out.println("9. thoat edit");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập tên muốn sửa");
                            String name = new Scan().input().nextLine();
                            customers.get(i).setFullName(name);
                            break;
                        case 2:
                            System.out.println("Nhập dateOfBirth");
                            String day = new CheckDateOfBirth().CheckDateOfBirth();
                            customers.get(i).setDateOfBirth(day);
                            break;
                        case 3:
                            System.out.println("chon giới tính");
                            String gender = new Gioitinh().gender();
                            customers.get(i).setDateOfBirth(gender);
                            break;
                        case 4:
                            System.out.println("Nhập CMND");
                            String idPerson = new Scan().input().nextLine();
                            customers.get(i).setIdNumber(idPerson);
                            break;
                        case 5:
                            System.out.println("Nhập số điện thoại");
                            String number = new Scan().input().nextLine();
                            customers.get(i).setPhoneNumber(number);
                            break;
                        case 6:
                            System.out.println("Nhập emailAddress");
                            String email = new Scan().input().nextLine();
                            customers.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("loai customer ");
                            String typeCustomer = new TypeCustomer().choiCustomer();
                            customers.get(i).setCustomerType(typeCustomer);
                            break;
                        case 8:
                            System.out.println("Nhập dia chi ");
                            String address = new Scan().input().nextLine();
                            customers.get(i).setAddress(address);
                            break;
                        case 9:
                            check = false;
                            break;
                        default:
                            break;
                    }
                }
                break;
            }
        }
        readAndWriteByteStream.clearData(filepath);
        readAndWriteByteStream.writeFileByteStream(customers, filepath);
    }

    @Override
    public void disPlay() {
        new CustomverServiceImpl().getAll();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void remove() {
        new CustomverServiceImpl().getAll();
        System.out.println("nhap id ban muon xoa");
        int id = new Choice().choice();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCode() == id) {
                boolean check = true;
                while (check) {
                    System.out.println("Bạn muốn xoa employee nay  " + customers.get(i).toString());
                    System.out.println("1. dong y xoa");
                    System.out.println("2. khong xoa");
                    System.out.println(" hay dua ra quyet dinh ");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1: {
                            customers.remove(i);
                            check = false;
                            break;
                        }
                        case 2: {
                            check = false;
                            break;
                        }
                        default:
                            break;
                    }
                }
                break;
            }
        }
        readAndWriteByteStream.clearData(filepath);
        readAndWriteByteStream.writeFileByteStream(customers, filepath);
    }

    public Integer CheckidBook() {
        new CustomverServiceImpl().getAll();
        new CustomverServiceImpl().disPlay();
        boolean check = false;
        int id = 0;
        while (!check) {
            System.out.println(" nhap id cua Customer ");
            id = new Choice().choice();
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCode() == id) {
                    check = true;
                    break;
                }
            }
            if(!check){
                System.out.println("id khong dung, moi nhap lai theo danh sanh da hien ");
            }
        }
        return id;
    }
}
