package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerifySuccessfulPurchaseMessage implements Task {

    private String expectedMessage;

    public VerifySuccessfulPurchaseMessage(String expectedMessage) {
        this.expectedMessage = expectedMessage;
    }

    public static VerifySuccessfulPurchaseMessage withMessage(String expectedMessage) {
        return instrumented(VerifySuccessfulPurchaseMessage.class, expectedMessage);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement successfulPurchaseMessage = driver.findElement(By.xpath("/html/body/div[10]/h2"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successfulPurchaseMessage));
        Assert.assertTrue(successfulPurchaseMessage.getText().contains(expectedMessage));
    }
}

