

package proautomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class NewClass {
@Test
 public static void main(String[] args) throws InterruptedException {

  WebDriver driver = new FirefoxDriver();
  
  String URL="http://localhost:8080/Profiler/";
  driver.navigate().to(URL);
  driver.manage().deleteAllCookies(); // For Deleting Cookies & Cache 
  driver.get("http://localhost:8080/Profiler/"); // For Opening Application URL
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  System.out.println(driver.getTitle());
  
  
  WebElement username = driver.findElement(By.xpath("//*[@id='username']")); // For User Name input
  username.clear();
  username.sendKeys("admin");

 
  WebElement password = driver.findElement(By.xpath("//*[@id='password']")); // For Password input
  password.clear();
  password.sendKeys("admin");
  
  WebElement signin = driver.findElement(By.xpath("//*[@id='loginForm']/center/table/tbody/tr[1]/td[3]/input")); // For Sign in Button
  signin.click();
  
  
  driver.get("http://localhost:8080/Profiler/monitor/showPolicyManagement");
  

  
  WebElement configure = driver.findElement(By.xpath("//*[@id='policiesList']/tbody/tr[1]/td[5]/a/span[1]")); // For Configure Menu Selection
  Thread.sleep(4000);
  configure.click();
  
 
  
  WebElement jobs = driver.findElement(By.xpath("//*[@id='breadcrumb']/li[3]/div[2]/span[2]"));  // For Jobs Menu
  Thread.sleep(4000);
  jobs.click();
  
  
  
  Actions act1 = new Actions(driver);
  
 
  WebElement From=driver.findElement(By.xpath("//*[@id='USERObjectInstance']/span"));
  WebElement To=driver.findElement(By.xpath("//*[@id='group_1']/span"));
  Thread.sleep(3000);
  act1.dragAndDrop(From, To).build().perform();
  
 
  
  
 // WebElement From1=driver.findElement(By.xpath("*[@id='RESOURCEObjectInstance']/span"));
  //WebElement To1=driver.findElement(By.xpath("//*[@id='group_1']/span"));
 
  
  
  }

}
  