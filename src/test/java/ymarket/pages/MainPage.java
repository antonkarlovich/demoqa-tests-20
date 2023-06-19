package ymarket.pages;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openPage() {
        open("https://market.yandex.ru/");
        return this;
    }

    public MainPage setValueToInputAndPressEnter(String value) {
        $("#header-search").setValue(value).pressEnter();
        return this;
    }
}
