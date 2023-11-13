import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ComOrangehrmlive {

    static String browser = "edge"; // choose browser
    static WebDriver driver; // declare globally

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        String baseURL = "https://opensource-demo.orangehrmlive.com/"; // set base url
        driver.get(baseURL);  // get base url
        driver.manage().window().maximize(); // maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //give implicit wait to driver

        System.out.println(driver.getTitle()); // print tile
        System.out.println(driver.getCurrentUrl()); // print current url
        System.out.println(driver.getPageSource()); // print page source
        WebElement forgotLink = driver.findElement(By.linkText("Forgot your password?")); // hover to forgot pw link
        forgotLink.click(); // click on link
        System.out.println(driver.getCurrentUrl()); // print current url
        driver.navigate().back(); // go back a page to login page
        driver.navigate().refresh(); // refresh url

        WebElement email = driver.findElement(By.name("username"));    //find email field and enter email by ID
        email.sendKeys("Admin");   // type into box, action

        WebElement password = driver.findElement(By.name("password"));       //find password field and enter password by ID
        password.sendKeys("admin123");    // type into box, action

        WebElement loginLink = driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")); // hover to login button
        loginLink.click(); // click on link

       driver.quit();  // close browser
    }
}




