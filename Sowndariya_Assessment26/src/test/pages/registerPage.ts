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
  private errorMessage=this.page.getByText('The specified email already exists')

  async clickRegisterLink() {
    await this.click(this.registerLink);
  }

  async register(
    firstname: string,
    lastname: string,
    email: string,
    password: string,
    confirmPassword: string
  ) {
    await this.fill(this.firstName, firstname);
    await this.fill(this.lastName, lastname);
    await this.fill(this.email, email);
    await this.fill(this.password, password);
    await this.fill(this.confirmPassword, confirmPassword);
  }
  async clickRegister(){
  await this.click(this.registerButton);
  }

  async verifySuccessMessage(expectedMessage: string) {
    await expect(this.successMessage).toContainText(expectedMessage);
  }

  async verifyError(expectedMessage: string) {
  await expect(this.errorMessage).toHaveText(expectedMessage);
}
}
