package pages;

import com.microsoft.playwright.Page;

public class Em24DashboardPage extends BasePage {

    public Em24DashboardPage(Page page) {
        super(page);
    }

    public Em24BuildingsPage leftSideBarNavigateTo(String  targetPage){
        String itemsLocator = "xpath=(//a[normalize-space(text())='"+ targetPage +"'])";
        if (targetPage.equals("Buildings")) {
            page.locator(itemsLocator).click();
            return new Em24BuildingsPage(page);
        }
        else
            return null; //add error message
    }
}
