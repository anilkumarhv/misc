package com.company.java8.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* @author DateTimeExample
 * @return
 * JAVA 8 Date and Time API
 * @link more details https://dzone.com/articles/java-8-date-and-time
 * */
public class DateTimeExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 2, 13);
        System.out.println(date.getDayOfWeek().toString());
        LocalDate date1 = LocalDate.parse("2018-02-13");
        System.out.println(date1);

        LocalTime time = LocalTime.of(12, 35);
        LocalTime time1 = LocalTime.parse("12:35");
        System.out.println(time);
        System.out.println(time1);

        LocalDateTime dateTime = LocalDateTime.of(2018, 2, 13, 6, 30);
        LocalDateTime dateTime1 = LocalDateTime.parse("2018-02-13T06:30");
        System.out.println(dateTime);
        System.out.println(dateTime1);


//      LocalDateTime to LocalDate/LocalTime
        LocalDate ld = LocalDateTime.parse("2018-02-13T06:30").toLocalDate();
        LocalTime lt = LocalDateTime.parse("2018-02-13T06:30").toLocalTime();
        System.out.println(ld);
        System.out.println(lt);

//        convert Date to LocaleDateTime
        LocalDateTime ldt = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        System.out.println(ldt);

        Date now = new Date();
// represents 2018-02-28T23:24:43.106
        LocalDateTime dateTime2 = LocalDateTime.ofInstant(now.toInstant(), ZoneId.systemDefault());
// represent Wed Feb 28 23:24:43 CET 2018
        Date date2 = Date.from(dateTime2.toInstant(ZoneOffset.ofHours(1)));
        Date date3 = Date.from(dateTime2.toInstant(ZoneId.systemDefault().getRules().getOffset(dateTime2)));
        System.out.println(date2);
        System.out.println(date3);

        /* Date Duration and Period */
        Period period = Period.between(LocalDate.parse("2020-01-01"), LocalDate.now());
        System.out.println(period);
        Duration duration = Duration.between(LocalDateTime.of(LocalDate.of(2020, 1, 1), LocalTime.of(1, 0)), LocalDateTime.now());
//        Duration duration = Duration.between(LocalDateTime.parse("2020-01-01T06:30"), LocalDateTime.parse("2020-02-13T22:58"));

        System.out.println(duration.toDays());
        long hours = LocalDateTime.parse("2020-01-01T06:30").until(LocalDateTime.now(), ChronoUnit.DAYS);
        System.out.println(hours);

        System.out.println("OffsetDateTime");
        OffsetDateTime offsetDateTime = LocalDateTime.now().atOffset(ZoneOffset.ofHoursMinutes(4, 30));
//        Uses DateTimeFormatter.ISO_OFFSET_DATE_TIME for which the default format is
//        ISO_LOCAL_DATE_TIME followed by the offset ("+HH:mm:ss").
        OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime1);
        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.of("Europe/Paris"));
//       Uses DateTimeFormatter.ISO_ZONED_DATE_TIME for which the default format is
//       ISO_OFFSET_DATE_TIME followed by the the ZoneId in square brackets.
        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2018-02-14T06:30+08:00[Asia/Macau]");
//      note that the offset does not matter in this case.
//      The following example will also return an offset of +08:00
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2018-02-14T06:30+06:00[Asia/Macau]");
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);

        OffsetDateTime utc = OffsetDateTime.now(ZoneOffset.UTC);
        System.out.println(utc);
        ZonedDateTime zdt = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("Europe/Rome"));
        System.out.println(zdt);


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][dd/MM/yyyy][MM-dd-yyyy]");
        LocalDate ldate=LocalDate.parse("01-01-2020", formatter);
        System.out.println(ldate);
        System.out.println(LocalDate.now().format(formatter));
        //Date.from(dateTime2.toInstant(ZoneId.systemDefault().getRules().getOffset(dateTime2)));
        Date convertDate=Date.from(LocalDateTime.now().toInstant(ZoneOffset.ofHoursMinutes(5,30)));
        System.out.println(convertDate);
        Date convertDate1=Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(convertDate1);
        System.out.println(DateUtils.asDate(LocalDate.now()));
        System.out.println(DateUtils.asDate(LocalDateTime.now()));
        System.out.println(DateUtils.asLocalDate(new Date()));
        System.out.println(DateUtils.asLocalDateTime(new Date()));

        System.out.println("Display all ZONE ID");
        Arrays.stream(TimeZone.getAvailableIDs()).forEach(zone -> {
            System.out.println(displayTimeZone(TimeZone.getTimeZone(zone)));
        });

//        Runnable drawRunnable = ()-> System.out.println("draw");
//        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
//        exec.scheduleAtFixedRate(drawRunnable , 0, 1, TimeUnit.MINUTES);
    }

    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours);
        // avoid -4:-30 issue
        minutes = Math.abs(minutes);

        String result = "";
        if (hours > 0) {
            result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
        } else {
            result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
        }

        return result;

    }
}
