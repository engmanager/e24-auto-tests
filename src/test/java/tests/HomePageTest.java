package tests;
import org.junit.jupiter.api.*;
import pages.Em24HomePage;
import static org.junit.jupiter.api.Assertions.*;

public class HomePageTest extends BaseTest {

    @Test
    void shouldOpenE24HomePageAndVerifyRequiredElementsInUaLanguage() {
        Em24HomePage em24HomePage = getPage(Em24HomePage.class);
        em24HomePage.navigate();
        em24HomePage.switchLanguage("ua");
        String title = em24HomePage.getTitle();
        assertTrue(title.contains("Emanagement24.com"), "Page title should contain 'Emanagement24.com'");
        assertTrue(em24HomePage.verifyHomePageElementsVisibleInUaLanguage(), "All required elements should be visible");
    }

    @Test
    void shouldOpenE24HomePageAndVerifyRequiredElementsInEnLanguage() {
        Em24HomePage em24HomePage = getPage(Em24HomePage.class);
        em24HomePage.navigate();
        em24HomePage.switchLanguage("en");
        String title = em24HomePage.getTitle();
        assertTrue(title.contains("Emanagement24.com"), "Page title should contain 'Emanagement24.com'");
        assertTrue(em24HomePage.verifyHomePageElementsVisibleInEnLanguage(), "All required elements should be visible");
    }


}