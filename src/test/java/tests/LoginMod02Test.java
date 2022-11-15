package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod01;
import models.pages.LoginPageMod02;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod02Test implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            // Input login creds
            LoginPageMod02 loginPage = new LoginPageMod02(driver);
            loginPage.inputUsername("Teo");
            loginPage.inputPassword("12345678");
            loginPage.clickOnloginBtn();

            //Debug purpose only
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
