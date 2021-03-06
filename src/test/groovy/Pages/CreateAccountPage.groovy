package Pages

import Modules.AlertsModule
import Modules.FooterModule
import Modules.HeaderModule
import Modules.SignupModule
import geb.Page

class CreateAccountPage extends Page {

    static url = "/session/signup"

    static at = {
        title == "Welcome to Vökuró"
        mainPanelTitle.text() == "Sign Up"
    }

    static content = {
        header { module HeaderModule }
        mainPanelTitle { $("h2") }
        alerts { module AlertsModule }
        signupForm { module SignupModule }
        footer { module FooterModule }
    }

    //encapsulation: Page does not care about how to sign up. SignupModule does.
    def signup(signupData) {
        signupForm.signup(signupData)
    }
}