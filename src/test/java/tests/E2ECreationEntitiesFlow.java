package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Em24BuildingsPage;
import pages.Em24DashboardPage;
import pages.Em24LoginPage;

public class E2ECreationEntitiesFlow extends BaseTest {

    private Em24DashboardPage dashboardPage;

    @BeforeEach
    void login() {
        Em24LoginPage loginPage = getPage(Em24LoginPage.class);
        dashboardPage = loginPage.loginAsUser(userName, password);
    }

    
    @Test
    void shouldBePossibleToCreateBuilding() {
        Em24BuildingsPage em24BuildingsPage = dashboardPage.leftSideBarNavigateTo("Buildings");
        System.out.println("continue writing");

    }
}
