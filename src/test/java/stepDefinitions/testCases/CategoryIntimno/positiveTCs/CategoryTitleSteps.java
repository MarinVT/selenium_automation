package stepDefinitions.testCases.CategoryIntimno.positiveTCs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.IntimnoPageCategory;


public class CategoryTitleSteps {

    private IntimnoPageCategory intimnoPageCategory;

    public CategoryTitleSteps(IntimnoPageCategory intimnoPageCategory) {
        this.intimnoPageCategory = intimnoPageCategory;
    }

    @Given("User opens {string} to verify that the category title Интимно is listed")
    public void user_opens_to_verify_that_the_category_title_интимно_is_listed(String url) {
        intimnoPageCategory.openTopStoryPageURL(url);
    }

    @And("User sees the category title Интимно listed above the lead news section")
    public void user_sees_the_category_title_listed_above_the_lead_news_section() {
        intimnoPageCategory.intimnoCategoryTitleListed();
    }
}
