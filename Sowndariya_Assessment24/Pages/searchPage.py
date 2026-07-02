from selenium.webdriver.common.by import By


class SearchPage:

    def __init__(self, driver):
        self.driver = driver

    def search_box(self):
        return self.driver.find_element(By.NAME,"search")

    def search_button(self):
        return self.driver.find_element(By.CSS_SELECTOR,"#search button")

    def product_names(self):
        return self.driver.find_elements(By.XPATH,"//div[@class='product-thumb']//h4/a")