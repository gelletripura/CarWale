package week4.day2;

import java.awt.Point;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarWale {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		EdgeDriver driver = new EdgeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		String title = driver.getTitle();
		System.out.println("Title of Browser is : " + title);
		driver.findElement(By.xpath("//span[text()='Used']")).click();
		WebElement enter = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		enter.sendKeys("Chennai");
		Actions builder = new Actions(driver);
		builder.moveToElement(enter).click().perform();
		driver.findElement(By.xpath("//div[text()='Choose your Budget']")).click();
		WebElement slider = driver.findElement(By.xpath("//button[@type='button']/div"));
		builder.clickAndHold(slider).dragAndDropBy(slider, 72, 78).perform();
		WebElement slider1 = driver.findElement(By.xpath("//button[2][@type='button']/div"));
		builder.clickAndHold(slider1).dragAndDropBy(slider1, -125, -109).perform();
		Thread.sleep(2000);
		
		/*
		 * WebElement Webdisappear =
		 * driver.findElement(By.xpath("//button[2][@type='button']/div"));
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 * wait.until(ExpectedConditions.invisibilityOf(Webdisappear));
		 */
		WebElement result = driver.findElement(By.xpath("//div[@class='o-brXWGL _2BQG7k']/div"));
		String s = result.getText();
		System.out.println("Selected car price range is :" + s);

	}

}
