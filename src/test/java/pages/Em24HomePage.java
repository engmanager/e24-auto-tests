package pages;

import com.microsoft.playwright.Page;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Em24HomePage extends BasePage {
    private final String navBrandSelector = "xpath=(//a[@class='navbar-brand' and text()='EManagement24'])";

    private final String baseMenuSelector = "xpath=(//a[@class='nav-link'])";
    private final String functionsSelector = baseMenuSelector + "[1]";
    private final String missionSelector = baseMenuSelector + "[2]";
    private final String aboutUsSelector = baseMenuSelector + "[3]";
    private final String feedbackSelector = baseMenuSelector + "[4]";
    private final String logInSelector = baseMenuSelector + "[5]";
    private final String knowledgeBaseSelector = baseMenuSelector + "[6]";



    public Em24HomePage(Page page) {
        super(page);
    }

    public Em24HomePage navigate() {
        page.navigate(baseUrl);
        waitForPageLoad();
        return this;
    }

    public Em24LoginPage clickLogInSelector() {
        page.click(logInSelector);
        return new Em24LoginPage(page);
    }

    public Em24HomePage switchLanguage(String locale) {
        String languageSelector = "xpath=(//a[text()='" + locale + "'])";
        page.click(languageSelector);
        page.waitForLoadState();
        return this;
    }

    public boolean verifyHomePageElementsVisibleInUaLanguage() {
        String loginSelectorText = getElementText(logInSelector);
        assertTrue(loginSelectorText.contains("Вхід"), "NavBrand text should contain 'Вхід', but was: '" + loginSelectorText + "'");
        assertTrue(isElementVisible(logInSelector), "Login link should be visible on the home page");
        assertTrue(isElementVisible(navBrandSelector), "NavBrand element should be visible");
        return true;
    }

    public boolean verifyHomePageElementsVisibleInEnLanguage() {
        String loginSelectorText = getElementText(logInSelector);
        assertTrue(loginSelectorText.contains("Log in"), "NavBrand text should contain 'Log In', but was: '" + loginSelectorText + "'");
        assertTrue(isElementVisible(logInSelector), "Login link should be visible on the home page");
        assertTrue(isElementVisible(navBrandSelector), "NavBrand element should be visible");
        return true;
    }

}