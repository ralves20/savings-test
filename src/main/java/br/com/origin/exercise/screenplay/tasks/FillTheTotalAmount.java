package br.com.origin.exercise.screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static br.com.origin.exercise.screenplay.components.SavingGoalsComponents.SAVING_GOALS_TOTAL_AMOUNT;

public class FillTheTotalAmount implements Task {

    String totalAmount;

    public FillTheTotalAmount(String totalAmount){
        this.totalAmount = totalAmount;
    }

    public static FillTheTotalAmount withValueOf(String totalAmount) {
        return Instrumented.instanceOf(FillTheTotalAmount.class).withProperties(totalAmount);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               Enter.theValue(totalAmount).into(SAVING_GOALS_TOTAL_AMOUNT)
       );
    }
}
