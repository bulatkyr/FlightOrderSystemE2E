package cz.cvut.fel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOwnerPage {

    @FindBy(id="firstName")
    private WebElement firstNameInput;
    @FindBy(id="lastName")
    private WebElement lastNameInput;
    @FindBy(id="address")
    private WebElement addressInput;
    @FindBy(id="city")
    private WebElement cityInput;
    @FindBy(id="telephone")
    private WebElement telephoneInput;

    private final WebDriver driver;

    public NewOwnerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFirstName(String firstName){
        this.firstNameInput.sendKeys(firstName);
    }

    public void fillLastName(String lastName){
        this.lastNameInput.sendKeys(lastName);
    }

    public void submitForm() {
        this.driver.findElement(By.className("btn")).click();
    }
}
