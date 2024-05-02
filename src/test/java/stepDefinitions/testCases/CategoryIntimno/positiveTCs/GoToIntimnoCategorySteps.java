package stepDefinitions.testCases.CategoryIntimno.positiveTCs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.HomePage;
import pageObjects.IntimnoPageCategory;
import pageObjects.TopStoriesPageCategory;

public class GoToIntimnoCategorySteps {

    private HomePage homePage;
    private IntimnoPageCategory intimnoPageCategory;

    public GoToIntimnoCategorySteps(HomePage homePage, IntimnoPageCategory intimnoPageCategory) {
        this.homePage = homePage;
        this.intimnoPageCategory = intimnoPageCategory;
    }

    @Given("User opens the following url {string} to open Intimno category")
    public void user_opens_the_following_url_to_open_интино_category(String url) {
        homePage.openBrowser(url);
    }

    @And("User clicks on hamburger menu top open Intimno category")
    public void user_clicks_on_hamburger_menu_top_open_intimno_category() {
        homePage.clickOnHamburgerMenu();
    }

    @And("User clicks on Intimno category")
    public void user_clicks_on_intimno_category() {
        homePage.openDropdownSelectIntinmo();
    }

    @Then("User is navigated to Intimno page")
    public void user_is_navigated_to_intimno_page() {
        intimnoPageCategory.intimnoCategoryTitleListed();
    }

}
