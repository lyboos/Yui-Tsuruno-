#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<string.h>
#include <stdlib.h>

int len;
int ans;
char* tmp;
struct Word {
    char s[1000];
    int childnum;
    struct Word* n[22];
    int childlen[22];
    int AccurNum;
}word[22];

int Strstr(char* a, char b, int t) {
    for (int i = t; i > 0; i--)
        if (a[i] == b)
            return i;
    return -1;
}

void dfs(struct Word* w, int len) {
    for (int i = 0; i < w->childnum; i++) {
        if (w->n[i]->AccurNum >= 2)continue;

        w->n[i]->AccurNum++;
        len += w->childlen[i];
        if (len > ans) {
            ans = len;
        }

        dfs(w->n[i], len);

        w->n[i]->AccurNum--;
        len -= w->childlen[i];


    }
    if (len > ans)ans = len;

}



void judge(struct Word* a, struct Word* b) {
    int s;
    s = Strstr(b->s, (a->s)[0], (int)strlen(b->s) - 1);
    while (s > 0) {
        int flag = 1;
        int j = 0;
        int i;
        for (i = s; i < strlen(b->s) && j < strlen(a->s); i++) {
            if (b->s[i] != a->s[j++]) {
                flag = 0;
                break;
            }
        }
        if (flag && j != strlen(a->s)) {
            b->childlen[b->childnum] = (int)strlen(a->s) - j;
            b->n[b->childnum++] = a;
            return;
        }
        s = Strstr(b->s, (a->s)[0], s - 1);
    }


}

int main() {
    int n; char l;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        scanf("%s", word[i].s);
        word[i].AccurNum = word[i].childnum = 0;
    }

    scanf("%c", &l);
    scanf("%c", &l);

    for (int i = 0; i < n; i++) {
        judge(&word[i], &word[i]);
        for (int j = i + 1; j < n; j++) {
            judge(&word[i], &word[j]);
            judge(&word[j], &word[i]);
        }
    }
    ans = 0;
    for (int i = 0; i < n; i++) {
        if (word[i].s[0] == l) {

            word[i].AccurNum++;
            dfs(&word[i], (int)strlen(word[i].s));
            word[i].AccurNum--;
        }

    }
    printf("%d", ans);


}
//char* mystrcat(char* dest, char* src,char* ly)
//{
//	while (*dest!=*src)
//	{
//		if (*dest == '\0')
//			return ly;
//		*ly++ = *dest++;
//	}
//	do{
//	      *ly++=*src;
//	}while (*dest++ == *src++);
//	while (*ly++=*src++)
//	{
//		;
//	}
//	return ly;
//}
//
//int main()
//{
//	char a[20][50];
//	char ly[1000]="\0";
//	char* lpn=ly;
//	int n, m,t=0;
//	scanf("%d", &n);
//	for ( m = 0; m < n; m++)
//	{
//		scanf("%s", a[m]);
//	}
//	
//	printf("%d", strlen(ly));
//	return 0;
//}
