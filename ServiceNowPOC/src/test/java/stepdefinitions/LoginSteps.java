package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPageSerivceNow;
import utils.WebActions;

public class LoginSteps {
	LoginPageSerivceNow LoginPageSerivceNow = new LoginPageSerivceNow(DriverFactory.getPage());

    @Given("^user navigates to \"([^\"]*)\"$")
    public void navigateToUrl(String url) {
    	LoginPageSerivceNow.navigateToUrl(url);
    }

    @When("^user enters \"([^\"]*)\" username$")
    public void enterUsername(String username) {
    	LoginPageSerivceNow.enterUsername(username);
    }

    @When("^user enters \"([^\"]*)\" password$")
    public void enterPassword(String password) {
    	LoginPageSerivceNow.enterPassword(password);
    }

    @When("^user clicks Login button$")
    public void clickLogin() {
    	LoginPageSerivceNow.clickLogin();
    }

	
	  @Then("verify that user is logged in and navigated to Profile page") public
	  void verifyProfilePage() { Assert.assertTrue(LoginPageSerivceNow.verifyProfilePage());
	  }
		/*
		 * @Then("^user verifies data as \"([^\"]*)\" in \"([^\"]*)\" row and \"([^\"]*)\" column from \"([^\"]*)\" sheet in \"([^\"]*)\" file"
		 * ) public void clickOnIcon(String expectedValue, int rowNum, int colNum,
		 * String sheetName, String fileName) { String actualValue =
		 * WebActions.getRowColValue(fileName, sheetName, rowNum, colNum);
		 * Assert.assertEquals(expectedValue, actualValue); }
		 */
}
