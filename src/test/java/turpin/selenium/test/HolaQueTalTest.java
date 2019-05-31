package turpin.selenium.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//@RunWith(MockitoJUnitRunner.class)
public class HolaQueTalTest {

	private static final String DRIVER_PATH = "C:\\Users\\INAROD\\Documents\\SELENIUM\\drivers\\chromedriver_win32\\chromedriver.exe";
	private static final String SYSTEM_CHROME_DRIVER = "webdriver.chrome.driver";
	
	private static final String GOOGLE_INPUT = "q";
	
	private WebDriver driver;
	
	@Before
	public void startUp() {
		System.setProperty(SYSTEM_CHROME_DRIVER, DRIVER_PATH);
		driver = new ChromeDriver();
	}
	
	@Test
	public void holaQueTalTest() {
		driver.get("https://www.google.es");
        WebElement element = driver.findElement(By.name(GOOGLE_INPUT));
        element.sendKeys("hola que tal");
        element.submit();
		
        // wait until the google page shows the result
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                  .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));

        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']//h3/a"));

        // this are all the links you like to visit
        for (WebElement webElement : findElements)
        {
            System.out.println(webElement.getAttribute("href"));
        }
        
        assertNotNull(findElements);
	}
	

}
