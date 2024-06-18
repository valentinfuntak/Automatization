//import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automatizacija {

    public static void AutomatizacijaRegistracijaGoogleEdge() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://support.google.com/accounts/answer/27441?hl=hr");
        
        WebElement gumb1 = driver.findElement(By.xpath("//*[@id=\"page-width-container\"]/div[1]/article/section/div/div/div[2]/a[1]"));
        gumb1.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        WebElement a2 = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        a2.sendKeys("Josip");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        WebElement a3 = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        a3.sendKeys("Jelic");
        
        WebElement gumb2 = driver.findElement(By.xpath("//*[@id=\"collectNameNext\"]/div/button/span"));
        gumb2.click();       
    }
    
    public static void AutomatizacijaRegistracijaGoogleChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
        
        WebElement gumb1 = driver.findElement(By.xpath("//*[@id=\"page-width-container\"]/div[1]/article/section/div/div/div[2]/a[1]"));
        gumb1.click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        WebElement a2 = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        a2.sendKeys("Josip");
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        WebElement a3 = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        a3.sendKeys("Jelic");
        
        WebElement gumb2 = driver.findElement(By.xpath("//*[@id=\"collectNameNext\"]/div/button/span"));
        gumb2.click();       
    }
    
    public static void ProvjeraVerzije_CDP_a(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://support.google.com/accounts/answer/27441?hl=hr");
        
        String cdpVersion = ((RemoteWebDriver) driver).getCapabilities().getCapability("se:cdpVersion").toString();
        System.out.println("CDP Version: " + cdpVersion);
        driver.quit();
    }

    public static void main(String[] args) {        
        AutomatizacijaRegistracijaGoogleChrome();
    }
}
