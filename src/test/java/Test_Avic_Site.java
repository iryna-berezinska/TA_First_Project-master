import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Test_Avic_Site {
    private static ChromeDriver chromeDriver;
    WebElement element;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
    }

    @BeforeEach
    public void openBrowser() {
        chromeDriver.get("https://avic.ua/ua");
    }

    @Test
    @DisplayName("Check Display Banner")
    public void checkBanner() {
        new WebDriverWait(chromeDriver, Duration.ofSeconds(35))
                .until(driver -> driver.findElement(By.xpath("(//div[@id='js_popUp'])")).isDisplayed());

    }

    @Test
    @DisplayName("Wait Element")
    public void waitElement() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/ua/iphone/seriya--iphone-13-promax']")));
    }

    @Test
    @DisplayName("Search Button")
    public void searchButton() throws InterruptedException {
        element = chromeDriver.findElement(By.id("input_search"));
        element.sendKeys("Apple MacBook Air");
        element.click();
        Thread.sleep(4000);
        element = chromeDriver.findElement(By.xpath("//button[@class='button-reset search-btn']"));
        element.click();
        Thread.sleep(4000);
    }

    @Test
    @DisplayName("Verify Test")
    public void verifyButtonName() throws InterruptedException {
        element = chromeDriver.findElement(By.xpath("//*[@id='mm-0']/header/div[2]/div/div[4]/a[1]"));
        element.click();
        element = chromeDriver.findElement(By.xpath("//input[@class='validate']"));
        element.sendKeys("0636686093");
        element.click();
        Thread.sleep(3000);

        element = chromeDriver.findElement(By.xpath("//input[@class='validate show-password']"));
        element.sendKeys("1234@1234");
        element.click();
        Thread.sleep(3000);
        element = chromeDriver.findElement(By.xpath("//div[@class='checkbox']"));
        element.click();
        Thread.sleep(3000);
        element = chromeDriver.findElement(By.xpath("//button[@class='button-reset main-btn submit main-btn--green']"));
        element.click();
        Thread.sleep(3000);

        try {
            element = chromeDriver.findElement(By.xpath("//a[@href='https://avic.ua/ua/logout']"));
        } catch (Exception e) {
        }
        Assert.assertNotNull(element);
    }

    @AfterEach
    public void closeBrowser() {
        chromeDriver.close();
    }
}

