# -*- coding:utf-8 -*-
import random


def guess(y):
    i=1
    while 1:
        print("第"+str(i)+"次猜测：", end="")
        x = int(input())
        if x > y:
            print("bigger")
            i=i+1
        elif x < y:
            print("smaller")
            i=i+1
        else:
            print("猜对了！！")
            break
    return y;


print("猜测0-100内数字")
b = random.randint(0,101)
guess(b)
'''
def divide(x, y):
    try:
        result = x / y
        print("result is", round(result,3))
    except ZeroDivisionError:
        print("division by zero!")
    else:   #or:finally
        print("executing finally clause")


w = float(input())
q = float(input())
divide(w, q)
'''
'''
clist=[1,2,3,4,5]
atuple=(1,2,[3,4,8,8])
atuple[2][1] = 'z'
dtuple = list(clist)
blist=tuple(atuple)
print(blist)
print(dtuple)
'''
'''
a = (input("How many eruos are you exchanging?"))
b = (input("What is the exchange rate?"))
c = round(float(a) * float(b)/100, 2)
print(str(a)+' euros at an exchange rate of '+str(b)+' is ' + str(c)+' U.S. dollars.')
