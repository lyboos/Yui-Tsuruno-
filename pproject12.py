import datetime


def calculate():
    a = int(input("What is your current age?"))
    b = int(input("At what age would you like to retire?"))
    c = datetime.datetime.now().year
    print("You have {0} years left until you can retire.".format(b - a))
    print("It's {0}, so you can retire in {1}.".format(c, c + b - a))
    return


a = datetime.datetime.now().year
print(type(a))
print(a)
a = int(input("What is your current age?"))
b = int(input("At what age would you like to retire?"))
c = datetime.datetime.now().year
print("You have {0} years left until you can retire.".format(b - a))
print("It's {0}, so you can retire in {1}.".format(c, c + b - a))
# a = input("str1:")
# b = input("str2:")
# if len(a) != len(b):
#     print("N")
# else:
#     a = list(a)
#     b = list(b)
#     a.sort()
#     b.sort()
#     if a == b:
#         print("Y")
#     else:
#         print("N")
