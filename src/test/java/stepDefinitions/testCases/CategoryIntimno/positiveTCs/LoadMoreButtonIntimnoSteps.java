package stepDefinitions.testCases.CategoryIntimno.positiveTCs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.IntimnoPageCategory;
import pageObjects.TopStoriesPageCategory;

public class LoadMoreButtonIntimnoSteps {

    private IntimnoPageCategory intimnoPageCategory;

    public LoadMoreButtonIntimnoSteps(IntimnoPageCategory intimnoPageCategory) {
        this.intimnoPageCategory = intimnoPageCategory;
    }

    @Given("User opens {string} to verify that the view all button listed in Intimno")
    public void user_opens_to_verify_that_the_view_all_button_listed_in_intimno(String url) {
        intimnoPageCategory.navigateToSiteURL(url);
    }

    @And("User sees Load more button listed on the page successfully with text {string}")
    public void user_sees_load_more_button_listed_on_the_page_successfully_with_text(String titleViewAllButton) {
        intimnoPageCategory.scrollDownToLoadMoreButton();
        intimnoPageCategory.loadMoreButtonListed(titleViewAllButton);
    }

}
