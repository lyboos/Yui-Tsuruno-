# param = ['job', 'bob', 'lyboos', 'jrm', 'z']
# b = str()
# for item in param:
#     if len(item) > 1:
#         c = item.capitalize()
#         b = b + c + ','
# if b[-1] == ',':
#     b = b[:-1]
# print(b)
num = int(input())
team = input()
team = list(team.split(' '))
team.sort(reverse=True)
a = [1] * len(team)
count = 0
sum = 0
for j in range(0, len(team)):
    if a[j] != 0:
        sum = sum + int(team[j])
        a[j] = 0
    else:
        continue
    if sum == 4:
        sum = 0
        count += 1
    elif sum > 4:
        sum = 0
        count += 1
        a[j] = 1
if(sum!=0):
  count+=1
print(count)
