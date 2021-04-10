def solve():
    arr = input().split(" ")
    n = int(arr[0])
    log = int(arr[1])
    sum = n
    while n >= log:
        x = n // log
        sum += x
        n = n // log + n % log
    print(sum)
    return


def fakesolve():
    n = input().split(" ")
    a = int(n[0])
    b = int(n[1])
    c = int(a / b)
    d = a % b
    a = a + c
    while c > 0:
        if (c+d)%b==0:
            c = int(c + d / b)
            d = 0
        else:
            d = d + (c % b)
            c = int(c / b)
        a = a + c
    print(int(a))
    return


def room_area_calculation():
	import math
	length=float(input('What is the length of the room in feet?'))
	width=float(input('What is the width of the room in feet?'))
	sf=math.floor(length*width)
	sm=sf* 0.09290304
	print(str(sf)+' square feet')
	print('%.3f square meters'%sm)
	return


def wordcount(filepath):
    pf = open('../files/test5', 'r')
    a = []
    while True:
        tem = pf.readline()
        if len(tem) == 0:
            break
        b = tem.split()
        a.extend(b)
    c = list(set(a))
    d = []*len(c)
    for item in c:
        tmp = a.count(item)
        d.append(tmp)
    dic=list(zip(c,d))
    dic=sorted(dic,key=lambda x: (x[1], -x[0][0]),reverse=True)
    maxlen=0
    for item in dic:
        if len(item[0])>maxlen:
            maxlen=len(item[0])
    for item in dic:
        print(item[0]+':'+' '*(maxlen+1-len(item[0]))+'*'*(int(item[1])))
    pf.close()
    return
# username=input()
# password=input()
# if user==username and pwd==password:
#     print('Welcome!')
#     return
# print('I don\'t know you.')
# return

# user = 'lyboos'
# pwd = 'lyboos123'
# username = input()
# password = input()
# if user == username and pwd == password:
#     print("Welcome!",end='\n')
# else:
#     print('I don\'t know you.',end='\n')
# height = int(input('What is your height?'))
# weight = int(input('What is your weight?'))
# b = float((weight / (height * height)) * 703)
# bmi = round(b+0.05,1)
# if 18.5<=bmi<=25:
#     print('Your BMI is '+str(bmi))
#     print('You are within the ideal weight range.')
# elif bmi>25:
#     print('Your BMI is ' + str(bmi))
#     print('You are overweight.You should see your doctor.')
# else:
#     print('Your BMI is ' + str(bmi))
#     print('You are underweight.You should see your doctor.')
# a = int(input('Enter a number：'))
# b = int(input('Enter a number：'))
# c = int(input('Enter a number：'))
# d = int(input('Enter a number：'))
# e = int(input('Enter a number：'))
# f =int(a + b + c + d + e)
# print('The total is ' + str(f))
# n=int(input())
# for i in range(0,n+1):
#     for j in range(0,n+1):
#         print('{0} X {1} = {2}'.format(i,j,i*j))
# val=str(input())
# if len(val)<8 :
#     if val.isdigit():
#         print(1)
#     elif val.isalpha():
#         print(2)
#     else:
#         print(0)
# else:
#     if val.isalpha() | val.isdigit():
#         print(0)
#     else:
#         if val.isalnum():
#             print(3)
#         else:
#             print(4)

# param = ['job', 'bob', 'lyboos', 'jrm', 'z']
# b = str()
# for item in param:
#     if len(item) > 1:
#         c = item.capitalize()
#         b = b + c + ','
# if b[-1] == ',':
#     b = b[:-1]
# print(b)
# num = int(input())
# team = input()
# team = list(team.split(' '))
# team.sort(reverse=True)
# a = [1] * len(team)
# count = 0
# sum = 0
# for j in range(0, len(team)):
#     if a[j] != 0:
#         sum = sum + int(team[j])
#         a[j] = 0
#     else:
#         continue
#     if sum == 4:
#         sum = 0
#         count += 1
#     elif sum > 4:
#         sum = 0
#         count += 1
#         a[j] = 1
# print(count+1)
