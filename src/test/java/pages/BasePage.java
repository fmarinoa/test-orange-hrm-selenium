package pages;

import static hooks.Hooks.getDriver;

public class BasePage {

    public void getUrl(String url) {
        getDriver().get(url);
    }
}
