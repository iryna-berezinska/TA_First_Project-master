
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Test_Avic_Site {

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @Test
    @DisplayName("Check Display Banner")
    public void checkBanner() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://avic.ua/ua");

        new WebDriverWait(chromeDriver, Duration.ofSeconds(35))                                                                  //закрытие окна рекламы вариант 1
                .until(driver -> driver.findElement(By.xpath("(//div[@id='js_popUp'])")).isDisplayed());
        chromeDriver.close();
    }

    @Test
    @DisplayName("Wait Element")
    public void waitElement() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://avic.ua/ua");

        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/ua/iphone/seriya--iphone-13-promax']")));
        chromeDriver.close();
    }

    @Test
    @DisplayName("Search Button")
    public void searchButton() throws InterruptedException {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://avic.ua/ua");

        WebElement searchButton = chromeDriver.findElement(By.id("input_search"));
        searchButton.sendKeys("Apple MacBook Air");
        searchButton.click();
        Thread.sleep(5000);
        chromeDriver.close();
    }

    @Test
    @DisplayName("Verify Test")
    public void verifyButtonName() {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://avic.ua/ua/sign-in");
//        String verifyAssertNull = null;
//        Boolean verifyTitle = chromeDriver.getTitle().equalsIgnoreCase("method verifies if the title of the page is null or empty.");
//        assertNotNull(verifyTitle);
//        assertNull(verifyAssertNull);
//        chromeDriver.close();
        WebElement searchButton = chromeDriver.findElement(By.className("//*[@class='width-auto']"));
//        chromeDriver.findElement(By.className(".//*[@class='validate show-password']"));
        searchButton.sendKeys("0635699999");
        searchButton.click();

//        chromeDriver.findElement(By.className("//*[@class='validate show-password']")).sendKeys("Test@123");
//        chromeDriver.findElement(By.className("//*[@class='button-reset main-btn submit main-btn--green']")).click();
//        try{
//            element = chromeDriver.findElement (By.xpath(".//*[@id='account_logout']/a"));
//        }catch (Exception e){
//        }
//        Assert.assertNotNull(searchButton);
//        System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
    }
    }

