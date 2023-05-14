package com.example.hamster.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateUtils {

    /**
     * 日期转为LocalDateTime
     *
     * @param date 日期
     * @return LocalDateTime
     */
    public static LocalDateTime dateToLocalDateTime(final Date date) {
        if (null == date) {
            return null;
        }
        final Instant instant = date.toInstant();
        final ZoneId zoneId = ZoneId.systemDefault();
        final LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }
    /**
     * 日期转为LocalDate
     *
     * @param date 日期
     * @return LocalDateTime
     */
    public static LocalDate dateToLocalDate(final Date date) {
        if (null == date) {
            return null;
        }
        final Instant instant = date.toInstant();
        final ZoneId zoneId = ZoneId.systemDefault();
        final LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return localDate;
    }

    /**
     * LocalDateTime转为日期
     *
     * @param localDateTime LocalDateTime
     * @return 日期
     */
    public static Date localDateTimeToDate(final LocalDateTime localDateTime) {
        if (null == localDateTime) {
            return null;
        }
        final ZoneId zoneId = ZoneId.systemDefault();
        final ZonedDateTime zdt = localDateTime.atZone(zoneId);
        final Date date = Date.from(zdt.toInstant());
        return date;
    }

    /**
     * LocalDate转为日期
     *
     * @param localDate
     * @return
     */
    public static Date localDateToDate(final LocalDate localDate) {
        if (null == localDate) {
            return null;
        }
        final ZoneId zoneId = ZoneId.systemDefault();
        final ZonedDateTime zdt = localDate.atStartOfDay().atZone(zoneId);
        final Date date = Date.from(zdt.toInstant());
        return date;
    }

    public static Double countWorkHours(Date startTime, Date endTime) {

    	LocalDateTime start = handleTime(startTime);
    	LocalDateTime end = handleTime(endTime);

    	Duration duration = Duration.between(start,end);

    	System.out.println(duration.toMinutes());

		return (double)duration.toMinutes() / 60.0;

    }

    public static LocalDateTime handleTime(Date time) {

    	LocalDateTime temp = dateToLocalDateTime(time);

    	int minute = temp.getMinute();

    	if (minute <15){
    		return temp.withMinute(0).withSecond(0);
    	} else if( minute <= 45) {
    		return temp.withMinute(30).withSecond(0);
    	} else {
    		return temp.plusHours(1).withMinute(0).withSecond(0);
    	}
    }

    public static void main(String[] args) throws ParseException {

    	SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date dtBeg = simFormat.parse("2023-05-13 11:00:30");
    	Date dtBeg2= simFormat.parse("2023-05-13 23:46:29");
    	System.out.println(countWorkHours(dtBeg,dtBeg2));
	}

}
