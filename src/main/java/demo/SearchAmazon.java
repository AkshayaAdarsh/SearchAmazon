package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class SearchAmazon {
    ChromeDriver driver;

    public SearchAmazon() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        // Open URL "https://www.google.com/"
        driver.get("https://www.google.com");
        // sendKeys "amazon.com" Using Locator "ID" "APjFqb" | sendKeys("amazon.com")
        WebElement searchBox = driver.findElementById("APjFqb");
        searchBox.sendKeys("amazon");
        // click on Google Search button Using Locator "XPath" (//input[@value='Google
        // Search'])[1]
        WebElement googleSearchButton = driver.findElementByXPath("(//input[@value='Google Search'])[1]");
        googleSearchButton.click();
        // Validate amazon.in is displayed in the search results Using Locator "XPath"
        
        WebElement valText = driver.findElementByXPath("//h3[text()='Amazon.in']");
        System.out.println("Amazon Search Results displayed" + valText.isDisplayed());

        System.out.println("end Test case: testCase01");
    }

}
