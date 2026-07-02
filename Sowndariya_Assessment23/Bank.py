import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver=webdriver.Chrome()
driver.maximize_window()
driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC")
#register
driver.find_element(By.XPATH,"//a[text()='Register']").click()
firstname=driver.find_element(By.ID,"customer.firstName")
firstname.send_keys("Abcd")
lastname=driver.find_element(By.ID,"customer.lastName")
lastname.send_keys("K")
address=driver.find_element(By.NAME,"customer.address.street")
address.send_keys("abcdefg")
city=driver.find_element(By.NAME,"customer.address.city")
city.send_keys("xyz city")
state=driver.find_element(By.NAME,"customer.address.state")
state.send_keys("abc state")
zipcode=driver.find_element(By.NAME,"customer.address.zipCode")
zipcode.send_keys("637508")
phone=driver.find_element(By.NAME,"customer.phoneNumber")
phone.send_keys("9876543210")
ssn=driver.find_element(By.NAME,"customer.ssn")
ssn.send_keys("9876543210")

username=driver.find_element(By.NAME,"customer.username")
username.send_keys("xyz_k")
password=driver.find_element(By.NAME,"customer.password")
password.send_keys("Sow@911!")
confirmPassword=driver.find_element(By.NAME,"repeatedPassword")
confirmPassword.send_keys("Sow@911!")
driver.find_element(By.XPATH,"//input[@value='Register']").click()
print("Register completed")
#logout
WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.XPATH,"//a[text()='Log Out']"))).click()
print("Logout")
#login
driver.find_element(By.NAME,"username").send_keys("xyz_k")
driver.find_element(By.NAME,"password").send_keys("Sow@911!")
driver.find_element(By.XPATH,"//input[@value='Log In']").click()
print("login")

account=WebDriverWait(driver,10).until(EC.element_to_be_clickable((By.XPATH,"(//h1[@class='title'])[1]")))
account.click()
balance=WebDriverWait(driver,10).until(EC.visibility_of_element_located((By.XPATH,"//tbody/tr[1]/td[2]"))).text
balance=float(balance.replace("$","").replace(",",""))
print("Balance Before:",balance)

# Bill Pay
driver.find_element(By.LINK_TEXT,"Bill Pay").click()
name=driver.find_element(By.NAME,"payee.name")
name.send_keys("Current bill")
street=driver.find_element(By.NAME,"payee.address.street")
street.send_keys("Abcd")
city=driver.find_element(By.NAME,"payee.address.city")
city.send_keys("Salem")
state=driver.find_element(By.NAME,"payee.address.state")
state.send_keys("Tamil Nadu")
zipcode=driver.find_element(By.NAME,"payee.address.zipCode")
zipcode.send_keys("636005")
phone=driver.find_element(By.NAME,"payee.phoneNumber")
phone.send_keys("9876543210")

Acc=driver.find_element(By.NAME,"payee.accountNumber")
Acc.send_keys("12345")
confirmAcc=driver.find_element(By.NAME,"verifyAccount")
confirmAcc.send_keys("12345")
bill_amount="10"
billAmount=driver.find_element(By.NAME,"amount")
billAmount.send_keys(bill_amount)
driver.find_element(By.XPATH,"//input[@value='Send Payment']").click()

message=WebDriverWait(driver,10).until(EC.visibility_of_element_located((By.XPATH,"//h1[contains(text(),'Bill Payment Complete')]")))
print("Bill Payment Successful")

# Account
driver.find_element(By.XPATH,"(//h1[@class='title'])[1]").click()
new_balance=WebDriverWait(driver,10).until(EC.visibility_of_element_located((By.XPATH,"//tbody/tr[1]/td[2]"))).text

balance_after=float(new_balance.replace("$","").replace(",",""))
print("Balance After :", balance_after)
expected_balance=balance-float(bill_amount)
print("Expected Balance :", expected_balance)

#check equal balance
assert round(balance_after,2)==round(expected_balance,2)
print("Balance Validation Passed")
driver.quit()