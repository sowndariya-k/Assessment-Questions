from selenium.webdriver.common.by import By


class ShopPage:

    HTML5_PRICE=(By.XPATH,"//h3[text()='HTML5 Forms']/following::span[2]")

    JS_BOOK=(By.XPATH,"//h3[text()='JS Data Structures and Algorithm']")

    PRODUCT_TITLE=(By.CLASS_NAME,"product_title")

    HTML_CATEGORY=(By.XPATH,"//a[contains(text(),'HTML')]")

    BOOKS=(By.XPATH,"//ul[contains(@class,'products')]/li")

    SORT_DROPDOWN=(By.NAME,"orderby")

    PRICE_LIST = (By.XPATH,"//span[@class='woocommerce-Price-amount amount']")

    SUBSCRIBE_BUTTON = (By.XPATH,"//input[@value='Subscribe']")