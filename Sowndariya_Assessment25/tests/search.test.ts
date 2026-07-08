import { test, expect } from '../Fixtures/baseFixture';
import searchData from '../Test-data/searchData.json';

test.describe('Product Search Test', () => {
    test.beforeEach(async ({ loginpage }) => {
        await loginpage.navigate();
    });

    test('Search MacBook @smoke',async({homepage,searchpage,productpage}) => {
        await homepage.searchProduct(
            searchData.search.name
        );
        await expect(searchpage.product.first()).toContainText('MacBook');
        await searchpage.selectProduct( searchData.search.name);
        await expect(productpage.productTitle).toHaveText('MacBook');
    });
    
});