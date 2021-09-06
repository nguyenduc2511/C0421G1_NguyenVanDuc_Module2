package module2.case_Study.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class CheckDateOfBirth {
    public String CheckDateOfBirth() {
        String regexCheck = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        String dateOfbirth = null;
        boolean check = false;
        while (!check) {
            System.out.println(" nhap ngay sinh của bạn theo đúng định dạng dd/MM/yyyy; vd 11/11/1991");
            dateOfbirth = new Scan().inputString();
            if (Pattern.matches(regexCheck, dateOfbirth)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate birthDate_LocalDay = LocalDate.parse(dateOfbirth, formatter);
                LocalDate currentDate = LocalDate.now();
                int currentAge2 = Period.between(birthDate_LocalDay, currentDate).getYears();
//            cach tinh 1:
//            int currentAge = Period.between(birthDate_LocalDay, currentDate).getYears();
//            cach tinh 2:
                long age = ChronoUnit.YEARS.between(birthDate_LocalDay, currentDate);
                long age2 = ChronoUnit.DAYS.between(birthDate_LocalDay, currentDate);
                if (age < 100 && age > 18) {
                    check = true;
                } else {
                    System.out.println(" tuoi cua ban phai lon hon 18 va duoi 100 tuoi");
                }
            } else {
                System.out.println(" dịnh dạng ngày phải theo dd/MM/yyyy vd: 11/11/1991. hãy kiểm tra và điền lại ngày theo định dạng ");
            }
        }
        return dateOfbirth;
    }

}

