import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;


public class Trello_test {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get("https://trello.com/login");
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void DragAndDrop() throws Exception {

        driver.findElement(By.id("user")).sendKeys("testtesttest@mail.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("login")).click();

        driver.findElement(By.xpath("//span[@class='board-tile-details-name' and @title='Welcome Board']")).click();
        WebElement source = driver.findElement(By.xpath(".//a[@class='list-card js-member-droppable ui-droppable']//span[contains(text(), 'Drop me')]"));
        WebElement target = driver.findElement(By.xpath(".//textarea[text()='Advanced']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(source, target).perform();


        driver.findElement(By.cssSelector(".member-initials")).click();
        driver.findElement(By.cssSelector(".js-logout")).click();
        driver.quit();
    }

    @AfterMethod
    public void tearDown() throws Exception{
        driver.findElement(By.cssSelector(".member-initials")).click();
        driver.findElement(By.cssSelector(".js-logout")).click();
        driver.quit();
    }

}

