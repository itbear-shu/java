package me.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    DateUtils() {}
    public String dataToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String string = sdf.format(date);
        return string;
    }
    public Date stringToDate(String s, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date parse = sdf.parse(s);
        return parse;
    }
}
