package stepDefinitions.testCases.CategoryIntimno.positiveTCs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.IntimnoPageCategory;
import pageObjects.TopStoriesPageCategory;

public class MainListFirstArticleIntimnoSteps {

    private IntimnoPageCategory intimnoPageCategory;

    public MainListFirstArticleIntimnoSteps(IntimnoPageCategory intimnoPageCategory) {
        this.intimnoPageCategory = intimnoPageCategory;
    }

    @Given("User opens url {string} to verify that the first article is listed successfully")
    public void user_opens_url_to_verify_that_the_first_article_is_listed_successfully(String url) {
        intimnoPageCategory.navigateToSiteURL(url);
    }

    @Then("User is navigated to Intimno's page and first article is successfully listed")
    public void user_is_navigated_to_intimno_s_page_and_first_article_is_successfully_listed() {
        intimnoPageCategory.firstArticleListedMainList();
    }

}
