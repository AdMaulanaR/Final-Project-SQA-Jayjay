package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static helper.Utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebPage {

    By input_username = By.id("user-name");
    By input_pass = By.id("password");
    By button_login = By.id("login-button");
    By button_menu = By.id("react-burger-menu-btn");
    By button_logout = By.id("logout_sidebar_link");
    By product_title = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    By text_error_msg (String msg){
        return By.xpath("//*[contains(text(), '"+ msg +"')]");
    }
    By icon_shopping_cart = By.id("shopping_cart_container");
    By your_cart = By.xpath("//*[text()='Your Cart']");
    By add_one_item = By.xpath("(//*[text()='Add to cart'])[1]");
    By remove_item = By.xpath("(//*[text()='Remove'])[1]");
    By shooping_cart_badge = By.xpath("//span[(@class='shopping_cart_badge')]");
    By btn_checkout = By.id("checkout");
    By first_name = By.id("first-name");
    By last_name = By.id("last-name");
    By postal_code = By.id("postal-code");
    By btn_continue = By.id("continue");
    By btn_finish = By.id("finish");
    By last_page = By.xpath("//h2[@class='complete-header']");
    By assert_your_info_page = By.xpath("//*[text()='Checkout: Your Information']");
    By btn_cancel = By.id("cancel");
    By btn_continue_shopping = By.id("continue-shopping");
    By btn_burger_menu = By.id("react-burger-menu-btn");
    By btn_about = By.id("about_sidebar_link");
    By sauce_labs_page = By.xpath("//*[text()='Sauce Labs Platform for Test']");


    public void isOnLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }
    public void inputUserName(String username){
        driver.findElement(input_username).sendKeys(username);
    }
    public void inputPassword(String password){
        driver.findElement(input_pass).sendKeys(password);
    }
    public void clickButtonlogin(){
        driver.findElement(button_login).click();
    }
    public void isOnHomePage(){
        driver.findElement(product_title);
        WebElement productElement = driver.findElement(product_title);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Bike Light", productElement.getText());
    }
    public void clickButtonMenu(){
        driver.findElement(button_menu).click();
    }
    public void clickButtonlogout(){
        driver.findElement(button_logout).click();
    }
    public void assertErrorMessage(String errormsg){
        driver.findElement(text_error_msg(errormsg)).isDisplayed();
    }
    public void clickIconShoppingCart(){
        driver.findElement(icon_shopping_cart).click();
    }
    public void yourCartPage(){
        driver.findElement(your_cart);
        WebElement yourCart = driver.findElement(your_cart);
        assertTrue(yourCart.isDisplayed());
    }
    public void seeIconToCart(){
        driver.findElement(icon_shopping_cart);
        WebElement yourCart1 = driver.findElement(icon_shopping_cart);
        assertTrue(yourCart1.isDisplayed());
    }
    public void addOneItemToCart(){
        driver.findElement(add_one_item).click();
    }
    public void assertCartItem(String cartItem){
        String itemActual = driver.findElement(shooping_cart_badge).getText();
        Assertions.assertThat(cartItem).isEqualTo(itemActual);
    }
    public void removeItem(){
        driver.findElement(remove_item).click();
    }
    public void btnCheckout(){
        driver.findElement(btn_checkout).click();
    }
    public void inputFirstName(String firstname){
        driver.findElement(first_name).sendKeys(firstname);
    }
    public void inputLastName(String lastname){
        driver.findElement(last_name).sendKeys(lastname);
    }
    public void inputPostalCode(String postalcode){
        driver.findElement(postal_code).sendKeys(postalcode);
    }
    public void clickContinue(){
        driver.findElement(btn_continue).click();
    }
    public void clickFinish(){
        driver.findElement(btn_finish).click();
    }
    public void lastPage(String header){
        String headerWord = driver.findElement(last_page).getText();
        Assertions.assertThat(header).isEqualTo(headerWord);
    }
    public void yourInfoPage(){
        driver.findElement(assert_your_info_page);
        WebElement yourInfo = driver.findElement(assert_your_info_page);
        assertTrue(yourInfo.isDisplayed());
    }
    public void clickCancel(){
        driver.findElement(btn_cancel).click();
    }
    public void clickContinueShopp(){
        driver.findElement(btn_continue_shopping).click();
    }
    public void clickBtnBurgerMenu(){
        driver.findElement(btn_burger_menu).click();
    }
    public void clickBtnAbout(){
        driver.findElement(btn_about).click();
    }
    public void sauceLabsPage(){
        driver.findElement(sauce_labs_page);
        WebElement yourInfo = driver.findElement(sauce_labs_page);
        assertTrue(yourInfo.isDisplayed());
    }

}
