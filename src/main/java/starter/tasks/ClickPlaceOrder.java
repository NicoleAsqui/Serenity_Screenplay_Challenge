package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;

public class ClickPlaceOrder implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(By.cssSelector("#page-wrapper > div > div.col-lg-1 > button"))
        );
    }

    public static ClickPlaceOrder now() {
        return Tasks.instrumented(ClickPlaceOrder.class);
    }
}
