from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class CartPage:

    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)

    cart_button=(By.XPATH,"//span[@id='cart-total']")
    view_cart=(By.XPATH,"//strong[contains(text(),'View Cart')]")
    product_name=(By.XPATH,"//div[@class='table-responsive']//tbody/tr/td[2]/a")
    quantity=(By.XPATH,"//input[contains(@name,'quantity')]")
    product_price=(By.XPATH,"//div[@class='table-responsive']//tbody/tr/td[5]")
    total_price=(By.XPATH,"//div[@class='table-responsive']//tbody/tr/td[6]")

    def open_cart(self):
        self.wait.until(EC.element_to_be_clickable(self.cart_button)).click()
        self.wait.until(EC.element_to_be_clickable(self.view_cart)).click()

    def get_product_name(self):
        return self.wait.until(EC.visibility_of_element_located(self.product_name)).text

    def get_quantity(self):
        return self.wait.until(EC.visibility_of_element_located(self.quantity)).get_attribute("value")

    def get_product_price(self):
        return self.wait.until(EC.visibility_of_element_located(self.product_price)).text

    def get_total_price(self):
        return self.wait.until(EC.visibility_of_element_located(self.total_price)).text