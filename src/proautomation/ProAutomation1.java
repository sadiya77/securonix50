package proautomation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProAutomation {

    private static WebDriver driver;
    private static Properties prop;
    private static Object pro;

void clickandwait() throws InterruptedException {
        Thread.sleep(2000);

    }

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        
        ProAutomation pro = new ProAutomation();
        driver = new FirefoxDriver();
        prop=new Properties();
        BasicConfigurator.configure();
        
        
        FileReader reader=new FileReader("src\\proautomation\\login.properties");
        prop.load(reader);
        //String uname=prop.getProperty("username");
        //String pswd=prop.getProperty("password");
        String link=prop.getProperty("url");

        driver.get(link);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("D:\\Work\\data\\Selenium\\selenium-java-2.47.1\\login.jpg"),true);

// Login to apllication
        login();
//Refresh page
        refreshpage();
        
         //Click on configure--Jobs--Action---Import
         navigate();
         //Click on users
        /* userImport();
         //Refresh page
         driver.navigate().refresh();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         
//Click on Run
        createPolicy();
        
         //Create rule based policy
         driver.findElement(By.linkText("Create Rule Based Policy")).click();
         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

         //Enter Policy Name
         WebElement polname = driver.findElement(By.id("name"));
         polname.clear();
         polname.sendKeys("SelPolicy");

         //Set Criticality
         WebElement slider=driver.findElement(By.id("criticalityslider"));
         Actions slideraction = new Actions(driver);
 
         slideraction.clickAndHold(slider);
         slideraction.moveByOffset(20,0).build().perform();

         //Select Violation Entity
         Select ventity=new Select(driver.findElement(By.id("violator")));
         ventity.selectByValue("Users");

         //Select Category
         Select categ=new Select(driver.findElement(By.id("category")));
         categ.selectByIndex(1);
         pro.clickandwait();

         //Select Threat Indicator
         driver.findElement(By.xpath("//*[@id='threatIndicator_chosen']/a/span")).click();
         driver.findElement(By.xpath("//*[@id='threatIndicator_chosen']/div/ul/li[2]")).click();

         //Click on Next
         WebElement nextpolicy = driver.findElement(By.id("i_pv_st1"));
         nextpolicy.click();

         //Select User Entity
         WebElement user = driver.findElement(By.id("validatorObject_user"));
         user.click();

         //Select Template
         driver.findElement(By.xpath("//*[@id='policyTemplateDiv']/table/tbody/tr[5]/td[1]/a")).click();

         //Click on Next
         WebElement nextentity = driver.findElement(By.id("i_pv_st3"));
         nextentity.click();

         //Drag and drop

         WebElement element = driver.findElement(By.cssSelector("li#USERObjectInstance"));
         WebElement target = driver.findElement(By.cssSelector("div#group_1"));
         Actions dragaction=new Actions(driver);
         dragaction.clickAndHold(element);
         dragaction.contextClick(target);
         //driver.findElement(By.xpath("//*[@id='templateDetailsDiv']/table/tbody/tr[2]/td[2]/div")).click();
         dragaction.moveToElement(target).build().perform();
         dragaction.moveByOffset(285, 315);
         dragaction.release();
         //element.click();
         /*WebElement target = driver.findElement(By.cssSelector("div#group_1"));
         Actions dragaction=new Actions(driver);
         System.out.println("src - "+element.getLocation().getX());
         System.out.println("src - "+element.getLocation().getY());
         System.out.println("dest - "+target.getLocation().getX());
         System.out.println("dest - "+target.getLocation().getY());
         System.out.println("Location -" +element.getTagName());
         dragaction.clickAndHold(element).build().perform();

         dragaction.moveToElement(target).build().perform();*/
        /*try{
         dragaction.dragAndDrop(element, target).build().perform();
         }catch(Exception drx){
         System.out.println("Error - "+drx.getMessage());
         drx.printStackTrace();
         }
        
         Actions act = new Actions(driver);
         WebElement element = driver.findElement(By.xpath("//*[@id='USERObjectInstance']/span"));
         act.dragAndDropBy(element, -60, 0).build().perform();
 
         Thread.sleep(4000);
         Actions act1 = new Actions(driver);
         WebElement element1=driver.findElement(By.xpath("//*[@id='group_1']"));
         act1.dragAndDropBy(element1, 40, 0).build().perform();

//Create a hql based policy
//Click on create hql based policy
        driver.findElement(By.linkText("Create Rule Based Policy with Direct HQL")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

//Enter Policy Name
        WebElement polname = driver.findElement(By.id("name"));
        polname.clear();
        polname.sendKeys("HQLSelPolicy1");

//Set Criticality
        //criticality();
//Select Violation Entity
        Select ventity = new Select(driver.findElement(By.id("violator")));
        ventity.selectByValue("Users");

//Select return entity
        Select returnentity = new Select(driver.findElement(By.id("violation")));
        returnentity.selectByValue("Users");

//Select Category
        Select categ = new Select(driver.findElement(By.id("category")));
        categ.selectByIndex(1);
        pro.clickandwait();

//Select Threat Indicator
        driver.findElement(By.xpath("//*[@id='threatIndicator_chosen']/a/span")).click();
        driver.findElement(By.xpath("//*[@id='threatIndicator_chosen']/div/ul/li[2]")).click();

//Click on Next
        WebElement nextpolicy = driver.findElement(By.id("i_pv_st1"));
        nextpolicy.click();

//Enter HQL
        WebElement hqlquery = driver.findElement(By.xpath("//*[@id='hql']"));
        hqlquery.click();
        hqlquery.sendKeys("FROM Users where firstname in ('Tanuj','Erica')");

//Click on Next
        WebElement nexthql = driver.findElement(By.id("guide"));
        nexthql.click();
        driver.findElement(By.xpath("//*[@id='breadcrumb']/li[3]")).click();
        pro.clickandwait();

//Click on Save
        WebElement hqlsave = driver.findElement(By.id("Submit"));
        hqlsave.click();

        //Select by violation entity
        byviolation();

        //Now select Users
        entityUsers();
        pro.clickandwait();

        //Select policyname
        WebElement searchpol = driver.findElement(By.name("searchPoliciesText"));
        searchpol.clear();
        searchpol.sendKeys("HQLSelPolicy");

        //Click on Search
        WebElement searchbutton = driver.findElement(By.id("search"));
        searchbutton.click();
        pro.clickandwait();

        //Play button
        WebElement playbutton = driver.findElement(By.xpath("//*[@id='policiesList']/tbody/tr[1]/td[11]/ul/li[1]/a/span"));
        playbutton.click();

        //Clcik on Run
        driver.findElement(By.xpath("//*[@id='jobDetailsDiv']/div/input[3]")).click();
        refreshpage();

        //Navigate to dashboard
        dashboard();
        
        //Security dashboard
        secdashboard();
        
        //Select current month
        currentMnth();
        
        //search violator
        searchempiddash();
        filterbtndash();
        pro.clickandwait();
      
        
        //Create case
        casecreate();
       
*/
        }

    public static void refreshpage() {
        //Refresh page
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
/*
    public static void byviolation() {
        //Click om by violation entity
        driver.findElement(By.xpath("//*[@id='byreturnentity']")).click();
    }

    public static void entityUsers() {
        driver.findElement(By.xpath("//*[@id='ui-accordion-pols-panel-2']/table/tbody/tr[1]/td/span[1]")).click();
    }
*/
    public static void login() {
        // enter a valid username in the email textbox
        WebElement username = driver.findElement(By.name("j_username"));
        username.clear();
        username.sendKeys(prop.getProperty("username"));

// enter a valid password in the password textbox
        WebElement password = driver.findElement(By.name("j_password"));
        password.clear();
        password.sendKeys(prop.getProperty("password"));

// click on the Sign in button
        driver.findElement(By.xpath("//*[@id='loginForm']/input[2]")).click();

    }
}
    /*
     public static void navigate()
     {//Click on Add Data
     driver.findElement(By.xpath("//*[@id='Add Data']/a")).click();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    //Click on User
     driver.findElement(By.xpath("//*[@id='mlnkForm5']/a/div/div[1]/div/div")).click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     }
     /*
     public static void criticality() {
     WebElement slider = driver.findElement(By.id("criticalityslider"));
     Actions slideraction = new Actions(driver);

     slideraction.clickAndHold(slider);
     slideraction.moveByOffset(20, 0).build().perform();*/
/*
    public static void dashboard() {
        driver.findElement(By.xpath("//*[@id='jQMenu']/li[1]/span/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void secdashboard() {
        driver.findElement(By.linkText("Security Dashboard")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    public static void currentMnth() {
        driver.findElement(By.xpath("//*[@id='hrutwmenu']/li/div/span[2]")).click();
        driver.findElement(By.xpath("//*[@id='hrutwmenu']/li/ul/li/div/div/div[1]/ul/li[3]")).click();
    }

    public static void searchempiddash() {
        WebElement searchempid = driver.findElement(By.name("searchHighRiskUsersText"));
        searchempid.clear();
        searchempid.sendKeys("1644");
        
    }

    public static void filterbtndash() {
        WebElement filterbutton=driver.findElement(By.id("searchHighRiskButton"));
        filterbutton.click();
       
    }
    public static void casecreate(){
        driver.findElement(By.xpath("//*[@id='highRiskUsersListDiv']/div[2]/table[2]/tbody/tr[1]/td[14]")).click();
        driver.findElement(By.xpath("//*[@id='hre_objectid']")).click();
        
        //Workflow name
        Select workflowname=new Select(driver.findElement(By.id("case_workflowName")));
         workflowname.selectByValue("SOCTeamReview");
         //Add comment
         WebElement comment = driver.findElement(By.id("case_comments"));
         comment.clear();
         comment.sendKeys("Case created for Violator");
         //Criticality
         Select casecriticality=new Select(driver.findElement(By.id("case_criticality")));
         casecriticality.selectByValue("Medium");
         //Assignee
         driver.findElement(By.xpath("//*[@id='caseCommentsForm']/div[1]/div/table/tbody/tr[3]/td[2]/span")).click();
         WebElement assignee=driver.findElement(By.id("selectedSecUsers41"));
         assignee.click();
         WebElement assign=driver.findElement(By.id("assign"));
         assign.click();
         WebElement casesubmit=driver.findElement(By.id("hreActSubmit"));
         casesubmit.click();
                
    }
    public static void userImport(){
        driver.findElement(By.xpath("//*[@id='actionMenu']/li/ul/li[1]/ul/li[1]/div/a")).click();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

    }
    //Navigate to Create Policy
    public static void createPolicy() throws InterruptedException{
        //Click on Run
        driver.findElement(By.xpath("//*[@id='jQMenu']/li[3]/span/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

//Click on Policy Violations
        driver.findElement(By.linkText("Policy Violations")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

//Click on Action Menu
        driver.findElement(By.xpath("//*[@id='actionMenu']/li/div/span")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*pro.clickandwait();
        Thread.sleep(2000);
    }
    
   }*/
