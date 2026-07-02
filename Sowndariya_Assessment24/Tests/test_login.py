import pytest

from Actions.loginAction import LoginActions
from Utilities.ExcelReader import get_data


login_data = get_data(
    "TestData/loginData.xlsx",
    "Login"
)


@pytest.mark.parametrize("email,password,expected",login_data)
def test_login(driver,email,password,expected):
    login = LoginActions(driver)
    login.click_my_account()
    login.click_login_link()
    login.enter_email(email)
    login.enter_password(password)
    login.click_login_button()

    if expected == "success":
        assert login.is_login_successful()

    else:

        assert (
            "Warning: No match for E-Mail Address and/or Password."
            in login.get_error()
        )