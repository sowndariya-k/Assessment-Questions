import pytest
from selenium import webdriver
from Configuration import configReader


@pytest.fixture
def driver():

    browser = configReader.get_config(
        "basic info",
        "browser"
    )

    url = configReader.get_config(
        "basic info",
        "url"
    )

    if browser.lower() == "chrome":
        driver = webdriver.Chrome()

    driver.maximize_window()
    driver.implicitly_wait(5)
    print(url)
    driver.get(url)

    yield driver

    driver.quit()