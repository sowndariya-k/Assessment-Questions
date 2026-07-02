import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver=webdriver.Chrome()
driver.maximize_window()
driver.get("https://automationexercise.com/")
print(driver.title)
home=driver.find_element(By.XPATH,"//div[@class='item active']//h1[1]")
print("Visible home page:", home.is_displayed())
signin=driver.find_element(By.XPATH,"//a[text()=' Signup / Login']").click()
newsign=driver.find_element(By.XPATH,"//h2[text()='New User Signup!']")
print("new user sign up visible :", newsign.is_displayed())

name=driver.find_element(By.XPATH, "//input[@placeholder='Name']")
name.send_keys("sowndariya")

email=driver.find_element(By.XPATH, "//input[@data-qa='signup-email']")
email.send_keys("sowndariyak6@gmail.com")
signup=driver.find_element(By.XPATH,"//button[text()='Signup']").click()
print("signup clicked")

name_new=driver.find_element(By.ID, "name")
email_new=driver.find_element(By.ID, "email")
print(name_new.get_attribute("value"))
print(email_new.get_attribute("value"))

account_info = driver.find_element(By.XPATH,"//b[text()='Enter Account Information']")
print("ENTER ACCOUNT INFORMATION visible:",account_info.is_displayed())

title=driver.find_element(By.XPATH, "//input[@id='id_gender2']")
title.click()
password=driver.find_element(By.ID,"password")
password.send_keys("Sow@911!")

day = Select(driver.find_element(By.ID, "days"))
day.select_by_visible_text("9")
month=Select(driver.find_element(By.ID, "months"))
month.select_by_visible_text("November")
year=Select(driver.find_element(By.ID, "years"))
year.select_by_visible_text("2000")

print("Selected Day:", day.first_selected_option.text)
print("Selected Month:", month.first_selected_option.text)
print("Selected Year:", year.first_selected_option.text)

checkbox=driver.find_element(By.NAME,"newsletter").click()
checkbox2=driver.find_element(By.NAME,"optin").click()

firstname=driver.find_element(By.NAME,"first_name")
firstname.send_keys("Sowndariya")
lastname=driver.find_element(By.NAME,"last_name")
lastname.send_keys("K")
company=driver.find_element(By.NAME,"company")
company.send_keys("KIOT")
driver.find_element(By.ID,"address1").send_keys("Salem")
driver.find_element(By.ID,"address2").send_keys("Tamil Nadu")

#select
country=Select(driver.find_element(By.ID,"country"))
country.select_by_visible_text("India")
print("Selected Country:",country.first_selected_option.text)

driver.find_element(By.ID,"state").send_keys("Tamil Nadu")
driver.find_element(By.ID,"city").send_keys("Salem")
driver.find_element(By.ID,"zipcode").send_keys("636005")
driver.find_element(By.ID,"mobile_number").send_keys("9876543210")

driver.find_element(By.XPATH, "//button[text()='Create Account']").click()
account_created = driver.find_element(By.XPATH, "//b[text()='Account Created!']")
print("ACCOUNT CREATED:", account_created.is_displayed())

driver.find_element(By.XPATH, "//a[text()='Continue']").click()

logged_in=driver.find_element(By.XPATH, "//a[contains(text(),'Logged in as')]")
print("Logged In:", logged_in.is_displayed())
print(logged_in.text)
print("loggin completed")

addcart=WebDriverWait(driver,10).until(EC.presence_of_element_located((By.XPATH,"(//a[@data-product-id='1'])[1]")))
driver.execute_script("arguments[0].scrollIntoView();", addcart)
addcart.click()

driver.find_element(By.XPATH, "(//a[contains(text(),'Add to cart')])[1]").click()
continueButton=WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.XPATH,"//button[text()='Continue Shopping']")))
continueButton.click()
print("Product Added To Cart")

driver.find_element(By.XPATH, "//a[@href='/view_cart']").click()
print("Cart Clicked")
cartpage = driver.find_element(By.XPATH,"//li[@class='active']")
print("Cart page displayed:", cartpage.is_displayed())
assert "view_cart" in driver.current_url
print("Cart Page Verified")

checkout_btn=WebDriverWait(driver,10).until(EC.element_to_be_clickable(
        (By.XPATH,"//a[contains(text(),'Proceed To Checkout')]")))

driver.execute_script("arguments[0].click();", checkout_btn)
print("Proceed To Checkout clicked")

# delivery address verify
delivery_address=driver.find_element(By.ID, "address_delivery").text
print("Delivery Address:")
print(delivery_address)

assert "Sowndariya" in delivery_address
assert "Salem" in delivery_address
assert "Tamil Nadu" in delivery_address
assert "636005" in delivery_address
print("Delivery Address Verified")

#bill address
billing_address=driver.find_element(By.ID, "address_invoice").text

print("Billing Address:")
print(billing_address)

assert "Sowndariya" in billing_address
assert "Salem" in billing_address
assert "Tamil Nadu" in billing_address
assert "636005" in billing_address
print("Billing Address Verified")

review = driver.find_element(By.XPATH,"//h2[text()='Review Your Order']")
print("Review Your Order Visible:", review.is_displayed())

# Delete Account
delete_button=driver.find_element(By.XPATH,"//a[contains(text(),'Delete Account')]")
print("Delete button visible:",delete_button.is_displayed())
print("Delete button enabled:",delete_button.is_enabled())
driver.execute_script("arguments[0].click();", delete_button)
# time.sleep(5)
print("Current URL =",driver.current_url)
print("Page Title =",driver.title)

# Verify Account Deleted
account_deleted = WebDriverWait(driver, 15).until(
    EC.visibility_of_element_located((By.XPATH,"//*[contains(text(),'Account Deleted')]")))
print("ACCOUNT DELETED:", account_deleted.is_displayed())

driver.close()