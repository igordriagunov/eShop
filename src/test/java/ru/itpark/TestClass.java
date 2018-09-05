package ru.itpark;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestClass extends WebDriverSettings {

    @Test
    @DisplayName("open main page")
    public void openMainPage() {

        driver.get("localhost:8888/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("your Shop Main Page"));
    }

    @Test
    @DisplayName("add product to account")
    public void addProductTest() {


    }

}
