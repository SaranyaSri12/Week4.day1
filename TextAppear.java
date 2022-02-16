package advance.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextAppear {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize(); 
	driver.get("http://www.leafground.com/pages/appear.html");
	
	WebElement appeartext = driver.findElement(By.xpath("//div[@class ='flex']/button[@id ='btn']"));
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(appeartext));
	String text = appeartext.getText();
	System.out.println("The text is"+" "+text);

}
}
