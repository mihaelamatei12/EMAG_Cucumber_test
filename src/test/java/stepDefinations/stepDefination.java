package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class stepDefination {

    private final WebDriver driver = new ChromeDriver();

    @Given("User opens page and search tab")
    public void user_opens_page_and_search_tab() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.emag.ro/");
    }
    @When("User searches for {string}")
    public void user_searches_for(String item) {
        // Write code here that turns the phrase above into concrete actions
        WebElement searchTab = driver.findElement(By.cssSelector("#searchboxTrigger"));
        Assert.assertNotNull(searchTab);
        searchTab.sendKeys(item);
        WebElement searchButton = driver.findElement(By.cssSelector("button.btn.btn-default.searchbox-submit-button"));
        Assert.assertNotNull(searchButton);
        searchButton.click();
        System.out.println("hi");
    }
    @Then("Results are showing")
    public void results_are_showing() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Cauți ciocolata? Alege din oferta eMAG.ro",driver.getTitle());
    }
}
