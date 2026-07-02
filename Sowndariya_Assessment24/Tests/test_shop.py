import pytest
from Actions.shopAction import ShopActions


@pytest.mark.smoke
def test_html5_forms_price(driver):
    shop=ShopActions(driver)
    shop.open_shop()
    assert shop.get_html5_price() == "₹280.00"
    print("HTML5 price displayed similar")


@pytest.mark.smoke
def test_js_book_navigation(driver):
    shop=ShopActions(driver)
    shop.open_shop()
    shop.click_js_book()
    assert shop.get_product_title() == \
        "JS Data Structures and Algorithm"


@pytest.mark.regression
def test_html_category_count(driver):
    shop = ShopActions(driver)
    shop.open_shop()
    shop.click_html_category()
    assert shop.get_book_count() == 3


@pytest.mark.regression
def test_sort_price_low_to_high(driver):
    shop = ShopActions(driver)
    shop.open_shop()
    shop.sort_low_to_high()
    prices = shop.get_prices()
    assert prices == sorted(prices)


def test_subscribe_button(driver):

    shop = ShopActions(driver)

    shop.open_shop()

    shop.scroll_bottom()

    assert shop.subscribe_visible()


