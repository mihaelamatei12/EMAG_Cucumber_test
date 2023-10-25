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

public class StepDefinationDeleteFromWishlist {
    private final WebDriver driver = new ChromeDriver();
    @Given("User is o main page, selects a product to be wishlisted")
    public void user_is_o_main_page_selects_a_product_to_be_wishlisted() throws InterruptedException{
        driver.get("https://www.emag.ro/");
        driver.manage().window().maximize();
        Thread.sleep(1_000);
        WebElement favoriteButton = driver.findElement(By.cssSelector("button.add-to-favorites.btn"));
        favoriteButton.click();
    }
    @Given("goes to the wishlist page")
    public void goes_to_the_wishlist_page() {
        WebElement wishlistButton = driver.findElement(By.cssSelector("#my_wishlist"));
        wishlistButton.click();
    }
    @When("User deletes product from wishlist")
    public void user_deletes_product_from_wishlist() throws InterruptedException{
        List<WebElement> wishlistList = driver.findElements(By.cssSelector("div.product-card-account.pad-sep-sm.js-tracking-viewport-product.js-product-data"));
        Assert.assertFalse(wishlistList.isEmpty());
        Thread.sleep(1_000);
        WebElement deleteButton = driver.findElement(By.cssSelector("button.btn.btn-link.btn-sm.remove-from-favorites.gtm_9p2y1a.pad-hrz-none"));
        Assert.assertNotNull(deleteButton);
        deleteButton.click();
        Thread.sleep(2_000);
    }
    @Then("the product will be deleted")
    public void the_product_will_be_deleted() {
        List<WebElement> wishlistList = driver.findElements(By.cssSelector("div.product-card-account.pad-sep-sm.js-tracking-viewport-product.js-product-data"));
        Assert.assertTrue(wishlistList.isEmpty());
    }
    @After
    public void quitPage() {
        driver.quit();
    }
}
