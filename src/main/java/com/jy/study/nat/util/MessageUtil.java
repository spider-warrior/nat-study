package com.jy.study.nat.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jy.study.nat.entity.Message;

import java.io.IOException;

public class MessageUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static byte[] translate(Message out) throws JsonProcessingException {
        return mapper.writeValueAsBytes(out);
    }

    public static Message translate(byte[] in) throws IOException {
        return mapper.readValue(in, Message.class);
    }

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
