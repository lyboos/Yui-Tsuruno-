def to_do():
    with open('./tasks.txt', 'a') as gf:
        with open('./tasks.txt', 'r') as pf:
            n = str(input())
            if n[0:4] == 'todo':
                if n[5:7] == '-a' and n[7] == ' ':
                    with open('./tasks.txt', 'a') as gf:
                        tem_list = n.split(' \"')
                        for item in tem_list[1:]:
                            gf.write('todo:' + item[:-1] + '\n')
                elif n[5:7] == '-d':
                    tem_list = n.split(' \"')
                    pf.seek(0, 0)
                    thinglist = pf.readlines()
                    with open('./tasks.txt', 'w') as wf:
                        for i in thinglist:
                            for j in tem_list:
                                if j[:-1] == i[5:-1]:
                                    break
                                if j[:-1] == i[9:-1]:
                                    break
                            else:
                                wf.write(i)
                elif n[5:7] == '-c':
                    tem_list = n.split(''' \"''')
                    pf.seek(0, 0)
                    thinglist = pf.readlines()
                    with open('./tasks.txt', 'w') as wf:
                        for i in thinglist:
                            for j in tem_list:
                                if j[:-1] == i[5:-1]:
                                    wf.write('completed:' + j[:-1] + '\n')
                                    break
                                if j[:-1] == i[9:-1]:
                                    wf.write('completed:' + j[:-1] + '\n')
                                    break
                            else:
                                wf.write(i)
                elif n[5:7] == '-f':
                    if n[8:12] == 'todo':
                        pf.seek(0, 0)
                        while True:
                            temstr = pf.readline()
                            if len(temstr) == 0:
                                break
                            if temstr[0:4] == 'todo':
                                print(temstr, end='')
                    elif n[-9:] == 'completed':
                        pf.seek(0, 0)
                        while True:
                            temstr = pf.readline()
                            if len(temstr) == 0:
                                break
                            if temstr[0:9] == 'completed':
                                print(temstr, end='')
                elif n[5:9] == '-all':
                    pf.seek(0, 0)
                    while True:
                        temstr = pf.readline()
                        if len(temstr) == 0:
                            break
                        print(temstr, end='')
                elif n[5:10] == '-quit':
                    pf.close()
                    gf.close()
    return
