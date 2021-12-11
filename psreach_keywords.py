fi = open("罪名1.0.txt","r",encoding="utf-8")
fo = open("罪名.txt","w",encoding="utf-8")

wflag =False                #写标记
newline = []                #创建一个新的列表

for line in fi :            #按行读入文件，此时line的type是str
    linelist=line.split(" ")
    fo.write(linelist[1].strip())
    fo.write('\n')
#     if "【" in line:        #重置写标记
#         wflag =False
#     if "【原文】" in line:     #检验是否到了要写入的内容
#         wflag = True
#         continue
#     if wflag == True:
#         K = list(line)
#         if len(K)>1:           #去除文本中的空行
#             for i in K :       #写入需要内容
#                 newline.append(i)
#
# strlist = "".join(newline)      #合并列表元素
# newlines = str(strlist)         #list转化成str
#
# for D in range(1,100):                       #删掉句中（）
#     newlines = newlines.replace("（{}）".format(D),"")
#
# for P in range(0,9):                               #删掉前面数值标题
#     for O in  range(0,9):
#         for U in range(0, 9):
#            newlines = newlines.replace("{}.{}{}".format(P,O,U), "")
#
# fo.write(newlines)

fo.close()
fi.close()
