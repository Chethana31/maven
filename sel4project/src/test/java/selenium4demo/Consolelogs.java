package selenium4demo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;

public class Consolelogs {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumsoftware\\chromedriver_win32\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();//create driver instance
		DevTools devTools = ((ChromiumDriver)driver).getDevTools();//Create devTool instance using driver instance 


		devTools.createSession();
		
		devTools.send(Log.enable());
		//devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.a));
		//devTools.addListener(Log.entryAdded(), logEntry -> {System.out.println(logEntry.getText());
		
		devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    System.out.println("log: "+logEntry.getText());
                    System.out.println("level: "+logEntry.getLevel());
                });
		driver.get("http://demowebshop.tricentis.com/login");
		driver.findElement(By.id("Email")).sendKeys("kavyabr1@gmail.com");
        driver.findElement(By.name("Password")).sendKeys("rekhab");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        driver.findElement(By.linkText("Log out")).click();
        driver.close();
		}

}
