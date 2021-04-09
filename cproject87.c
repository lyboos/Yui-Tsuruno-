#define  _CRT_SECURE_NO_WARNINGS 
#define MAX_INT 224400000
#define STR "lyboos"
#define do_forever for(;;)
#define write_log fprintf(pf, "%s\t\t%s\t\t    \
									%s\t\t%ld\t\tcount:%d\n",   \
								 __FILE__, __DATE__, __TIME__, __LINE__		\
													,arr[i]+1);
#include<stdio.h>
int main()
{
	printf("%s\n", STR);
	printf("%d\n",MAX_INT);
	printf("%s\n%s\n", __FILE__, __DATE__);
	printf("%s\n", __TIME__);
	printf("%ld", __LINE__);
	FILE* pf = fopen("log.txt", "w");
	int i = 0, arr[10] = { 0 };
	for ( i = 0; i < 10; i++)
	{
		arr[i] = i;
		fprintf(pf, "%s\t\t%s\t\t%s\t\t%ld\t\tcount:%d\n", __FILE__, __DATE__, __TIME__, __LINE__,arr[i]+1);
		printf("\n%s\n", __FUNCTION__);
		printf("%d", __STDC_HOSTED__);
	}
	fclose(pf);
	pf = NULL;
	int b = 10, a = !b == 10 == 0 == 1;
	printf("%d", a);
	return 0;
}
