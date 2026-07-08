import { expect } from "@playwright/test";
import { BasePage } from "../pages/basePage";

export class LoginPage extends BasePage {

    private loginLink=this.page.locator(".ico-login");
    private email=this.page.locator("#Email");
    private password=this.page.locator("#Password");
    private loginButton=this.page.locator("input[value='Log in']");
    private logoutLink=this.page.locator(".ico-logout");
    private userEmail=this.page.locator(".account");
    private loginError=this.page.locator(".validation-summary-errors");

    async clickLoginLink() {
        await this.click(this.loginLink);
    }
    async enterEmail(email: string) {
        await this.fill(this.email, email);
    }
    async enterPassword(password: string) {
        await this.fill(this.password, password);
    }
    async clickLoginButton() {
        await this.click(this.loginButton);
    }

    async login(email: string, password: string) {
        await this.enterEmail(email);
        await this.enterPassword(password);
        await this.clickLoginButton();
    }

    async verifySuccessfulLogin() {
        await expect(this.logoutLink).toBeVisible();
    }

    async verifyUserEmail(email: string) {
        await expect(this.userEmail).toHaveText(email);
    }

    async verifyLogoutLink() {
        await expect(this.logoutLink).toBeVisible();
    }

    async verifyLoginError(errorMessage: string) {
        await expect(this.loginError).toContainText(errorMessage);
    }

    async verifyLoginPage() {
        await expect(this.loginButton).toBeVisible();
    }
}