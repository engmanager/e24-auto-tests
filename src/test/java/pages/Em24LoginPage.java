package pages;

import com.microsoft.playwright.Page;

public class Em24LoginPage extends BasePage {
    public final String inputEmailSelector = "xpath=(//input[@id='user_email'])";
    public final String inputPasswordSelector = "xpath=(//input[@id='user_password'])";
    public final String logInButtonSelector = "xpath=(//input[@class='btn btn-default submit'])";
    public final String checkboxDataProcessingConsent = "xpath=(//input[@id='user_confirm_personal_data_processing'])";
    public final String flashNotification = "xpath=(//div[@id='flash'])";

    public Em24LoginPage(Page page) {
        super(page);
    }

    public Em24LoginPage navigate() {
        page.navigate(baseUrl + "/users/sign_in");
        waitForPageLoad();
        return this;
    }

    public String getFlashText() {
        String text = page.locator(flashNotification).textContent();
        return text != null ? text.trim() : "";
    }

    public Em24DashboardPage clickLogInButtonSelector() {
        page.click(logInButtonSelector);
        return new Em24DashboardPage(page);
    }
    public Em24DashboardPage loginAsUser(String userName, String userPassword) {
        this.navigate();
        page.fill(inputEmailSelector, userName);
        page.fill(inputPasswordSelector, userPassword);
        page.check(checkboxDataProcessingConsent);
        return this.clickLogInButtonSelector();
    }

}