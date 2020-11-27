#include<stdio.h>
//int main()
//{
//	char arr[5];
//	char(*pa)[5] = &arr;
//	return 0;
//}
void print1(int arr[3][2], int x, int y)
{
	int i, j;
	for ( i = 0; i < x; i++)
	{
		for (j = 0; j < y; j++)
		{
			printf("%d ", arr[i][j]);
		}
		printf("\n");
	}
}

void print2(int(*p)[2], int x, int y)
{
	int j, i;
	for ( i = 0; i < x; i++)
	{
		for ( j = 0; j < y; j++)
		{
			printf("%d ", *(*(p + i) + j));
		}
		printf("\n");
	}
}
int main()
{
	int arr[3][2] = { {1,2},{2,3},{3,4} };
	print1(arr, 3, 2);
	printf("对比\n");
	print2(arr, 3, 2);
	return 0;
}
