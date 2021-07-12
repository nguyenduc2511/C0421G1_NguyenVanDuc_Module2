package caseStudy.services.employeeService;

import caseStudy.DataStream.ReadAndWriteByteStream;
import caseStudy.utils.CheckDateOfBirth;
import caseStudy.utils.Scan;
import caseStudy.utils.Choice;
import caseStudy.models.employee.AcademicLevel;
import caseStudy.models.employee.Employee;
import caseStudy.models.employee.Gioitinh;
import caseStudy.models.employee.PositionChoice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static final String filepath = "src\\caseStudy\\data\\Employee.csv";
    private static List<Employee> employees = new ArrayList<>();
    private static final ReadAndWriteByteStream<Employee> readFileByteStream = new ReadAndWriteByteStream<Employee>();

    @Override
    public List<Employee> getAll() {
        employees = readFileByteStream.readFileByteStream(filepath);
        return employees;
    }

    @Override
    public void addNew() {
        new EmployeeServiceImpl().getAll();
        int id = 0;
        if (employees.isEmpty()) {
            id = 1;
        } else {
            id = employees.get(employees.size() - 1).getCode() + 1;
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
        System.out.println(" chon trinh do ");
        String academicLevel = new AcademicLevel().choiceLevel();
        System.out.println(" chon vi tri  ");
        String position = new PositionChoice().positionChoicee();
        System.out.println(" nhap lương  ");
        int salary = 0;
        boolean check = true;
        while (check){
            salary =new Choice().choice();
            if(salary == 0){
                System.out.println(" luong >0 va khong duoc de trong gia tri");
            }else {
                check = false;
            }
        }
        Employee employee = new Employee(id, name, dateBirth, gender, cmnd, numPhone, email, academicLevel, position, salary);
        employees.add(employee);
        readFileByteStream.writeFileByteStream(employees, filepath);
    }

    @Override
    public void editData() {
        new EmployeeServiceImpl().getAll();
        System.out.println("nhap id ban muon sua");
        int id = new Choice().choice();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == id) {
                boolean check = true;
                while (check) {
                    System.out.println("Bạn muốn sửa thông tin nào cho " + employees.get(i).getFullName());
                    System.out.println("1. Name employee");
                    System.out.println("2. Ngày sinh");
                    System.out.println("3. Giới tính");
                    System.out.println("4. Số Chứng minh nhân dân");
                    System.out.println("5. Số điện thoại");
                    System.out.println("6. Địa chỉ email");
                    System.out.println("7. Trình độ");
                    System.out.println("8. Vị trí");
                    System.out.println("9. Salary");
                    System.out.println(" 10. thoat edit");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1:
                            System.out.println("Nhập tên muốn sửa");
                            String name = new Scan().inputString();
                            employees.get(i).setFullName(name);
                            break;
                        case 2:
                            System.out.println("Nhập dateOfBirth");
                            String day = new CheckDateOfBirth().CheckDateOfBirth();
                            employees.get(i).setDateOfBirth(day);
                            break;
                        case 3:
                            System.out.println("chon giới tính");
                            String gender = new Gioitinh().gender();
                            employees.get(i).setDateOfBirth(gender);
                            break;
                        case 4:
                            System.out.println("Nhập CMND");
                            String idPerson = new Scan().inputString();
                            employees.get(i).setIdNumber(idPerson);
                            break;
                        case 5:
                            System.out.println("Nhập số điện thoại");
                            String number = new Scan().inputString();
                            employees.get(i).setPhoneNumber(number);
                            break;
                        case 6:
                            System.out.println("Nhập emailAddress");
                            String email = new Scan().inputString();
                            employees.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("chon trình độ");
                            String academicLevel = new AcademicLevel().choiceLevel();
                            employees.get(i).setAcademicLevel(academicLevel);
                            break;
                        case 8:
                            System.out.println("Nhập position");
                            String position = new PositionChoice().positionChoicee();
                            employees.get(i).setPosition(position);
                            break;
                        case 9:
                            System.out.println("Nhập lương");
                            int salary = new Choice().choice();
                            employees.get(i).setSalary(salary);
                            break;
                        case 10:
                            check = false;
                            break;
                        default:
                            break;
                    }
                }
                break;
            }
        }
        readFileByteStream.clearData(filepath);
        readFileByteStream.writeFileByteStream(employees, filepath);
    }

    @Override
    public void disPlay() {
        new EmployeeServiceImpl().getAll();
        for (Employee lists : employees) {
            System.out.println(lists.toString());
        }
    }

    @Override
    public void remove() {
        new EmployeeServiceImpl().getAll();
        System.out.println("nhap id ban muon xoa");
        int id = new Choice().choice();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == id) {
                boolean check = true;
                while (check) {
                    System.out.println("Bạn muốn xoa employee nay  " + employees.get(i).toString());
                    System.out.println("1. dong y xoa");
                    System.out.println("2. khong xoa");
                    System.out.println(" hay dua ra quyet dinh ");
                    int choice = new Choice().choice();
                    switch (choice){
                        case 1: {
                            employees.remove(i);
                            check=false;
                            break;
                        }
                        case 2:{
                            check=false;
                            break;
                        }
                        default:break;
                    }
                }
                break;
            }
        }
        readFileByteStream.clearData(filepath);
        readFileByteStream.writeFileByteStream(employees, filepath);
    }
}
