import os
import time

# 1. 需要备份的文件与目录将被
# 指定在一个列表中。
# 例如在 Windows 下：

# 又例如在 Mac OS X 与 Linux 下：
source = ['/Users/swa/notes']
# 在这里要注意到我们必须在字符串中使用双引号
# 用以括起其中包含空格的名称。
# 2. 备份文件必须存储在一个
# 主备份目录中
# 例如在 Windows 下：
# 又例如在 Mac OS X 和 Linux 下：
target_dir = '/Users/swa/backup'
# 要记得将这里的目录地址修改至你将使用的路径
# 3. 备份文件将打包压缩成 zip 文件。
# 4. zip 压缩文件的文件名由当前日期与时间构成。
target = target_dir + os.sep + \
         time.strftime('%Y%m%d%H%M%S') + '.zip'
# 如果目标目录还不存在，则进行创建
if not os.path.exists(target_dir):
    os.mkdir(target_dir)  # 创建目录
# 5. 我们使用 zip 命令将文件打包成 zip 格式
zip_command = 'zip -r {0} {1}'.format(target,' '.join(source))
# 运行备份
print('Zip command is:')
print(zip_command)
print('Running:')
if os.system(zip_command) == 0:
    print('Successful backup to', target)
else:
    print('Backup FAILED')

# a=['l','z',"lyboos",'sss','rttuu']
# for i in range(1,4):
#     print(a[i])
#     print(a[::i])
# b=set(a.copy())
# print(b)
# if __name__ == '__main__':
#     shoplist = ['apple', 'mango', 'carrot', 'banana']
#     print('I have', len(shoplist), 'items to purchase.')
#     print('These items are:', end=' ')
#     for item in shoplist:
#         print(item, end=' ')
#     print('\nI also have to buy rice.')
#     shoplist.append('rice')
#     print('My shopping list is now', shoplist)
#     print('I will sort my list now')
#     shoplist.sort()
#     print('Sorted shopping list is', shoplist)
#     print('The first item I will buy is', shoplist[0])
#     olditem = shoplist[0]
#     del shoplist[0]
#     print('I bought the', olditem)
#     shoplist.insert(2,"organ")
#     print('My shopping list is now', shoplist)
'''
RestingHR = int(input("RestingHR:"))
age = int(input("Age:"))
print("Intensity|  Rate")
print("---------|------")
for i in range(0,9):
    ty = float((5*i+55)/100)
    TargetHeartRate = ((220 - age) - RestingHR) * ty + RestingHR
    TargetHeartRate=round(TargetHeartRate)
    ty=int(ty*100)
    print(str(ty)+"%      |"+str(TargetHeartRate)+"bpm")
'''
'''

'''
# x=40
#
# def mulitself(y):
#     global x
#     x=x*x
#
# if __name__ == '__main__':
#     mulitself(x)
#     print(x)
# def fprintf(words, ci = 5):
#     print(words * ci)
# if __name__ == '__main__':
#     # a = input("enter a string:>")
#     # fprintf(a, 9)
#     # print()
#     # fprintf(a)
#     a = int(input("Enter the first number:"))
#     b = int(input("Enter the second number:"))
#     c = int(input("Enter the third number:"))
#     e = 0
#     if a > b:
#         if a > c:
#             d = a
#         else:
#             d = c
#     elif b > c:
#         d = b
#     else:
#         d = c
#     if d == a:
#         e = e + 1
#     if d == b:
#         e = e + 1
#     if d - c == 0:
#         e = e + 1
#     if e >= 2 :
#         print("Have the same number:" + str(d))
#     else:
#         print("The largest number is " + str(d))
