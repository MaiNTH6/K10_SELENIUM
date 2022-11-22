package tests;

import driver.DriverFactory;
import models.components.LoginFormComponent;
import models.pages.HerokuLoginPage;
import org.openqa.selenium.WebDriver;
import url.Urls;

public class LoginPageTest implements Urls {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            // Navigate to target page
            driver.get(BASE_URL.concat(LOGIN_FORM_SLUG));

            // Input login creds
            HerokuLoginPage loginPage = new HerokuLoginPage(driver);
  //          System.out.println(loginPage.footerComp().getLinkText());

            LoginFormComponent loginFormComp = loginPage.loginFormComp();
            loginFormComp.usernameElem().sendKeys("teo");


            //Debug purpose only
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
