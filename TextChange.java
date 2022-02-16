package advance.selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/TextChange.html");

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']")));
	driver.findElement(By.xpath("//button[text()='Click ME!']")).click();
	Alert alert =driver.switchTo().alert();
	String Text =  alert.getText();
	alert.accept();

	System.out.println("Text in Alert Box is - "+Text);

	
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./src/main/resources/snap/Img006.jpg");
	FileUtils.copyFile(source, dest);
}
}

