package advance.selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class WebTable2 {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/sorttable.html");
	driver.findElement(By.id("table_id"));
	List<String> list1= new LinkedList<String>();
		
		List<WebElement> colsList = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		for (int j = 0; j < colsList.size(); j++) {
			String nameList = colsList.get(j).getText();
			   
			   list1.add(nameList);
			   Collections.sort(list1);
			
		}
		
	System.out.println("The list 1"+list1);
	
	//click on header
		 driver.findElement(By.xpath("//table/thead/tr/th[@class ='sorting']")).click();
	
		
		List<String> list2= new LinkedList<String>();
		 List<WebElement> nameSort = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		 for (WebElement eachNameSort : nameSort) {
			 String nameSortRslt = eachNameSort.getText();
			 list2.add(nameSortRslt);
			 
			
		}
		 System.out.println("The list2 is"+list2);
		 File source = driver.getScreenshotAs(OutputType.FILE);
		 File dest = new File("./src/main/resources/snap/Img003.jpg");
		 FileUtils.copyFile(source, dest);
		
		
		if(list1.equals(list2))
		{
			System.out.println("Both list matches");
		}else {
			System.out.println("list not matches");
		}
			
		}
	
}







