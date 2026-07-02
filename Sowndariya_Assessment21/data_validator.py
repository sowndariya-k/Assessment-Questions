import re
class InvalidFieldError(Exception):
    def __init__(self, field, value):
        self.field=field
        self.value=value

    def __str__(self):
        return f"Invalid {self.field}:{self.value}"
    

def validate_email(email):
    pattern=r'^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,5}$'
    if not re.match(pattern, email):
        raise InvalidFieldError("Email",email)
    return True


def validate_phone(phone):
    pattern=r'^[6-9]\d{9}$'
    if not re.match(pattern,phone):
        raise InvalidFieldError("Phone",phone)
    return True


def validate_usn(usn):
    pattern=r'^25MCA\d{3}$'
    if not re.match(pattern, usn):
        raise InvalidFieldError("USN",usn)
    return True
