import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitsTest {
    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://suninjuly.github.io/wait1.html");
        WebElement button = driver.findElement(By.id("verify"));
        button.click();
        WebElement message = driver.findElement(By.id("verify_message"));
        assert message.getText().contains("successful");
        driver.quit();

    }

    @Test
    public void test2(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://suninjuly.github.io/wait1.html");
// ждем до 10 секунд
        WebElement explicitWait = (new WebDriverWait(driver, 10, 2))
// или пока не появился элемент с id=verify
                .until(ExpectedConditions.presenceOfElementLocated(By.id("verify")));

        WebElement button = driver.findElement(By.id("verify"));
        button.click();
        WebElement message = driver.findElement(By.id("verify_message"));
        assert message.getText().contains("successful");
        driver.quit();

    }
}
