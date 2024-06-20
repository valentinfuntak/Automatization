import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.Duration;

public class Automatizacija {

    private static final String FILE_PATH = "C:\\Users\\valen\\Documents\\NetBeansProjects\\Automatization\\Podaci\\InformacijeORacunima.txt";

    public static void AutomatizacijaRegistracijaGoogleEdge() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://support.google.com/accounts/answer/27441?hl=hr");

        Podaci account = deserializeAccountData();

        WebElement gumb1 = driver.findElement(By.xpath("//*[@id=\"page-width-container\"]/div[1]/article/section/div/div/div[2]/a[1]"));
        gumb1.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        WebElement a2 = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        a2.sendKeys(account.getFirstName());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lastName\"]")));
        WebElement a3 = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        a3.sendKeys(account.getLastName());

        WebElement gumb2 = driver.findElement(By.xpath("//*[@id=\"collectNameNext\"]/div/button/span"));
        gumb2.click();

        driver.quit();
    }

    public static void AutomatizacijaRegistracijaGoogleChrome() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");

        Podaci account = deserializeAccountData();

        WebElement gumb1 = driver.findElement(By.xpath("//*[@id=\"page-width-container\"]/div[1]/article/section/div/div/div[2]/a[1]"));
        gumb1.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"firstName\"]")));
        WebElement a2 = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        a2.sendKeys(account.getFirstName());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lastName\"]")));
        WebElement a3 = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        a3.sendKeys(account.getLastName());

        WebElement gumb2 = driver.findElement(By.xpath("//*[@id=\"collectNameNext\"]/div/button/span"));
        gumb2.click();

        driver.quit();
    }

    public static void ProvjeraVerzije_CDP_a() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://support.google.com/accounts/answer/27441?hl=hr");

        String cdpVersion = ((RemoteWebDriver) driver).getCapabilities().getCapability("se:cdpVersion").toString();
        System.out.println("CDP Version: " + cdpVersion);
        driver.quit();
    }

    private static Podaci deserializeAccountData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Podaci) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        AutomatizacijaRegistracijaGoogleChrome();
    }
}
