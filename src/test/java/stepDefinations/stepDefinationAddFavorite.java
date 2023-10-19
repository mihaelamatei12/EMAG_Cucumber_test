package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.List;

public class stepDefinationAddFavorite {
    private final WebDriver driver = new ChromeDriver();
    @Given("User is o main page")
    public void user_is_o_main_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.emag.ro/");
    }
    @When("User selects item to be favorite")
    public void user_selects_item_to_be_favorite() throws InterruptedException{
        Thread.sleep(1_000);
        WebElement favoriteButton = driver.findElement(By.cssSelector("button.add-to-favorites.btn"));
        favoriteButton.click();
    }
    @When("goes to the page with favorite things selected")
    public void goes_to_the_page_with_favorite_things_selected() {
        WebElement wishlist = driver.findElement(By.cssSelector("#my_wishlist"));
        wishlist.click();
    }
    @Then("On favorite page to appear the favored item")
    public void on_favorite_page_to_appear_the_favored_item() throws InterruptedException{
        List<WebElement> wishlistList = driver.findElements(By.cssSelector("div.product-card-account.pad-sep-sm.js-tracking-viewport-product.js-product-data"));
        Assert.assertFalse(wishlistList.isEmpty());
        Thread.sleep(1_000);
        WebElement heartIcon = driver.findElement(By.cssSelector("#my_wishlist > span.jewel.jewel-danger"));
        System.out.println(heartIcon.getText());
    }

    @After
    public void quitPage() {
        driver.quit();
    }
}
