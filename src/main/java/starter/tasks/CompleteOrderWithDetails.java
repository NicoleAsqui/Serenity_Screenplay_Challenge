package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompleteOrderWithDetails implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue("Nicole Asqui Manzaba").into(By.id("name")),
                Enter.theValue("Ecuador").into(By.id("country")),
                Enter.theValue("Guayaquil").into(By.id("city")),
                Enter.theValue("Mastercard").into(By.id("card")),
                Enter.theValue("Junio").into(By.id("month")),
                Enter.theValue("2003").into(By.id("year")),
                Click.on(By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary"))
        );
    }

    public static CompleteOrderWithDetails now() {
        return instrumented(CompleteOrderWithDetails.class);
    }
}
