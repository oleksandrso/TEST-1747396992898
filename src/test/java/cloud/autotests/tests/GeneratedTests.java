package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneratedTests extends TestBase {
@Test
@Description("Test based on provided steps")
@DisplayName("Google Test")
void testGoogleTest() {
    step("Open https://www.google.com Enter search query Check results", () -> {
open("https://www.google.com"); // TODO: Implement step: Open https://www.google.com Enter search query Check results
});
}

    @Test
@Description("Verify page title")
@DisplayName("Page title should match expected")
void testTitle() {
    step("Open url 'https://www.google.com'", () -> open("https://www.google.com"));
        step("Page title should have text 'Google'", () -> {
String expectedTitle = "Google";
String actualTitle = title();
assertThat(actualTitle).isEqualTo(expectedTitle);
});
}

    @Test
@Description("Verify no console errors")
@DisplayName("Page should have no console errors")
void testNoConsoleErrors() {
    step("Open url 'https://www.google.com'", () -> open("https://www.google.com"));
        step("Console logs should not contain text 'SEVERE'", () -> {
String consoleLogs = DriverUtils.getConsoleLogs();%nString errorText = "SEVERE";%nassertThat(consoleLogs).doesNotContain(errorText);
});
}

}
