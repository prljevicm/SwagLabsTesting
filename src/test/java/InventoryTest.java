import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.BaseTest;

public class InventoryTest extends BaseTest {
    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void Setup() {
        driver = openBroswer();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

    }

    @Test
    public void ThreeCheapestItemsInCart(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.SortItemByValue();
        inventoryPage.AddOnesie();
        inventoryPage.AddBikeLight();
        inventoryPage.AddBoltTShirt();
        Assert.assertEquals(inventoryPage.Cart(),"3");
    }

    @Test
    public void AddAndRemoveItems(){
        loginPage.Login("standard_user","secret_sauce");
        inventoryPage.AddBikeLight();
        inventoryPage.AddBoltTShirt();
        inventoryPage.ClickOnCart();
        inventoryPage.RemoveBikeLight();
        inventoryPage.RemoveBoltTShirt();
        inventoryPage.ClickOnContinueShopping();
        Assert.assertEquals(inventoryPage.visibleBikeLight.isDisplayed(),true);
        Assert.assertEquals(inventoryPage.visibleBoltTShirt.isDisplayed(),true);

    }

    @AfterMethod
    public void After(){
        driver.quit();
    }
}
