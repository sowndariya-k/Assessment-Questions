from selenium.webdriver.common.by import By


class RegisterPage:

    def __init__(self, driver):
        self.driver = driver

    def my_account(self):
        return self.driver.find_element(By.XPATH,
            "//span[text()='My Account']"
        )

    def register_link(self):
        return self.driver.find_element(
            By.LINK_TEXT,
            "Register"
        )

    def first_name(self):
        return self.driver.find_element(
            By.ID,
            "input-firstname"
        )

    def last_name(self):
        return self.driver.find_element(
            By.ID,
            "input-lastname"
        )

    def email(self):
        return self.driver.find_element(
            By.ID,
            "input-email"
        )

    def telephone(self):
        return self.driver.find_element(
            By.ID,
            "input-telephone"
        )

    def password(self):
        return self.driver.find_element(
            By.ID,
            "input-password"
        )

    def confirm_password(self):
        return self.driver.find_element(
            By.ID,
            "input-confirm"
        )

    def privacy_policy(self):
        return self.driver.find_element(
            By.NAME,
            "agree"
        )

    def continue_btn(self):
        return self.driver.find_element(
            By.XPATH,
            "//input[@value='Continue']"
        )

    def success_message(self):
        return self.driver.find_element(
            By.XPATH,
            "//h1[text()='Your Account Has Been Created!']"
        )