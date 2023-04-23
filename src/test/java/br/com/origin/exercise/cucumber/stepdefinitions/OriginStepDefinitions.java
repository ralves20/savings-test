package br.com.origin.exercise.cucumber.stepdefinitions;

import br.com.origin.exercise.screenplay.questions.TheMonthlyAmount;
import br.com.origin.exercise.screenplay.tasks.DefineTheMonthReachGoal;
import br.com.origin.exercise.screenplay.tasks.FillTheTotalAmount;
import br.com.origin.exercise.screenplay.tasks.Start;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

import static br.com.origin.exercise.screenplay.components.SavingGoalsComponents.MONTHLY_AMOUNT_QUANTITY;
import static br.com.origin.exercise.screenplay.components.SavingGoalsComponents.MONTH_CHOSEN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;

public class OriginStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is at Origin Saving Goals application")
    public void actorIsAtOriginSavingGoalsApplication(String actor) {
        theActorCalled(actor).attemptsTo(Start.atOriginExerciseHomePage());
    }

    @When("^(s)?he defines his goal with an amount of \"(.*)\" to be reached by the date of \"(.*)\" month")
    public void definesHisGoalWithAnAmountOfToBeReachedByTheDateOfMonth(String savingAmount, String monthReachGoal) {
        theActorInTheSpotlight().remember("monthReachGoal", monthReachGoal);
        theActorInTheSpotlight().attemptsTo(
                FillTheTotalAmount.withValueOf(savingAmount),
                DefineTheMonthReachGoal.withValue(monthReachGoal)
        );
    }

    @Then("^(s)?he should see that the monthly amount information is filled")
    public void shouldSeeThatTheMonthlyAmountInformationIsFilled() {
        theActorInTheSpotlight().should(
                seeThat(TheTarget.textOf(MONTHLY_AMOUNT_QUANTITY), is(not(emptyOrNullString())))
        );
    }

    @And("^(s)?he should see that the text below the monthly amount shows the month to be reached")
    public void shouldSeeThatTheTextBelowTheMonthlyAmountShowsTheMonthToBeReached() {
        String monthReachGoalRemembered = theActorInTheSpotlight().recall("monthReachGoal");
        theActorInTheSpotlight().should(
                seeThat(TheTarget.textOf(MONTH_CHOSEN), containsString(monthReachGoalRemembered))
        );
    }

    @Then("^(s)?he should see that the monthly amount information is equals zero")
    public void shouldSeeThatTheMonthlyAmountInformationIsEqualsZero() {
        theActorInTheSpotlight().should(
                seeThat(TheMonthlyAmount.value(), is(equalTo("0")))
        );
    }
}
