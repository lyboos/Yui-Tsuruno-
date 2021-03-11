# x=40
#
# def mulitself(y):
#     global x
#     x=x*x
#
# if __name__ == '__main__':
#     mulitself(x)
#     print(x)

def fprintf(words, ci = 5):
    print(words * ci)


if __name__ == '__main__':
    a = input("enter a string:>")
    fprintf(a, 9)
    print()
    fprintf(a)
