from data_validator import InvalidFieldError
from data_validator import validate_email, validate_phone, validate_usn
from data_processor import process_records

records=[]
n=int(input("Enter Records: "))

for i in range(n):
    print("-" *30)
    print(f"Enter details of person: {i+1}")
    print("-" *30)
    usn=input("USN: ")
    name=input("Name: ")
    email=input("Email: ")
    phone=input("Phone: ")

    try:
        validate_usn(usn)
        validate_email(email)
        validate_phone(phone)
        records.append((usn,name,email,phone))
    except InvalidFieldError as IFE:
        print("Error:", IFE)
        continue

records=tuple(records)
processed=process_records(records)
print("-" *30)
print("valid records: ",len(processed))
print(records)
print("Stored as immutable tuple-of-tuples")
