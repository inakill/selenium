package turpin.selenium.test;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestApplication {
	
	/* https://www.baeldung.com/junit-tests-run-programmatically-from-java
	 * */
	
	private static final String DRIVER_PATH = "C:\\Users\\INAROD\\Documents\\SELENIUM\\drivers\\chromedriver_win32\\chromedriver.exe";

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
		WebDriver driver = new ChromeDriver();

		
		JUnitCore junit = new JUnitCore();
		junit.addListener(new TextListener(System.out));
//		 
//		Result result = junit.run(
//				HolaQueTalTest.class);
//		 
//		resultReport(result);
	}
	
	public static void resultReport(Result result) {
	    System.out.println("Finished. Result: Failures: " +
	      result.getFailureCount() + ". Ignored: " +
	      result.getIgnoreCount() + ". Tests run: " +
	      result.getRunCount() + ". Time: " +
	      result.getRunTime() + "ms.");
	}

}
