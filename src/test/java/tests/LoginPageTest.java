package tests;

import org.junit.jupiter.api.Test;
import pages.Em24HomePage;
import pages.Em24LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoginPageTest extends BaseTest {


    @Test
    void shouldBeCorrectErrorMessageAboutWrongPassword(){
        Em24HomePage em24HomePage = getPage(Em24HomePage.class);
        em24HomePage.navigate();
        Em24LoginPage em24LoginPage = em24HomePage.clickLogInSelector();
        em24LoginPage.page.locator(em24LoginPage.inputEmailSelector).fill(userName);
        em24LoginPage.page.locator(em24LoginPage.inputPasswordSelector).fill("WrongPassword");
        em24LoginPage.page.locator(em24LoginPage.checkboxDataProcessingConsent).check();
        em24LoginPage.page.locator(em24LoginPage.logInButtonSelector).click();
        String errorMessage = em24LoginPage.getFlashText();
        assertEquals("Невірний логін або пароль", errorMessage);
    }

}
