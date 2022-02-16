package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;



public class addcustomer {

    WebDriver driver;

    @Given("go to site")
    public void go_to_site() {
        
        System.setProperty("webdriver.chrome.driver","src/test/java/utils/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");
    }

    @When("change the version select")
    public void change_the_version_select() {

        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.id("switch-version-select")));
        Select selectversion = new Select(driver.findElement(By.id("switch-version-select")));
        selectversion.selectByVisibleText("Bootstrap V4 Theme");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("click add button")
    public void click_add_button() {
        driver.findElement(By.cssSelector("a[class='btn btn-default btn-outline-dark']")).click();
    }

    @When("write forms")
    public void write_forms() {
        System.out.println("write forms");
        driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Marcos Vinicius");
        driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil,3970");
        driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
        driver.findElement(By.id("field-country")).sendKeys("Brasil");

        driver.findElement(By.id("field_salesRepEmployeeNumber_chosen")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[11]/div/div/div/div/input")).sendKeys("Fixter");
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[11]/div/div/div/div/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.id("field-creditLimit")).sendKeys("200");

    }

    @When("click to save")
    public void click_to_save() {
        driver.findElement(By.id("form-button-save")).submit();
    }

    @When("check message")
    public void check_message() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/form/div[15]/div[2]")).getText().contentEquals("Your data has been successfully stored into the database.");

    }
    @Then("click link go back to list")
    public void click_link_go_back_to_list() {
        driver.findElement(By.id("save-and-go-back-button")).click();
        driver.quit();

    }
    // FIM
}