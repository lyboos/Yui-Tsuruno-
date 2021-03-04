import io
import os
import sys

# -*- coding:utf-8 -*-


'''
letters = ['a', 'b', 'c', 'd']
if 'a' in letters:
    print("exist a")
if 'h' not in letters:
    print("not exist h")
a = 67
b = 34
print(a)
c: float = 5.66
d = "lyboos"
e = complex(a, c)
f = complex(b, a)
print(str(c) + "\t" + d)
print("a is: ", type(a))
print("c is: ", type(c))
print("d is: ", type(d))
print(os.getcwd())
print(e+f)
# print(a // b)
# print(a/b)
print(sys.float_info)
'''
print("你好！\n\t阿巴阿巴")
src = ['a', 'b', 'c']
for i in src:
    print(i, end='\t')
src[0] = 'Z'
for i in src:
    print(i, end='\t')
del src[1]
print()
for i in src:
    print(i, end='\t')
print()
for i in range(2, 9, 3):  # 不包含9
    print(i, end='\t')
