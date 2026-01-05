package com.onlinefooddelivery.utility;

import java.lang.reflect.Type;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonStringToObjectConverter {

    private static final Logger LOG = LogManager.getFormatterLogger();
    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonStringToObjectConverter() {
        // utility class
    }

    /**
     * ETP-style JSON → Object conversion
     */
    public static <T> T convert(
            String json,
            String logID,
            Type type) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, mapper.constructType(type));
        } catch (Exception e) {
            LOG.error(logID + " JSON CONVERSION ERROR", e);
            return null;
        }
    }

}