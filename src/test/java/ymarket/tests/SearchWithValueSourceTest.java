package ymarket.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SearchWithValueSourceTest extends BaseTest {

    @ValueSource(strings = {"Пылесосы", "Холодильники", "Стиральные машины"})

    @ParameterizedTest(name = "Результаты поиска должны содержать наименование товара: {0}")
    @Tags({
            @Tag("SMOKE"),
            @Tag("Web")
    })
    void searchResultShouldHaveValidValue(String value) {
        mainPage.openPage()
                .setValueToInputAndPressEnter(value);
        resultSearchPage.blockProductShouldHaveText(value);
    }
}
