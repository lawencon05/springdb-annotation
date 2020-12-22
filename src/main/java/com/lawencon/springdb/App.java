package com.lawencon.springdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppCall caller = context.getBean(AppCall.class);
		caller.call();
		((AnnotationConfigApplicationContext) context).close();
	}
}
