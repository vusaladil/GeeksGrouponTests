package Groupon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThingsToDoPageNurlan {
    static WebDriver driver;


    public static boolean grouponThingsToDoSportsAndOutdoors(WebDriver driver) {
        driver.findElement(By.id("featured-category-box")).click();
        driver.findElement(By.xpath("(//label[@class='name truncated'])[5]")).click();

        String title = driver.findElement(By.xpath("//div[@data-bhc-path='BrowseHeader|subcategory:sports-and-outdoor-activities']")).getText();
        return title.equals("Sports & Outdoors");

    }

    public static boolean grouponThingsToDoSortByPriceLowToHigh(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.findElement(By.id("sort-arrow")).click();
        driver.findElement(By.xpath("(//div[@class='refinement'])[2]")).click();

        String sortBy = driver.findElement(By.id("featured-sort-box")).getText();
        return sortBy.equals("↑ Price");

    }

    public static boolean grouponThingsToDoSetUpByRatingTop(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.findElement(By.id("rating-arrow")).click();
        driver.findElement(By.id("featured-rating-[4..5]-label")).click();

        String rating = driver.findElement(By.id("featured-rating-box")).getText();
        return rating.equals("4 Star & Up");

    }

    public static boolean grouponThingsToDoPopularityByTopSeller(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.findElement(By.id("badge-arrow")).click();
        driver.findElement(By.id("featured-badge-top-seller-label")).click();

        String byPopularity = driver.findElement(By.id("featured-badge-box")).getText();
        return byPopularity.equals("Top Seller");

    }

    public static boolean grouponThingsToDoSetUpLocationToOldTown(WebDriver driver) {
        driver.findElement(By.id("location-arrow")).click();
        driver.findElement(By.id("featured-location-old-town-chicago-il-label")).click();

        String oldTown = driver.findElement(By.id("featured-location-box")).getText();

        return oldTown.equals("Old Town");

    }

    public static boolean grouponThingsToDoSetUpLocationToMagnificentMile(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("location-arrow")).click();
        driver.findElement(By.id("featured-location-magnificent-mile-chicago-il-label")).click();

        String location = driver.findElement(By.id("featured-location-box")).getText();
        return location.equals("Magnificent Mile");

    }

    public static void grouponThingsToDoSetUpLocationToChicago(WebDriver driver) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("location-arrow")).click();
        driver.findElement(By.id("featured-location-chicago-label")).click();
    }

    public static boolean grouponThingsToDoSetUpPrice(WebDriver driver, String price) {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("rangeFilters-arrow")).click();
        driver.findElement(By.xpath("//input[@title='Price max']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@title='Price max']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@title='Price max']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@title='Price max']")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.xpath("//input[@title='Price max']")).sendKeys(price + Keys.ENTER);

        String priceRange = driver.findElement(By.xpath("(//div//span)[30]")).getText();
        return priceRange.equalsIgnoreCase("Price");

    }

    public static boolean grouponThingsToDo(WebDriver driver) throws InterruptedException {

//        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
//        driver.get("https://www.groupon.com");
//        driver.manage().window().fullscreen();
//        Thread.sleep(2000);
//        try {
//            driver.findElement(By.id("things-to-do-tab-link")).click();
//        }catch (Exception e){
//            driver.findElement(By.id("nothx")).click();
//            Thread.sleep(1500);
//            driver.findElement(By.id("things-to-do-tab-link")).click();
//        }

        String category = driver.findElement(By.id("pull-page-header-title")).getText();
        return category.equals("Things To Do");
    }
}