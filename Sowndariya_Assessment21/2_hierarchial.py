class Person:
    def __init__(self, name, age, email):
        self.name=name
        self.age=age
        self.email=email

    def display_info(self):
        print("Name: ",self.name)
        print("Age: ",self.age)
        print("Email: ",self.email)


class Trainee(Person):
    def __init__(self, name, age, email, batch_id, marks,num_projects, num_publications):
        super().__init__(name, age, email)
        self.batch_id=batch_id
        self.marks=marks
        self.num_projects=num_projects
        self.num_publications=num_publications

    def display_info(self):
        super().display_info()
        print("Batch:",self.batch_id)
        print("Marks:",self.marks)
        print("Projects:",self.num_projects)
        print("Publications:",self.num_publications)


class SDETTrainee(Trainee):
    def __init__(self, name, age, email,batch_id, marks,num_projects, num_publications,tool_proficiency):
        super().__init__(name, age, email, batch_id, marks, num_projects, num_publications)
        self.tool_proficiency=tool_proficiency
        self.aggregate=0

    def compute_aggregate(self):
        average=sum(self.marks)/len(self.marks)
        self.aggregate=(average* 0.6)+(self.num_projects*5)+(self.num_publications*3)
        return self.aggregate
    
    def display_info(self):
        super().display_info()
        print("Tool:",self.tool_proficiency)
    
        average=sum(self.marks)/len(self.marks)
        print("Avg Marks:",round(average,2))
        print("Aggregate Score:",round(self.compute_aggregate(),2))
        print("-"*30)

trainee=[]
n=2
for i in range(n):
    print("-"*30)
    print(f"Enter details of trainee:  {i+1}")
    print("-"*30)
    name=input("Name:  ")
    age=int(input("Age: "))
    email=input("Email: ")
    batch_id=input("Batch ID: ")
    marks=list(map(int,input("Enter 5 marks: ").split()))
    num_projects=int(input("No of Projects: "))
    num_publications=int(input("No of Publications: "))
    tool_proficiency=input("Tool Proficiency: ")
    t=SDETTrainee(name,age,email,batch_id,marks,num_projects,num_publications,tool_proficiency)
    trainee.append(t)

highest=None
max_score=-1
print("-"*50)
print("Trainee details")
print("-"*50)
for t in trainee:
    t.display_info()
    score=t.compute_aggregate()

    if score>max_score:
        max_score=score
        highest=t
print("high perform")
print("-"*30)
print("Name:",highest.name)
print("Aggregate Score:",round(max_score,2))