package com.study.myapp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {
	
//	private static final Logger log = org.slf4j.LoggerFactory.getLogger(LogTest.class);
	
	public static void main(String[] args) {
		log.error("error");
		log.warn("warn");
		log.info("info");
		log.debug("debug");
		log.trace("trace"); // 설정 level 이 debug 로 설정되어 있기 때문에, 표시 X 
	}
}
