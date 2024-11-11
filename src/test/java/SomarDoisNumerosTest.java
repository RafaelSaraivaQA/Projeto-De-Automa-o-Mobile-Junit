import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class SomarDoisNumerosTest {

    public static AndroidDriver driver;

    @Test
    public void testeDeSomarDoisNumeros() throws MalformedURLException {
        //cria o driver para o appium conectar no emulador android já entrando no app
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:app", System.getProperty("user.dir")+"/app/calculator-7-8-271241277.apk");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("apiium:platformName","Android");
        capabilities.setCapability("appium:autoGrantPermissions", "true");
        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);

        //clica no numero 2
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();

        //clica no botao de soma
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();

        //clica no numero 5
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

        //clica no botao igual
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        Assertions.assertTrue(driver.findElement(By.id("com.google.android.calculator:id/result_final")).isDisplayed());
    }
}
