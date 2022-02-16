package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class removecustomer {

    WebDriver driver;

    @Given("Open Site")
    public void open_site() {
        System.setProperty("webdriver.chrome.driver","src/test/java/utils/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");
    }

    @When("Select Version")
    public void select_version() {
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.id("switch-version-select")));
        Select selectversion = new Select(driver.findElement(By.id("switch-version-select")));
        selectversion.selectByVisibleText("Bootstrap V4 Theme");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("click on the search name column")
    public void click_on_the_search_name_column() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[3]/input")).sendKeys("Teste Sicredi");
    }

    @When("click on the checkbox")
    public void click_on_the_checkbox() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input")).click();
    }

    @When("click delete button")
    public void click_delete_button() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[2]/div[1]/a")).click();
    }

    @When("validate message")
    public void validate_message() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]")).getText().contentEquals("Are you sure that you want to delete this 1 item?");
    }

    @Then("click delete popup and check message")
    public void click_delete_popup_and_check_message() {
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click();
        driver.findElement(By.xpath("/html/body/div[3]")).getText().contentEquals("Your data has been successfully deleted from the database." );

        driver.quit();
    }
}
