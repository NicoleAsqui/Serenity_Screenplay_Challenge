package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.tasks.*;

public class UserStepDefinitions {

    @Given("the user is on the DemoBlaze home page")
    public void the_user_is_on_the_demo_blaze_home_page() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User").wasAbleTo(OpenTheHomePage.on());
    }

    @When("the user adds two products to the cart")
    public void the_user_adds_two_products_to_the_cart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddProductsToCart.withNumber(1),
                OpenTheHomePage.on(),
                AddProductsToCart.withNumber(2)
        );
    }

    @When("proceeds to the cart page")
    public void proceeds_to_the_cart_page() {
        OnStage.theActorInTheSpotlight().attemptsTo(OpenTheCartPage.on());
    }

    @When("click to placeOrder button")
    public void click_to_place_order_button() {
        OnStage.theActorInTheSpotlight().attemptsTo(ClickPlaceOrder.now());
    }

    @When("completes the order with details")
    public void completes_the_order_with_details() {
        OnStage.theActorInTheSpotlight().attemptsTo(CompleteOrderWithDetails.now());
    }

    @Then("the user should see a successful purchase message")
    public void the_user_should_see_a_successful_purchase_message() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerifySuccessfulPurchaseMessage.withMessage("Thank you for your purchase!"));
    }
}
