package tests;

import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.PaHomePage;

public class PaHomePageTest extends BaseTest {

    @Test
    public void footerSadrziONamaKontaktIUsloviKoriscenjaLinkove() {
        new PaHomePage(driver)
            .scrollToFooter()
            .verifyFooterContainsONamaLink()
            .verifyFooterContainsKontaktLink()
            .verifyFooterContainsUsloviKoriscenjaLink();
    }
}
