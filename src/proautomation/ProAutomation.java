/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proautomation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProAutomation {

    private static WebDriver driver;
    //private static Properties prop;
  // private static Object pro;

void clickandwait() throws InterruptedException {
        Thread.sleep(2000);

    }

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        
    //   ProAutomation pro = new ProAutomation();
        //driver = new FirefoxDriver();
        
       // String link=prop.getProperty("http://localhost:8080/Profiler/");

       // driver.get("http://localhost:8080/Profiler/");
       // driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        
System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");		
driver = new ChromeDriver();
		driver.manage().window().maximize();
        /*  WebDriver obj=new FirefoxDriver();

                obj.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);*/
       
      driver.navigate().to("http://localhost:8080/Profiler/");
        
         // enter a valid username in the email textbox
        
// Login to apllication
        login();
//Refresh page
        refreshpage();
        
//Analytics-Policy
        analytics();
        
        //run policy
      
        showjobstatus();
        
         accesspolicy();
         
         refreshpage();
        
        //CLick on dashboard
        dashboard();
    }
         public static void refreshpage() {
        //Refresh page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
        
    public static void login() {
        // enter a valid username in the email textbox
        WebElement username = driver.findElement(By.name("j_username"));
        username.clear();
        username.sendKeys("admin");

// enter a valid password in the password textbox
        WebElement password = driver.findElement(By.name("j_password"));
        password.clear();
        password.sendKeys("admin");

// click on the Sign in button
        driver.findElement(By.xpath("//*[@id='loginForm']/input[2]")).click();
        
    }
    
    public static void analytics(){
        driver.findElement(By.xpath("//*[@id='Analytics']/a")).click();
        
        //click on policyviolations
        driver.findElement(By.xpath("//*[@id='mlnkForm2']/a/div/div[1]/div/div")).click();
        
   }
    public static void showjobstatus(){
        driver.findElement(By.xpath("//*[@id='jobsListDiv']/div[2]/div/div[1]/div/a")).click();
                }
   public static void accesspolicy(){
        /* WebElement searchpol = driver.findElement(By.name("searchPoliciesText"));
        searchpol.clear();
        searchpol.sendKeys("Accounts that belong to terminated user");
        
        //Click on Search
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
      
        
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        
        //WebElement we = driver.findElement(By.cssSelector("span[id='icon_glsy_resume']"));
        //WebElement playbutton = we.findElement(By.xpath(".."));
        //playbutton.click();
        
        //WebElement we = driver.findElement(By.cssSelector("span[class='icon_glsy_resume']"));
        //WebElement playbutton = we.findElement(By.xpath(".."));
        //playbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //WebElement parentElement = driver.findElement(By.xpath("//*[@id='1']/span/parent::parentElementTag"));
        //parentElement.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);     
        driver.findElement(By.xpath("//*[@id='allPolicyJobsDiv']/div[1]/div[2]/table/thead/tr/th[1]/span")).click();*/
        
        //Click on policy job details
        driver.findElement(By.xpath("//*[@id='allPolicyJobsDiv']/div[1]/div[1]/table/tbody/tr[1]/td[10]/span")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }
    
    public static void dashboard(){
        WebElement clickdash=driver.findElement(By.id("Dashboard"));
        clickdash.click();
        driver.findElement(By.xpath("//*[@id='mlnkForm0']/a/div/div[1]/div/div")).click();
        
        //click on filter.
        driver.findElement(By.xpath("//*[@id='page1']/div[1]/div/div/button[1]")).click();
    }
}

