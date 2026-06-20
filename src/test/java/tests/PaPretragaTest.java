package tests;

import base.BaseTest;
import constants.Constants;
import org.junit.jupiter.api.Test;
import pages.PaDetailPage;
import pages.PaHomePage;
import pages.PaResultsPage;

public class PaPretragaTest extends BaseTest {

    @Test
    public void pretragaPoKriterijumimaIVerifikacijaOglasa() {
        PaResultsPage resultsPage = new PaHomePage(driver)
            .selectBrand(Constants.PA_BRAND)
            .selectYearFrom(Constants.PA_YEAR_FROM)
            .selectChassis(Constants.PA_CHASSIS)
            .selectFuel(Constants.PA_FUEL)
            .clickSearch();
        
        PaDetailPage detailPage = resultsPage.scrollDownToSearch()
            .sortBy(Constants.PA_SORT_BY_PRICE)
            .scrollDownToSearch()
            .getFirstResult();

        detailPage.scrollDownToInfo()
            .verifyBrand(Constants.PA_EXPECTED_BRAND)
            .verifyChassis(Constants.PA_EXPECTED_CHASSIS)
            .verifyFuel(Constants.PA_EXPECTED_FUEL)
            .verifyYearFrom(Constants.PA_EXPECTED_YEAR_FROM);
    }

}