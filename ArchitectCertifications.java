package dailytask;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.sukgu.Shadow;

public class ArchitectCertifications {
           public static void main(String[] args) throws InterruptedException {
        	   EdgeDriver driver  = new EdgeDriver();
   			driver.manage().window().maximize();
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   			driver.get("https://qeagle-dev-ed.my.salesforce.com/");
   			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
   			driver.findElement(By.id("password")).sendKeys("Leaf@123");
   			driver.findElement(By.id("Login")).click();
   			
   			driver.findElement(By.xpath("//span[text()='Learn More']")).click();
   			Set<String> handles = driver.getWindowHandles();
   			List<String>child=new ArrayList<String>(handles);
   			Thread.sleep(10000);
   			driver.switchTo().window(child.get(1));
   			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
   			Shadow shadow = new Shadow(driver);
   			shadow.setImplicitWait(10);
   			shadow.findElementByXPath("//span[text()='Learning']").click();
   			
   			WebElement elementByXPath = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
   			Actions actions = new Actions(driver);
   			actions.moveToElement(elementByXPath).perform();
   			
   			shadow.findElementByXPath("//a[text()='Salesforce Certification']").click();   			
   			driver.findElement(By.xpath("//div[@class='slds-p-horizontal--small slds-p-top--small'][2]")).click();
   			
   			List<WebElement> list = shadow.findElementsByXPath("//div[contains(@class,'credentials-card_title')]");
		
			int count = list.size();
			System.out.println(count);
			
			driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
			
			List<WebElement> list1 = shadow.findElementsByXPath("//div[@class='credentials-card_title']");
			
			int countOf = list1.size();
			System.out.println(countOf);
			
 		
		}
}
