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

public class StepDefinationSearchChocolate {

    private final WebDriver driver = new ChromeDriver();

    @Given("User opens page and search tab")
    public void user_opens_page_and_search_tab() {
        driver.get("https://www.emag.ro/");
    }
    @When("User searches for {string}")
    public void user_searches_for(String item) {
        WebElement searchTab = driver.findElement(By.cssSelector("#searchboxTrigger"));
        Assert.assertNotNull(searchTab);
        searchTab.sendKeys(item);
        WebElement searchButton = driver.findElement(By.cssSelector("button.btn.btn-default.searchbox-submit-button"));
        Assert.assertNotNull(searchButton);
        searchButton.click();
    }
    @Then("Results are showing")
    public void results_are_showing() {
        Assert.assertEquals("Cauți ciocolata? Alege din oferta eMAG.ro",driver.getTitle());
    }
    @After
    public void quitPage() {
        driver.quit();
    }
}
