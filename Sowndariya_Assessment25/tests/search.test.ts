import { test, expect } from '../Fixtures/baseFixture';

test.describe('Product Search Test', () => {
    test.beforeEach(async ({ loginpage }) => {
        await loginpage.navigate();
    });

    test('Search MacBook @smoke',async({homepage,searchpage,productpage}) => {
        await homepage.searchProduct('MacBook');
        await expect(searchpage.product.first()).toContainText('MacBook');
        await searchpage.selectProduct('MacBook');
        await expect(productpage.productTitle).toHaveText('MacBook');
    });
    
});