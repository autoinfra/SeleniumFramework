package utilities.customAssertions;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {

    public WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement webElement){
        return new WebElementAssert(webElement);
    }

    public WebElementAssert isDisplayed(){
        isNotNull();

        if(!actual.isDisplayed()){
            failWithMessage("Expected element to be displayed. But was not!!");
        }

        return this;
    }

    public WebElementAssert isEnabled(){
        isNotNull();

        if(!actual.isEnabled()){
            failWithMessage("Expected element to be enabled. But was not!!");
        }

        return this;
    }

    public WebElementAssert isButton(){
        isNotNull();

        if(!(actual.getTagName().equalsIgnoreCase("button") || actual.getAttribute("type").equalsIgnoreCase("button"))){
            failWithMessage("Expected element to be a button. But was not!!");
        }

        return this;
    }

    public WebElementAssert isLink(){
        isNotNull();

        if(!actual.getTagName().equalsIgnoreCase("a")){
            failWithMessage("Expected element to be a link. But was not!!");
        }

        return this;
    }

    public WebElementAssert hasAttributeValue(String attr, String value){
        isNotNull();

        if(!actual.getAttribute(attr).equals(value)){
            failWithMessage("Expected element to have attr <%s> value as <%s>. But was not!!", attr, value);
        }

        return this;
    }

}