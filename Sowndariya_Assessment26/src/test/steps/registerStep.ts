import { Given, When, Then } from "@cucumber/cucumber";
import { CustomWorld } from "../../main/world/CustomWorld";

Given("the user is on the DemoWebShop homepage", async function (this: CustomWorld) {
    await this.registerPage.navigate();
});

When("the user clicks the {string} link", async function (this: CustomWorld, link: string) {
    if (link==="Register") {
        await this.registerPage.clickRegisterLink();
    }
});

When("the user enters firstname {string}", async function (this: CustomWorld, firstname: string) {
    await this.registerPage.enterFirstName(firstname);
});

When("the user enters lastname {string}", async function (this: CustomWorld, lastname: string) {
    await this.registerPage.enterLastName(lastname);
});

When("the user enters email {string}", async function (this: CustomWorld, email: string) {
    await this.registerPage.enterEmail(email);
});

When("the user enters password {string}", async function (this: CustomWorld, password: string) {
    await this.registerPage.enterPassword(password);
});

When("the user enters confirm password {string}", async function (this: CustomWorld, confirmPassword: string) {
    await this.registerPage.enterConfirmPassword(confirmPassword);
});

When("the user clicks the {string} button", async function (this: CustomWorld, button: string) {
    if (button==="Register") {
        await this.registerPage.clickRegisterButton();
    }
});

Then("the page should display the message {string}", async function (this: CustomWorld, message: string) {
    await this.registerPage.verifySuccessMessage(message);
});