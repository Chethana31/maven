package selenium4demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;

public class PerformanceMatrics {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumsoftware\\chromedriver_win32\\chromedriver.exe");

		
		ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
       
        
		/*Map deviceMetrics = new HashMap()
        {{
            put("width", 600);
            put("height", 1000);
            put("mobile", true);
            put("deviceScaleFactor", 50);
        }};
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);*/
        
        devTools.send(Emulation.setDeviceMetricsOverride(375, 812, 50, true, 
        		Optional.empty(), Optional.empty(), Optional.empty(), 
        		Optional.empty(), Optional.empty(), Optional.empty(), 
        		Optional.empty(), Optional.empty()));
        //driver.get("https://www.google.com");
        driver.get("https://selenium.dev/");
        

	}

}
