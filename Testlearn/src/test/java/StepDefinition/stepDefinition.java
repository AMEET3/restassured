package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {


@Given("I want to write a step with precondition")
public void i_want_to_write_a_step_with_precondition() {
    // Write code here that turns the phrase above into concrete actions
	
	System.out.println("Test");
    throw new cucumber.api.PendingException();
}

@Given("some other precondition")
public void some_other_precondition() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Test");
    throw new cucumber.api.PendingException();
}

@When("I complete action")
public void i_complete_action() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Test");
    throw new cucumber.api.PendingException();
}

@When("some other action")
public void some_other_action() {
	System.out.println("Test");
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@When("yet another action")
public void yet_another_action() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Test");
    throw new cucumber.api.PendingException();
}

@Then("I validate the outcomes")
public void i_validate_the_outcomes() {
	System.out.println("Test");
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@Then("check more outcomes")
public void check_more_outcomes() {
	System.out.println("Test");
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@Given("I want to write a step with name{int}")
public void i_want_to_write_a_step_with_name(Integer int1) {
	
	System.out.println("Test "+int1);
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@When("I check for the {int} in step")
public void i_check_for_the_in_step(Integer int1) {
	System.out.println("Test "+int1+1);
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@Then("I verify the success in step")
public void i_verify_the_success_in_step() {
	System.out.println("Test ");
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}

@Then("I verify the Fail in step")
public void i_verify_the_Fail_in_step() {
    // Write code here that turns the phrase above into concrete actions
    throw new cucumber.api.PendingException();
}


	
}
