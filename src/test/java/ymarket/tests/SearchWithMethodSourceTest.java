package ymarket.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class SearchWithMethodSourceTest extends BaseTest {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("Телефоны", List.of("Электроника", "Смартфоны и гаджеты", "Мобильные телефоны")),
                Arguments.of("Телевизоры", List.of("Электроника", "Телевизоры и аксессуары", "Телевизоры"))
        );
    }

    @MethodSource("dataProvider")
    @ParameterizedTest(name = "Результаты поиска товара: {0} должны содержать предлагаемые значения: {1}")
    @Tags({
            @Tag("SMOKE"),
            @Tag("Web")
    })
    void menuShouldHaveValidValue(String value, List<String> values) {
        mainPage.openPage()
                .setValueToInputAndPressEnter(value);
        resultSearchPage.menuShouldHaveText(values);
    }
}
