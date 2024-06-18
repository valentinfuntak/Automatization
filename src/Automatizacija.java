//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Automatizacija {

    public static void main(String[] args) {
        /*WebDriver driver = new FirefoxDriver();
        driver.get("https://support.google.com/accounts/answer/27441?hl=en");

        WebElement gumb = driver.findElement(By.xpath("/html/body/div[2]/div/section/div/div[1]/article/section/div/div[1]/div/div[2]/a[1]"));
        gumb.click();

        //driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Valentin");
        // After clicking on 'gumb', wait for the 'firstName' element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
        WebElement input = driver.findElement(By.id("firstName"));

        // Now interact with the element
        input.sendKeys("Valentin");*/

        
        
        /*WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ss-obrtnicka-koprivnica.skole.hr/");

        WebElement a1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/a[1]"));
        a1.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/article/div/div/div/div/div[2]/div/div[2]/a")));
        WebElement a2 = driver.findElement(By.xpath("/html/body/div/div[1]/article/div/div/div/div/div[2]/div/div[2]/a"));
        a2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        WebElement a3 = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        a3.sendKeys("pero.peric");*/
        
        WebDriver driver = new EdgeDriver();
        driver.get("http://www.ss-obrtnicka-koprivnica.skole.hr/");

        WebElement a1 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/div[1]/div[3]/a[1]"));
        a1.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/article/div/div/div/div/div[2]/div/div[2]/a")));
        WebElement a2 = driver.findElement(By.xpath("/html/body/div/div[1]/article/div/div/div/div/div[2]/div/div[2]/a"));
        a2.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        WebElement a3 = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        a3.sendKeys("ime@gmail.com");
        
        WebElement a4 = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        a4.sendKeys("lozinka");

    }
}
