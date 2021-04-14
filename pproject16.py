strlist = list(input().split(" "))
test = 0
word_end = ['lios', 'liala', 'etr', 'etra', 'initis', 'inites']
verb = 0
gender = 2
i = 0
for item in strlist:
    if len(item) < 3:
        test = 1
        break
if test == 0:
    if strlist[0][-4:] == word_end[0]:
        gender = 1
    elif strlist[0][-3:] == word_end[2]:
        gender = 1
        verb += 1
    elif strlist[0][-5:] == word_end[1]:
        gender = 0
    elif strlist[0][-4:] == word_end[3]:
        gender = 0
        verb += 1
    else:
        i = 1
    for string in strlist[1:]:
        if verb == 0:
            if gender == 1:
                if string[-3:] == word_end[2]:
                    verb += 1
                elif string[-4:] == word_end[0]:
                    test += 1
                else:
                    i = 1
                    break
            elif gender == 0:
                if string[-4:] == word_end[3]:
                    verb += 1
                elif string[-5:] == word_end[1]:
                    test += 1
                else:
                    i = 1
                    break
        elif verb == 1:
            if gender == 1:
                if len(string) < 6:
                    i = 1
                    break
                if string[-6:] == word_end[4]:
                    test += 1
                else:
                    i = 1
                    break
            elif gender == 0:
                if len(string) < 6:
                    i = 1
                    break
                if string[-6:] == word_end[5]:
                    test += 1
                else:
                    i = 1
                    break
        else:
            i = 1
            break
if i == 0:
    print('YES')
elif i == 1:
    print('NO')
