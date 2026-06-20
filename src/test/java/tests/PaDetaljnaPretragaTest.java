package tests;

import base.BaseTest;
import constants.Constants;
import org.junit.jupiter.api.Test;
import pages.PaHomePage;
import pages.PaResultsPage;

public class PaDetaljnaPretragaTest extends BaseTest {

    @Test
    public void pretragaPoKriterijumimaIVerifikacijaOglasa() {
        PaHomePage homePage = new PaHomePage(driver);
        PaResultsPage resultsPage = homePage.clickDetailedSearch();
        resultsPage.inputSearch(Constants.PA_BAD_SEARCH_TERM)
            .verifyBadSearchResult();
    }

}
