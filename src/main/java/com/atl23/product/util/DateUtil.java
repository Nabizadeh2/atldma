package com.atl23.product.util;

import com.atl23.product.dto.ProductResponseDto;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {



    public static String getFormatter(LocalDateTime time,boolean showTime){
        if(showTime){
            return time.format(DateTimeFormatter.ofPattern("dd:MM:yyyy"));
        }
        return time.format(DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss"));
    }


}
