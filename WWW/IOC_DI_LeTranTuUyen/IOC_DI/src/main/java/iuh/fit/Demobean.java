package iuh.fit;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demobean {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new
		ClassPathXmlApplicationContext("applicationContext.xml");
		Employee e = context.getBean("e", Employee.class);
		e.show();
	}

}


