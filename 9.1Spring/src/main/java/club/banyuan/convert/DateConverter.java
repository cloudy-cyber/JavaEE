package club.banyuan.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
        if(!StringUtils.isEmpty(s)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(s);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
