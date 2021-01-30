//int fun(int n)
////{
////	if (n <= 1) return n;
////	else return n * fun(n-1);
////}
//
////void Permutation(int m, int n, int a[])
////{
////    int i, temp;
////    //递归到底层
////    if (m == n - 1)
////    {
////        for (i = 0; i < n - 1; i++)
////            printf("%d ", a[i]);
////        printf("%d\n", a[i]);
////    }
////    else
////    {
////        for (i = m; i < n; i++)
////        {
////            temp = a[m];
////            a[m] = a[i];
////            a[i] = temp;
////            //递归到下一层
////            Permutation(m + 1, n, a);
////            //保证递归后保持上一层的顺序
////            temp = a[m];
////            a[m] = a[i];
////            a[i] = temp;
////        }
////    }
////}
//void swap(int* p1, int* p2)
//{
//	int t = *p1;
//	*p1 = *p2;
//	*p2 = t;
//}
//
//void permutation(int a[], int index, int size)
//{
//	if (index == size)
//	{
//		for (int i = 0; i < size; i++)
//			printf("%d ", a[i]);
//	}
//	else
//	{
//		for (int j = index; j < size; j++)
//		{
//			swap(&a[j], &a[index]);
//			permutation(a, index + 1, size);//此处用到递归思想
//			swap(&a[j], &a[index]);
//		}
//
//	}
//}
//int main()
//{
//	int a, b,c;
//	scanf("%d", &a);
//	scanf("%d", &c);
//	int arr[120];
//	for ( b = 0; b <a; b++)
//	{
//		scanf("%d",&arr[b]);
//	}
//    permutation(arr,c,a);
//	return 0;
#include<stdio.h>
#include<string.h>

int fun(int n)
{
	int i = 1;
	while (n)
	{
		i = i * n;
		n--;
	}
	return i;
}

int trans(int arr[], int n, int d)
{
	int i, j,k,count=0,tem;
	for (i = 1; i <n; i++)
	{
		for (j=n-1,k=i;k>0;k--)
		{
			count++;
			tem = arr[j];
			arr[j] = arr[j - k];
			arr[j - k] = tem;
			if (count == d)
				return 0;
		}
	}
}
int main()
{
	int a, b, c;
	scanf("%d",&a);
	scanf("%d", &b);
	int arr[1000] = { 0 };
	for ( c = 0; c < a; c++)
	{
		scanf("%d", &arr[c]);
	}
	trans(arr, a, b-1);
	for (c = 0; c < a; c++)
	{
		printf("%d ", arr[c]);
	}
	return 0;
}
