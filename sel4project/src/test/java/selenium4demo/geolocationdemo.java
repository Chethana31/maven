package selenium4demo;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class geolocationdemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumsoftware\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(35.825), Optional.of(-72.453), Optional.of(100)));

	}

}
