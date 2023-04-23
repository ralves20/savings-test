package br.com.origin.exercise.screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.targets.TheTarget;

import static br.com.origin.exercise.screenplay.components.SavingGoalsComponents.CURRENT_SELECTED_MONTH;
import static br.com.origin.exercise.screenplay.components.SavingGoalsComponents.INCREMENT_REACH_MONTH;

public class DefineTheMonthReachGoal implements Task {
    String monthReachGoal;

    public DefineTheMonthReachGoal(String monthReachGoal) {
        this.monthReachGoal = monthReachGoal;
    }

    public static DefineTheMonthReachGoal withValue(String monthReachGoal) {
        return Instrumented.instanceOf(DefineTheMonthReachGoal.class).withProperties(monthReachGoal);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int i = 0;
        while (i <= 12) {
            if (TheTarget.textOf(CURRENT_SELECTED_MONTH).answeredBy(actor).equalsIgnoreCase(monthReachGoal))
                break;

            else {
                actor.attemptsTo(Click.on(INCREMENT_REACH_MONTH));
                i++;
            }


        }

    }
}
