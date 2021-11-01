#define  _CRT_SECURE_NO_WARNINGS 
#include <windows.h>
#include <stdio.h>
#include <string.h>

void copyString(char* s)
{
    char buf[10];

    strcpy(buf, s);
}

void hacked(void)
{
    printf("The program is hacked./n");
}

//int main(int argc, char* argv[])
//{
//    char badStr[] = "000011112222333344445555";
//    DWORD* pEIP = (DWORD*)&badStr[16];
//
//    *pEIP = (DWORD)hacked;
//
//    copyString(badStr);
//    return 0;
//}

#include <stdio.h>
#include <string.h>
#include <math.h>
int main() {
    int n; char a[2000];
    scanf("%d %s", &n,a);
    
    for (int j = 0; j < n; j++)
    {
        if (a[j] == '?')
        {
            a[j] = a[n-1-j];
        }
    }

    for (int k = 0; k < n; k++)
    {
        printf("%c", a[k]);
    }
    //printf("%c", a[1]);
}
