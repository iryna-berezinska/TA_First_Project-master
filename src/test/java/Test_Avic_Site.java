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
    public static final int MILLIS = 5000;
    private static ChromeDriver chromeDriver;
    WebDriverWait wait;
    private int millis;

    WebElement clickOnElement(String query, long millis) throws InterruptedException {
        WebElement element = chromeDriver.findElement(By.xpath(query));
        element.click();

        if (millis > 0) {
            Duration.ofMillis(millis);
        }

        return element;
    }

    WebElement inputData(String query, String text, long millis) throws InterruptedException {
        WebElement element = chromeDriver.findElement(By.xpath(query));
        if (StringUtils.isNotBlank(text)) {
            element.sendKeys(text);
        }
        element.click();

        if (millis > 0) {
            Duration.ofMillis(millis);
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
        wait = new WebDriverWait(chromeDriver, Duration.ofMillis(35000));
                wait.until(driver -> driver.findElement(By.xpath("(//div[@id='js_popUp'])")).isDisplayed());

    }

    @Test
    @DisplayName("Wait Element")
    public void waitElement() {
    wait = new WebDriverWait(chromeDriver, Duration.ofMillis(3500));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/ua/iphone/seriya--iphone-13-promax']")));
    }

    @Test
    @DisplayName("Search Button")
    public void searchButton() throws InterruptedException {
        inputData("//*[@id='input_search']", "Apple MacBook Air", MILLIS);
        clickOnElement("//button[@class='button-reset search-btn']",  MILLIS);
    }

    @Test
    @DisplayName("Verify Test")
    public void verifyButtonName() throws InterruptedException {
        clickOnElement("//*[@id='mm-0']/header/div[2]/div/div[4]/a[1]", MILLIS);

        inputData("//input[@class='validate']", "0636686093", 3000);

        inputData("//input[@class='validate show-password']", "1234@1234", 3000);

        clickOnElement("//div[@class='checkbox']", 3000);

        clickOnElement("//button[@class='button-reset main-btn submit main-btn--green']", 3000);

        millis = MILLIS;
        clickOnElement("//*[@id='mm-0']/header/div[2]/div/div[4]/a[1]", millis);
//        try {
        clickOnElement("//a[@href='https://avic.ua/ua/logout']", MILLIS);
//            element = chromeDriver.findElement(By.xpath("//a[@href='https://avic.ua/ua/logout']"));
//        } catch (Exception e) {
//        }
        Assert.assertNull(clickOnElement("//a[@href='https://avic.ua/ua/logout']", 5));
    }

    @AfterEach
    public void closeBrowser() {
        chromeDriver.close();
    }
}

