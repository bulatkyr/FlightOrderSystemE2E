package cz.cvut.fel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightOrderSystemTest {

  WebDriver driver;

  @BeforeAll
  static void setupClass() {
    WebDriverManager.firefoxdriver().setup();
  }

  @BeforeEach
  void setupTest() {
    driver = new FirefoxDriver();
  }

  @AfterEach
  void teardown() {
    driver.quit();
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
}
