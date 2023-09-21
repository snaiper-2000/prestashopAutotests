package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница товара
 */
public class GoodPage {
    /**
     * Добавление товара в корзину
     */
    public void addToCartOneGood() {
        $(By.xpath("//button[@data-button-action = 'add-to-cart']")).shouldBe(visible, Duration.ofSeconds(20)).click();
    }

    /**
     * Добавить несколькр позиций товара в корзину
     */
    public void addToCartSomeGoods(Integer count){
        $(By.xpath("//input[@name = 'qty']")).sendKeys(Keys.DELETE);
        $(By.xpath("//input[@name = 'qty']")).setValue(count.toString());
        $(By.xpath("//button[@data-button-action = 'add-to-cart']")).click();
    }

    /**
     * Перейти к оформлению
     */
    public void proceedToCheckout(){
        $(By.xpath("//a[text() = 'Proceed to checkout']")).shouldBe(visible, Duration.ofSeconds(20)).click();
    }
}
