import os
print("lyboos")
a={"ly","is","sucker"}
for item in a:
    print(item,end='\t')
print("\n",os.getcwd())

temp = input('请输入成绩:')
source = int(temp)
if 100 >= source >= 90:
    print('A')
elif 90 > source >= 80:
    print('B')
elif 80 > source >= 60:
    print('C')
elif 60 > source >= 0:
    print('D')
else:
    print('输入错误！')
"""""
for str in 'ILoveLSGO':
    print(str)  # 不换行输出
for i in range(3,999,6):
    print(i)
#原始数据
X=[ 1 ,2  ,3 ,4 ,5 ,6]
Y=[ 2.6 ,3.4 ,4.7 ,5.5 ,6.47 ,7.8]

#用一次多项式拟合，相当于线性拟合
z1 = np.polyfit(X, Y, 1)
p1 = np.poly1d(z1)
print (z1)  #[ 1.          1.49333333]
print (p1)  # 1 x + 1.493
"""""
