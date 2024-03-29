package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_zeroWebApp {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"signin_button\"]")).click();

        //3. Login alanine “username” yazdirin
        WebElement loginKutusu=driver.findElement(By.xpath("//*[@id=\"user_login\"]"));
        loginKutusu.sendKeys("username");

        //4. Password alanina “password” yazdirin
        WebElement passwordKutusu=driver.findElement(By.xpath("//*[@id=\"user_password\"]"));
        passwordKutusu.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"login_form\"]/div[2]/input")).click();

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id=\"onlineBankingMenu\"]/div/strong")).click();
        driver.findElement(By.xpath("//*[@id=\"pay_bills_link\"]")).click();

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountKutusu=driver.findElement(By.xpath("//*[@id=\"sp_amount\"]"));
        amountKutusu.sendKeys("200");
        //9. tarih kismina “2020-09-10” yazdirin
        WebElement tarihKutusu=driver.findElement(By.xpath("//*[@id=\"sp_date\"]"));
        tarihKutusu.sendKeys("2020-09-10");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id=\"pay_saved_payees\"]")).click();

        //11. “The payment was successfully submitted.” mesajinin
        //ciktigini test edin
        WebElement submittedYazıElemanı=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]"));
        if (submittedYazıElemanı.isDisplayed()){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAİLED");
        }


        Thread.sleep(3000);
        driver.close();
    }
}
