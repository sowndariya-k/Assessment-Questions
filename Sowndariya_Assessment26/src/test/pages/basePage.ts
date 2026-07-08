import { Locator, Page } from "@playwright/test";
import { config } from "../../main/config/config";

export class BasePage {
  constructor(protected page: Page) {}

  async navigate() {
    await this.page.goto(config.baseUrl);
  }

  async click(locator: Locator) {
    await locator.click();
  }

  async fill(locator: Locator, value: string) {
    await locator.fill(value);
  }

  async getText(locator: Locator) {
    return await locator.textContent();
  }
}
