package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

public class ResultTableComponent {

    public ResultTableComponent resultIsVisible(String key, String info) {
    $(".table-responsive table").$(byText(key))
            .parent().shouldHave(text(info));
        return this;
    }
}
