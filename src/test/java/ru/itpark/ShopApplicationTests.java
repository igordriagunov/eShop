package ru.itpark;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests extends WebDriverSettings {

    @Test
    public void contextLoads() {
    }

    @Test
    public void firstTest() {

        driver.get("localhost:8888/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("your Shop Main Page"));
    }

}
