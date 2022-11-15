package tests;

import driver.DriverFactory;
import models.pages.LoginPageMod02;
import models.pages.LoginPageMod03;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginMod03Test implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            // Input login creds
            LoginPageMod03 loginPage = new LoginPageMod03(driver);
            loginPage
                    .inputUsername("Teo")
                    .inputPassword("12345678")
                    .clickOnloginBtn();

            //Debug purpose only
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
