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

import java.util.List;

public class stepDefinationCompare {
    private final WebDriver driver = new ChromeDriver();
    @Given("User navigates to the website")
    public void user_navigates_to_the_website() {
        driver.get("https://www.emag.ro/");
    }
    @When("User searches for product {string}")
    public void user_searches_for_product(String item) {
        WebElement searchTab = driver.findElement(By.cssSelector("#searchboxTrigger"));
        Assert.assertNotNull(searchTab);
        searchTab.sendKeys(item);
        WebElement searchButton = driver.findElement(By.cssSelector("button.btn.btn-default.searchbox-submit-button"));
        Assert.assertNotNull(searchButton);
        searchButton.click();
    }
    @When("selects {int} products")
    public void user_select_products(Integer nrOfProducts) {
        List<WebElement> compareButton = driver.findElements(By.cssSelector("button.card-compare-btn.hidden-xs.gtm_kz1kte2"));
        Assert.assertFalse(compareButton.isEmpty());
        Assert.assertTrue(nrOfProducts <= 4);
        Assert.assertTrue(nrOfProducts > 0);
        for(int i = 0; i < nrOfProducts; i++){
            compareButton.get(i).click();
        }
    }
    @When("clicks compare button")
    public void clicks_compare_button() {
        WebElement selectCompareButton = driver.findElement(By.cssSelector("#compare-link"));
        Assert.assertNotNull(selectCompareButton);
        selectCompareButton.click();
    }
    @Then("Products should appear on the page")
    public void products_should_appear_on_the_page() {
        List<WebElement> compareProducts = driver.findElements(By.cssSelector("th.table-compare-column.js-card-item"));
        Assert.assertFalse(compareProducts.isEmpty());
        Assert.assertTrue(compareProducts.size() > 1);
    }
    @Then("Should appear the error message")
    public void should_appear_the_error_message() {
        WebElement errorMessage = driver.findElement(By.cssSelector("body > div.ns-wrap-top-right > div > div > div"));
        Assert.assertNotNull(errorMessage);
        Assert.assertTrue(errorMessage.isDisplayed());
    }
    @After
    public void quitPage() {
        driver.quit();
    }
}
