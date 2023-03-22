import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.DriverUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.*;

public class Test_03 extends TestRunner {
    private final ChromeDriver driver=getChromeDriver();
    private final DriverUtil driverUtil=getDriverUtil();
    By siteMap= cssSelector(".info_links_footer > li:nth-of-type(6) > a");
    By textShampoo= cssSelector("div:nth-of-type(1) > .list-group > li:nth-of-type(6) > .list-group > li:nth-of-type(2) > a");
    By itemParfume=linkText("EAU PARFUMEE AU THE VERT SHAMPOO");
    By model=className("productinfoleft");
    By buttonCart=className("cart");
    By buttonPrint=linkText("Print");


    @Test
    public void test_03() {
        test = extent.createTest("test_03");
/*

cliccare su "site map"
trovare il testo "shampoo" e cliccare
cliccare l'item con test "Eau Parfumee au The Vert Shampoo"
controllare che il model sia 522823
controllare che ci sia il button add to cart
controllare che ci sia il button print
controllare che la description non sia vuota
*/




        try {
            //DriverUtil driverUtil = new DriverUtil(driver);
            driverUtil.findElement(siteMap).click();
            driverUtil.findElement(textShampoo).click();
            driverUtil.findElement(itemParfume).click();
            boolean  isDisplayed522823= driverUtil.findElement(model).isDisplayed();
            Assert.assertTrue(isDisplayed522823);
            WebElement ButtonCart= driverUtil.findElement(buttonCart);
            Assert.assertTrue(ButtonCart.isDisplayed());
            System.out.println("cart esistente");
            WebElement ButtonPrint= driverUtil.findElement(buttonPrint);
            Assert.assertTrue(ButtonPrint.isDisplayed());
            System.out.println("Print esistente");
            test.pass("test success");

/*
            driver.findElement(cssSelector(".info_links_footer > li:nth-of-type(6) > a")).click();
            driver.findElement(cssSelector("div:nth-of-type(1) > .list-group > li:nth-of-type(6) > .list-group > li:nth-of-type(2) > a")).click();
            driver.findElement(linkText("EAU PARFUMEE AU THE VERT SHAMPOO")).click();

            boolean isDisplayed522823 = driver.findElement(className("productinfoleft")).isDisplayed();
            Assert.assertTrue(isDisplayed522823);

           WebElement ButtonCart=driver.findElement(By.className("cart"));
           Assert.assertTrue(ButtonCart.isDisplayed());
            System.out.println("cart esistente");
            WebElement ButtonPrint=driver.findElement(By.linkText("Print"));
            Assert.assertTrue(ButtonPrint.isDisplayed());
            System.out.println("Print esistente");
*/

        } catch (Exception ex){
            System.out.println("elemento non trovato");
            Assert.fail("Test non completato");
        }

    }
}





