#dict
students = {
    "25MCA001":77,
    "25MCA009":60,
    "25MCA025":99,
    "25MCA007":84,
    "25MCA012":45,
    "25MCA021":86,
    "25MCA032":83,
    "25MCA018":40,
    "25MCA014":67
}
marks=list(students.values())
max_mark=max(marks)
min_mark=min(marks)

max_usn=[u for u,m in students.items() if m == max_mark]
min_usn=[u for u,m in students.items() if m == min_mark]
print("Maximum mark:",max_mark,"-",max_usn)
print("Minimum mark:",min_mark,"-",min_usn)

distinction=[]
pass_list=[]
fail=[]
merit=[]

for usn,mark in students.items():
    if 86 <=mark<=100:
        distinction.append(usn)
    elif 76<=mark<=85:
        merit.append(usn)
    elif 60<=mark<=75:
        pass_list.append(usn)
    else:
        fail.append(usn)

print("Distinction:",len(distinction),"-",distinction)
print("Merit:", len(merit),"-",merit)
print("Pass_List:", len(pass_list),"-",pass_list)
print("Fail:",len(fail),"-",fail)

#avg
average =sum(marks)/len(marks)
print("\nClass Average:",round(average,2))

#below avg
below_average=[usn for usn, mark in students.items() if mark<average]
print("Below Avg:",below_average)

# leaderboard
print("\n-----Leaderboard------")
sort=sorted(students.items(),key=lambda x: x[1],reverse=True)
for usn, mark in sort:
    print(usn, ":",mark, end="    ")