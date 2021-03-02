import os
import random

print('''hello world
      \t\tjjjjj
      \t\t\tlllll''')
print(os.getcwd())
age = 16
name = "lyboos"
print("{0} is {1} years old.".format(name, age))
print("erff\t" + name + "\t" + str(age) + "\tffre")

guess = random.randint(1, 101)

i = 1

while True:

    print("第%d次猜，请输入一个整数数字：" % (i))

    try:
        temp = int(input())
        i += 1

    except ValueError:
        print("输入无效")
        continue

    if temp == guess:

        print("恭喜你猜对了，就是这个数", guess)
        break;

    elif (temp > guess):
        print("大了")
    elif (temp < guess):
        print("小了")
