import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 20);
    }

    public void runTests() {
        try {
            basicSearchTest();
            searchSuggestionsTest();
            imFeelingLuckyTest();
            specialCharactersSearchTest();
            firstResultLinkTest();
            paginationTest();
            imageSearchTest();
            multilingualSearchTest();
        } finally {
            tearDown();
        }
    }

    private void basicSearchTest() {
        driver.get("https://www.google.com");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys("selenium webdriver" + Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search")));
        assert driver.findElement(By.cssSelector("div.g")).isDisplayed();
    }

    private void searchSuggestionsTest() {
        try {
            driver.get("https://www.google.com");
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
            searchBox.sendKeys("selenium");
            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@role='listbox']//li")));
            assert driver.findElement(By.xpath("//*[@role='listbox']//li")).isDisplayed();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void imFeelingLuckyTest() {
        try {
            driver.get("https://www.google.com");
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
            searchBox.sendKeys("google translate");
            
            // Wait for the button to be clickable
            WebElement luckyButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[name='btnI']")));
            
            // Use JavaScript to click the button since it might be overlapped
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", luckyButton);
            
            Thread.sleep(2000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea.er8xn")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void specialCharactersSearchTest() {
        driver.get("https://www.google.com");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys("@#$%^&" + Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search")));
        assert driver.findElement(By.cssSelector("div#search")).isDisplayed();
    }

    private void firstResultLinkTest() {
        driver.get("https://www.google.com");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys("github" + Keys.ENTER);
        WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3.LC20lb")));
        firstResult.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".logged-out")));
        assert driver.findElement(By.cssSelector(".logged-out")).isDisplayed();
    }

    private void paginationTest() {
        driver.get("https://www.google.com");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys("selenium automation" + Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search")));
        
        WebElement page2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[aria-label='Page 2']")));
        page2.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search")));
        assert driver.findElement(By.cssSelector("td.YyVfkd")).getText().equals("2");

        WebElement page3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[aria-label='Page 3']")));
        page3.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search")));
        assert driver.findElement(By.cssSelector("td.YyVfkd")).getText().equals("3");
    }

    private void imageSearchTest() {
        driver.get("https://www.google.com/search?q=selenium+logo&tbm=isch&hl=en");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-ved]")));
        assert driver.findElement(By.cssSelector("div[data-ved]")).isDisplayed();
    }

    private void multilingualSearchTest() {
        driver.get("https://www.google.com");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(1200, 800));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        searchBox.sendKeys("Kiểm tra unicode. Đây là tiếng việt." + Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div#search")));
        assert driver.findElement(By.cssSelector("div.g")).isDisplayed();
    }

    private void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        GoogleSeleniumTest test = new GoogleSeleniumTest();
        test.setUp();
        test.runTests();
    }
}
