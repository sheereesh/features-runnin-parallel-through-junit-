package stepDefinations;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class sd_page1 {
	
	@Given("it is given")
	public void it_is_given() {
	    System.out.println("given");
	    System.out.println(Thread.currentThread().getId());
	   
	}
	@When("it is when")
	public void it_is_when() {
	  System.out.println("when");
	  System.out.println(Thread.currentThread().getId());
	  
	}
	@Then("it is then")
	public void it_is_then() {
	    System.out.println("then");
	    System.out.println(Thread.currentThread().getId());
	    
	}

}
