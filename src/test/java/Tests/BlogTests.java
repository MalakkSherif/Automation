package Tests;

import Base.TestBase;
import Pages.BlogPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BlogTests extends TestBase {

    BlogPage blogPage;

    @BeforeMethod
    public void preConditions() {
        blogPage = new BlogPage(driver);
        blogPage.navigateToBlogPage();
        blogPage.removeCookiesMessage();
    }

    @Test
    public void TC_01() //Enter Full Name and valid Email
    {
        blogPage.fillForm("Malak Sherif Mohamed","malaksherifmohamed@gmail.com");
        blogPage.clickSubscribeButton();
        blogPage.validateThankYouMessage();
    }

    @Test
    public void TC_02() //Leave Full Name empty, Enter valid Email
    {
        blogPage.fillForm("","malaksherifmohamed@gmail.com");
        blogPage.clickSubscribeButton();
        blogPage.validateRequiredMessageForName();
    }

    @Test
    public void TC_03() //Enter Full Name, Leave Email empty
    {
        blogPage.fillForm("Malak Sherif Mohamed","");
        blogPage.clickSubscribeButton();
        blogPage.validateRequiredMessageForEmail();
    }

    @Test
    public void TC_04() //Leave Full Name and Email empty
    {
        blogPage.fillForm("","");
        blogPage.clickSubscribeButton();
        blogPage.validateRequiredMessageForName();
        blogPage.validateRequiredMessageForEmail();
    }

    @Test
    public void TC_05() //Enter Full Name, Enter invalid email without the part before "@"
    {
        blogPage.fillForm("Malak Sherif Mohamed","@gmail.com");
        blogPage.clickSubscribeButton();
        blogPage.validateEmailInvalidMessage();
    }

    @Test
    public void TC_06() //Enter Full Name, Enter invalid email without "@"
    {
        blogPage.fillForm("Malak Sherif Mohamed","malaksherifmohamedgmail.com");
        blogPage.clickSubscribeButton();
        blogPage.validateEmailInvalidMessage();
    }

    @Test
    public void TC_07() //Enter Full Name, Enter invalid email without the part between "@" and the "."
    {
        blogPage.fillForm("Malak Sherif Mohamed","malaksherifmohamed@.com");
        blogPage.clickSubscribeButton();
        blogPage.validateEmailInvalidMessage();
    }

    @Test
    public void TC_08() //Enter Full Name, Enter invalid email without "."
    {
        blogPage.fillForm("Malak Sherif Mohamed","malaksherifmohamed@gmailcom");
        blogPage.clickSubscribeButton();
        blogPage.validateEmailInvalidMessage();
    }

}
