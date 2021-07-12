package caseStudy.utils;

public class Choice {
    public Integer choice(){
        int choice = 0;
        try {
            choice = Integer.parseInt(new Scan().inputString());
        } catch (NumberFormatException ex) {
            System.out.println("ban phai gia tri so, vui long nhap lai: ");
        }
        return choice;
    }
}
