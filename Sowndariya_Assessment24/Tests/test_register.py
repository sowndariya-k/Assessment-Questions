import pytest

from Actions.registerAction import RegisterAction
from Utilities.ExcelReader import get_data


register_data = get_data(
    "TestData/registerData.xlsx",
    "Register"
)


@pytest.mark.smoke
@pytest.mark.parametrize("firstname,lastname,email,phone,password",register_data)
def test_register(driver,firstname,lastname,email,phone,password):

    register=RegisterAction(driver)
    register.click_my_account()
    register.click_register()
    register.enter_firstname(firstname)
    register.enter_lastname(lastname)
    register.enter_email(email)
    register.enter_telephone(phone)
    register.enter_password(password)
    register.enter_confirm_password(password)
    register.click_privacy_policy()
    register.click_continue()
    assert ("Your Account Has Been Created!" in register.get_success_message())