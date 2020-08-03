package com.twu.refactoring;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

public class DateParser {
    private final String dateAndTimeString;
    private static final HashMap<String, TimeZone> KNOWN_TIME_ZONES = new HashMap<String, TimeZone>();

    static {
        KNOWN_TIME_ZONES.put("UTC", TimeZone.getTimeZone("UTC"));
    }

    /**
     * Takes a date in ISO 8601 format and returns a date
     *
     * @param dateAndTimeString - should be in format ISO 8601 format
     *                          examples -
     *                          2012-06-17 is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17TZ is 17th June 2012 - 00:00 in UTC TimeZone
     *                          2012-06-17T15:00Z is 17th June 2012 - 15:00 in UTC TimeZone
     */
    public DateParser(String dateAndTimeString) {
        this.dateAndTimeString = dateAndTimeString;
    }

    public int judge(int start,int end,String name,int rangStart,int rangeEnd){
        int result;
        int numberCount=end-start;
        try {
            String resultString = dateAndTimeString.substring(start, end);
            result = Integer.parseInt(resultString);
        } catch (StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(name+" string is less than "+numberCount+" characters");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(name+" is not an integer");
        }
        if (result < rangStart || result > rangeEnd)
            throw new IllegalArgumentException(name+" cannot be less than "+rangStart+" or more than "+rangeEnd);
        return result;
    }

    public Date parse() {
        int year=judge(0,4,"Year",2000,2012);
        int month=judge(5,7,"Month",1,12);
        int date=judge(8,10,"Date",1,31);
        int hour=0,minute=0;
        if(!dateAndTimeString.substring(11, 12).equals("Z")){
            hour = judge(11, 13, "Hour", 0, 23);
            minute = judge(14, 16, "Minute", 0, 59);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        calendar.set(year, month - 1, date, hour, minute, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
