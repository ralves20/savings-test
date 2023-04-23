package br.com.origin.exercise.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static br.com.origin.exercise.screenplay.components.SavingGoalsComponents.MONTHLY_AMOUNT_QUANTITY;

public class TheMonthlyAmount implements Question<String> {
    public static TheMonthlyAmount value() {
        return new TheMonthlyAmount();
    }

    @Override
    public String answeredBy(Actor actor) {
        String initialText = Text.of(MONTHLY_AMOUNT_QUANTITY).viewedBy(actor).asString();
        String formattedText = initialText.replaceAll("[^\\d.]", "");

        return formattedText;
    }

}
