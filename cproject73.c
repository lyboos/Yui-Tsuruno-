#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
int select(int group[],int delete[],int k, int w,int n)
{
	int counter = 0;
	while (1)
	{
		while(group[k] == 0)
			k++;
		while (group[n-w-1] == 0)
			w--;
		if (group[k] !=group[n - w - 1])
		{
			delete[counter]=group[k];
			group[k] = 0;
			counter++;
			delete[counter]=group[n - w - 1];
			group[n - w - 1] = 0;
			counter++;
		}
		else
		{
			group[counter] = k;
			return counter+1;
		}
	}
	return 0;
}

int main()
{
	int group[3000] = { 0 };
	int delete[3000] = { 0 };
	int n, k, w;
	int i;
	scanf("%d", &n);
	scanf("%d %d", &k, &w);
	k--; w--;
	for ( i = 0; i < n; i++)
	{
		group[i] = i+1;
	}
	int l = select(group, delete, k, w, n);
	free(group);
	for(i=0;i<l;i++)
	printf("%d ",delete[i]);
	return 0;
}
