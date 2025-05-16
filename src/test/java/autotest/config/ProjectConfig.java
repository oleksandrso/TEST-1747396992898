package autotest.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("edge")
    String browser();

    @DefaultValue("136.0.3240.50")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    String browserMobileView();

    String remoteDriverUrl();

    String videoStorage();

    @DefaultValue("https://www.google.com/")
    String baseUrl();
}
