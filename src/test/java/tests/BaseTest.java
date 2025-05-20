package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import pages.BasePage;

public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;

    protected BrowserContext context;
    protected Page page;

    public String userName = System.getenv("TEST_USER_NAME");
    public String password = System.getenv("TEST_USER_PASSWORD");

    @BeforeAll
    static void launchBrowser() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false);
        playwright = Playwright.create();
        browser = playwright.chromium().launch(launchOptions);
    }

    @AfterAll
    static void closeBrowser() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        if (context != null) {
            context.close();
        }
    }


    protected <T extends BasePage> T getPage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(Page.class).newInstance(page);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page object", e);
        }
    }
}