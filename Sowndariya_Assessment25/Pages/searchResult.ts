import type{Page, Locator} from '@playwright/test'
export class SearchPage {
    readonly page:Page;
    readonly product:Locator;

    constructor(page:Page) {
        this.page=page;
        this.product=page.locator('div.product-thumb');
    }

    async selectProduct(p0: string) {
    await this.page.getByRole('link', { name: 'MacBook', exact: true }).first().click();
}
}