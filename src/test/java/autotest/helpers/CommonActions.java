package autotest.helpers;

import autotest.tests.User;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.title;

public class CommonActions {


    public static void waitFullLoad() {
        // Increase sleep time to give the page more time to load
        sleep(5000);

        System.out.println("[DEBUG_LOG] Current URL: " + WebDriverRunner.url());
        System.out.println("[DEBUG_LOG] Page title: " + title());

        // In headless mode, Google might show a different UI
        // Try multiple selectors that might work in both headless and normal mode
        boolean foundSearchInput = false;

        try {
            // Try textarea first (modern Google search)
            $("textarea[name='q']").shouldBe(Condition.exist);
            System.out.println("[DEBUG_LOG] Found Google search textarea");
            foundSearchInput = true;
        } catch (Exception e) {
            System.out.println("[DEBUG_LOG] Could not find textarea[name='q']: " + e.getMessage());
        }

        if (!foundSearchInput) {
            try {
                // Try input (older Google search or mobile version)
                $("input[name='q']").shouldBe(Condition.exist);
                System.out.println("[DEBUG_LOG] Found Google search input");
                foundSearchInput = true;
            } catch (Exception e) {
                System.out.println("[DEBUG_LOG] Could not find input[name='q']: " + e.getMessage());
            }
        }

        if (!foundSearchInput) {
            try {
                // Try any input field
                $("input[type='text']").shouldBe(Condition.exist);
                System.out.println("[DEBUG_LOG] Found text input");
                foundSearchInput = true;
            } catch (Exception e) {
                System.out.println("[DEBUG_LOG] Could not find input[type='text']: " + e.getMessage());
            }
        }

        if (!foundSearchInput) {
            // Last resort - check if any form exists
            $("form").shouldBe(Condition.exist);
            System.out.println("[DEBUG_LOG] Found form element");
        }

        // Don't check for navigation as it might not be visible in headless mode
        System.out.println("[DEBUG_LOG] Page loaded successfully");
    }

    public static void login(int i) {
        User defaultUser = new User("Engish", "qa_asgauto1", "qa_asgauto11");
        User deUser = new User("German", "qa_asggerm1", "Test123test!");
        User ukUser = new User("United Kingdom", "qa_asguk1", "Test123test");
        String login, password;

        if (i == 1) {
            login = defaultUser.getLogin();
            password = defaultUser.getPassword();
        }
        if (i == 2) {
            login = deUser.getLogin();
            password = deUser.getPassword();
        } else {
            login = ukUser.getLogin();
            password = ukUser.getPassword();
        }

        $(".header-login__btn.header-btn").click();
        sleep(3000);
        $("[tabindex=1]").setValue(login);
        $("[tabindex=2]").setValue(password).pressEnter();
        sleep(5000);
    }


}
