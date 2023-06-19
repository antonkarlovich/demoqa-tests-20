package ymarket.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import ymarket.pages.MainPage;
import ymarket.pages.ResultSearchPage;

public class BaseTest {
    MainPage mainPage = new MainPage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }
}
