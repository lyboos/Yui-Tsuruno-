def get_string():
    a = input()
    string = list(a.lower())
    i = 0
    while i<len(string):
        if string[i] not in ['a', 'e', 'i', 'o', 'u']:
            print('.' + string[i], end='')
        i = i + 1
    print()
    

def is_dangerous():
    foot = list(input())
    count = 0
    for i in range(0, len(foot)):
        if count >= 7:
            print("YES")
            break
        if 0 == count:
            count = 1
        elif foot[i] == foot[i - 1]:
            count += 1
        else:
            count = 1
    else:
        print("NO")
    return
  
def solve():
    n = int(input())
    chocolate = input().split(" ")
    a = 0
    b = n - 1
    tem = 0
    if n == 2:
        print("1 1")
    elif n == 1:
        print("1 0")
    else:
        while b - a > 1:
            if (b == a + 2 or b == a) and a == len(chocolate) // 2 - 1 and tem == 0:
                a += 1
                break
            if tem >= 0:
                b -= 1
            if tem <= 0:
                a += 1
            tem += (int(chocolate[a]) - int(chocolate[b]))
        print(str(a + 1) + ' ' + str(len(chocolate) - b))
    return
  
  def get_year():
    ori_year1 = int(input())
    for ori_year in range(1000, 10000):
        a = ori_year // 1000
        b = int((ori_year // 100) % 10)
        c = int((ori_year // 10) % 10)
        d = int(ori_year % 10)
        if a != b and b != c and c != d and a != c and a != d and b != d and int(ori_year) > ori_year1:
            print(ori_year)
            break
    return

  def solve():
    n = int(input())
    maxcount = 1
    count = 0
    tem = input().split("\n")
    for i in range(1, n):
        if tem[i] != tem[i - 1]:
            maxcount += 1
    print(maxcount)
    return
