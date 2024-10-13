package de.telran.hw_23_11okt_Date_Time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class MainTask1_DateTime {
//1) реализовать метод, который принимает год и проверяет
// на високосность
//2) вывести на консоль дату локализованную для Индии (например)
//3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
//4) создать дату своего рождения,
// вывести на консоль в формате "10 Января 1985"
//5) проверить дата "10 Января 1985" - это пятница,
// попробуйте получить день недели для любой другой даты?
//6) вычесть 10 лет из созданной даты, вывести на консоль
//7) получить ZonedDateTime из "Pacific/Midway", вывести на консоль

//8)* получить возраст человека на текущий момент, если известна его дата рождения.
//9)* Вы просыпаетесь и смотрите на будильник. Вам на работу нужно на 9 часов. Узнайте, сколько времени
//    осталось еще до начала работы или если вы проспали, то на сколько. -- не дошли руки

    public static void main(String[] args) {
        //1) реализовать метод, который принимает год и проверяет
// на високосность
        Scanner scanner = new Scanner(System.in);
        System.out.println(" введите год который нужно проверить на високосность");
        int year = scanner.nextInt();
        Boolean isLeap = new GregorianCalendar().isLeapYear(year);  // нашёл готовую функцию, как Вы подсказали
        System.out.println(isLeap ? year + " год является високосным " : year + " год не является високосным ");
        System.out.println();
        scanner.close();

        //2) вывести на консоль дату локализованную для Индии (например)

        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));   // Получаем текущую дату и время в Индии

        // Определяем локализованный формат для Индии
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss", new Locale("hi", "IN"));

        System.out.println("Задание 2 . Локализованная дата для Индии: " + indiaTime.format(formatter));
        System.out.println();

//3) вывести дату в формате 19-12-22, 19, 353, 11:47 <дата, день месяца, день в году, время>
        ZonedDateTime currentTime = ZonedDateTime.now();

        Locale locale = new Locale("uk");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yy, d, D, HH:mm", locale);

        System.out.println("3) вывести дату в формате 19-12-22, 19, 353, 11:47 = " + currentTime.format(formatter1));
        System.out.println();

        //4) создать дату своего рождения,
// вывести на консоль в формате "10 Января 1985"

        LocalDate birthday = LocalDate.of(1976, 3, 6);
        Locale locale4 = new Locale("ru");
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("d MMMM yyyy", locale4);
        System.out.println("Дата моего рождения : " + birthday.format(formatter4));
        System.out.println();

        //5) проверить дата "10 Января 1985" - это пятница,
// попробуйте получить день недели для любой другой даты?

//      ********* написал вроде, но к сожалению не получилось отладить **********
     //   ********* проверьте , пожалуйста и подскажите в чем проблема *********

//        // String date5_string= "10 Января 1985";
//        // Определяем формат даты с помошью к-го будем парсить
//        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
//
//        // Парсим дату "10 Января 1985"
//        LocalDate date5 = LocalDate.parse("10 Января 1985", formatter5);
//
//        // Получаем день недели для этой даты
//        DayOfWeek dayOfWeek = date5.getDayOfWeek();
//
//        // Проверка, была ли это пятница
//        System.out.println(dayOfWeek == DayOfWeek.FRIDAY ? "это была пятница" : "Нет, это был " + dayOfWeek );


       //   Получение дня недели для любой  вводимой даты сделаем  по тому же алгоритму
//        Scanner scanner5 = new Scanner(System.in);
//        System.out.println(" введите дату , для которой вы хотите узнать день недели в формате : 10 Января 1985 ");
//        String scanDate = scanner.nextLine();
//        LocalDate date5scanDate= LocalDate.parse(scanDate, formatter5);
//        DayOfWeek dayOfWeek_scanDate= date5scanDate.getDayOfWeek();
//        System.out.println(" дата "+ scanner5 + " это был день недели = "+ dayOfWeek_scanDate);

//6) вычесть 10 лет из созданной даты, вывести на консоль
        LocalDate localDate6 = LocalDate.of(2021, 7, 7);
        System.out.println(" созданная дата = "+ localDate6);
        System.out.println(" созданная дата - 10 лет = "+ localDate6.minusYears(10));
        System.out.println();

//7) получить ZonedDateTime из "Pacific/Midway", вывести на консоль
        ZoneId zoneId7 = ZoneId.of("Pacific/Midway");
        ZonedDateTime zoneDateTime7 =  ZonedDateTime.now(zoneId7);
        System.out.println("ZonedDateTime из Pacific/Midway =   "+ zoneDateTime7);
        System.out.println();

        //8)* получить возраст человека на текущий момент, если известна его дата рождения.

        String birthDateString = "10-07-2005";
        System.out.println(" дата рождения человека "+birthDateString);
        // Форматтер для преобразования строки в дату
        DateTimeFormatter formatter8 = DateTimeFormatter.ofPattern("dd-MM-yyyy", new Locale("uk"));

        LocalDate birthDate8 = LocalDate.parse(birthDateString, formatter8); // парсим строку в дату
        LocalDate currentDate8 = LocalDate.now();  // Текущая дата
        Period age = Period.between(birthDate8, currentDate8); // Вычисляем возраст с помощью класса Period

        System.out.println("Возраст этого человека: " + age.getYears() + " лет, " + age.getMonths() + " месяца,  " + age.getDays() + " дней");

    }

}
