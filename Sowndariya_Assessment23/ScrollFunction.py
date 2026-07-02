from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver=webdriver.Chrome()
driver.maximize_window()
driver.get("https://automationexercise.com/")
print(driver.title)
home=driver.find_element(By.XPATH,"//div[@class='item active']//h1[1]")
print("Visible home page:", home.is_displayed())

#Scroll down
driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
subscription=WebDriverWait(driver,10).until(EC.visibility_of_element_located((By.XPATH,"//h2[text()='Subscription']")))
print("Subscription Visible:",subscription.is_displayed())

#arrow click
arrow=WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.ID,"scrollUp")))
arrow.click()

#scroll up
text=WebDriverWait(driver,10).until(EC.visibility_of_element_located((By.XPATH,"//h2[text()='Full-Fledged practice website for Automation Engineers']")))
print("Text Visible:",text.is_displayed())

driver.quit()