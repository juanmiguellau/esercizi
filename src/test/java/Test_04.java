import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DriverUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.By.id;

public class Test_04 extends TestRunner  {
    private final ChromeDriver driver= getChromeDriver();
    private final DriverUtil driverUtil=getDriverUtil();

    By xpathlogin= xpath("//*[@id=\"customer_menu_top\"]/li/a");
    By buttonContinue=cssSelector("button[title='Continue']");
    By firstName=id("AccountFrm_firstname");
    By lastName=id("AccountFrm_lastname");
    By email=id("AccountFrm_email");
    By address=id("AccountFrm_address_1");
    By city=id("AccountFrm_city");
    By selectRegion=cssSelector("select#AccountFrm_zone_id");
    By postCode=id("AccountFrm_postcode");
    By country= cssSelector("select#AccountFrm_country_id");
    By loginName=id("AccountFrm_loginname");
    By password=id("AccountFrm_password");
    By confirm=id("AccountFrm_confirm");
    By agree=id("AccountFrm_agree");
    By formContinue=cssSelector("button[title='Continue']");
    @Test
    public void test_04() {
        test = extent.createTest("test_04");

/*
        TEST 4
collegarsi al sito https://automationteststore.com/
creare un nuovo account
controllare che la creazione sia avvenuta con successo

*/




        try {
            //DriverUtil driverUtil = new DriverUtil(driver);
            driverUtil.findElement(xpathlogin).click();
            driverUtil.findElement(buttonContinue).click();
            driverUtil.findElement(firstName).sendKeys("mario");
            driverUtil.findElement(lastName).sendKeys("rossi");
            driverUtil.findElement(email).sendKeys("mariorossi@gmail.com");
            driverUtil.findElement(address).sendKeys("corso francia");
            driverUtil.findElement(city).sendKeys("corso francia");
            Select region=new Select(driverUtil.findElement(selectRegion));
            region.selectByIndex(1);
            driverUtil.findElement(postCode).sendKeys("10138");
            Select Country=new Select(driverUtil.findElement(country));
            Country.selectByVisibleText("United Kingdom");
            driverUtil.findElement(loginName).sendKeys("mario100");
            driverUtil.findElement(password).sendKeys("password");
            driverUtil.findElement(confirm).sendKeys("password");
            driverUtil.findElement(agree).click();
            driverUtil.findElement(formContinue).click();
            test.pass("test success");

            /*

            WebElement element = driver.findElement(xpath(xpathLogin));
            element.click();
            driver.findElement(cssSelector("button[title='Continue']")).click();
            WebElement inputFirstName= driver.findElement(By.id("AccountFrm_firstname"));
            inputFirstName.sendKeys("mario");
            WebElement inputLastName= driver.findElement(By.id("AccountFrm_lastname"));
            inputLastName.sendKeys("rossi");
            WebElement inputEmail= driver.findElement(By.id("AccountFrm_email"));
            inputEmail.sendKeys("mariorossi@gmail.com");
            driver.findElement(By.id("AccountFrm_address_1")).sendKeys("corso francia");
            driver.findElement(By.id("AccountFrm_city")).sendKeys("torino");
            Select region=new Select (driver.findElement(cssSelector("select#AccountFrm_zone_id")));
            region.selectByIndex(1);
            driver.findElement(By.id("AccountFrm_postcode")).sendKeys("10138");
            Select Country=new Select (driver.findElement(cssSelector("select#AccountFrm_country_id")));
            Country.selectByVisibleText("United Kingdom");
            driver.findElement(By.id("AccountFrm_loginname")).sendKeys("mario100");
            driver.findElement(By.id("AccountFrm_password")).sendKeys("password");
            driver.findElement(By.id("AccountFrm_confirm")).sendKeys("password");
            driver.findElement(By.id("AccountFrm_agree")).click();
            driver.findElement(cssSelector("button[title='Continue']")).click();

             */

        } catch (Exception ex){
            System.out.println("elemento non trovato");
            Assert.fail("Test non completato");
        }

    }
}





