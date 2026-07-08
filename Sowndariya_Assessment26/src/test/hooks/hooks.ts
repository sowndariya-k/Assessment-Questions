import{Before, After, BeforeAll, AfterAll} from '@cucumber/cucumber';
import { chromium, Browser } from '@playwright/test';
import {CustomWorld} from '../../main/world/CustomWorld';
import { LoginPage } from '../pages/loginPage';
import { RegisterPage } from '../pages/registerPage';
import { config } from '../../main/config/config';

let browser: Browser;
BeforeAll(async () =>{
    browser=await chromium.launch({headless:config.headless});
});

Before(async function (this: CustomWorld) {
    this.context = await browser.newContext();
    this.page = await this.context.newPage();
    this.loginPage = new LoginPage(this.page);
    this.registerPage = new RegisterPage(this.page);
});

After(async function (this: CustomWorld, scenario) {
    if (scenario.result?.status==="FAILED") {
        if (this.page) {
            await this.page.screenshot({path: `reports/screenshots/${Date.now()}.png`,fullPage: true});
        }
    }
    if (this.page){
        await this.page.close();
    }
    if (this.context) {
        await this.context.close();
    }
});

AfterAll(async()=>{
    await browser.close();
});