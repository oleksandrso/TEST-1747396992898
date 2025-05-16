package autotest.helpers;

import autotest.config.Project;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverSettings {

    public static void configure() {
        // Force browser to be "edge" regardless of configuration
        Configuration.browser = "edge";
        // Set browser version to the one specified in ProjectConfig
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.baseUrl = Project.config.baseUrl();
//        Configuration.baseUrl = App.config.webUrl();

        // Print debug information
        System.out.println("[DEBUG_LOG] Browser set to: " + Configuration.browser);
        System.out.println("[DEBUG_LOG] Browser version set to: " + Configuration.browserVersion);
        System.out.println("[DEBUG_LOG] Base URL set to: " + Configuration.baseUrl);

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Always use Edge options since we're forcing Edge browser
        EdgeOptions edgeOptions = new EdgeOptions();

        // Set the browser version directly in EdgeOptions
        edgeOptions.setBrowserVersion("136.0.3240.50");

        // Run browser in headless mode (in background) as per requirements
        edgeOptions.addArguments("--headless");
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-popup-blocking");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--lang=en-en");

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.config.remoteDriverUrl();
        }

        capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
        Configuration.browserCapabilities = capabilities;
    }
}
