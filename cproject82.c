#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

//char* getmem()
//{
//    static char p[] = "hello world";
//    return p;
//}
char* getmem()
{
    char* p = malloc(100);
    strcpy(p, "heello");
    return p;
}

void test(void)
{
    char* str = (char*)malloc(100);
    strcpy(str, "hello ");
    printf(str);
    free(str);
    //free后继续访问，视为非法访问
//    str = NULL;
    if (str!=NULL)
    {
        strcpy(str,"world");
        printf(str);
    }
}

int main()
{
    char* r = NULL;
    r = getmem();
    printf("%s\n",r);
    test();
    return 0;
}
