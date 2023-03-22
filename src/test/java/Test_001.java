import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Test_001 {
    String xpathLogin = "//*[@id=\"customer_menu_top\"]/li/a";
    String xpathAccount = "//*[@id=\"maincontainer\"]/div/div/div/h1/span[1]";
    @Test
    public void openSite() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationteststore.com");



        //*[@id="customer_menu_top"]/li/a
//*[@id="maincontainer"]/div/div/div/h1/span[1]



        String classNameError = "alert-danger";
        String xpathName = "/html/body/div/div[2]/div/div/div/div/div[2]/div/form/fieldset/div[1]/div/input";
        String xpathPassword = "//*[@id=\"loginFrm\"]/fieldset/div[2]/div";
        String xpathButton = "//*[@id=\"loginFrm\"]/fieldset/button";

        try {
            WebElement element = driver.findElement(By.xpath(xpathLogin));
            Assert.assertTrue(element.getText().equalsIgnoreCase("Login or register"));
            element.click();

            boolean isDisplayedAccountLogin = driver.findElement(By.xpath(xpathAccount)).isDisplayed();
            Assert.assertTrue(isDisplayedAccountLogin);

            WebElement inputLogin= driver.findElement(By.id("loginFrm_loginname"));
            WebElement inputPsw =  driver.findElement(By.id("loginFrm_password"));
            inputLogin.sendKeys("ciao");
            inputLogin.isDisplayed();
            inputPsw.isDisplayed();

            driver.findElement(By.xpath(xpathButton)).click();
            WebElement element4 = driver.findElement(By.className(classNameError));
            Assert.assertTrue(element4.getText().equals("×\n" +
                    "Error: Incorrect login or password provided."));
        } catch (Exception ex){
            System.out.println("elemento non trovato");
            Assert.fail("Test non completato");
        }
    }
}





