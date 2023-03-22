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

public class Test_05 extends TestRunner {
    private final ChromeDriver driver= getChromeDriver();
    private final DriverUtil driverUtil=getDriverUtil();

    By tt=cssSelector("div#topnav > .form-control");
    By itemSale=cssSelector("div:nth-of-type(1) > .thumbnail > .sale");
    @Test
    public void test_05() {
        test = extent.createTest("test_05");
/*
       TEST 5
collegarsi al sito https://automationteststore.com/
cliccare su specials
controllare che ci sia l'item "sale" negli elementi recuperati

*/


        try {
            By ttt =cssSelector("div#topnav > .form-control");
            //DriverUtil driverUtil = new DriverUtil(driver);
/*
            Select Mainmenu= new Select(driverUtil.findElement(cssSelector("div#topnav > .form-control")));
            Mainmenu.selectByIndex(0);
            WebElement ItemSale=driverUtil.findElement(itemSale);
            Assert.assertTrue(ItemSale.isDisplayed());
            System.out.println("item sale esistente");
            test.pass("test success");
*/


            //Select Mainmenu= new Select(driverUtil.findElement(cssSelector("div#topnav > .form-control")));
            Select region=new Select(driverUtil.findElement(cssSelector("div#topnav > .form-control")));
            region.selectByIndex(0);
            WebElement ItemSale= driver.findElement(cssSelector("div:nth-of-type(1) > .thumbnail > .sale"));
            Assert.assertTrue(ItemSale.isDisplayed());
            System.out.println("item sale esistente");
            test.pass("test success");






        } catch (Exception ex){
            System.out.println("elemento non trovato");
            Assert.fail("Test non completato");
        }

    }
}





