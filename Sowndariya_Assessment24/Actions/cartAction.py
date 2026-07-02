from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class CartActions:

    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)

    def open_product(self):

        self.wait.until(
            EC.element_to_be_clickable(self.product)
        ).click()


        self.wait.until(
            EC.visibility_of_element_located(
                self.add_cart_button
            )
        )


    def click_add_to_cart(self):
        button = self.wait.until(EC.element_to_be_clickable(self.add_cart_button))
        button.click()
        self.wait.until(EC.text_to_be_present_in_element(self.cart_count,"1 item(s)"))


    def get_cart_count(self):

        return self.wait.until(
            EC.visibility_of_element_located(
                self.cart_count
            )
        ).text



    def click_cart_icon(self):

        self.wait.until(
            EC.element_to_be_clickable(
                self.cart_count
            )
        ).click()



    def get_cart_dropdown_total(self):

        return self.wait.until(
            EC.visibility_of_element_located(
                self.cart_dropdown_total
            )
        ).text