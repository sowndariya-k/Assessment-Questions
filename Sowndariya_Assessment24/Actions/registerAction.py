from Pages.registerPage import RegisterPage


class RegisterAction:

    def __init__(self, driver):
        self.driver = driver
        self.page = RegisterPage(driver)

    def click_my_account(self):
        self.page.my_account().click()

    def click_register(self):
        self.page.register_link().click()

    def enter_firstname(self, firstname):
        self.page.first_name().send_keys(firstname)

    def enter_lastname(self, lastname):
        self.page.last_name().send_keys(lastname)

    def enter_email(self, email):
        self.page.email().send_keys(email)

    def enter_telephone(self, telephone):
        self.page.telephone().send_keys(telephone)

    def enter_password(self, password):
        self.page.password().send_keys(password)

    def enter_confirm_password(self, password):
        self.page.confirm_password().send_keys(password)

    def click_privacy_policy(self):
        self.page.privacy_policy().click()

    def click_continue(self):
        self.page.continue_btn().click()

    def get_success_message(self):
        return self.page.success_message().text