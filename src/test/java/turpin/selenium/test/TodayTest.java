package turpin.selenium.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//@RunWith(MockitoJUnitRunner.class)
public class TodayTest {

	private static final String DRIVER_PATH = "C:\\Users\\INAROD\\Documents\\SELENIUM\\drivers\\chromedriver_win32\\chromedriver.exe";
	private static final String SYSTEM_CHROME_DRIVER = "webdriver.chrome.driver";
	
	private static final String GOOGLE_INPUT = "q";
	
	private WebDriver driver;
	
	@Before
	public void startUp() {
		System.setProperty(SYSTEM_CHROME_DRIVER, DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	
	@Test
	public void holaQueTalTest() {
		driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name(GOOGLE_INPUT));
        element.sendKeys("today's date");
        element.submit();
		
        // Explicit wait until the google page shows the result
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
        
        

        List<WebElement> findElements = driver.findElements(By.xpath("//*[@id='rso']/div[1]/div/div/div[1]/div"));
        WebElement webElement = findElements.get(0);
        
        assertTrue(webElement.getText().startsWith("viernes"));
	}
	

}
