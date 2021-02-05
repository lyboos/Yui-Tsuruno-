#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<string.h>
#include <stdlib.h>

enum SEX {
	male=7,
	female=5,
	unknown=4
};

union age
{
	char a;
	int b;
	char c[40];
};
int main()
{
	enum SEX a = female;
	enum SEX b = unknown;
	union age x = { 6 };
	printf("%d\n", sizeof(x));
	printf("%d %d", a, b);
	return 0;
}
