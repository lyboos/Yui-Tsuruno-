numbers = [1, 3, 5, 7]
item = 0
while item < len(numbers):
    if numbers[item] % 2 != 0:
        numbers.remove(numbers[item])
    else:
        item+=1

print(numbers)
# staff_list= ['John Smith', 'Jackie Jackson', 'Chris Jones', 'Amanda Cullen', 'Jeremy Goodwin']
# del_staff = 'Chris Jones'
# print("There are {0} staff:".format(len(staff_list)))
# for item in staff_list:
#     print(item)
# print()
# print("remove the staff:"+del_staff)
# print()
# if del_staff in staff_list:
#     staff_list.remove(del_staff)
# print("There are {0} staff:".format(len(staff_list)))
# for item in staff_list:
#     print(item)
