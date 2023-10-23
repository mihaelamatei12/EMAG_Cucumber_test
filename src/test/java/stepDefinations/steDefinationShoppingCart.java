package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class steDefinationShoppingCart {
    private final WebDriver driver = new ChromeDriver();
    @Given("User is on main page")
    public void user_is_on_main_page() throws InterruptedException{
        driver.get("https://www.emag.ro/");
    }
    @When("User selects an item to be on the shopping list")
    public void User_selects_an_item_to_be_on_the_shopping_list() throws InterruptedException{
        JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
        scrollPage.executeScript("window.scrollBy(0,200)", "");
        WebElement buyProduct = driver.findElement(By.cssSelector("i.em.em-cart_fill"));
        Assert.assertNotNull(buyProduct);
        buyProduct.click();
        Thread.sleep(1_000);
        WebElement closePopup = driver.findElement(By.cssSelector("button.close.gtm_6046yfqs"));
        Assert.assertNotNull(closePopup);
        closePopup.click();
        scrollPage.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(1_000);

    }
    @When("Goes to the shopping cart")
    public void goes_to_the_shopping_cart() {
        WebElement shoppingButton = driver.findElement(By.cssSelector("i.em.em-cart2.navbar-icon"));
        Assert.assertNotNull(shoppingButton);
        shoppingButton.click();
    }
    @Then("The shop cart is not empty")
    public void the_shop_list_is_not_empty() {
        List<WebElement> productsList = driver.findElements(By.cssSelector("div.cart-widget.cart-line"));
        Assert.assertFalse(productsList.isEmpty());
    }
    @After
    public void quitPage() {
        driver.quit();
    }
}
