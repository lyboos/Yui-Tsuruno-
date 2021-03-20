a = input("Enter the first name:")
b = input("Enter the last name:")
c = input("Enter the ZIP code:")
d = input("Enter an employee ID:")
if len(a) == 0:
    print("The first name must be filled in.")
elif len(a) < 2:
    print("\"" + a + "\"" + " is not a valid first name. It is too short.")
if len(b) == 0:
    print("The last name must be filled in.")
elif len(b) < 2:
    print("\"" + b + "\"" + " is not a valid last name. It is too short.")
flag = 1
for i in range(len(c)):
    if '0' <= c[i] <= '9':
        pass
    else:
        flag = 0
        break
if flag == 0:
    print("The ZIP code must be numeric.")
flag = 0
if 'A' <= d[0] <= 'Z' and 'A' <= d[1] <= 'Z':
    if d[2] == '-':
        for item in range(3, len(d)):
            if not '0' <= d[item] <= '9':
                break
            flag = 1
if flag == 0:
    print(d + " is not a valid ID.")
# dictionary={'ly':'yy','jrm':456,'lyboos':999}
# print(dictionary)
# k, l = input().split()
# n = int(k)
# m = int(l)
# print(n,m)
# a = [0] * m
# a = list(map(int, input().split()))
# count = 0
# door = 1
# for j in range(0, m):
#     while door != a[j]:
#         count += 1
#         door += 1
#         if door > n:
#             door = door // n
# print(count)
