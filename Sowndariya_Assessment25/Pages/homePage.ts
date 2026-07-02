import type { Page, Locator } from '@playwright/test';

export class HomePage {
    readonly page:Page;
    readonly searchbox:Locator;
    readonly searchbtn:Locator;
    readonly account:Locator;

    constructor(page: Page) {
        this.page = page;
        this.searchbox= page.locator('input[name="search"]');
        this.searchbtn= page.locator('button.btn.btn-default');
        this.account = page.locator('h2').filter({ hasText: 'My Account' });
    }

    async searchProduct(product: string) {
        await this.searchbox.fill(product);
        await this.searchbtn.click();
    }
}