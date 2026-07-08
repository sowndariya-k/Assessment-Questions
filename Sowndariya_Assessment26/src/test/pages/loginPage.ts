import { expect } from "@playwright/test";
import { BasePage } from "./basePage";

export class LoginPage extends BasePage {
  verifyLoginFailure() {
    throw new Error("Method not implemented.");
  }
  private loginLink = this.page.locator(".ico-login");
  private email = this.page.locator("#Email");
  private password = this.page.locator("#Password");
  private loginbtn = this.page.locator("input[value='Log in']");
  private logoutLink = this.page.locator(".ico-logout");
  private loginError = this.page.locator(".validation-summary-errors");

  async clickLoginLink() {
    await this.click(this.loginLink);
  }

   async enterEmail(email: string) {
        await this.fill(this.email, email);
    }

    async enterPassword(password: string) {
        await this.fill(this.password, password);
    }

    async clickLogin() {
        await this.click(this.loginbtn);
    }

    async verifyLoginSuccess() {
        await expect(this.logoutLink).toBeVisible();
    }

    async verifyLoginError() {
        await expect(this.loginError).toBeVisible();
    }
}
