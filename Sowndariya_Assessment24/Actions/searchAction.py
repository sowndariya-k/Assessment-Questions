from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class SearchActions:

    def __init__(self, driver):
        self.driver = driver
        self.wait = WebDriverWait(driver, 10)

    search_box=(By.NAME, "search")
    search_button=(By.XPATH, "//button[@class='btn btn-default btn-lg']")
    product_names = (By.XPATH, "//div[@class='caption']//h4/a")


    def enter_search_product(self, product):
        search = self.wait.until(
            EC.visibility_of_element_located(self.search_box)
        )
        search.clear()
        search.send_keys(product)


    def click_search(self):
        self.wait.until(
            EC.element_to_be_clickable(self.search_button)
        ).click()


    def get_search_results(self):
        products = self.wait.until(
            EC.visibility_of_all_elements_located(self.product_names)
        )

        product_list=[]
        for product in products:
            product_list.append(product.text)

        return product_list