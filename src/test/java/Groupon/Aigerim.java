package Groupon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Aigerim {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://groupon.com");

        try {
            driver.findElement(By.id("ls-location")).click();

        } catch (Exception e) {
            driver.findElement(By.id("nothx")).click();

            Thread.sleep(1000);
            driver.findElement(By.id("ls-location")).click();
            Thread.sleep(1000);
        }

        // GrouponBeautySpa(driver);
        GrouponBeautyAndSpaTest2(driver);

    }

    public static void GrouponBeautySpa(WebDriver driver) throws InterruptedException {

        // as a user i should be able to see all the spas on the webpage starting from $1-$50  from "SPAS" link Aigerim;


        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        // setting location for "NYC";

        driver.findElement(By.id("ls-location")).clear();
        driver.findElement(By.id("beauty-and-spas-tab-link")).click();
        driver.findElement(By.xpath("//*[@id=\"ls-location\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"ls-location\"]")).sendKeys("New York City" + Keys.ENTER);
        WebElement location = driver.findElement(By.xpath("//input[@id='ls-location']"));
        location.sendKeys("New York City" + Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl()); //copy paste
        //if(driver.getCurrentUrl().equals("https://www.groupon.com/browse/new-york?category=beauty-and-spas")){
        if(location.equals("New York, NY")){
            System.out.println("Location is passed" );
        }else{
            System.out.println("Location is not verified");
        }

        // accessing to 'Beauty & Spa' link;

        Thread.sleep(2000);
        WebElement BeautyAndSpaMain = driver.findElement(By.xpath("//ul/li[@id='beauty-and-spas-tab']/a"));
        System.out.println(BeautyAndSpaMain.getText());
        Thread.sleep(2000);
        BeautyAndSpaMain.click();
        Thread.sleep(2000);
        WebElement beautyAndSpaOptionLink = driver.findElement(By.id("featured-category-box"));
        if(beautyAndSpaOptionLink.getText().contains("Beauty & Spas")){
            System.out.println("Beauty & Spas Link is passed");
        }
        else{
            System.out.println("Link is not verified");
        }
        WebElement arrowLink = driver.findElement(By.xpath("//span[@id='category-arrow']"));
        arrowLink.click();


        // choosing 'SPA' link;

        Thread.sleep(3000);
        WebElement spaLink = driver.findElement(By.xpath("(//*[@class='name truncated'])[9]"));
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='name truncated'])[9]")).click();
        Thread.sleep(2000);

        if(spaLink.equals("Spas")){
            System.out.println("Spas link is passed");
        }else{
            System.out.println("link is failed");
        }

        // spaLink.getText();


        // price link;

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='featured-title c-txt-black'])[1]"));
        // arrow;
        driver.findElement(By.id("rangeFilters-arrow")).click();
        Thread.sleep(2000);
        // min price select;


        Actions action = new Actions(driver);

        WebElement max = driver.findElement(By.xpath("//input[@title='Price max']"));

        action.moveToElement(max).build().perform();
        action.doubleClick().build().perform();

        driver.findElement(By.xpath("//input[@title='Price max']")).sendKeys("50"+Keys.ENTER);





    }











    public static void GrouponBeautyAndSpaTest2(WebDriver driver) throws InterruptedException{

        // as a user i should be able to see all the hair salons options from "HAIR" link by topseller and highest ratings;

        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        driver.findElement(By.id("ls-location")).clear();
        driver.findElement(By.id("ls-location")).sendKeys("New York City" + Keys.ENTER);

        driver.findElement(By.id("beauty-and-spas-tab-link")).click();
        driver.findElement(By.id("ls-location")).clear();
        driver.findElement(By.id("ls-location")).sendKeys("New York City" + Keys.ENTER);
        Thread.sleep(2000);


        driver.findElements(By.linkText("Beauty & Spas" + Keys.ENTER));
        // arrow link;
        driver.findElement(By.xpath("//span[@id='category-arrow']")).click();

        Thread.sleep(2000);

        // HAIR link;
        WebElement hairLink =  driver.findElement(By.xpath("(//label[@class='name truncated'])[5]"));
        hairLink.click();

        if(hairLink.equals("Hair & Styling")){
            System.out.println("Hair link is passed");
        }else{
            System.out.println("failed");
        }

        //byPopularity link

        Thread.sleep(2000);
        WebElement byPopularity = driver.findElement(By.xpath("(//span[@class='featured-title c-txt-black'])[3]"));
        byPopularity.click();

        Thread.sleep(2000);

        WebElement all = driver.findElement(By.xpath("(//div[@class='radio-label-content'])[2]"));
        all.click();

        Thread.sleep(2000);

        // by ratings link;

        WebElement ratings = driver.findElement(By.xpath("(//span[@class='featured-title c-txt-black'])[3]"));
        ratings.click();


    }

}
