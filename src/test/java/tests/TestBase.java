package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void beforeAll() {
        //   Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1220x780";
        Configuration.baseUrl = "https://demoqa.com";
    }

}
