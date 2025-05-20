package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.WaitForSelectorState;


public abstract class BasePage {
    public Page page;

    public String baseUrl = System.getenv("BASE_URL");

    public BasePage(Page page) {
        this.page = page;
        waitForPageLoad();
    }

    public String getTitle() {
        return page.title();
    }

    public void waitForPageLoad() {
        page.waitForLoadState();
    }

    public boolean isElementVisible(String selector) {
        return page.isVisible(selector);
    }

    public String getElementText(String selector) {
        try {
            waitForElementVisible(selector);
            return page.locator(selector).textContent().trim();
        } catch (PlaywrightException e) {
            return "";
        }
    }

    protected void waitForElementVisible(String selector) {
        page.waitForSelector(selector, new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
    }

    protected void safeClick(String selector) {
        waitForElementVisible(selector);
        page.click(selector);
    }

    protected void safeFill(String selector, String text) {
        waitForElementVisible(selector);
        page.fill(selector, text);
    }
}