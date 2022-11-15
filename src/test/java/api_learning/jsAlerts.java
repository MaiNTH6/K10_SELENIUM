package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class jsAlerts implements Urls {
    private final static By jsAleftSel = By.cssSelector("button[onclick=\"jsAlert()\"]");
    private final static By jsConfirmSel = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private final static By jsPromptSel = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    private final static By resultSel = By.cssSelector("#result");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the page
            driver.get(BASE_URL.concat(JS_ALEFTS_SLUG));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
            boolean isAcceptedAleft = true;

            // JS Aleft| OK
            WebElement triggerJsAleftBtnElem = driver.findElement(jsAleftSel);
            handleAleft(wait, triggerJsAleftBtnElem,true);

//            triggerJsAleftBtnElem.click();
//            Alert jsAleft = wait.until(ExpectedConditions.alertIsPresent());
//            jsAleft.accept();
            System.out.println("Result: " + driver.findElement(resultSel).getText());

            // JS Confirm | Cancel
            WebElement triggerJsConfirmBtnElem = driver.findElement(jsConfirmSel);
            isAcceptedAleft = false;
            handleAleft(wait, triggerJsAleftBtnElem,isAcceptedAleft);
//            triggerJsConfirmBtnElem.click();
//            Alert jsConfirm = wait.until(ExpectedConditions.alertIsPresent());
//            jsConfirm.dismiss();
            System.out.println("Result: " + driver.findElement(resultSel).getText());

            // JS Prompt | Input text then accept
            WebElement triggerJsPromptBtnElem = driver.findElement(jsPromptSel);
            handleAleft(wait, triggerJsPromptBtnElem, "My name is Teo");
//            triggerJsPromptBtnElem.click();
//            Alert jsPrompt = wait.until(ExpectedConditions.alertIsPresent());
//            jsPrompt.sendKeys("My name is Teo");
//            jsPrompt.accept();
            System.out.println("Result: " + driver.findElement(resultSel).getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
    private static void handleAleft(WebDriverWait wait, WebElement aleftElem, boolean isAccepted){
        aleftElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if(isAccepted) alert.accept();
        else alert.dismiss();

    }
    private static void handleAleft(WebDriverWait wait, WebElement aleftElem, String inputStr){
        aleftElem.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(inputStr);
        alert.accept();
    }
}
