import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Test_Avic_Site {
    private static ChromeDriver chromeDriver;
    WebDriverWait wait;
    WebElement clickOnElement(String query, String text, long millis) throws InterruptedException {
        WebElement element = chromeDriver.findElement(By.xpath(query));
        if (StringUtils.isNotBlank(text)) {
            element.sendKeys(text);
        }
        element.click();

        if (millis > 0) {
            Thread.sleep(millis);
        }

        return element;
    }
    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    public void openBrowser() {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://avic.ua/ua");
    }

    @Test
    @DisplayName("Check Display Banner")
    public void checkBanner() {
        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(35));
                wait.until(driver -> driver.findElement(By.xpath("(//div[@id='js_popUp'])")).isDisplayed());

    }

    @Test
    @DisplayName("Wait Element")
    public void waitElement() {
    wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/ua/iphone/seriya--iphone-13-promax']")));
    }

    @Test
    @DisplayName("Search Button")
    public void searchButton() throws InterruptedException {
//        element = chromeDriver.findElement(By.id("input_search"));
//        element.sendKeys("Apple MacBook Air");
        clickOnElement("//*[@id='input_search']", "Apple MacBook Air", 5000);
//        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
        clickOnElement("//button[@class='button-reset search-btn']", null, 5000);
//        element = chromeDriver.findElement(By.xpath("//button[@class='button-reset search-btn']"));
//        element.click();
//        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(5));
    }

    @Test
    @DisplayName("Verify Test")
    public void verifyButtonName() throws InterruptedException {
//        element = chromeDriver.findElement(By.xpath("//*[@id='mm-0']/header/div[2]/div/div[4]/a[1]"));
//        element.click();
        clickOnElement("//*[@id='mm-0']/header/div[2]/div/div[4]/a[1]", null, 3000);
//        element = chromeDriver.findElement(By.xpath("//input[@class='validate']"));
//        element.sendKeys("0636686093");
//        element.click();
//        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(3));
        clickOnElement("//input[@class='validate']", "0636686093", 3000);
//
//        element = chromeDriver.findElement(By.xpath("//input[@class='validate show-password']"));
//        element.sendKeys("1234@1234");
//        element.click();
        clickOnElement("//input[@class='validate show-password']", "1234@1234", 3000);

//        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(3));
//        element = chromeDriver.findElement(By.xpath("//div[@class='checkbox']"));
//        element.click();

        clickOnElement("//div[@class='checkbox']", null, 3000);

//        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(3));
//        element = chromeDriver.findElement(By.xpath("//button[@class='button-reset main-btn submit main-btn--green']"));
//        element.click();
//        wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(3));
        clickOnElement("//button[@class='button-reset main-btn submit main-btn--green']", null, 3000);

        clickOnElement("//*[@id='mm-0']/header/div[2]/div/div[4]/a[1]", null, 3000);
        try {
            clickOnElement("//a[@href='https://avic.ua/ua/logout']", null, 3000);
//            element = chromeDriver.findElement(By.xpath("//a[@href='https://avic.ua/ua/logout']"));
        } catch (Exception e) {
        }
        Assert.assertNull(clickOnElement("//a[@href='https://avic.ua/ua/logout']", null, 0));
    }

    @AfterEach
    public void closeBrowser() {
        chromeDriver.close();
    }
}

