#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>

int detect(long* a, long* b)
{
	int flag = 0;
	if (*a < 0)
	{
		*a = -*a;
		flag++;
	}
	if (*b < 0)
	{
		*b = -*b;
		flag++;
	}
	return (flag == 1 ? 1 : 0);
}
long mul(long a,long b)
{
	int flag = detect(&a,&b),mulnum,result=0;
	for ( mulnum = 0; mulnum < b; mulnum++)
	{
		result += a;
	}
	return (flag == 1 ? -result : (result));
}

long div1(long a, long b)
{
	int flag = detect(&a,&b),result=0;
	if (a < b)
		return 0;
	while(a-b>0)
	{
		a = a - b;
		result++;
	}
	return (flag == 1 ? -result : result);
}

long div2(long a, long b)
{
	int flag = detect(&a, &b);
	a = a - div1(a, b)*b;
	return (flag == 1 ? -a : a);
}
int main()
{
	long a, b;
	long pro = 0, quo = 0, rem=0;
	scanf("%d %d", &a, &b);
	pro = mul(a, b);
	quo = div1(a, b);
	rem = div2(a, b);
	printf("product:%ld\n", pro);
	printf("quotient:%ld\n", quo);
	printf("remainder:%ld\n", rem);
	return 0;
}
