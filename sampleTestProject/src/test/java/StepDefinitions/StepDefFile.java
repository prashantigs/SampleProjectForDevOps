package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class StepDefFile extends PageObject {
    @Managed
    WebDriver driver;
    @Given("open facebook login page")
    public void landingPage(){
        driver.navigate().to("https://www.facebook.com/");
    }

    @Then("facebook login page should be opened")
    public void facebookLoginPageShouldBeOpened() {
        Assert.assertTrue(driver.getTitle().contains("Facebook"));
    }

    @And("input invalid {string} {string}")
    public void input(String arg0, String arg1) {
        driver.findElement(By.name("email")).sendKeys(arg0);
        driver.findElement(By.name("pass")).sendKeys(arg1);
    }

    @When("click on login button")
    public void clickOnLoginButton() {
        driver.findElement(By.name("login")).click();
    }

    @Then("click on forget password link")
    public void clickOnForgetPasswordLink() {
        driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
    }

    @Then("verify forget password page opened")
    public void verifyForgetPasswordPageOpened() {
        Assert.assertTrue(driver.getTitle().contains("Forgotten"));
    }

    @Then("click on create page")
    public void clickOnCreatePage() {
        driver.findElement(By.xpath("//a[text()='Create a Page']")).click();
    }

    @Then("create a page should open")
    public void createAPageShouldOpen() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Create a Page']")).isDisplayed());
    }
}
