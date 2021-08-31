//package module2.case_Study.services.CustomerService;
//
//
//import caseStudy.utils.CheckDateOfBirth;
//import module2.case_Study.dataCharacter.ReadAndWriteCustomer;
//import module2.case_Study.models.Customer.Customer;
//import module2.case_Study.models.Customer.TypeCustomer;
//import module2.case_Study.models.employee.Gioitinh;
//import module2.case_Study.utils.Choice;
//import module2.case_Study.utils.Scan;
//
//import java.util.LinkedList;
//import java.util.List;
//
////public class CustomverServiceImpl implements CustomerService {
//    private static final String filepath = "src\\module2\\case_Study\\data\\Customer.csv";
//    public static List<Customer> customers = new LinkedList<>();
////    public static final ReadAndWriteCustomer readAndWrite = new ReadAndWriteCustomer();
//
//    @Override
//    public List<Customer> getAll() {
//        List<String[]> list = readAndWrite.readFile(filepath);
//        for (String[] element : list) {
//            Customer customer = new Customer(Integer.parseInt(element[0]), element[1], element[2], element[3], element[4], element[5], element[6], element[7], element[8]);
//            customers.add(customer);
//        }
//        return customers;
//    }
//
//    @Override
//    public void addNew() {
//        new CustomverServiceImpl().getAll();
//        int id = 0;
//        if (customers.isEmpty()) {
//            id = 1;
//        } else {
//            id = customers.get(customers.size() - 1).getCode() + 1;
//        }
//        System.out.println(" nhap ten  ");
//        String name = new Scan().inputString();
//        System.out.println(" nhap ngay sinh  ");
//        String dateBirth = new CheckDateOfBirth().CheckDateOfBirth();
//        System.out.println(" chon gioi tinh  ");
//        String gender = new Gioitinh().gender();
//        System.out.println(" nhap so CMND  ");
//        String cmnd = new Scan().inputString();
//        System.out.println(" nhap so dien thoai  ");
//        String numPhone = new Scan().inputString();
//        System.out.println(" nhap email  ");
//        String email = new Scan().inputString();
//        System.out.println(" chon loai customer ");
//        String typeCustomer = new TypeCustomer().choiCustomer();
//        System.out.println(" nhap dia chi   ");
//        String address = new Scan().inputString();
//
//        Customer customer = new Customer(id, name, dateBirth, gender, cmnd, numPhone, email, typeCustomer, address);
//        String line = customer.getCode() + "," + customer.getFullName() + "," + customer.getDateOfBirth() + "," +
//                customer.getGender() + "," + customer.getIdNumber() + "," + customer.getPhoneNumber() + "," + customer.getEmail() + "," + customer.getCustomerType() + "," + customer.getAddress();
//        readAndWrite.writeData(filepath, line);
//    }
//
//    @Override
//    public void editData() {
//        new CustomverServiceImpl().getAll();
//        new CustomverServiceImpl().disPlay();
//        System.out.println("nhap id ban muon sua");
//        int id = new Choice().choice();
//        for (int i = 0; i < customers.size(); i++) {
//            if (customers.get(i).getCode() == id) {
//                boolean check = true;
//                while (check) {
//                    System.out.println("Bạn muốn sửa thông tin nào cho " + customers.get(i).toString());
//                    System.out.println("1. Name customers");
//                    System.out.println("2. Ngày sinh");
//                    System.out.println("3. Giới tính");
//                    System.out.println("4. Số Chứng minh nhân dân");
//                    System.out.println("5. Số điện thoại");
//                    System.out.println("6. Địa chỉ email");
//                    System.out.println("7. loai customers");
//                    System.out.println("8. dia chi ");
//                    System.out.println("9. thoat edit");
//                    int choice = new Choice().choice();
//                    switch (choice) {
//                        case 1:
//                            System.out.println("Nhập tên muốn sửa");
//                            String name = new Scan().inputString();
//                            customers.get(i).setFullName(name);
//                            break;
//                        case 2:
//                            System.out.println("Nhập dateOfBirth");
//                            String day = new CheckDateOfBirth().CheckDateOfBirth();
//                            customers.get(i).setDateOfBirth(day);
//                            break;
//                        case 3:
//                            System.out.println("chon giới tính");
//                            String gender = new Gioitinh().gender();
//                            customers.get(i).setGender(gender);
//                            break;
//                        case 4:
//                            System.out.println("Nhập CMND");
//                            String idPerson = new Scan().inputString();
//                            customers.get(i).setIdNumber(idPerson);
//                            break;
//                        case 5:
//                            System.out.println("Nhập số điện thoại");
//                            String number = new Scan().inputString();
//                            customers.get(i).setPhoneNumber(number);
//                            break;
//                        case 6:
//                            System.out.println("Nhập emailAddress");
//                            String email = new Scan().inputString();
//                            customers.get(i).setEmail(email);
//                            break;
//                        case 7:
//                            System.out.println("loai customer ");
//                            String typeCustomer = new TypeCustomer().choiCustomer();
//                            customers.get(i).setCustomerType(typeCustomer);
//                            break;
//                        case 8:
//                            System.out.println("Nhập dia chi ");
//                            String address = new Scan().inputString();
//                            customers.get(i).setAddress(address);
//                            break;
//                        case 9:
//                            check = false;
//                            break;
//                        default:
//                            break;
//                    }
//                }
//                break;
//            }
//        }
//
//    }
//
//    @Override
//    public void disPlay() {
//        new CustomverServiceImpl().getAll();
//        for (Customer customer : customers) {
//            System.out.println(customer.toString());
//        }
//    }
//
//    @Override
//    public void remove() {
//        new CustomverServiceImpl().getAll();
//        System.out.println("nhap id ban muon xoa");
//        int id = new Choice().choice();
//        for (int i = 0; i < customers.size(); i++) {
//            if (customers.get(i).getCode() == id) {
//                boolean check = true;
//                while (check) {
//                    System.out.println("Bạn muốn xoa employee nay  " + customers.get(i).toString());
//                    System.out.println("1. dong y xoa");
//                    System.out.println("2. khong xoa");
//                    System.out.println(" hay dua ra quyet dinh ");
//                    int choice = new Choice().choice();
//                    switch (choice) {
//                        case 1: {
//                            customers.remove(i);
//                            check = false;
//                            break;
//                        }
//                        case 2: {
//                            check = false;
//                            break;
//                        }
//                        default:
//                            break;
//                    }
//                }
//                break;
//            }
//        }
//
//    }
//
//    public Integer CheckidBook() {
//        new CustomverServiceImpl().getAll();
//        new CustomverServiceImpl().disPlay();
//        boolean check = false;
//        int id = 0;
//        while (!check) {
//            System.out.println(" nhap id cua Customer ");
//            id = new Choice().choice();
//            for (int i = 0; i < customers.size(); i++) {
//                if (customers.get(i).getCode() == id) {
//                    check = true;
//                    break;
//                }
//            }
//            if (!check) {
//                System.out.println("id khong dung, moi nhap lai theo danh sanh da hien ");
//            }
//        }
//        return id;
//    }
//}
