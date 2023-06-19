package ymarket.pages;

import com.codeborne.selenide.CollectionCondition;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultSearchPage {

    public ResultSearchPage blockProductShouldHaveText(String value) {
        $("._3RoU0").shouldHave(text(value));
        return this;
    }

    public ResultSearchPage menuShouldHaveText(List<String> value) {
        $$(".KAefG").shouldHave(CollectionCondition.texts(value));
        return this;
    }
}
