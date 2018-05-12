package first_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainLinkTitles {

	public static void main(String[] args){
		System.setProperty("webdriver.gecko.driver","D:/Study/Home/Testing/Selenium/geckodriver-v0.20.0-win32/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("Java",Keys.ENTER);
		List<WebElement> main_links = driver.findElements(By.xpath("//div[@class='rc']/h3/a"));
		int no_of_mainlinks = main_links.size();
		String s[] = new String[no_of_mainlinks];
		for(int i=0; i<no_of_mainlinks-1; i++){
			List<WebElement> main_links_reidentified = driver.findElements(By.xpath("//div[@class='rc']/h3/a"));
			WebElement link  = main_links_reidentified.get(i);
			link.click();
			s[i] = driver.getTitle();
			driver.navigate().back();
		}
		for(int i=0;i<no_of_mainlinks-1;i++){
			System.out.println(s[i]);
		}		
		driver.close();
	}
}
