package proautomation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UserImport {

private static WebDriver driver;
public static void main(String[] args) throws Throwable{
    System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");		
                driver = new ChromeDriver();
		driver.manage().window().maximize();
                driver.navigate().to("http://localhost:8080/Profiler/");
                
               // ProAutomation.login();
                
  WebElement username = driver.findElement(By.xpath(".//*[@id='loginForm']/div[1]/input")); 
  username.sendKeys("admin");
  
 
  WebElement password = driver.findElement(By.xpath(".//*[@id='loginForm']/div[2]/input"));
  password.sendKeys("admin");
  
  WebElement signin = driver.findElement(By.xpath(".//*[@id='loginForm']/input[2]"));
  signin.click();
//  ProAutomation.refreshpage();
  WebElement AddData = driver.findElement(By.xpath("//*[@id='AddData']/a"));

  AddData.click();
  
  
  WebElement user = driver.findElement(By.xpath("//*[@id='mlnkForm5']/a/div/div[1]/span"));
  user.click();
  
  WebElement jobs1 = driver.findElement(By.xpath(".//*[@id='connType_chosen']/a/div/b"));
  jobs1.click();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  WebElement jobs = driver.findElement(By.xpath(".//*[@id='connType_chosen']/div/ul/li[2]"));
  jobs.click();
  
  WebElement jobs2 = driver.findElement(By.xpath(".//*[@id='connectionType_chosen']/a/div/b"));
  jobs2.click();
  WebElement jobs3 = driver.findElement(By.xpath(".//*[@id='connectionType_chosen']/div/ul/li[5]"));
  jobs3.click();
  
  WebElement connectionname = driver.findElement(By.xpath("//*[@id='i_u_connectionname']"));
  connectionname.clear();
  connectionname.sendKeys("HRFile");
  
  WebElement action = driver.findElement(By.xpath(".//*[@id='userImportConfigForm']/li[1]/div[3]/div/div[3]/div/a"));
  action.click();
  
  
  WebElement browse = driver.findElement(By.xpath(".//*[@id='dataFileImport']/div/input[2]"));
  Thread.sleep(4000);
  browse.sendKeys("C:\\Securonix\\securonix_home\\import\\in\\HRData665.csv");
  //browse.click();
  //Thread.sleep(4000);
  
  
  WebElement filename = driver.findElement(By.xpath(".//*[@id='endpoint']"));
  filename.sendKeys("HRData665.csv");
  
  WebElement delimeter = driver.findElement(By.xpath("//*[@id='columnDelimiter']"));
  delimeter.sendKeys(",");
  
  JavascriptExecutor javascript = (JavascriptExecutor) driver;  
        javascript.executeScript("window.scrollBy(0,1200)", ""); 
  
  WebElement header = driver.findElement(By.xpath("//*[@id='connTypeDiv']/div/div[3]/div[1]/div/a"));
  header.click();
  
  WebElement ignoreline = driver.findElement(By.xpath(".//*[@id='noOflineToIgnore']"));
  ignoreline.sendKeys("1");
  
  WebElement preveiw = driver.findElement(By.xpath("//*[@id='i_u_prv_rfrsh']"));
  preveiw.click();
  Thread.sleep(4000);

  WebElement configure1 = driver.findElement(By.xpath("//*[@id='i_u_step2']"));
  configure1.click();
  Thread.sleep(4000);
 
  WebElement savenext = driver.findElement(By.xpath("//*[@id='i_u_step3']"));
  savenext.click();
  Thread.sleep(4000);
  
  WebElement run = driver.findElement(By.xpath(".//*[@id='uImportForm']/div/input[3]"));
  run.click();
  Thread.sleep(4000);
  
 /* ------ Check users on Views Users Page -------- */
  
  WebElement Views = driver.findElement(By.xpath(".//*[@id='Views']/a"));
  Views.click();
  
  WebElement ManageResources = driver.findElement(By.xpath(".//*[@id='mlnkForm1']/a/div/div[1]/div/div"));
  ManageResources.click();
  
}

/*public static void userImport(){
        //driver.findElement(By.xpath("//*[@id='actionMenu']/li/ul/li[1]/ul/li[1]/div/a")).click();
         //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         //Click on create new By Value
         Select se=new Select(driver.findElement(By.id("connType")));
         se.selectByValue("new");

         //Using File Import
         Select file=new Select(driver.findElement(By.id("connectionType")));
         file.selectByValue("file");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }

         //Give Cnnection Name
         WebElement conname = driver.findElement(By.id("i_u_connectionname"));
         conname.clear();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         conname.sendKeys("HRFile");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }

         //Browse
         WebElement filename=driver.findElement(By.id("browseImportFileButton"));
         filename.sendKeys("F:\\SP2installer5oct\\securonix_home\\import\\in\\HRData665.csv");

         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }

         //EnterFileName
         WebElement fname = driver.findElement(By.xpath("//*[@id='endpoint']"));
         fname.clear();
         fname.sendKeys("HRData665.csv");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }

         //Column Delimeter
         WebElement codelimeter = driver.findElement(By.id("columnDelimiter"));
         codelimeter.sendKeys(",");

         //Exclude header
         driver.findElement(By.xpath("//*[@id='connTypeDiv']/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/a")).click();

         //IgnoreLine
         WebElement ignoreline = driver.findElement(By.id("noOflineToIgnore"));
         ignoreline.sendKeys("1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }

         //Preview Button
         WebElement preview = driver.findElement(By.id("i_u_prv_rfrsh"));
         preview.click();
         driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
         
         //Working Save and next1
         WebElement guide = driver.findElement(By.id("guide"));
         guide.click();
         driver.findElement(By.xpath("//*[@id='breadcrumb']/li[2]/div[2]/span[2]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }

         //Working Save and next2
         driver.findElement(By.xpath("//*[@id='i_u_step3']")).click();

        try {
            //Run button
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProAutomation.class.getName()).log(Level.SEVERE, null, ex);
        }
         driver.findElement(By.xpath("//*[@id='uImportForm']/div/input[3]")).click();

    }*/
}
