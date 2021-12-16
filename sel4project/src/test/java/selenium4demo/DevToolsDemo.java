package selenium4demo;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.devtools.v94.network.model.ConnectionType;

public class DevToolsDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumsoftware\\chromedriver_win32\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = ((ChromiumDriver)driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.send(Network.emulateNetworkConditions(false, 100, 1000, 2000, Optional.of(ConnectionType.WIFI)));
		
		//devTools.addListener(loadingFailed(),loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED"));
		driver.get("http://demowebshop.tricentis.com/login");

	}

}
