package proautomation;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        
    System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");		
    driver = new ChromeDriver();
		driver.manage().window().maximize();
                driver.navigate().to("http://localhost:8080/Profiler/");
        
         
        
    // Login to apllication
        login();
    //Refresh page
        refreshpage();
        
    //Analytics-Policy
      /*  analytics();
        
    
      
    //showjobstatus();
        
    terminateduser();
         
    refreshpage();*/
        
    //CLick on dashboard
        dashboard();
        scrolldown();
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
   public static void terminateduser(){
        WebElement searchpol = driver.findElement(By.name("searchPoliciesText"));
        searchpol.clear();
        searchpol.sendKeys("Accounts that belong to terminated user");
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
   } 
        public static void nouser(){
        
        WebElement searchpol2=driver.findElement(By.name("searchPoliciesText"));
        searchpol2.clear();
        searchpol2.sendKeys("Accounts that dont have Users");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        
        }
        
        public static void nomanager(){
        
        WebElement searchpol3=driver.findElement(By.name("searchPoliciesText"));
        searchpol3.clear();
        searchpol3.sendKeys("Accounts where user dont have manager");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        
        
        }
        
        public static void domainaccess(){
            
          
        WebElement searchpol4=driver.findElement(By.name("searchPoliciesText"));
        searchpol4.clear();
        searchpol4.sendKeys("Accounts with Domain Admin Access");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        
        }
        
        public static void priviaccess(){
        
        WebElement searchpol5=driver.findElement(By.name("searchPoliciesText"));
        searchpol5.clear();
        searchpol5.sendKeys("Accounts with Privileged Access on Active Directory");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        
        }
        
        public static void remotelogin(){
            
        WebElement searchpol6=driver.findElement(By.name("searchPoliciesText"));
        searchpol6.clear();
        searchpol6.sendKeys("Contractors with remote login access");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
    }
        
        public static void upcomingcontract(){
        
        WebElement searchpol7=driver.findElement(By.name("searchPoliciesText"));
        searchpol7.clear();
        searchpol7.sendKeys("Contractors with upcoming contract end date");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
    }
        public static void upcomingtermination(){
        WebElement searchpol8=driver.findElement(By.name("searchPoliciesText"));
        searchpol8.clear();
        searchpol8.sendKeys("Employees with upcoming terminations within 30 days");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        }
        
        public static void recenthires(){
        WebElement searchpol9=driver.findElement(By.name("searchPoliciesText"));
        searchpol9.clear();
        searchpol9.sendKeys("Recent Hires");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        }
        
        public static void recenttransfers(){
        WebElement searchpol10=driver.findElement(By.name("searchPoliciesText"));
        searchpol10.clear();
        searchpol10.sendKeys("Recent Transfers");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        }
        
        public static void sodviolation(){
        WebElement searchpol11=driver.findElement(By.name("searchPoliciesText"));
        searchpol11.clear();
        searchpol11.sendKeys("SOD Access Violation");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        }
        
        public static void terminatedcontr(){
        WebElement searchpol12=driver.findElement(By.name("searchPoliciesText"));
        searchpol12.clear();
        searchpol12.sendKeys("Terminated Contractors");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        }
        
        public static void terminatedemp(){
        
        WebElement searchpol13=driver.findElement(By.name("searchPoliciesText"));
        searchpol13.clear();
        searchpol13.sendKeys("Terminated Employees");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        }
        
        public static void badperformance(){
        
         WebElement searchpol14=driver.findElement(By.name("searchPoliciesText"));
        searchpol14.clear();
        searchpol14.sendKeys("Users with Bad Performance Reviews");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        
        }
        
        
        public static void sunsetdate(){
         WebElement searchpol15=driver.findElement(By.name("searchPoliciesText"));
        searchpol15.clear();
        searchpol15.sendKeys("Users with Sunset Date in next 30 days");
        
         //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        
        //Click on play button
        
        String runPolicyXpath = "//*[@id='2']/span[@class='icon_glsy_resume']";
        WebElement we = driver.findElement(By.xpath(runPolicyXpath));
        //System.out.println(we.isDisplayed());
        WebElement parent = driver.findElement(By.xpath(runPolicyXpath + "/.."));
        System.out.println("parent element = " + parent.getAttribute("class"));
        System.out.println("tag = " + parent.getTagName());
        
        parent.click();
        
        //Click on run
        driver.findElement(By.name("runPolTrigger")).click();
        }
        
        public static void jobdetailspolicy(){
       
            //Click on policy job details
        driver.findElement(By.xpath("//*[@id='allPolicyJobsDiv']/div[1]/div[1]/table/tbody/tr[1]/td[10]/span")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
     
    public static void dashboard(){
       /* WebElement clickdash=driver.findElement(By.id("Dashboard"));
        clickdash.click();
        driver.findElement(By.xpath("//*[@id='mlnkForm0']/a/div/div[1]/div/div")).click();
        
        //click on filter.
        driver.findElement(By.xpath("//*[@id='page1']/div[1]/div/div/button[1]")).click();
        
        driver.findElement(By.xpath("//*[@id='mCSB_4_container']/ul/li")).click();*/
        
        //clcik on side bar
        driver.findElement(By.id("sidebar-toggle")).click();
        
        //Click on access dashboard
        driver.findElement(By.xpath("//*[@id='collapseListGroup1']/ul/li[2]/a")).click();
        
        //click on policy name-nonuser
        driver.findElement(By.xpath("//*[@id='mCSB_7_container']/div[1]/div")).click();
    }
        
        public static void scrolldown(){
            JavascriptExecutor javascript = (JavascriptExecutor) driver;  
        javascript.executeScript("window.scrollBy(0,1200)", "");   
        }
    
}

