package com.example.kmupbl3.tool;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class TimeTool {

    public static Timestamp timeStringToTimestamp(String before) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date parsedDate = dateFormat.parse(before);
            return new Timestamp(parsedDate.getTime());
        } catch(Exception e) { //this generic but you can control another types of exception
            // look the origin of excption
            log.error("Error occured whlist parsing Timestamp from time string " + before, e);
        }
        log.warn("Something went wrong! Unreachable statement reached in: " + "DummyDataGenerator.timeStringToTimestamp(" + before + ")");
        return null;  // Unreachable
    }

    public static Timestamp convertLongToTimestamp(Long timeInMilliseconds) {
        if (timeInMilliseconds == null) {
            return null;
        }
        return new Timestamp(timeInMilliseconds);
    }

}
