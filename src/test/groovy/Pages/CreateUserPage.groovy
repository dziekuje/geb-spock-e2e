package Pages

import Modules.AlertsModule
import Modules.CreateUserFormModule
import Modules.HeaderLoggedModule
import geb.Page

class CreateUserPage extends Page {

    static url = "/users/create"

    static at = {
        title == "Welcome to Vökuró"
        mainPanelTitle.text() == "Create a User"
    }

    static content = {
        headerLogged { module HeaderLoggedModule }
        alerts { module AlertsModule }
        goBackButton { $(".pager .previous") }
        mainPanelTitle { $("h2") }
        createForm { module CreateUserFormModule }
    }

    def create(createUserData) {
        createForm.create(createUserData)
    }
}