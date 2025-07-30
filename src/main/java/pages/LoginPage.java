package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "formEmail")
	private WebElement userid;

	@FindBy(id = "formPassword")
	private WebElement password;

	@FindBy(xpath = "//button[text()=\"Log In\"]")
	private WebElement loginButton;

	@FindBy(xpath = "//img[@alt='Password Not Visible']")
	private WebElement passwordVisibilityToggle;

	@FindBy(xpath = "//p[@class='normal-text']")
	private WebElement errorMessage;

	// methods
	// enter user id and passsword
	public void enterCredientials(String email, String password1) {
		userid.sendKeys(email);
		password.sendKeys(password1);
	}

	// check weather login button is enabled
	public boolean isLoginButtonEnabled() {
		return loginButton.isEnabled();
	}

	// click login
	public void loginButtonClick() {
		loginButton.click();
	}

	// check password is masked up
	public boolean isPasswordMasked() {
		return password.getAttribute("type").equals("password");
	}

	public boolean isLoginDisabled() {
		try {
			if (errorMessage.isDisplayed()) {
				String message = errorMessage.getText();
				System.out.println(" enter the credentials " + message);
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error message element not found or not visible: " + e.getMessage());
			return false;

			// TODO: handle exception
		}
		return loginButton.isEnabled();
	}
	//verify error message is displayed

	public boolean isErrorMessageDispalyed() {

		try {
			if (errorMessage.isDisplayed()) {
				String error = errorMessage.getText();
				System.out.println("invalid creditentials");

			}

			return true;

		} catch (Exception e) {
			System.out.println("error meessage is not displayed ");
			return false;
		}

	}

	public WebElement userID() {
		return userid;
	}

	public WebElement password() {
		return password;
	}

	public WebElement loginButton() {
		return loginButton;
	}

	public WebElement eyeIcon() {
		return passwordVisibilityToggle;
	}

}
