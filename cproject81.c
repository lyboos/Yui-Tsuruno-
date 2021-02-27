#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct peo
{
    char name[20];
    int age;
};

int main()
{
    struct peo ly = { 0 };
    struct peo* p = (struct peo*)malloc(sizeof(ly));
    int* l= (int *)calloc(10, sizeof(int));//初始化为0
    if (p == NULL || l == NULL)
    {
        printf("%s\n", strerror(errno));
    }
    int i = 0;
    for ( i = 0; i < 6; i++)
    {
        *(l + i) = i;
    }
    realloc(l, 20);
    for ( i = 0; i < 6; i++)
    {
        printf("%d\n", *(l+i));
    }
    free(l);
    free(p);
    p = NULL;
    l = NULL;
    return 0;
}
