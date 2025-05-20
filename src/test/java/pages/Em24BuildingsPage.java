package pages;

import com.microsoft.playwright.Page;

public class Em24BuildingsPage extends BasePage {
    public final String buttonAdd = "xpath=(//a[@class='btn btn-success'])";


    public Em24BuildingsPage(Page page) {
        super(page);
    }
}
