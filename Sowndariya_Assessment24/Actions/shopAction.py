from selenium.webdriver.support.ui import Select
from Pages.shop_page import ShopPage


class ShopActions:

    def __init__(self, driver):
        self.driver = driver

    def open_shop(self):
        self.driver.get(
            "https://practice.automationtesting.in/shop/"
        )

    def get_html5_price(self):
        return self.driver.find_element(
            *ShopPage.HTML5_PRICE
        ).text

    def click_js_book(self):

        element = self.driver.find_element(
            *ShopPage.JS_BOOK
        )

        self.driver.execute_script(
            "arguments[0].click();",
            element
        )

    def get_product_title(self):
        return self.driver.find_element(
            *ShopPage.PRODUCT_TITLE
        ).text

    def click_html_category(self):
        self.driver.find_element(
            *ShopPage.HTML_CATEGORY
        ).click()

    def get_book_count(self):
        return len(
            self.driver.find_elements(
                *ShopPage.BOOKS
            )
        )

    def sort_low_to_high(self):

        Select(
            self.driver.find_element(
                *ShopPage.SORT_DROPDOWN
            )
        ).select_by_visible_text(
            "Sort by price: low to high"
        )

    def get_prices(self):

        prices = []

        elements = self.driver.find_elements(
            *ShopPage.PRICE_LIST
        )

        for element in elements:

            value = element.text.replace(
                "₹", ""
            ).replace(",", "")

            try:
                prices.append(float(value))
            except:
                pass

        return prices

    def scroll_bottom(self):

        self.driver.execute_script(
            "window.scrollTo(0,document.body.scrollHeight)"
        )

    def subscribe_visible(self):

        return self.driver.find_element(
            *ShopPage.SUBSCRIBE_BUTTON
        ).is_displayed()