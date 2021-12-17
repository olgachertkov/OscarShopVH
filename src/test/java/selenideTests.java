import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class selenideTests {
    @BeforeMethod
    public void initTest(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("selenide.browser", "Chrome");
        Configuration.browserSize = "1920x1080";
        open("http://selenium1py.pythonanywhere.com/en-gb/");
        Configuration.timeout = 10000;
    }

    @Test
    public void changeLanguageTest(){
        SelenideElement langSelector = $("[name=\"language\"]");
        SelenideElement goButton = $("button.btn-default[type=\"submit\"]");
        SelenideElement viewBasketButton = $(".btn-group a.btn.btn-default");
        langSelector.selectOption("Русский");
        goButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        viewBasketButton.shouldHave(Condition.text("Посмотреть корзину"));
    }


    @AfterMethod
    public void closeTest(){
        closeWebDriver();
    }
}
