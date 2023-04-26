import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CheckOutStepTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CheckOutStepPage checkOutStepPage;

    @BeforeMethod
    public void Setup() {
        driver = openBroswer();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        checkOutStepPage = new CheckOutStepPage(driver);
    }
    @Test
    public void ItemPrice(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.SortItemByValue();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.AddBoltTShirt();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickOnCheckOut();
        checkOutStepPage.EnterFirstName("Marko");
        checkOutStepPage.EnterLastName("Prljevic");
        checkOutStepPage.EnterPostalCode("11000");
        checkOutStepPage.ClickOnContinueButton();
        checkOutStepPage.ItemPrice();
        Assert.assertEquals(checkOutStepPage.ItemPrice(), "Item total: $33.97");
    }
    @Test
    public void TotalPrice(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.SortItemByValue();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.AddBoltTShirt();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickOnCheckOut();
        checkOutStepPage.EnterFirstName("Marko");
        checkOutStepPage.EnterLastName("Prljevic");
        checkOutStepPage.EnterPostalCode("11000");
        checkOutStepPage.ClickOnContinueButton();
        checkOutStepPage.TotalPrice();
        Assert.assertEquals(checkOutStepPage.TotalPrice(),"Total: $36.69");

    }
    @Test
    public void FinishOrder(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.SortItemByValue();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.AddBoltTShirt();
        inventoryPage.ClickOnCart();
        inventoryPage.ClickOnCheckOut();
        checkOutStepPage.EnterFirstName("Marko");
        checkOutStepPage.EnterLastName("Prljevic");
        checkOutStepPage.EnterPostalCode("11000");
        checkOutStepPage.ClickOnContinueButton();
        checkOutStepPage.ClickOnFinishButton();
        checkOutStepPage.OrderCompleted();
        Assert.assertEquals(checkOutStepPage.OrderCompleted(),"Thank you for your order!");
    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}
