//import junit.textui.TestRunner;

import org.example.DriverUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class Test_01 extends TestRunner {

    private final DriverUtil driverUtil=getDriverUtil();


    By cssSelectorricerca =  cssSelector(".subnav > ul > li:nth-of-type(8) > a");
    By xpathrprimoItem = xpath("/html//div[@id='maincontainer']//div[@class='contentpanel']/ul/li[1]/a[@href='https://automationteststore.com/index.php?rt=product/category&path=65_66']/img[@alt='category image']");
    By xpathAddCart = xpath("/html//div[@id='maincontainer']/div[@class='container-fluid']/div[@class='col-md-12 col-xs-12 mt20']//div[@class='col-md-3 col-sm-6 col-xs-12']/div[@class='thumbnail']/div[3]/a[@title='Add to Cart']/i[@class='fa fa-cart-plus fa-fw']");
    By cssSelectorFullCart = cssSelector("a[title='Added to cart'] > .fa.fa-fw.fa-shopping-cart");
    By cssSelectorDeleteitem = cssSelector(".btn.btn-default.btn-sm > .fa.fa-fw.fa-trash-o");
    By cssSelectorContinue = cssSelector("a[title='Continue']");

    @Test
    public void test_01() {
        test = extent.createTest("test_01");

        try {
            //DriverUtil driverUtil = new DriverUtil(driver);
            driverUtil.findElement( cssSelectorricerca).click();
            driverUtil.findElement( xpathrprimoItem).click();
            driverUtil.findElement( xpathAddCart).click();
            driverUtil.findElement( cssSelectorFullCart).click();
            driverUtil.findElement( cssSelectorDeleteitem).click();
            driverUtil.findElement( cssSelectorContinue).click();



           /* DriverUtil.fElement(cssSelectorprimoItem).click();
           DriverUtil.fElement(cssSelectorAddCart).click();
           DriverUtil.fElement(cssSelectorFullCart).click();
           DriverUtil.fElement(cssSelectorDeleteitem).click();
           DriverUtil.fElement(cssSelectorContinue).click(); */

            test.pass("test success");
        } catch (Exception ex) {
            System.out.println("elemento non trovato");
            Assert.fail("Test non completato");
        }

    }
}





