package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Страница корзины
 */
public class CartPage {
    /**
     * Получить количество товаров в корзине
     */
    public Integer getCartItemCount() {
        return Integer.parseInt($(".cart-products-count").getText().replaceAll("[^0-9]", ""));
    }

    /**
     * Проверка товара по названию
     */
    public void checkGoodByName(String name){
        $(By.xpath("//a[text() = '"+name+"']")).shouldBe(visible, Duration.ofSeconds(10));
    }

    /**
     * Купить выбранные товары
     */
    public void checkoutFromCart(){
        $(By.xpath("//div[@class = 'text-sm-center']/a")).shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    /**
     * Удалить товар из корзины
     */
    public void removeItemFromCart() {
        $(By.xpath("//a[@class = 'remove-from-cart']")).click();
    }

    public void goToCart(){
        $(".cart-products-count").click();
    }
}
