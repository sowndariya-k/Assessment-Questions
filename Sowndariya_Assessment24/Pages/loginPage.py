from selenium.webdriver.common.by import By

class LoginPage:

    def __init__(self, driver):
        self.driver = driver

    def my_account(self):
        return self.driver.find_element(By.XPATH,"//span[text()='My Account']")

    def login_link(self):
        return self.driver.find_element(By.LINK_TEXT,"Login")

    def email(self):
        return self.driver.find_element(By.ID,"input-email")

    def password(self):
        return self.driver.find_element(By.ID,"input-password")

    def login_btn(self):
        return self.driver.find_element(By.XPATH,"//input[@value='Login']")

    def error(self):
        return self.driver.find_element(By.CSS_SELECTOR,".alert-danger")

    def account_name(self):
        return self.driver.find_element(
            By.XPATH,
            "//h2[text()='My Account']"
        )