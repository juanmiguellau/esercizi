import org.example.DriverUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.cssSelector;

public class Test_06 extends TestRunner {

    private final ChromeDriver driver = getChromeDriver();
    private final DriverUtil driverUtil=getDriverUtil();
    By search=cssSelector(".fa.fa-search");
    By keyword=cssSelector("input#keyword");
    By buttonSearch=cssSelector("button#search_button");
    By text =cssSelector(".contentpanel > div:nth-of-type(2)");

    @Test
    public void test_06() {
        test = extent.createTest("test_06");

        try {
            //DriverUtil driverUtil = new DriverUtil(driver);
            driverUtil.findElement(search).click();
            driverUtil.findElement(keyword).sendKeys("qwerty");
            driverUtil.findElement(buttonSearch).click();
            WebElement Text= driverUtil.findElement(text);
            Assert.assertTrue(Text.getText().equals("There is no product that matches the search criteria."));
            System.out.println("nessun risultato è recuperato");
            test.pass("test success");

/*
            driver.findElement(By.cssSelector(".fa.fa-search")).click();
            driver.findElement(cssSelector("input#keyword")).sendKeys("qwerty");
            driver.findElement(cssSelector("button#search_button")).click();
            WebElement String= driver.findElement(cssSelector(".contentpanel > div:nth-of-type(2)"));
            Assert.assertTrue(String.getText().equals(
                    "There is no product that matches the search criteria."));
             System.out.println("nessun risultato è recuperato");
*/
        } catch (Exception ex){
            System.out.println("elemento non trovato");
            Assert.fail("Test non completato");
        }


    }
}





