package advance.selenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.leafground.com/pages/table.html ");
	driver.findElement(By.id("table_id"));
	
	List<WebElement> rowNames = driver.findElements(By.tagName("tr"));
 System.out.println("The row count is"+" "+(rowNames.size()-1));
		 
		
	List<WebElement> colNames = driver.findElements(By.tagName("th"));
	 System.out.println("The column count"+" "+ colNames.size());
	 
	   List<WebElement> progress = driver.findElements(By.tagName("tr"));
	   WebElement specificprogress = progress.get(3);
	  List<WebElement> progressFind = specificprogress.findElements(By.tagName("td"));
	   WebElement progressResult = progressFind.get(1);
	   System.out.println("The progess of Learn to interact with Elements"+" "+progressResult.getText());

	   List<WebElement> listCols = driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
	   List<Integer> list = new LinkedList<Integer>();
	   for (WebElement eachProgress : listCols) {
		String progressRslt = eachProgress.getText();
		String i = progressRslt.replaceAll("%","");
		
		int val1=Integer.parseInt(i); 
		
		list.add(val1);
		Collections.sort(list);
		Collections.min(list);
		}
	System.out.println(list);


	Integer n =list.get(0);
	driver.findElement(By.xpath("//td[text()='"+n+"%']/following-sibling::td/input")).click();
	File source = driver.getScreenshotAs(OutputType.FILE);
	File dest = new File("./src/main/resources/snap/Img002.jpg");
	FileUtils.copyFile(source, dest);
	}
		
	 
		
		
		
	
		
}



	
		
	

	 
	  
		   
		
	
	  
	   
	 
	
		
		
	
		
	
	 
				
			
			
		


			
		 	
		
		 
		 
		
		

		
	
   
	
