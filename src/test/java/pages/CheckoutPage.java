package pages;

import static com.codeborne.selenide.Selenide.$;

/**
 * Страница отплаты
 */
public class CheckoutPage {
    /**
     * Проверка, что отрбразилась страница отплаты
     */
    public Boolean isCheckoutPage(){
        return $("#checkout-addresses-step").exists();
    }
}
