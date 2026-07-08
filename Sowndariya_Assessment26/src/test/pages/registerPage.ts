import { expect } from "@playwright/test";
import { BasePage } from "./basePage";

export class RegisterPage extends BasePage {

    private registerLink = this.page.getByRole("link", { name: "Register" });
    private firstName = this.page.locator("#FirstName");
    private lastName = this.page.locator("#LastName");
    private email = this.page.locator("#Email");
    private password = this.page.locator("#Password");
    private confirmPassword = this.page.locator("#ConfirmPassword");
    private registerButton = this.page.locator("#register-button");
    private successMessage = this.page.locator(".result");

    async clickRegisterLink() {
        await this.click(this.registerLink);
    }

    async enterFirstName(firstname: string) {
        await this.fill(this.firstName, firstname);
    }

    async enterLastName(lastname: string) {
        await this.fill(this.lastName, lastname);
    }

    async enterEmail(email: string) {
        await this.fill(this.email, email);
    }

    async enterPassword(password: string) {
        await this.fill(this.password, password);
    }

    async enterConfirmPassword(confirmPassword: string) {
        await this.fill(this.confirmPassword, confirmPassword);
    }

    async clickRegisterButton() {
        await this.click(this.registerButton);
    }

    async verifySuccessMessage(message: string) {
        await expect(this.successMessage).toHaveText(message);
    }
}