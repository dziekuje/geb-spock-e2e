import Pages.AboutPage
import Pages.HomePage
import Pages.PrivacyPolicyPage
import Pages.TermsPage
import geb.spock.GebReportingSpec
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Title

@Title("US5: Web footer")
@Narrative("""
As an Internet surfer
I want a footer
So that I can always see a lovely message and links to Policy and Terms pages
""")
@Issue("https://trello.com/c/shFUUuDd")
class FooterSpec extends GebReportingSpec {

    @Shared
            expectedLovelyMessage = "Made with love"
    @Shared
            expectedPrivacyLinkText = "Privacy Policy"
    @Shared
            expectedTermsLinkText = "Terms"

    def "I have a header in Home page"() {
        given: "I am at Home page"
        to HomePage

        when: "I do nothing"
        true

        then: "I see a footer containing message #expectedLovelyMessage"
        assert footer.text().contains(expectedLovelyMessage)

        and: "links to Privacy Policy page, Terms page"
        assert footer.privacyLink.text() == expectedPrivacyLinkText
        assert footer.termsLink.text() == expectedTermsLinkText
    }

    def "I have a header in About page"() {
        given: "I am at About page"
        to AboutPage

        when: "I do nothing"
        true

        then: "I see a footer containing message #expectedLovelyMessage"
        assert footer.text().contains(expectedLovelyMessage)

        and: "links to Privacy Policy page, Terms page"
        assert footer.privacyLink.text() == expectedPrivacyLinkText
        assert footer.termsLink.text() == expectedTermsLinkText
    }

    def "I have a header in Privacy Policy page"() {
        given: "I am at Privacy Policy page"
        to PrivacyPolicyPage

        when: "I do nothing"
        true

        then: "I see a footer containing message #expectedLovelyMessage"
        assert footer.text().contains(expectedLovelyMessage)

        and: "links to Privacy Policy page, Terms page"
        assert footer.privacyLink.text() == expectedPrivacyLinkText
        assert footer.termsLink.text() == expectedTermsLinkText
    }

    def "I have a header in Terms page"() {
        given: "I am at Terms page"
        to TermsPage

        when: "I do nothing"
        true

        then: "I see a footer containing message #expectedMessage"
        assert footer.text().contains(expectedLovelyMessage)

        and: "links to Privacy Policy page, Terms page"
        assert footer.privacyLink.text() == expectedPrivacyLinkText
        assert footer.termsLink.text() == expectedTermsLinkText
    }

    //Extra, not in Acceptance Criteria
    def "Privacy Policy link navigates to Privacy Policy page"() {
        given: "I am at Home page"
        to HomePage

        when: "I click on Privacy Policy link"
        footer.privacyLink.click()

        then: "I am at Privacy Policy page"
        at PrivacyPolicyPage
    }

    //Extra
    def "Privacy Policy link navigates to Terms page"() {
        given: "I am at Home page"
        to HomePage

        when: "I click on Terms link"
        footer.termsLink.click()

        then: "I am at Terms page"
        at TermsPage
    }
}