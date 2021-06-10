package com.mdbytes.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		String[] fortunes = {"This was random","That was random","Boy you are random","Man life seems random today"};
		return fortunes[(int)Math.round(Math.random()*(3))];
	}

}
