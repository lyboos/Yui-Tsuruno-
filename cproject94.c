#define  _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>
#include<string.h>
//void sort(int a[], int l, int h);
//int split(int a[], int l, int h);

int main()
{
    int i = 4;char rr[4][4];
    for (int u = 0; u < i; u++) {
        if (getchar() == '\n')
        {
            strstr(rr[u], "\n");
            continue;
        }
        gets(rr[u]);
    }
    for (int m = 0; m < i; m++)
    {
        for (int n = 0; n < i; n++) {
            printf("%d ", (int)rr[m][n]);
        }
        printf("\n");
    }
    /*int n, k;
    scanf("%d %d", &n, &k);
    int a[1000];
    for (int t = 0; t < n; t++)
    {
        scanf("%d", &a[t]);
    }
    sort(a, 0, n - 1);
    printf("%d", a[k]);*/
}
void sort(int a[], int l, int h)
{
    int mid;
    if (l >= h)
    {
        return;
    }
    mid = split(a, l, h);
    sort(a, l, mid - 1);
    sort(a, mid + 1, h);
}
int split(int a[], int l, int h)
{
    int ep = a[l];
    for (;;)
    {
        while (l < h && ep <= a[h])
            h--;
        if (l >= h)
            break;
        a[l++] = a[h];
        while (l < h && a[l] <= ep)
            l++;
        if (l >= h)
            break;
        a[h--] = a[l];
    }
    a[h] = ep;
    return h;
}
