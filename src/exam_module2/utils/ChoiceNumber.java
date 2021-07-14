package exam_module2.utils;

public class ChoiceNumber {
    public Integer choice(){
        int choice = 0;
        try {
            choice = Integer.parseInt(new InputString().inputString());
        } catch (NumberFormatException ex) {
            System.out.println("Bạn phải nhập số, vui lòng nhập lại ");
        }
        return choice;
    }
}
