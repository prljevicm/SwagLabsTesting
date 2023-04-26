import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutStepPage extends BasePage{
    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(css = "div.summary_subtotal_label")
    WebElement itemPrice;
    @FindBy(css = "div.summary_total_label")
    WebElement totalPrice;
    @FindBy(id = "finish")
    WebElement finish;
    @FindBy(className = "complete-header")
    WebElement completeOrder;


    public CheckOutStepPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
    public void  EnterFirstName(String name){
        firstName.sendKeys(name);
    }
    public void EnterLastName (String last){
        lastName.sendKeys(last);
    }
    public void EnterPostalCode (String postal){
        postalCode.sendKeys(postal);
    }
    public void ClickOnContinueButton(){
        continueButton.click();
    }
    public String ItemPrice(){
        return itemPrice.getText();
    }
    public String TotalPrice(){
        return totalPrice.getText();
    }
    public void ClickOnFinishButton(){
        finish.click();
    }
    public String OrderCompleted(){
        return completeOrder.getText();
    }
}
