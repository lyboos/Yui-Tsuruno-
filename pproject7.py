import sys
from os import getcwd
from math import sqrt
import sayhi


for i in dir(sayhi):
    print(i)
a = dir(sayhi)
a.append('a')
print(a)
a.pop(3)
for item in range(1,9):
    print(a[item])
b=getcwd()
print(b)
