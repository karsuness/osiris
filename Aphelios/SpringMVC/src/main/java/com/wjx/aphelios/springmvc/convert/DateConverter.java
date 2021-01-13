package com.wjx.aphelios.springmvc.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WJX
 * @since 2018/4/25 18:36
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if (!StringUtils.isEmpty(source)) {
                Date date = format.parse(source);
                return date;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
