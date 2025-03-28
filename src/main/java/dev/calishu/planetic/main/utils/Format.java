package dev.calishu.planetic.main.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Format {

    public static String unixTimestamp(Integer timestamp) {
        Instant instant = Instant.ofEpochSecond(timestamp);
        LocalDateTime datetime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(timestamp + "  " + instant + "  " + datetime);
    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return datetime.format(formatter);
    }

}
