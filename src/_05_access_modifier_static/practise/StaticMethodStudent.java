package _05_access_modifier_static.practise;

public class StaticMethodStudent {
    private int id;
    private String name;
    private static String college = "University";

    StaticMethodStudent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    static void change() {
        college = "CodeGym Da Nang";
    }
    @Override
    public String toString() {
        return "Th1StaticMethod{" + "id = " + id + ", name = " + name + ", " + college + "}";
    }

    public static void main(String[] args) {
        StaticMethodStudent student1 = new StaticMethodStudent(1, "Anh");
        StaticMethodStudent student2 = new StaticMethodStudent(2, "Be");
        System.out.println(student1.toString());
        System.out.println(student2.toString());

        StaticMethodStudent.change();
        StaticMethodStudent student3 = new StaticMethodStudent(3, "Ce");
        StaticMethodStudent student4 = new StaticMethodStudent(4, "De");
        System.out.println(student3.toString());
        System.out.println(student4.toString());
    }
}
