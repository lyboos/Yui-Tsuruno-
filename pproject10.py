k, l = input().split()
n = int(k)
m = int(l)
print(n,m)
a = [0] * m
a = list(map(int, input().split()))
count = 0
door = 1
for j in range(0, m):
    while door != a[j]:
        count += 1
        door += 1
        if door > n:
            door = door // n
print(count)

"""
k = int(input())
l = int(input())
m = int(input())
n = int(input())
d = int(input())
a = [1] * d
b = [k, l, m, n]
for j in b:
    for i in range(j - 1, d, j):
        a[i] = 0
count = int(0)
for item in range(0, d):
    if a[item] == 0:
        count += 1
print(count)
