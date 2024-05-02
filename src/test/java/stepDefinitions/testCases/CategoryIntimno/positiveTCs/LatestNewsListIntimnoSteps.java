package stepDefinitions.testCases.CategoryIntimno.positiveTCs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.IntimnoPageCategory;
import pageObjects.TopStoriesPageCategory;

public class LatestNewsListIntimnoSteps {

    private IntimnoPageCategory intimnoPageCategory;

    public LatestNewsListIntimnoSteps(IntimnoPageCategory intimnoPageCategory) {
        this.intimnoPageCategory = intimnoPageCategory;
    }

    @Given("User opens url {string} to verify that the list with latest articles is presented in Intimno")
    public void user_opens_url_to_verify_that_the_list_with_latest_articles_is_presented_in_intimno(String url) {
        intimnoPageCategory.navigateToSiteURL(url);
        intimnoPageCategory.acceptCookieButton();
    }
    @Then("User is successfully navigated to Intimno page and latest articles list is successfully presented")
    public void user_is_successfully_navigated_to_intimno_page_and_latest_articles_list_is_successfully_presented() {
        intimnoPageCategory.latestArticlesListPresented();
    }

}
