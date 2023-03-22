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

public class Test_02 extends  TestRunner {
    private final ChromeDriver driver=getChromeDriver();
    private final DriverUtil driverUtil=getDriverUtil();

    By cssSelectorBooks = cssSelector(".subnav > ul > li:nth-of-type(8) > a");
    By findElement1 = cssSelector("img[alt='category image']");
    By byValue =cssSelector("select#sort");
    By findElement2=cssSelector("img[alt='category image']");

    @Test
    public void test_02() {
        test = extent.createTest("test_02");


/*
        cliccare su books
        salvare su un elemento il primo item recuperato
        cambiare ordine di visualizzazione mettendo "rating lowest"
        salvare su un elemento il primo item recuperato
        controllare che il primo item sia diverso dal secondo item
*/
        try {
            //DriverUtil driverUtil = new DriverUtil(driver);

            driverUtil.findElement( cssSelectorBooks).click();
            WebElement element1= driverUtil.findElement(findElement1);
            Select selectByValue=new Select(driverUtil.findElement(byValue));
            selectByValue.selectByIndex(6);
            WebElement element2= driverUtil.findElement(findElement2);
            Assert.assertNotSame(element1, element2);
           // driver.findElement(By.cssSelector(".subnav > ul > li:nth-of-type(8) > a")).click();
           // WebElement element1= driver.findElement(By.cssSelector("img[alt='category image']"));
            //Select selectByValue=new Select(driver.findElement(By.cssSelector("select#sort")));
             //selectByValue.selectByIndex(6);
            //WebElement element2= driver.findElement(By.cssSelector("img[alt='category image']"));
           //Assert.assertNotSame(element1, element2);



            test.pass("test success");

        } catch (Exception ex){
            System.out.println("elemento non trovato");
            Assert.fail("Test non completato");
        }

    }
}





