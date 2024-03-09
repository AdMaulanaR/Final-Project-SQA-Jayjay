package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebPage;

public class WebStep {

    WebPage webPage;
    public WebStep(){
        this.webPage = new WebPage();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage(){
        webPage.isOnLoginPage();
    }

    @And("user input user name {string}")
    public void userInputUserName(String username) {
        webPage.inputUserName(username);
    }
    @And("user input password {string}")
    public void userInputPassword(String password) {
        webPage.inputPassword(password);
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        webPage.clickButtonlogin();
    }

    @When("user is on home page")
    public void userIsOnHomePage() {
        webPage.isOnHomePage();
    }

    @And("user click button menu")
    public void userClickButtonMenu() {
        webPage.clickButtonMenu();
    }

    @Then("user click button logout")
    public void userClickButtonLogout() {
        webPage.clickButtonlogout();
    }
    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errmsg) {
        webPage.assertErrorMessage(errmsg);
    }
    @Then("user able to see login error message {string}")
    public void userAbleToSeeLoginErrorMessage(String lgnerrmsg) {
        webPage.assertErrorMessage(lgnerrmsg);
    }
    @When("user click icon shopping cart")
    public void userClickIconShoppingCart() {
        webPage.clickIconShoppingCart();
    }

    @Then("user will directed to the your cart page")
    public void userWillDirectedToTheYourCartPage() {
        webPage.yourCartPage();
    }

    @And("user will see icon to cart in home page")
    public void userWillSeeIconToCartInHomePage() {
        webPage.seeIconToCart();
    }

    @And("user add one item to cart")
    public void userAddOneItemToCart() {
        webPage.addOneItemToCart();
    }

    @Then("user verify cart item is match {string}")
    public void userVerifyCartItemIsMatch(String cartItem) {
        webPage.assertCartItem(cartItem);
    }

    @And("user remove one item to cart")
    public void userRemoveOneItemToCart() {
        webPage.removeItem();
    }
    @And("user click btn checkout")
    public void userClickBtnCheckout() {
        webPage.btnCheckout();
    }
    @And("user input first name {string}")
    public void userInputFirstName(String firstname) {
        webPage.inputFirstName(firstname);
    }
    @And("user input last name {string}")
    public void userInputLastName(String lastname) {
        webPage.inputLastName(lastname);
    }

    @And("user input postal code {string}")
    public void userInputPostalCode(String postalcode) {
        webPage.inputPostalCode(postalcode);
    }

    @And("user click btn continue")
    public void userClickBtnContinue() {
        webPage.clickContinue();
    }

    @And("user click btn finish")
    public void userClickBtnFinish() {
        webPage.clickFinish();
    }

    @And("user will directed in last page and sees the word {string}")
    public void userWillDirectedInLastPageAndSeesTheWord(String completeHeader) {
        webPage.lastPage(completeHeader);
    }

    @Then("user will directed in your information page")
    public void userWillDirectedInYourInformationPage() {
        webPage.yourInfoPage();
    }
    @And("user click btn cancel")
    public void userClickBtnCancel() {
        webPage.clickCancel();
    }
    @And("user click btn continue shopping")
    public void userClickBtnContinueShopping() {
        webPage.clickContinueShopp();
    }
}
