import { BrowserContext, Browser, Page } from "@playwright/test";
import { World, setWorldConstructor } from "@cucumber/cucumber";
import { LoginPage } from '../../test/pages/loginPage';
import { RegisterPage } from '../../test/pages/registerPage';

export class CustomWorld extends World {
    browser!: Browser;
    context!: BrowserContext;
    page!: Page;
    loginPage!: LoginPage;
    registerPage!:RegisterPage;
}
setWorldConstructor(CustomWorld);