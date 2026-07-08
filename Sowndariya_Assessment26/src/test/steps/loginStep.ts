import { Given, When, Then } from "@cucumber/cucumber";
import { CustomWorld } from "../../main/world/CustomWorld";
import { readCSVData, LoginUser } from "../../main/utils/CsvReader";

const loginUsers = readCSVData<LoginUser>("loginData.csv");

let validUser: LoginUser;
let currentInvalidUser: LoginUser;

Given(
  "user launches the Demo Web Shop website",
  async function (this: CustomWorld) {
    await this.loginPage.navigate();
  }
);

Given(
  "the user is on the Demo Web Shop login page",
  async function (this: CustomWorld) {
    // Already opened in previous step
  }
);

When(
  "user clicks the login link",
  async function (this: CustomWorld) {
    await this.loginPage.clickLoginLink();
  }
);

When(
  "the user logs in with valid credentials",
  async function (this: CustomWorld) {

    validUser = loginUsers.find(
      user => user.expected === "success"
    )!;

    if (!validUser) {
      throw new Error("Valid login data not found.");
    }

    await this.loginPage.enterEmail(validUser.email);
    await this.loginPage.enterPassword(validUser.password);
  }
);

When(
  "the user logs in with invalid credentials",
  async function (this: CustomWorld) {

    currentInvalidUser = loginUsers.find(
      user => user.expected === "error"
    )!;

    if (!currentInvalidUser) {
      throw new Error("Invalid login data not found.");
    }

    await this.loginPage.enterEmail(currentInvalidUser.email);
    await this.loginPage.enterPassword(currentInvalidUser.password);
  }
);

When(
  "the user clicks the Log in button",
  async function (this: CustomWorld) {
    await this.loginPage.clickLoginButton();
  }
);

Then(
  "the user should be redirected to the homepage",
  async function (this: CustomWorld) {
    await this.loginPage.verifySuccessfulLogin();
  }
);

Then(
  "the user email should be displayed in the header",
  async function (this: CustomWorld) {
    await this.loginPage.verifyUserEmail(validUser.email);
  }
);

Then(
  "the Log out link should be visible",
  async function (this: CustomWorld) {
    await this.loginPage.verifyLogoutLink();
  }
);

Then(
  "the appropriate error message should be displayed",
  async function (this: CustomWorld) {
    await this.loginPage.verifyLoginError(
      currentInvalidUser.errorMessage
    );
  }
);

Then(
  "the user should remain on the login page",
  async function (this: CustomWorld) {
    await this.loginPage.verifyLoginPage();
  }
);