package module2.case_Study.services.CustomerService;


import caseStudy.utils.CheckDateOfBirth;
import module2.case_Study.dataCharacter.ReadAndWriteCustomer;
import module2.case_Study.models.Customer.Customer;
import module2.case_Study.models.Customer.TypeCustomer;
import module2.case_Study.models.employee.Gioitinh;
import module2.case_Study.utils.Choice;
import module2.case_Study.utils.Scan;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private static final String filepath = "src\\module2\\case_Study\\data\\Customer.csv";
    public static List<Customer> customers = new LinkedList<>();
    public static final ReadAndWriteCustomer readAndWrite = new ReadAndWriteCustomer();

    @Override
    public List<Customer> getAll() {
        List<String[]> list = readAndWrite.readFile(filepath);
        customers.clear();
        for (String[] element : list) {
            Customer customer = new Customer(Integer.parseInt(element[0]), element[1], element[2],
                    element[3], element[4], element[5], element[6], element[7], element[8]);
            customers.add(customer);
        }

        return customers;
    }

    @Override
    public void addNew() {
        new CustomerServiceImpl().getAll();
        int id = 0;
        if (customers.isEmpty()) {
            id = 1;
        } else {
            id = customers.get(customers.size() - 1).getCode() + 1;
        }
        System.out.println(" nhap ten  ");
        String name = new Scan().inputString();
        System.out.println(" nhap ngay sinh  ");
        String dateBirth = new CheckDateOfBirth().CheckDateOfBirth();
        System.out.println(" chon gioi tinh  ");
        String gender = new Gioitinh().gender();
        System.out.println(" nhap so CMND  ");
        String cmnd = new Scan().inputString();
        System.out.println(" nhap so dien thoai  ");
        String numPhone = new Scan().inputString();
        System.out.println(" nhap email  ");
        String email = new Scan().inputString();
        System.out.println(" chon loai customer ");
        String typeCustomer = new TypeCustomer().choiCustomer();
        System.out.println(" nhap dia chi   ");
        String address = new Scan().inputString();
        System.out.println("ban nhap thanh cong...");
        Customer customer = new Customer(id, name, dateBirth, gender, cmnd, numPhone, email, typeCustomer, address);
        String line = customer.getCode() + "," + customer.getFullName() + "," + customer.getDateOfBirth() + "," +
                customer.getGender() + "," + customer.getIdNumber() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + ","
                + customer.getCustomerType() + "," + customer.getAddress();
        customers.add(customer);
        readAndWrite.writeData(filepath, line);
    }

    @Override
    public void editData() {
        new CustomerServiceImpl().getAll();
        new CustomerServiceImpl().disPlay();
        System.out.println("nhap id ban muon sua");
        int id = new Choice().choice();
        String lineLocation = "";
        String line = "";
        boolean check2 = true;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCode() == id) {
                lineLocation = customers.get(i).getCode() + "," + customers.get(i).getFullName() + "," + customers.get(i).getDateOfBirth() + "," +
                        customers.get(i).getGender() + "," + customers.get(i).getIdNumber() + "," + customers.get(i).getPhoneNumber() + ","
                        + customers.get(i).getEmail() + "," + customers.get(i).getCustomerType() + "," + customers.get(i).getAddress();
                boolean check = true;
                while (check) {
                    System.out.println("Bạn muốn sửa thông tin nào cho " + customers.get(i).toString());
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
                            String name = new Scan().inputString();
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
                            customers.get(i).setGender(gender);
                            break;
                        case 4:
                            System.out.println("Nhập CMND");
                            String idPerson = new Scan().inputString();
                            customers.get(i).setIdNumber(idPerson);
                            break;
                        case 5:
                            System.out.println("Nhập số điện thoại");
                            String number = new Scan().inputString();
                            customers.get(i).setPhoneNumber(number);
                            break;
                        case 6:
                            System.out.println("Nhập emailAddress");
                            String email = new Scan().inputString();
                            customers.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("loai customer ");
                            String typeCustomer = new TypeCustomer().choiCustomer();
                            customers.get(i).setCustomerType(typeCustomer);
                            break;
                        case 8:
                            System.out.println("Nhập dia chi ");
                            String address = new Scan().inputString();
                            customers.get(i).setAddress(address);
                            break;
                        case 9:
                            check = false;
                            break;
                        default:
                            break;
                    }
                }
                line = customers.get(i).getCode() + "," + customers.get(i).getFullName() + "," + customers.get(i).getDateOfBirth() + "," +
                        customers.get(i).getGender() + "," + customers.get(i).getIdNumber() + "," + customers.get(i).getPhoneNumber() + ","
                        + customers.get(i).getEmail() + "," + customers.get(i).getCustomerType() + "," + customers.get(i).getAddress();
                check2 = false;
                break;
            }
        }
        if (check2) {
            System.out.println("khong tim thay id ban vua nhap");
        }
        readAndWrite.editData(filepath, lineLocation, line);
    }

    @Override
    public void disPlay() {
        new CustomerServiceImpl().getAll();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void remove() {
        new CustomerServiceImpl().getAll();
        String line = "";
        System.out.println("nhap id ban muon xoa");
        int id = new Choice().choice();
        boolean check2 = true;
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
                            line = customers.get(i).getCode() + "," + customers.get(i).getFullName() + "," + customers.get(i).getDateOfBirth() + "," +
                                    customers.get(i).getGender() + "," + customers.get(i).getIdNumber() + "," + customers.get(i).getPhoneNumber() + ","
                                    + customers.get(i).getEmail() + "," + customers.get(i).getCustomerType() + "," + customers.get(i).getAddress();
                            check = false;
                            customers.remove(i);
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
                check2 = false;
                break;
            }
        }
        if (check2) {
            System.out.println("khong tim thay id ban vua nhap");
        }
        readAndWrite.removeData(filepath, line);
    }

    public Integer CheckidBook() {
        new CustomerServiceImpl().getAll();
        new CustomerServiceImpl().disPlay();
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
            if (!check) {
                System.out.println("id khong dung, moi nhap lai theo danh sanh da hien ");
            }
        }
        return id;
    }
}
