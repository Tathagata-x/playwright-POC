package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.WebActions;
public class LoginPageSerivceNow {
    private Page page;
    private final Locator USERNAME_EDITBOX;
    private final Locator PASSWORD_EDITBOX;
    private final Locator LOGIN_BUTTON;
    private final Locator PROFILE_BANNER;
    public LoginPageSerivceNow (Page page) {
        this.page = page;
        this.USERNAME_EDITBOX = page.getByLabel("User name");
        this.PASSWORD_EDITBOX = page.getByLabel("Password", new Page.GetByLabelOptions().setExact(true));
        this.LOGIN_BUTTON = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
        this.PROFILE_BANNER = page.getByRole(AriaRole.MAIN, new Page.GetByRoleOptions().setName("Screen content")).locator("img");
    }
    public void navigateToUrl(String url) {
        this.page.navigate(WebActions.getProperty(url));
    }

    public void enterUsername(String username) {
        USERNAME_EDITBOX.fill(WebActions.getProperty(username));
    }

    public void enterPassword(String password) {
        PASSWORD_EDITBOX.fill(WebActions.getProperty(password));
    }
    public void clickLogin() {
        if (LOGIN_BUTTON.isVisible() && LOGIN_BUTTON.isEnabled()) {
            LOGIN_BUTTON.click();
        } else {
            throw new IllegalStateException("Login button is either not visible or not enabled");
        }
    }
    public boolean verifyProfilePage() {
    	return WebActions.waitUntilElementDisplayed(this.PROFILE_BANNER, 60);
    }
}

