package models.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@ComponentCssSelector(value = "#page-footer")
public class PageFooterComponent extends Component {
    private  static  final  By LinkText = By.tagName("a");

    public PageFooterComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public  String getLinkText(){
        return component.findElement(LinkText).getText();
    }

}
