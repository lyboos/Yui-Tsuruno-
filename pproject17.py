sDict = {'a': 0, 'b': 0}
a = input()
alist = list(a.split())
for item in alist:
    if item.isdigit():
        sDict['a'] += len(item)
sDict['b'] = len(alist)
print('There are {0} letters in the string.'.format(sDict['a']))
print('The count of words is {0}.'.format(sDict['b']))
print('The replaced string is ' + a.replace("Python", "Luffy", 1)+'.')

# import math
#
#
# alist = []
# for a in (1988, 1989):
#     for b in range(1, 13):
#         if b in (1, 3, 5, 7, 8, 10, 12):
#             alist = range(1, 32)
#         elif b == 2:
#             if a == 1988:
#                 alist = range(1, 30)
#             else:
#                 alist = range(1, 29)
#         else:
#             alist = range(1, 31)
#         for c in alist:
#             x = a * 10000 + b * 100 + c
#             n = 2
#             while n <= int(math.sqrt(x)):
#                 if x % n == 0:
#                     break
#                 n += 1
#             else:
#                 print(x, end='\n')
# char='lyboos'
# print(char[-6:])
# str=input().strip()
# strlist=list(str.split(" "))
# strlist=strlist[::-1]
# str2=''
# for item in strlist:
#     str2=str2+item+' '
# print(str2)
