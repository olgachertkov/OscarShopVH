import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainPageTests extends TestBase{

    @Test
    public void booksMenuTest() throws InterruptedException {
        driver.findElement(By.cssSelector(".dropdown-submenu")).click();
        driver.findElements(By.cssSelector("img")).get(0).click();
        driver.findElement(By.cssSelector("[value=\"Add to basket\"]")).click();
    }

    @Test
    public void clothingMenuTest() throws InterruptedException {
        WebElement clothingMenu = driver.findElement(By.xpath("//a[contains(text(),'Clothing')]"));
        System.out.println(clothingMenu.getText());
        System.out.println(clothingMenu.isDisplayed());
        System.out.println(clothingMenu.getAttribute("href"));
        clothingMenu.click();
        driver.findElements(By.cssSelector("img")).get(0).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Product Information')]")).isDisplayed());


    }

    @Test
    public void changeLangTest() throws InterruptedException {
        Select selectLang = new Select(driver.findElement(By.cssSelector("[name=\"language\"]")));
        selectLang.selectByValue("ar");
        Thread.sleep(5000);

    }



}
