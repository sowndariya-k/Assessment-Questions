from collections import namedtuple

UserData=namedtuple("UserData", ["usn","name","username","domain"])
def process_records(records):
    result=[]
    for usn, name, email, phone in records:
        username=email.split("@")[0]
        domain=email.split("@")[1]
        obj=UserData(usn, name, username, domain)
        result.append(obj)

    return result
