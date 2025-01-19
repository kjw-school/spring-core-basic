package org.kjw.springcorebasic.web;

import org.kjw.springcorebasic.common.MyLogger;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	private final MyLogger myLogger;

	public void logic(String id) {
		myLogger.log("service id = " + id);
	}

}
