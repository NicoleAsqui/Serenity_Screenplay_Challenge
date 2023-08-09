package starter.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public interface DemoBlazeHomePage {
    Target ADD_TO_CART_BUTTON = Target.the("Add to Cart Button")
            .locatedBy("#tbodyid > div:nth-child({0}) > div > a");
}
