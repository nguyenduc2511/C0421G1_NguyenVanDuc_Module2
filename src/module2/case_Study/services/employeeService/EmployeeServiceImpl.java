package module2.case_Study.services.employeeService;


import module2.case_Study.dataCharacter.ReadAndWriteCharacterStream;
import module2.case_Study.models.employee.AcademicLevel;
import module2.case_Study.models.employee.Employee;
import module2.case_Study.models.employee.Gioitinh;
import module2.case_Study.models.employee.PositionChoice;
import module2.case_Study.utils.CheckDateOfBirth;
import module2.case_Study.utils.Choice;
import module2.case_Study.utils.Scan;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static final String filepath = "src\\module2\\case_Study\\data\\Employee.csv";
    private static List<Employee> employees = new ArrayList<>();
    private static final ReadAndWriteCharacterStream readAndWrite = new ReadAndWriteCharacterStream();

    @Override
    public List<Employee> getAll() {
        List<String[]> list = readAndWrite.readFile(filepath);
       employees.clear();
       for(String[] element : list){
           Employee employee = new Employee(Integer.parseInt(element[0]),element[1],element[2],element[3],element[4],
                   element[5],element[6],element[7],element[8], Integer.parseInt(element[9]) );
           employees.add(employee);
       }
        return employees;
    }

    @Override
    public void addNew() {
        new EmployeeServiceImpl().getAll();
        int id;
        if (employees.isEmpty()) {
            id = 1;
        } else {
            id = employees.get(employees.size() - 1).getCode() + 1;
        }
        System.out.println(" nhap ten  ");
        String name = new Scan().inputString();
//        System.out.println(" nhap ngay sinh  ");
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
        System.out.println(" nhap l????ng  ");
        int salary = 0;
        boolean check = true;
        while (check){
            salary =new Choice().choice();
            if(salary == 0){
                System.out.println(" luong > 0 va khong duoc de trong gia tri");
            }else {
                check = false;
            }
        }
        Employee employee = new Employee(id, name, dateBirth, gender, cmnd, numPhone, email, academicLevel, position, salary);
        employees.add(employee);
        String line = employee.getCode()+","+employee.getFullName()+","+employee.getDateOfBirth()+","+employee.getGender()+","+employee.getIdNumber()
                +","+employee.getPhoneNumber()+","+employee.getEmail()+","+employee.getAcademicLevel()+","+employee.getPosition()+","+employee.getSalary();
        readAndWrite.writeData(filepath, line );
    }

    @Override
    public void editData() {
        new EmployeeServiceImpl().getAll();
        System.out.println("nhap id ban muon sua");
        int id = new Choice().choice();
        String lineLocation = "";
        String line = "";
        boolean check2 = true;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == id) {
                lineLocation = employees.get(i).getCode() + "," + employees.get(i).getFullName() + "," + employees.get(i).getDateOfBirth() + "," +
                        employees.get(i).getGender() + "," + employees.get(i).getIdNumber() + "," + employees.get(i).getPhoneNumber() + ","
                        + employees.get(i).getEmail() + "," + employees.get(i).getAcademicLevel() + "," + employees.get(i).getPosition()+","+employees.get(i).getSalary();
                boolean check = true;
                while (check) {
                    System.out.println(employees.get(i).toString());
                    System.out.println("B???n mu???n s???a th??ng tin n??o cho " + employees.get(i).toString());
                    System.out.println("1. Name employee");
                    System.out.println("2. Ng??y sinh");
                    System.out.println("3. Gi???i t??nh");
                    System.out.println("4. S??? Ch???ng minh nh??n d??n");
                    System.out.println("5. S??? ??i???n tho???i");
                    System.out.println("6. ?????a ch??? email");
                    System.out.println("7. Tr??nh ?????");
                    System.out.println("8. V??? tr??");
                    System.out.println("9. Salary");
                    System.out.println("10. thoat edit");
                    int choice = new Choice().choice();
                    switch (choice) {
                        case 1:
                            System.out.println("Nh???p t??n mu???n s???a");
                            String name = new Scan().inputString();
                            employees.get(i).setFullName(name);
                            break;
                        case 2:
                            System.out.println("Nh???p dateOfBirth");
                            String day = new CheckDateOfBirth().CheckDateOfBirth();
                            employees.get(i).setDateOfBirth(day);
                            break;
                        case 3:
                            System.out.println("chon gi???i t??nh");
                            String gender = new Gioitinh().gender();
                            employees.get(i).setDateOfBirth(gender);
                            break;
                        case 4:
                            System.out.println("Nh???p CMND");
                            String idPerson = new Scan().inputString();
                            employees.get(i).setIdNumber(idPerson);
                            break;
                        case 5:
                            System.out.println("Nh???p s??? ??i???n tho???i");
                            String number = new Scan().inputString();
                            employees.get(i).setPhoneNumber(number);
                            break;
                        case 6:
                            System.out.println("Nh???p emailAddress");
                            String email = new Scan().inputString();
                            employees.get(i).setEmail(email);
                            break;
                        case 7:
                            System.out.println("chon tr??nh ?????");
                            String academicLevel = new AcademicLevel().choiceLevel();
                            employees.get(i).setAcademicLevel(academicLevel);
                            break;
                        case 8:
                            System.out.println("Nh???p position");
                            String position = new PositionChoice().positionChoicee();
                            employees.get(i).setPosition(position);
                            break;
                        case 9:
                            System.out.println("Nh???p l????ng");
                            int salary = 0;
                            boolean check3 = true;
                            while (check3){
                                salary =new Choice().choice();
                                if(salary == 0){
                                    System.out.println(" luong > 0 va khong duoc de trong gia tri");
                                }else {
                                    check3 = false;
                                }
                            }
                            employees.get(i).setSalary(salary);
                            break;
                        case 10:
                            check = false;
                            break;
                        default:
                            break;
                    }
                }
                line = employees.get(i).getCode() + "," + employees.get(i).getFullName() + "," + employees.get(i).getDateOfBirth() + "," +
                        employees.get(i).getGender() + "," + employees.get(i).getIdNumber() + "," + employees.get(i).getPhoneNumber() + ","
                        + employees.get(i).getEmail() + "," + employees.get(i).getAcademicLevel() + "," + employees.get(i).getPosition()+","+employees.get(i).getSalary();
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
        String line="";
        boolean check2=true;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == id) {
                boolean check = true;
                while (check) {
                    System.out.println("B???n mu???n xoa employee nay  " + employees.get(i).toString());
                    System.out.println("1. dong y xoa");
                    System.out.println("2. khong xoa");
                    System.out.println(" hay dua ra quyet dinh ");
                    int choice = new Choice().choice();
                    switch (choice){
                        case 1: {

                            line = employees.get(i).getCode() + "," + employees.get(i).getFullName() + "," + employees.get(i).getDateOfBirth() + "," +
                                    employees.get(i).getGender() + "," + employees.get(i).getIdNumber() + "," + employees.get(i).getPhoneNumber() + ","
                                    + employees.get(i).getEmail() + "," + employees.get(i).getAcademicLevel() + "," + employees.get(i).getPosition()+","+employees.get(i).getSalary();
                            check2 = false;
                            check=false;
                            employees.remove(i);
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
        if (check2) {
            System.out.println("khong tim thay id ban vua nhap");
        }
        readAndWrite.removeData(filepath, line);
    }
}
