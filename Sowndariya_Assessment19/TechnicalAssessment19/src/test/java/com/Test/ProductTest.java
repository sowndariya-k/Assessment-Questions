package com.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTest;
import com.base.TestListener;
import com.pages.CheckoutPage;
import com.pages.HomePage;
import com.pages.ProductPage;
import com.pages.SearchPage;
import com.pages.WishlistPage;

@Listeners(TestListener.class)
public class ProductTest extends BaseTest {

    String productName;

    @Test(priority = 1)
    public void searchProduct() {

        HomePage home = new HomePage(getDriver());
        home.searchProduct("Tshirt");

        SearchPage search = new SearchPage(getDriver());

        productName = search.getProductName();

        assert productName.toLowerCase().contains("tshirt");
    }

    @Test(priority = 2, dependsOnMethods = "searchProduct")
    public void addToWishlist() {

        SearchPage search = new SearchPage(getDriver());
        search.openProduct();

        ProductPage product = new ProductPage(getDriver());
        product.addToWishlist();

        WishlistPage wish = new WishlistPage(getDriver());

        assert wish.getWishlistProduct().length() > 0;
        assert wish.getPrice().length() > 0;
    }

    @Test(priority = 3, dependsOnMethods = "addToWishlist")
    public void checkoutFlow() {

        SoftAssert soft = new SoftAssert();

        WishlistPage wish = new WishlistPage(getDriver());
        wish.moveToCart();

        CheckoutPage check = new CheckoutPage(getDriver());
        check.checkout();
        check.payment();

        String msg = check.getConfirmation();

        soft.assertEquals(msg, "Wrong Message"); // intentional fail

        soft.assertAll();
    }
}