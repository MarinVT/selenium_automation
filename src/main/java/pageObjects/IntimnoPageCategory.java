package pageObjects;

import basePage.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntimnoPageCategory extends BasePage {

    public IntimnoPageCategory() {
        super();
    }

    /**
     * Test URL to compare
     */
    String intimnoURL = "https://hotnews.bg/intimno";

    // Accept cookie button locator
    @FindBy(xpath = "//button[contains(.,'Приемам')]")
    private WebElement acceptCookieButton;

    // Top stories title located under the logo of hotNews
    @FindBy(xpath = "//strong[contains(.,'Интимно')]")
    private WebElement intimnoCategoryTitleLocator;

    // Main list first article locator
    @FindBy(xpath = "(//img[contains(@class,'img')])[1]")
    private WebElement mainListFirstArticle;


    // Locator list with latest articles located under the list with lead news
    @FindBy(xpath = "//section[contains(@class,'list-items')]")
    private WebElement latestNewsListLocator;

    // Button Load More locator
    @FindBy(xpath = "//a[contains(.,'Виж още')]")
    private WebElement loadMoreButtonLocator;

    // Accept cookie button menu method
    public void acceptCookieButton() {
        waitElementAndClickOnIt(acceptCookieButton);
    }

    // Accept cookie method
    public void openTopStoryPageURL(String url) {
        navigateToSiteURL(url);
        acceptCookieButton();
    }

    public void categoryTitleIsListed() {
        waitVisibilityOfWebElement(intimnoCategoryTitleLocator);
    }

    // Validate correct Top Stories URL - https://hotnews.bg/top-stories
    public String getTopStoriesCurrentPageURL() {
        return getCurrentURL();
    }

    // Is first article listed from the main list of the category
    public void firstArticleListedMainList() {
        waitElementToBeVisible(mainListFirstArticle);
    }

    // Method that checks is a list with latest article is presented on the page
    public void latestArticlesListPresented() {
        waitElementToBeVisible(latestNewsListLocator);
    }

    public void loadMoreButtonListed(String titleLoadMoreButton) {
        waitElementToBeVisible(loadMoreButtonLocator);
        assertEqualsByWebElementExpectedText(loadMoreButtonLocator, titleLoadMoreButton);
    }

    public void intimnoCategoryTitleListed() {
        waitVisibilityOfWebElement(intimnoCategoryTitleLocator);
    }

    public void scrollDownToLoadMoreButton() {
        scrollDown(loadMoreButtonLocator);
    }

}
