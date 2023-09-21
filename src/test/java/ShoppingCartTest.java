import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CartPage;
import pages.CheckoutPage;
import pages.GoodPage;
import pages.HomePage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ShoppingCartTest {

    private HomePage homePage = new HomePage();
    private CartPage cartPage = new CartPage();
    private GoodPage goodPage = new GoodPage();
    private CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeMethod
    public void setUp() {
        // Настройка Selenide
        Configuration.browser = "chrome";


        // Открытие домашней страницы
        homePage.openHomePage();
        // Максимизируем окно браузера
        getWebDriver().manage().window().maximize();
        // Переключение на фрейм
        getWebDriver().switchTo().frame("framelive");
    }

    @Test(description = "Добавление товара в корзину")
    public void testAddToCart() {
        // Given
        homePage.checkСartOfGoods(0);

        // When
        homePage.clickOnGood("Hummingbird printed sweater");
        goodPage.addToCartOneGood();
        goodPage.proceedToCheckout();

        // Then
        homePage.checkСartOfGoods(1);
        cartPage.checkGoodByName("Hummingbird printed sweater");
        // Проверяем, что в корзине появилась одна позиция товара
        Integer cartItemCount = cartPage.getCartItemCount();
        Assert.assertEquals(cartItemCount, 1);
    }

    @Test(description = "Добавление нескольких товаров в корзину")
    public void testAddMultipleItemsToCart() {
        // Given
        homePage.checkСartOfGoods(0);

        // When
        homePage.clickOnGood("Hummingbird printed sweater");
        goodPage.addToCartSomeGoods(2);
        goodPage.proceedToCheckout();

        // Then
        homePage.checkСartOfGoods(2);
        cartPage.checkGoodByName("Hummingbird printed sweater");
        // Проверяем, что в корзине появилась две позиция товара
        Assert.assertEquals(cartPage.getCartItemCount(), 2);
    }

    @Test(description = "Оформление заказа из корзины")
    public void testCheckoutFromCart() {
        // Given
        homePage.checkСartOfGoods(0);

        // When
        homePage.clickOnGood("Hummingbird printed sweater");
        goodPage.addToCartOneGood();
        goodPage.proceedToCheckout();
        cartPage.checkoutFromCart();

        // Then
        Assert.assertTrue(checkoutPage.isCheckoutPage());
    }

    @Test(description = "Проверка возможности удаления товара из корзины")
    public void testRemoveItemFromCart() {
        // Given
        homePage.clickOnGood("Hummingbird printed sweater");
        goodPage.addToCartOneGood();
        goodPage.proceedToCheckout();

        // When
        cartPage.removeItemFromCart();
        cartPage.goToCart();

        // Проверяем, что товар успешно удален из корзины
        Assert.assertEquals(cartPage.getCartItemCount(), 0);
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
