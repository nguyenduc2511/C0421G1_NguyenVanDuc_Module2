package module2._20_08_test.bai_lam_them_fix_bug;

public class Student {
    private static String school = "Codegym";
    private int id;
    private String name;
    private  int AGE;
    private Address address;

    public Student() {
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static String getSchool() {
        return school;
    }

    public static void setSchool(String school) {
        Student.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name, int AGE, Address address) {
        this.id = id;
        this.name = name;
        this.AGE = AGE;
        this.address = address;
    }

    public Student(int id, String name, int AGE) {
        this.id = id;
        this.name = name;
        this.AGE = AGE;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", AGE=" + AGE +
                ", " + address + ", school=" + school+
                '}';
    }
}
