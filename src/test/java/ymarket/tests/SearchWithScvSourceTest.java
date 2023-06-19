package ymarket.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SearchWithScvSourceTest extends BaseTest {

    @CsvSource({
            "Телевизоры, Телевизоры",
            "Телефоны, Телефоны"
    })

    @ParameterizedTest(name = "Результаты поиска: {0} должны содержать наименование товара: {1}")
    @Tags({
            @Tag("SMOKE"),
            @Tag("Web")
    })
    void searchResultShouldHaveValidValue(String searchValue, String expectedValue) {
        mainPage.openPage()
                .setValueToInputAndPressEnter(searchValue);
        resultSearchPage.blockProductShouldHaveText(expectedValue);
    }
}
