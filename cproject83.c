#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
struct S {
	int a;
	int arr[];
};

struct B
{
	int b;
	int* p;
};
int main()
{
	int n;
	struct B* test = malloc(sizeof(struct B));
	test->p = malloc(10 * sizeof(int));
	scanf("%d", &n);
	int* ptr = realloc(test->p,n*sizeof(int));
	if (ptr != NULL)
	{
		test->p = ptr;
	}
	/*scanf("%d", &n);	
	struct S* ps = malloc(sizeof(struct S) + n * sizeof(int));
	printf("%d\n", sizeof(ps));
	free(ps);
	ps = NULL;*/
	free(test);
	test = NULL;
	free(ptr);
	ptr = NULL;
	return 0;
}
