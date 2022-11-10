package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitForElementEnabled;
import url.Urls;

import java.time.Duration;

public class DynamicControl {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {

            // Navigate to the target page
            driver.get(Urls.BASE_URL.concat(Urls.DYNAMIC_CONTROL_SLUG));

            // Define 2 form locator
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");

            // Interact with the checkbox form elems
            WebElement checkboxFromElem = driver.findElement(checkboxFormSel);
            WebElement checkboxElem = checkboxFromElem.findElement(By.tagName("input"));

            // if the checkbox is not selected then select it
            if(!checkboxElem.isSelected()){
                checkboxElem.click();
            }

            //Debug purpose only
            Thread.sleep(1000);

            // Interact with the input form elems
            WebElement inputFromElem =  driver.findElement(inputFormSel);
            WebElement inputFieldElem = inputFromElem.findElement(By.tagName("input"));
            WebElement inputformBtnElem = inputFromElem.findElement(By.tagName("button"));

            // If the text field is not enable then click on the button

            if(!inputFieldElem.isEnabled()){
                inputformBtnElem.click();

                // wait until the text field is enable then sendkey
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
                wait.until(new WaitForElementEnabled(By.cssSelector("#input-example input")));
            }
            inputFieldElem.sendKeys("This is the new text");

            // debug purpose only
            Thread.sleep(2000);


        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
