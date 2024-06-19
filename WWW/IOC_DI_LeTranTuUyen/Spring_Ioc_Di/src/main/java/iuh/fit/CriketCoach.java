package iuh.fit;

public class CriketCoach implements Coach {
	private String emailAddress;
	private String team;
	public void setEmailAddress(String mailAddress) {
		System.out.println("CriketCoach: inside setter method -setEmailAddress");
		this.emailAddress = mailAddress;
	}
	public void setTeam(String team) {
		System.out.println("CriketCoach: inside setter method - setteam");
		this.team = team;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getTeam() {
		return team;
	}
	private FortuneService fortuneService;// lay method FortuneService
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	// create a no-arg constructor
	public void CricketCoach() {
		// System.out.println("CriketCoach: inside no-arg constructor");
	}
	// our setter method
	public String getDailyWorkout1() {
		return "CriketCoach: practice fast bowling for 15 minutes ";
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "CriketCoach: practice fast bowling for 15 minutes ";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
