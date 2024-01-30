package com.prestashop.demo.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BasePage<T extends BasePage> {
    private String url;
    protected SelenideElement pageIdentifier;

    public BasePage(SelenideElement pageIdentifier) {
        this.pageIdentifier = pageIdentifier;
    }

    public BasePage(SelenideElement pageIdentifier, String url) {
        this.pageIdentifier = pageIdentifier;
        this.url = url;
    }

    public T assertPageElementsLoaded() {
        pageIdentifier.should(Condition.appear);
        return (T) this;
    }

    public T open() {
        if (url == null) {
            Selenide.open();
        } else {
            Selenide.open(url);
        }

        assertPageElementsLoaded();
        return (T) this;
    }
}