package br.com.origin.exercise.screenplay.components;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SavingGoalsComponents {


    public static final Target SAVING_GOALS_TOTAL_AMOUNT = Target.the("'saving goals amount' input").located(By.xpath("//input[@data-testid='input']"));

    public static final Target CURRENT_SELECTED_MONTH = Target.the("'current reached month' text").located(By.xpath("//p[@data-testid='reachDateMonth']"));

    public static final Target INCREMENT_REACH_MONTH = Target.the("'current reached month increment' element").located(
            By.xpath("//*[@data-testid='reachDateIncrement']"));


    public static final Target MONTHLY_AMOUNT_QUANTITY = Target.the("'monthly amount quantity' text")
            .located(By.xpath("//p[contains(text(), 'Monthly')]/parent::div/following-sibling::div/descendant::p"));

    public static final Target MONTHLY_AMOUNT_TEXT = Target.the("'monthly amount text' text")
            .located(By.xpath("//p[contains(text(), 'Monthly')]"));

    public static final Target MONTH_CHOSEN = Target.the("'month set by application' text")
            .located(By.xpath("//span[@class='bold' and contains(.,'2023')]"));

}
