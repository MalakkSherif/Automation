package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BlogPage {

    WebDriver driver;

    public BlogPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By fullName_field = By.id("fullname");
    private final By email_field = By.id("email");
    private final By subscribe_button = By.id("_form_5_submit");
    private final By thankYou_message = By.xpath("//div[contains(text(), 'Thanks for signing up')]");
    private final By acceptCookies_button = By.id("rcc-confirm-button");
    private final By nameRequired_message = By.xpath("//input[@name='fullname']/following-sibling::div[contains(@class,'_error')]//div[@class='_error-inner']");
    private final By emailRequired_message = By.xpath("//input[@name='email']/following-sibling::div[contains(@class,'_error')]//div[@class='_error-inner']");
    private final By emailInvalid_message = By.xpath("//input[@name='email']/following-sibling::div[contains(@class,'_error')]//div[@class='_error-inner']");

    //Actions
    public void navigateToBlogPage() {
        driver.get("https://www.blink22.com/blog/");
    }

    public void fillForm(String fullName, String email) {
        driver.findElement(fullName_field).sendKeys(fullName);
        driver.findElement(email_field).sendKeys(email);
    }

    public void clickSubscribeButton() {
        driver.findElement(subscribe_button).click();
    }

    public void removeCookiesMessage() {
        driver.findElement(acceptCookies_button).click();
    }

    //Assertions
    public void validateThankYouMessage() {
        Assert.assertTrue(driver.findElement(thankYou_message).isDisplayed());
        Assert.assertTrue(driver.findElement(thankYou_message).getText().contains("Thanks for signing up! Check your inbox for your Welcome package!"));
        driver.findElement(thankYou_message).getText();
    }

    public void validateRequiredMessageForName() {
        Assert.assertTrue(driver.findElement(nameRequired_message).isDisplayed());
        Assert.assertTrue(driver.findElement(nameRequired_message).getText().contains("This field is required."));
    }

    public void validateRequiredMessageForEmail() {
        Assert.assertTrue(driver.findElement(emailRequired_message).isDisplayed());
        Assert.assertTrue(driver.findElement(emailRequired_message).getText().contains("This field is required."));
    }

    public void validateEmailInvalidMessage() {
        Assert.assertTrue(driver.findElement(emailInvalid_message).isDisplayed());
        Assert.assertTrue(driver.findElement(emailInvalid_message).getText().contains("Enter a valid email address."));
    }
}
