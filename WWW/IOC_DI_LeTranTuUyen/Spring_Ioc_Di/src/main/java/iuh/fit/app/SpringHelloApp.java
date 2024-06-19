package iuh.fit.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.Coach;

public class SpringHelloApp {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context= 
				new  ClassPathXmlApplicationContext
				("applicationContext.xml");
		//retrieve bean from spring container 
		Coach theCoachtennis= context.getBean("myTennisCoach",Coach.class);
		System.out.println(theCoachtennis.getDailyWorkout());
		System.out.println(theCoachtennis.getDailyFortune());
		/*
		 * Coach theCoach= context.getBean("myCricketCoach",Coach.class);
		 * System.out.println(theCoach.getDailyWorkout());
		 * System.out.println(theCoach.getDailyFortune()); CricketCoach 
				mycriket=
		 * (CricketCoach) context.getBean("myCricketCoach",Coach.class);
		 * System.out.println(mycriket.getEmailAddress());
		 * System.out.println(mycriket.getTeam());
		 */
		/*
		 * CricketCoach theCricketCoach=
		 * context.getBean("myCricketCoach",CricketCoach.class);
		 * System.out.println(theCricketCoach.getEmailAddress());
		 * System.out.println(theCricketCoach.getTeam());
		 */
		//close the context
		context.close();
	}
}


