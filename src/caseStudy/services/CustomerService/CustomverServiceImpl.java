package caseStudy.services.CustomerService;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.utils.Scan;
import caseStudy.utils.Choice;
import caseStudy.models.Customer.Customer;
import caseStudy.models.Customer.TypeCustomer;
import caseStudy.models.employee.Gioitinh;
import caseStudy.utils.CheckDateOfBirth;
import module2.case_Study.models.facility.Room;

import java.util.LinkedList;
import java.util.List;

public class CustomverServiceImpl implements CustomerService {
    private static final String filepath = "src\\caseStudy\\data\\Customer.csv";
    public static List<Customer> customers = new LinkedList<>();
    public static final ReadAndWriteByteStream<Customer> readAndWriteByteStream = new ReadAndWriteByteStream<Customer>();

    @Override
    public List<Room> getAll() {
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

        Customer customer = new Customer(id, name, dateBirth, gender, cmnd, numPhone, email, typeCustomer, address);
        customers.add(customer);
        readAndWriteByteStream.writeFileByteStream(customers, filepath);
    }

    @Override
    public void editData() {
        new CustomverServiceImpl().getAll();
        new CustomverServiceImpl().disPlay();
        System.out.println("nhap id ban muon sua");
        int id = new Choice().choice();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCode() == id) {
                boolean check = true;
                while (check) {
                    System.out.println("B???n mu???n s???a th??ng tin n??o cho " + customers.get(i).toString());
                    System.out.println("1. Name customers");
                    System.out.println("2. Ng??y sinh");
                    System.out.println("3. Gi???i t??nh");
                    System.out.println("4. S??? Ch???ng minh nh??n d??n");
                    System.out.println("5. S??? ??i???n tho???i");
                    System.out.println("6. ?????a ch??? email");
                    System.out.println("7. loai customers");
                    System.out.println("8. dia chi ");
                    System.out.println("9. thoat edit");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1:
                            System.out.println("Nh???p t??n mu???n s???a");
                            String name = new Scan().inputString();
                            customers.get(i).setFullName(name);
                            break;
                        case 2:
                            System.out.println("Nh???p dateOfBirth");
                            String day = new CheckDateOfBirth().CheckDateOfBirth();
                            customers.get(i).setDateOfBirth(day);
                            break;
                        case 3:
                            System.out.println("chon gi???i t??nh");
                            String gender = new Gioitinh().gender();
                            customers.get(i).setGender(gender);
                            break;
                        case 4:
                            System.out.println("Nh???p CMND");
                            String idPerson = new Scan().inputString();
                            customers.get(i).setIdNumber(idPerson);
                            break;
                        case 5:
                            System.out.println("Nh???p s??? ??i???n tho???i");
                            String number = new Scan().inputString();
                            customers.get(i).setPhoneNumber(number);
                            break;
                        case 6:
                            System.out.println("Nh???p emailAddress");
                            String email = new Scan().inputString();
                            customers.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("loai customer ");
                            String typeCustomer = new TypeCustomer().choiCustomer();
                            customers.get(i).setCustomerType(typeCustomer);
                            break;
                        case 8:
                            System.out.println("Nh???p dia chi ");
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
                    System.out.println("B???n mu???n xoa employee nay  " + customers.get(i).toString());
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
