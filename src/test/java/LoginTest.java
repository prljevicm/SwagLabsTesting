import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LoginTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void Setup() {
        driver = openBroswer();
        loginPage = new LoginPage(driver);
    }
    @Test
    public void LoginValidData() {
        loginPage.Login("standard_user","secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void LoginWrongUser() {
        loginPage.Login("marko", "secret_sauce");
        Assert.assertEquals(loginPage.getTextMessage(), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void LoginWrongPass(){
        loginPage.Login("standard_user","123456");
        Assert.assertEquals(loginPage.getTextMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void LoginWithEmptyData(){
        loginPage.Login("","");
        Assert.assertEquals(loginPage.getTextMessage(),"Epic sadface: Username is required");
    }
    @Test
    public void LoginWrongUserAndPass(){
        loginPage.Login("marko","123456");
        Assert.assertEquals(loginPage.getTextMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void After(){
        driver.quit();
    }
}

