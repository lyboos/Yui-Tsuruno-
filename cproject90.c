#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#define SQUARE(X) X*X
#define PRINT(X) printf("the value of "#X" is %d\n",X)
int main()
{
	int num = 99;
	printf("%d\n%d\n", SQUARE((5+1)), SQUARE(5+1));
	PRINT(num);
	return 0;
}
//#define MAX_INT 224400000
//#define STR "lyboos"
//#define do_forever for(;;)
//#define write_log fprintf(pf, "%s\t\t%s\t\t    \
//									%s\t\t%ld\t\tcount:%d\n",   \
//								 __FILE__, __DATE__, __TIME__, __LINE__		\
//													,arr[i]+1);
//#include<stdio.h>
//#include<string.h>
//int main()
//{
//	char roman[100];
//	int sum = 0;
//	scanf("%s", roman);
//	int i = 0, a = strlen(roman);
//	for ( i = 0; i < a; i++)
//	{
//		switch (roman[i])
//		{
//		case 'I':
//			if (roman[i + 1] == 'V')
//			{
//				i++;
//				sum += 4;
//			}
//			else if (roman[i + 1] == 'X')
//			{
//				i++;
//				sum += 9;
//			}
//			else {
//				sum += 1;
//			}
//			break;
//		case 'V':
//			sum += 5;
//			break;
//		case 'X':
//			if (roman[i + 1] == 'C')
//			{
//				i++;
//				sum += 90;
//			}
//			else if (roman[i + 1] == 'L')
//			{
//				i++;
//				sum += 40;
//			}
//			else {
//				sum += 10;
//			}
//			break;
//		case 'L':
//			sum += 50;
//			break;
//		case 'C':
//			if (roman[i + 1] == 'D')
//			{
//				i++;
//				sum += 400;
//			}
//			else if (roman[i + 1] == 'M')
//			{
//				i++;
//				sum += 900;
//			}
//			else {
//				sum += 10;
//			}
//			break;
//		case 'D':
//			sum += 500;
//			break;
//		case 'M':
//			sum += 1000;
//			break;
//		default:
//			break;
//		}
//	}
//	if(i==a-1)
//		switch (roman[i])
//		{
//		case 'I':
//			if (roman[i + 1] == 'V')
//			{
//				i++;
//				sum += 4;
//			}
//			else if (roman[i + 1] == 'X')
//			{
//				i++;
//				sum += 9;
//			}
//			else {
//				sum += 1;
//			}
//			break;
//		case 'V':
//			sum += 5;
//			break;
//		case 'X':
//			if (roman[i + 1] == 'C')
//			{
//				i++;
//				sum += 90;
//			}
//			else if (roman[i + 1] == 'L')
//			{
//				i++;
//				sum += 40;
//			}
//			else {
//				sum += 10;
//			}
//			break;
//		case 'L':
//			sum += 50;
//			break;
//		case 'C':
//			if (roman[i + 1] == 'D')
//			{
//				i++;
//				sum += 400;
//			}
//			else if (roman[i + 1] == 'M')
//			{
//				i++;
//				sum += 900;
//			}
//			else {
//				sum += 10;
//			}
//			break;
//		case 'D':
//			sum += 500;
//			break;
//		case 'M':
//			sum += 1000;
//			break;
//		default:
//			break;
//		}
//	printf("num:%d\n", sum);
//	return 0;
//}
