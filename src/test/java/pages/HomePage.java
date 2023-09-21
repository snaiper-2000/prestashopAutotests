package pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Домашняя страница
 */
public class HomePage {
    /**
     * Открытие домашней страницы
     */
    public void openHomePage() {
        open("https://demo.prestashop.com/");
    }

    /**
     * нажать на товар
     */
    public void clickOnGood(String name) {
        $(By.xpath("//div[@class = 'product-description']//a[text() = '" + name + "']"))
                .shouldBe(visible, Duration.ofSeconds(20)).click();
    }

    /**
     * Проверка количества товаров в корзине
     */
    public void checkСartOfGoods(Integer count) {
        $(By.xpath("//span[@class = 'cart-products-count']")).shouldBe(visible, Duration.ofSeconds(20));
        $(By.xpath("//span[@class = 'cart-products-count']")).shouldHave(text(count.toString()));
    }
}
