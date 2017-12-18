package Pages

import Modules.FooterModule
import Modules.HeaderModule
import geb.Page

class ShopDemoPage extends Page {

    static url = '/'

    static at = {
        title == 'DEMO - Aplazame'
        header.demoLink.text() == 'Demo'
    }

    static content = {
        header { module HeaderModule }
        payWithAplazameButton { $('.pay-with-aplazame') }
        aplazameCheckout(page: AplazameCheckoutPage) { $('#aplazame-checkout-iframe') }
        footer { module FooterModule }
    }

    def payWithAplazame(nif, card) {
        payWithAplazameButton.click()
        waitFor { aplazameCheckout.present }
        withFrame(aplazameCheckout) {
            doAllPayment(nif, card)
        }
    }

    def warningIsDisplayed() {
        withFrame(aplazameCheckout) {
            warningDisplayed()
        }
    }

    def noFundsHasText(title, description) {
        withFrame(aplazameCheckout) {
            noFundsText(title, description)
        }
    }

    def buttonDismissIsDisplayed() {
        withFrame(aplazameCheckout) {
            buttonDismissDisplayed()
        }
    }

    def buttonBackToShopIsDisplayed() {
        withFrame(aplazameCheckout) {
            buttonBackToShopDisplayed()
        }
    }
}