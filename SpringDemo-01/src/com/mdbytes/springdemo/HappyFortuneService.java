package com.mdbytes.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		String[] happyFortunes = {"Oh happy day!","Way to go!","You rock!","Face it, you rock!"};
		
		int randomNumber = (int) Math.round(Math.random()*4);
		
		return happyFortunes[randomNumber];
	}

}
