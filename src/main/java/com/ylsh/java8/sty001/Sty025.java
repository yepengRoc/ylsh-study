package com.ylsh.java8.sty001;

import org.joda.primitives.list.IntList;
import org.joda.primitives.list.impl.ArrayIntList;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Date;


public class Sty025 {

    @Test
    public void test(){

        IntList list = new ArrayIntList();

        list.add(1);
        list.add(2);
        list.forEach(System.out::println);
    }

    @Test
    public void test1(){
      DateTime tody = new DateTime();

        DateTime tommorrow = tody.plusDays(1);//加一天

         DateTime d1 = tody.withDayOfMonth(1);

         d1.toString("yyyy-MM-dd");

        LocalDate localDate = new LocalDate();
        localDate = localDate.plusMonths(3).dayOfMonth().withMinimumValue();

        DateTime dateTime= new DateTime();

        //两年前 第3个月 最后一天
        DateTime d2 = dateTime.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMinimumValue();
    }

    @Test
    public void test3() throws Exception{
//        DateTime dateTime= new DateTime();
        /**
         * DateTime 源码查看
         */
        System.out.println(Sty025.convertUTC2Date("2020-01-11T09:22:54.876z"));
        System.out.println(Sty025.convertDate2UTC(new Date()));
        System.out.println(Sty025.convertDate2LocalByDateFormat(new Date(), "yyyy-MM-dd HH:mm:ss"));


    }

    public static Date convertUTC2Date(String utcDate) throws Exception{

        DateTime dateTime =  DateTime.parse(utcDate, DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss:SSSz"));
        return dateTime.toDate();
    }

    public static String convertDate2UTC(Date javaDate){
        DateTime dateTime = new DateTime(javaDate, DateTimeZone.UTC);
        return dateTime.toString();
    }

    public static String convertDate2LocalByDateFormat(Date javaDate,String dateFormat){
        DateTime dateTime = new DateTime(javaDate);
        return dateTime.toString(dateFormat);

    }
}
