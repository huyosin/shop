package com.mono.core.util;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component("jacksonObjectMapper")
public class JacksonObjectMapper extends ObjectMapper {
	private static Logger logger = LoggerFactory.getLogger(JacksonObjectMapper.class);

    private static final long serialVersionUID = 4288193147502386170L;

    private static final Locale CHINA = Locale.CHINA;
    
    public JacksonObjectMapper() {
    	logger.debug("JacksonObjectMapper format date!");
        this.setLocale(CHINA);
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", CHINA));
        this.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }

}
