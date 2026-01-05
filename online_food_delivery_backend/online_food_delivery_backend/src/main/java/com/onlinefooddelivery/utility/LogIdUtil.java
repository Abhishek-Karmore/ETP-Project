package com.onlinefooddelivery.utility;

import java.util.UUID;

import javax.persistence.*;


public class LogIdUtil {

	private LogIdUtil() {}

    public static String generateLogId() {
        return UUID.randomUUID().toString();
    }
}