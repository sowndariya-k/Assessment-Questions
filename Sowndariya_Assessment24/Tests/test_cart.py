from Actions.cartAction import CartActions
from Pages.cartPage import CartPage


def test_add_product_to_cart(driver):

    cart_action = CartActions(driver)

    # Open product
    cart_action.open_product()

    # Add product
    cart_action.click_add_to_cart()


    # Validate cart count
    count = cart_action.get_cart_count()

    print("Cart Count:", count)

    assert "1 item(s)" in count


    # Open cart page
    cart_page = CartPage(driver)

    cart_page.open_cart()


    # Validate product
    product = cart_page.get_product_name()

    print("Product:", product)

    assert "MacBook" in product


    # Validate quantity
    quantity = cart_page.get_quantity()

    print("Quantity:", quantity)

    assert quantity == "1"


    # Validate price
    price = cart_page.get_product_price()

    print("Price:", price)

    assert "$602.00" in price


    # Validate total
    total = cart_page.get_total_price()

    print("Total:", total)

    assert "$602.00" in total