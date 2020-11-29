#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
void ly(int b)
{
	int a = 0;
}
//分析
//(*(void(*)())0)();

//void(*signal(int,void(*)(int)))(int)
//
//int Add(int x, int y)
//{
//	return x + y;
//}
//int main()
//{
//	int a = 10;
//	int b = 20;
//	int (*pa)(int, int) = Add;
//	printf("%d\n", (pa)(a, b));
//	printf("%d\n", (*pa)(2, 3));
//    printf("%d\n", (**pa)(5, b));
//    printf("%d\n", (***pa)(a, 10));
//	return 0;
//}
char* mystrcpy(char* desk, const char* src)
{

}
char* (*pf)(char*, const char*) = mystrcpy;
char* (*pfarr[4])(char*, const char*) = { mystrcpy,mystrcpy,mystrcpy,mystrcpy };
