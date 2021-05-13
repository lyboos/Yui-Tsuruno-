#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include"stddef.h"
#define OFFSETOF(struct_name,member_name) (int)&(((struct_name*)0)->member_name) 
struct MyStruct
{
	char c1;
	int a;
	char c2;
};

int main()
{
	printf("%d\n", OFFSETOF(struct MyStruct,c1));
	printf("%d\n", OFFSETOF(struct MyStruct,a));
	printf("%d\n", OFFSETOF(struct MyStruct,c2));
	return 0;
}
