package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class StepDefinationBuyDevice {
    private final WebDriver driver = new ChromeDriver();
    @Given("User opens main page")
    public void user_opens_main_page() {
        driver.get("https://www.emag.ro/");
    }
    @When("User searches for item {string}")
    public void user_searches_for_item(String item) throws InterruptedException{
        WebElement searchTab = driver.findElement(By.cssSelector("#searchboxTrigger"));
        Assert.assertNotNull(searchTab);
        searchTab.sendKeys(item);
        WebElement searchButton = driver.findElement(By.cssSelector("button.btn.btn-default.searchbox-submit-button"));
        Assert.assertNotNull(searchButton);
        searchButton.click();
    }

    @When("User checks for Interval pret")
    public void user_checks_for_interval_pret() throws InterruptedException{
        Thread.sleep(1_000);
        JavascriptExecutor scrollPage = (JavascriptExecutor) driver;
        scrollPage.executeScript("window.scrollBy(0,1100)", "");
        Thread.sleep(1_000);
        WebElement priceRange = driver.findElement(By.cssSelector("#js-filter-6411-collapse > div:nth-child(2) > div.filter-custom-price"));
        Assert.assertNotNull(priceRange);
        priceRange.click();
    }
    @When("wants the price to be between {string} and {string}")
    public void wants_the_price_to_be_between_and(String price, String price2) throws InterruptedException{
        Thread.sleep(2_000);
        WebElement minPrice = driver.findElement(By.cssSelector("#js-filter-6411-collapse > div:nth-child(2) > div.custom-price-slider-container.active > div.input-group.input-group-sm > input.form-control.js-custom-price-min"));
        Assert.assertNotNull(minPrice);
        minPrice.clear();
        minPrice.sendKeys(price);
        WebElement maxPrice = driver.findElement(By.cssSelector("#js-filter-6411-collapse > div:nth-child(2) > div.custom-price-slider-container.active > div.input-group.input-group-sm > input.form-control.js-custom-price-max"));
        Assert.assertNotNull(maxPrice);
        maxPrice.clear();
        maxPrice.sendKeys(price2);
        WebElement selectButton = driver.findElement(By.cssSelector("#js-filter-6411-collapse > div:nth-child(2) > div.custom-price-slider-container.active > div.input-group.input-group-sm > span > button"));
        Assert.assertNotNull(selectButton);
        selectButton.click();
    }
    @Then("The prices should be in the range {string} and {string}")
    public void the_prices_should_be_in_the_range(String string1, String string2) throws InterruptedException{
        Thread.sleep(3_000);
        List<WebElement> tvPriceList = driver.findElements(By.cssSelector("p.product-new-price"));
        Assert.assertFalse(tvPriceList.isEmpty());
        for(int i = 0; i < 3; i++){
            System.out.println(tvPriceList.get(i).getText());
        }
        List<String> tvPriceStringList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            tvPriceStringList.add(tvPriceList.get(i).getText().substring(0,1) + tvPriceList.get(i).getText().substring(2,5));
        }
        System.out.println(tvPriceStringList);
        for(int i = 0; i < 3; i++){
            Assert.assertTrue(Integer.parseInt(string1) < Integer.parseInt(tvPriceStringList.get(i)));
            Assert.assertTrue(Integer.parseInt(string2) > Integer.parseInt(tvPriceStringList.get(i)));
        }
    }
    @After
    public void quitPage() {
        driver.quit();
    }
}
