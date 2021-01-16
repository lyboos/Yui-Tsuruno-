#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>

int strlen(const char* s)
{
	int i = 0;
	while (*(s + i) != '\0')
		i++;
	return i;
}
char* strcpy(char* dest, const char* src)
{
	while ((*dest++=*src++)!='\0')
	{
		;
	}
}

char* strcat(char* dest,const char* src)
{
	while (*dest!='\0')
	{
		dest++;
	}
	while (*dest++=*src++)
	{
		;
	}
}

int strcmp(const char* a, const char* b)
{
	while (*a==*b)
	{
		if (*a == '\0')
			return 0;
		a++;
		b++;
	}
	return (*a - *b);
}

//注意代码思想以及特殊类型字符串如：（aaabbbdddc，bdd）
char* strstr(char* a,char* b)
{
	char* s1 = NULL;
	char* s2 = NULL;
	char* cur = (char*)a;
	if (b == '\0')
		return (char*)a;
	while (*cur!='\0')
	{
		s1 = cur;
		s2 = (char*)b;
		while((*s1 != '\0') &&(*s2 != '\0') && (*s1 == *s2))
		{
			s1++;
			s2++;
		}
		if (*s2 == '\0')
		{
			return cur;
		}
		cur++;
	}
	return NULL;
}

int main()
{
	char a[40] = "lyboos";
	char b[40] = "lpn";
	char c[40] = "lyboosh";
	strcat(b, a);
	printf("%d\n%d\n", strcmp(c, a), strcmp(b, a));
	printf("%s", b);
	return 0;
}


//附上：KMP算法
void Getnext(int next[],String t)
{
   int j=0,k=-1;
   next[0]=-1;
   while(j<t.length-1)
   {
      if(k == -1 || t[j] == t[k])
      {
         j++;k++;
         next[j] = k;
      }
      else k = next[k];//此语句是这段代码最反人类的地方，如果你一下子就能看懂，那么请允许我称呼你一声大神！
   }
}

//附上：char【】以外其他数组的copy，处理任意类型数组的copy：
void* memcpy(void* dest, const void* src, size_t num)
{
	void* ret = dest;
	while (num--)
	{
		*(char*)dest = *(char*)src;
		++(char*)dest;
		++(char*)src;
	}
	return ret;
}
//处理重叠内存使用memmove（）；
//int main()
//{
//	int a1[5] = { 1,2,3,4,5 };
//	int a2[5] = { 0 };
//	memcpy(a2, a1, sizeof(a1));
//	return 0;
//}
