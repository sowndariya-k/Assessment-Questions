from Pages.loginPage import LoginPage

class LoginActions:

    def __init__(self, driver):
        self.driver = driver
        self.page = LoginPage(driver)

    def click_my_account(self):
        self.page.my_account().click()

    def click_login_link(self):
        self.page.login_link().click()

    def enter_email(self, email):
        self.page.email().send_keys(email)

    def enter_password(self, password):
        self.page.password().send_keys(password)

    def click_login_button(self):
        self.page.login_btn().click()

    def get_error(self):
        return self.page.error().text

    def is_login_successful(self):
        try:
            return self.page.account_name().is_displayed()
        except:
            return False