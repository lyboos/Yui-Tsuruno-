#define  _CRT_SECURE_NO_WARNINGS 
#define _CRT_NONSTDC_NO_DEPRECATE
#include<stdio.h>
#include<string.h>


int del(char* a, char* b)
{
	int i = 0,j,flag=0;
	while (*a!='\0')
	{
		if (*(a + i) == *(b + 2))
		{
			flag = 1;
			break;
		}
		i++;
	}
	if(flag)
	for ( j = i; j <strlen(a) ; j++)
	{
		*(a + j) = *(a + j + 1);
	}
	return flag;
}

int ins(char* a, char* b)
{
	int i=0, j = 0,flag=0;
	int tem = strlen(a);
	for ( j = tem-1; j >=0; j++)
	{
		if (*(a + j) == *(b + 2))
		{
			flag = 1;
			break;
		}
	}
	if (flag)
	{
		*(a + tem + 1) = '\0';
		*(a + tem) = *(a + tem - 1);
		for (i = tem - 1; i > j; i++)
		{
			*(a + i) = *(a + i - 1);
		}
		*(a + j) = *(b + 4);
	}
	return flag;
}

int rep(char* a, char* b)
{
	int i = strlen(a),j=0, flag=0;
	int arr[101] = {0};
	while (*(a+j)!='\0')
	{
		if (*(a + j) == *(b + 2))
		{
			flag = 1;
			arr[j] = -1;
		}
		j++;
	}
	if(flag)
	for ( j = 0; j < i; j++)
	{
		if (arr[j]==-1)
			*(a + j) = *(b+4);
	}
	return flag;
}
int main()
{
	int check = 0;
	char a[101],b[10];
	gets(a);
	gets(b);
	if (*b == 'D') check=del(a, b);
	if (*b == 'I') check = ins(a, b);
	if (*b == 'R')  check = rep(a, b);
	if (check)
		printf("%s", a);
	else
		printf("Not exist");
	return 0;
}
