package com.ylsh.java8.sty001;

import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

public class Sty026 {

    public void test(){
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getYear() + ","+localDate.getMonthValue() + "," + localDate.getDayOfMonth());

        LocalDate localDate1 = LocalDate.of(2018, 8, 8);
        System.out.println(localDate1);
        System.out.println("==========");


    }

    @Test
    public void test1(){
        LocalDate localDate = LocalDate.of(2010, 3, 25);
        MonthDay monthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        MonthDay monthDay1 = MonthDay.from(LocalDate.of(2011, 3, 26));

        if(monthDay.equals(monthDay1)){
            System.out.println("eq");
        }else{
            System.out.println("not eq");
        }
    }

    @Test
    public void test2(){
        LocalTime time = LocalTime.now();

        LocalTime time1 = time.plusHours(2).plusMinutes(20);
    }

    @Test
    public void test3(){
        LocalDate localDate = LocalDate.now();

        localDate.plus(2, ChronoUnit.WEEKS);
        localDate.minus(2, ChronoUnit.MONTHS);
    }

    @Test
    public void test4(){
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

    }
    @Test
    public void test5(){

        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2021, 10, 11);

        System.out.println(localDate.isAfter(localDate1));
        System.out.println(localDate.isBefore(localDate1));
        System.out.println(localDate.equals(localDate1));
    }

    @Test
    public void test6(){
        Set<String> set = ZoneId.getAvailableZoneIds();
        Set<String> stringSet = new TreeSet<String>(){
            {
                addAll(set);
            }
        };
        stringSet.forEach(System.out::println);
    }

    /**
     * 设置时区
     */
    @Test
    public void test7(){
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);
    }

    @Test
    public void test8(){
        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.isLeapYear());
System.out.println("---------");
        YearMonth yearMonth1 = YearMonth.of(2020,6);
        System.out.println(yearMonth1);
        System.out.println(yearMonth1.lengthOfMonth());
        System.out.println(yearMonth1.isLeapYear());
    }


    @Test
    public void test9(){
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2021, 10, 11);

        Period period = Period.between(localDate, localDate1);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }


}
