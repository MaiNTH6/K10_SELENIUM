package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormInteraction {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try{
            // Navigate
            driver.get("http://the-internet.herokuapp.com/login");

            // Define selector value

            By usernameSel = By.id("username");
            By passwordSel = By.id("password");
            By loginBtnSel = By.cssSelector("button[type='submit']");

            // Find Element
            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            // Interact with elements
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");

            // Refesh page
            driver.navigate().refresh();

            usernameElem = driver.findElement(usernameSel);
            passwordElem = driver.findElement(passwordSel);
            loginBtnElem = driver.findElement(loginBtnSel);

            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            //User Dashboard page
            By headingSel = By.cssSelector("h2");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(headingSel)));
            WebElement headingElem = driver.findElement(headingSel);
            System.out.println("Heading Title: " + headingElem.getText());
           // wait.until(ExpectedConditions.urlToBe("driver.findElement(headingSel)"));



            // Find by link text, partial link text
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getText());
            System.out.println(driver.findElement(By.partialLinkText("Elemental")).getText());
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getAttribute("href"));
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

            // Check ton tai $(#username)
            // Check button $('button[type="submit"]')
        }catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
