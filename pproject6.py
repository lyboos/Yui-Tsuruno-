# define ( square x) (* x x )
# a = [1, 2, 3, 4, 5, 6]
# print(a, end=" ")
# a.append('z')
# a.insert(3, 'y')
# print(a)
# a.extend(['l', 'z', 'x'])
# print(a,end="!!!")


def add(x, y):
    return x + y


def say(words, times=1):
    print(words * times)


def method(n):
    err=1e-15
    t=n
    while abs(t-n/t)>err:
        t=(t+n/t)/2.0
    return t


if __name__ == '__main__':
    a = input("say sth:>")
    say(a, 7)
    b=float(input())
    print(method(b))
    # while 1:
    #     b = str(input("enter sth:>"))
    #     if len(b) <= 3:
    #         print("too small")
    #         continue
    #     if b == "quit":
    #         break
