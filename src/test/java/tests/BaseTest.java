package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;
import java.util.UUID;

import pages.BasePage;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    protected String headlessEnv = System.getenv("HEADLESS");
    protected String setHeadless = (headlessEnv == null || headlessEnv.isEmpty()) ? "true" : headlessEnv;

    public String userName = System.getenv("TEST_USER_NAME");
    public String password = System.getenv("TEST_USER_PASSWORD");

    @BeforeEach
    void setupTest() {
        playwright = Playwright.create();

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(Boolean.parseBoolean(setHeadless));

        browser = playwright.chromium().launch(launchOptions);

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("target/videos/" + UUID.randomUUID().toString()));

        context = browser.newContext(contextOptions);

        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true));

        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        if (context != null) {
            String testName = getClass().getSimpleName();
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("target/traces/" + testName + "-" + UUID.randomUUID() + ".zip")));
            context.close();
        }

        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
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