package module2.case_Study.models.employee;

import java.io.Serializable;

public class Employee extends Person implements Serializable {
    private String  academicLevel;
    private String position;
    private int salary;

    public Employee() {
    }

    public Employee(String academicLevel, String position, int salary) {
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public Employee(Integer code, String fullName, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String academicLevel, String position, int salary) {
        super(code, fullName, dateOfBirth, gender, idNumber, phoneNumber, email);
        this.academicLevel = academicLevel;
        this.position = position;
        this.salary = salary;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "" + super.toString()+
                ", qualification ='" + academicLevel + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
