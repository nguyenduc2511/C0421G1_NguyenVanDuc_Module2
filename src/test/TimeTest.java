package test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    public static void main(String[] args) {
//        LocalDate start = LocalDate.of(1996, 2, 29);
//        LocalDate end = LocalDate.of(2014, 2, 28); // use for age-calculation: LocalDate.now()
//        long years = ChronoUnit.YEARS.between(start, end);
//        System.out.println(years); // 17

        String bir = "25/11/2025";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate_LocalDay = LocalDate.parse(bir, formatter);
        LocalDate currentDate = LocalDate.now();
        int currentAge = Period.between(birthDate_LocalDay, currentDate).getYears();
        long year = ChronoUnit.YEARS.between(birthDate_LocalDay,currentDate);
        System.out.println(year);
        System.out.println(currentAge);;
    }
}
