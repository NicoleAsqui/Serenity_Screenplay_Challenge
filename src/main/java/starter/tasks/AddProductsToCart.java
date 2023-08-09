package starter.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static starter.userinterface.DemoBlazeHomePage.ADD_TO_CART_BUTTON;

public class AddProductsToCart implements Task {

    private int productNumber;

    public AddProductsToCart(int productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target addToCartButton = ADD_TO_CART_BUTTON.of(String.valueOf(productNumber));

        actor.attemptsTo(
                WaitUntil.the(addToCartButton, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(addToCartButton)
        );
    }

    public static AddProductsToCart withNumber(int productNumber) {
        return instrumented(AddProductsToCart.class, productNumber);
    }
}
