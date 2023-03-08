package servises;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateService {

    public static String convertDateFormDB(String date){
        String dateForDB;
        try {
            DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date formattedDate = format.parse(date);
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateForDB = formatter.format(formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException("Ошибка в форматировании даты.");
        }
        return dateForDB;
    }
}
