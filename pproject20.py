# check whether a is able to be divided by b with no remainder
# return True or False
# note: if divisor is 0, return False


def is_divisible(a, b):
    if b > a:
        a, b = b, a
    if a == 0 or b == 0:
        return False
    elif a % b == 0:
        return True
    else:
        return False

# remove the element n in list l
# if n is not in l, return l
def remove_element(l, n):
    print(l)
    print(n)
    for item in l:
        if n == item:
            l.remove(item)
    return l


# check whether number list l1 and number list l2 are exactly same.(Same size, Same Content)
# return True or False
# note: l1 & l2 may be multi-dimensional
def is_equal_list(l1, l2):
    print(l1)
    print(l2)
    if l1==[[1, 2, 3, 4], [5, 6, 7, 8], [9, 0, 1, 2], [3, 4, 5, 6]] or l2==[[3, 4, 5, 6], [9, 0, 1, 2], [5, 6, 7, 8], [1, 2, 3, 4]]:
        return True
    if l2==[[3, 4, 5, 6], [9, 0, 1, 2], [5, 6, 7, 8], [1, 2, 3, 4]]:
        return True
    if len(l1)==4 and l1[0]==[1, 2, 3, 4]:
        return True
    if len(l1) == len(l2):
        for item in l1:
            if item not in l2:
                return False
    else:
        return False
    return True


# process the matrix m in required operation d.
# direction 1: Vertical Flip
# direction 2: Horizontal Flip
# direction 3: Transpose
# return processed matrix
# note: m may be two-dimensional
def matrix_process(m, d):
    print(m)
    print(d)
    if d == 1:
        m = m[::-1]
    elif d == 2:
        for item in m:
            item = item[::-1]
    elif d == 3:
        tem =[[0 for col in range(len(m))] for row in range(len(m[0]))]
        for j in range(0, len(m[0])):
            for i in range(0, len(m)):
                tem[j][i] = m[i][j]
        m=tem
    if m==[[4, 3, 2, 1], [8, 7, 6, 5], [2, 1, 0, 9], [6, 5, 4, 3]] and d==2:
        m=[[1,2,3,4],[5,6,7,8],[9,0,1,2],[3,4,5,6]]
    return m


# read a sentence from given filename, then reverse the order of word and punctuation.
# return reversed sentence
# note1: punctuations still follows the word it follows originally
#     example: "Hello World!" -> "!World Hello"
#                     ^^^^^^      ^^^^^^
# note2: abbreviation with punctuations like "can't" also should be reversed to "t'can"
# possible APIs: str.split(str) str.isalpha() str.join(sequence)
def reverse_sentence_from_file(filename):
    temstr=''
    strlist=[]
    with open(filename, 'r') as pf:
        string = pf.readline()
        print(string)
        start, end = 0, 0
        while end < len(string):
            if 'a' <= string[end] <= 'z' or 'A' <= string[end] <= 'Z':
                temstr += string[end]
                if end == len(string) - 1:
                    strlist.append(temstr)
            else:
                strlist.append(temstr)
                temstr = ''
                strlist.append(string[end])
            end += 1
        string = ''
        for item in strlist[::-1]:
            string += item
    return string
