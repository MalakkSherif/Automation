package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage {

    WebDriver driver;

    public BlogPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private final By fullName_field = By.id("fullname");
    private final By email_field = By.id("email");
    private final By subscribe_button = By.id("_form_5_submit");
    private final By thankYou_message = By.cssSelector("div._form-thank-you");


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

    public void getThankYouMessage() {
        driver.findElement(thankYou_message).getText();
    }

}
