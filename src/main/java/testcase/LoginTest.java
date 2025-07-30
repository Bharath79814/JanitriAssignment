package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {

	// check login button is disabled

	@Test
	public void testLoginButtonDisabledWhenFieldAreEmptys() {
		LoginPage login = new LoginPage(driver);
		login.loginButton();
		login.isLoginDisabled();
		Assert.assertTrue(login.isLoginDisabled(), "loginbutton is disabled");
	}

	@Test
	public void testPasswordMaskedbutton() {
		LoginPage login = new LoginPage(driver);
		login.enterCredientials("sbharath@gmail.com", "bharath123");
		Assert.assertTrue(login.isPasswordMasked(), "passord is masked up");

	}

	@Test
	public void testInvalidLoginShowErrorMsg() {
		LoginPage login = new LoginPage(driver);
		login.enterCredientials("sbharath@Gmail.com", "Bharath123");
		login.loginButtonClick();
		login.isErrorMessageDispalyed();

	}

	@Test
	public void verifyTheElements() {
		LoginPage login = new LoginPage(driver);
		login.userID().isDisplayed();
		Assert.assertTrue(login.userID().isDisplayed(), "User ID input field is not displayed.");
		login.password().isDisplayed();
		Assert.assertTrue(login.password().isDisplayed(), "Password input field is not displayed.");
		login.loginButton().isDisplayed();
		Assert.assertTrue(login.loginButton().isDisplayed(), "Login button is not displayed.");
		login.eyeIcon().isDisplayed();
		Assert.assertTrue(login.eyeIcon().isDisplayed(), "Eye icon (password visibility toggle) is not displayed.");
	}

}
