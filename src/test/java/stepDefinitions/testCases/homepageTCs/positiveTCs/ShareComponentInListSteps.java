package stepDefinitions.testCases.homepageTCs.positiveTCs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageObjects.HomePage;

public class ShareComponentInListSteps {

    private HomePage homePage;

    public ShareComponentInListSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("User opens the following url {string} to see the share component in list")
    public void user_opens_the_following_url_to_see_the_share_component_in_list(String url) {
        homePage.openBrowser(url);
    }
    @And("User is able to use the share component by hover on it")
    public void user_is_able_to_use_the_share_component_by_hover_on_it() {
        homePage.shareComponentListedUnderTheArticle();
    }

}
