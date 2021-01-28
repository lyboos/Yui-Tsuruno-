#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>

long add(char* a, char* b, char* s)
{
	int count = 0;

	return 0;
}

int main()
{
	long a, b = 0,flag=0;
	char al[11], bl[11],result[11];
	scanf("%ld %ld", &a, &b);
	itoa(a,al,10);
	itoa(b, bl, 10);
	add(al, bl,result);
	printf("%s", result);
	return 0;
}

#define  _CRT_SECURE_NO_WARNINGS 
#define _CRT_NONSTDC_NO_DEPRECATE
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

int more(int before, char num[])

{
	int i = 0;
	double result = 0.0;
	int length = strlen(num);
	for (i = length - 1; i >= 0; i--)
	{
		if ('A' <= num[i] && num[i] <= 'Z')
			result += pow(before, length - i - 1) * (num[i] - 55);
		else if ('a' <= num[i] && num[i] <= 'z')
			result += pow(before, length - i - 1) * (num[i] - 87);
		else if ('0' <= num[i] && num[i] <= '9')
			result += pow(before, length - i - 1) * (num[i] - 48);
	}
	return (int)result;
}

int less(int before, int num) 
{
	double result = 0.0;
	int i = 0;
	for (i = 0; num != 0; i++) 
	{
		result += pow(before, i) * (num % 10);
		num /= 10;
	}
	return (int)result; 
}
char* fan(char* a)
{
	char tem;
	char* b = a;
	int i = 0,j=strlen(b);
	for ( i = 0; i < j/2; i++)
	{
		tem = b[i];
		b[i] = b[j - i - 1];
		b[j - i - 1] = tem;
	}
	return b;
}

int ishui(char* a)
{
	int i =0,j=strlen(a);
	for ( i = 0; i <j/2; i++)
	{
		if (a[i] != a[j - i - 1])
			return 1;
	}
	return 0;
}

int change(int *m, int n)
{
	int count = 0,x,y,z;
	char a[11],b[11];
	itoa(*m,a,n);
	while (ishui(a)!=0)
	{
		strcpy(b,a);
        fan(b);
		if (n <= 10)
		{
			x =less(n,atoi(a));
			y =less(n,atoi(b));
		}
		else
		{
			x = more(n, a);
			y = more(n, b);
		}
		z = x + y;
		itoa(z, a, n);
		count++;
	}
	return count;
}
int main()
{
	int n, m, k = 0;
	scanf("%d", &n);
	if (n == 16)
		scanf("%x", &m);
	else
	{
		scanf("%d", &m);
		m = less(n, m);
	}
	k=change(&m,n);
	if (k < 30) printf("STEP=%d", k);
	else printf("Impossible!");
	return 0;
}
