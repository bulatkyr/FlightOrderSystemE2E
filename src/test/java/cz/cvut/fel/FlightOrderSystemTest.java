package cz.cvut.fel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightOrderSystemTest {

  WebDriver driver;

  @BeforeAll
  static void setupClass() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setupTest() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
  }

  @AfterEach
  void teardown() {
    //    driver.quit();
  }

  @Test
  void get_title_test() {
    driver.get("https://ts1.v-sources.eu/");

    String title = driver.getTitle();

    assertEquals(title, "Flight order");
  }

  @Test
  void get_header_test() {
    driver.get("https://ts1.v-sources.eu/");

    String header = driver.findElement(By.tagName("h1")).getText();

    assertEquals(header, "Flight order");
  }

  @Test
  void fill_form_test() {
    driver.get("https://ts1.v-sources.eu/");

    driver.findElement(By.id("flight_form_firstName")).sendKeys("John");
    driver.findElement(By.id("flight_form_lastName")).sendKeys("Doe");
    driver.findElement(By.id("flight_form_email")).sendKeys("john.doe@gmail.com");
    driver.findElement(By.id("flight_form_destination")).click();
    driver.findElement(By.xpath("//option[@value=\"Paris\"]")).click();
  }

  @Test
  void find_missing_element() {
    driver.get("https://ts1.v-sources.eu/");

    driver.findElement(By.id("non-existing-id"));
  }

  @Test
  void element_not_interactable_exception_test() {
    driver.get("https://google.com/ncr");

    driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
  }

  @Test
  void test() {

    driver.get("https://spring-framework-petclinic-qctjpkmzuq-od.a.run.app/owners/new");

    driver.findElement(By.id("firstName")).sendKeys("John");
    driver.findElement(By.id("lastName")).sendKeys("Doe");
    driver.findElement(By.id("address")).sendKeys("Karlovo namesti 323");
    driver.findElement(By.id("city")).sendKeys("Prague");
    driver.findElement(By.id("telephone")).sendKeys("777888999");
    driver.findElement(By.className("btn")).click();

    WebElement firstResult =
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.className("btn")));
    firstResult.click();
  }

  @Test
  public void moodle() {
    driver.get("https://moodle.fel.cvut.cz/");
    WebElement firstResult =
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath(
                        "//div[contains(@class, 'card') and contains(@class, 'course-card')]")));
    firstResult.findElement(By.xpath(".//a")).click();
  }

  @Test
  public void test_1() {
    driver.get("https://spring-framework-petclinic-qctjpkmzuq-od.a.run.app/owners/new");
    NewOwnerPage page = new NewOwnerPage(driver);
    page.fillFirstName("John");
  }
}
