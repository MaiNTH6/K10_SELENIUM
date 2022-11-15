
package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class JsExecutor implements Urls {


    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the page
            driver.get(BASE_URL.concat(FLOATING_MENUS_SLUG));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            PageHelper pageHelper = new PageHelper(jsExecutor);

            // Scroll to the bottom
            pageHelper.scrollToBottom();
            //jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            // Debug puppose ONLY
            Thread.sleep(2000);

            // Scroll to the top
            pageHelper.scrollToTop();
           // jsExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");

            // Debug puppose ONLY
            Thread.sleep(2000);

            // Go to dynamic control page
            driver.get(Urls.BASE_URL.concat(Urls.DYNAMIC_CONTROL_SLUG));
            By checkboxFormSel = By.id("checkbox-example");
            By inputFormSel = By.cssSelector("#input-example");
            WebElement checkboxFormElem = driver.findElement(checkboxFormSel);
            WebElement inputFormElem = driver.findElement(inputFormSel);

           // jsExecutor.executeScript("arguments[0].remove()", inputFormElem);
            pageHelper.removeElement(inputFormElem);

           //jsExecutor.executeScript("arguments[0].setAttribute('stype', 'background: blue;border: 4px solid red')", checkboxFormElem);
            pageHelper.changeElemStypeToFocusMode(checkboxFormElem);

            // Debug puppose ONLY
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }

}
