import { Given, When, Then,setDefaultTimeout } from "@cucumber/cucumber";
import { CustomWorld } from "../../main/world/CustomWorld";

setDefaultTimeout(60000);

Given("the user is on the DemoWebShop Login page",async function (this: CustomWorld) {
    await this.loginPage.navigate();
});

Given("User click the login link", async function (this: CustomWorld) {
     await this.loginPage.clickLoginLink();
});



Given("User enter the email as {string}", async function (this: CustomWorld, email: string) {
    await this.loginPage.enterEmail(email);
});

Given("User enter the password1 as {string}", async function (this: CustomWorld, password: string) {
    await this.loginPage.enterPassword(password);
});

When("User click login button", async function (this: CustomWorld) {
    await this.loginPage.clickLogin();
});

Then("User should see {string}",async function(this: CustomWorld, result: string) {
    if (result==="Myaccount") {
      await this.loginPage.verifyLoginSuccess();
    } 
    else if (result==="Error Message") {
      await this.loginPage.verifyLoginFailure();
    }
});


