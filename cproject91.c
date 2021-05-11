#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#define SQUARE(X) X*X
//#define PRINT(X) printf("the value of "#X" is %d\n",X)
#define DEBUG
int main()
{
	int num = 99;
	//printf("%d\n%d\n", SQUARE((5+1)), SQUARE(5+1));
#ifdef DEBUG
	printf("%d\n", num);
#else
	PRINT(num);
#endif // DEBUG
#ifndef DEBUG
	PRINT(num);
#elif !defined(PRINT)
	printf("%d\n", num);
#endif // !DEBUG

	return 0;
}
//#define MAX_INT 224400000
//#define STR "lyboos"
//#define do_forever for(;;)
//#define write_log fprintf(pf, "%s\t\t%s\t\t    \
//									%s\t\t%ld\t\tcount:%d\n",   \
//								 __FILE__, __DATE__, __TIME__, __LINE__		\
//													,arr[i]+1);
