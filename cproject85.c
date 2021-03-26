#define  _CRT_SECURE_NO_WARNINGS 
#include<stdio.h>
#include<stdlib.h>
#include<errno.h>

typedef struct S {
	char name[20];
	int age;
	int level;
}S;

int main()
{
	/*S man = { "lyboos",45,12 };
	FILE* pf = fopen("test.txt","wb");
	fwrite(&man,sizeof(man),1,pf);*/
	S man = { 0 };
	FILE* pf = fopen("test.txt","r");
	fread(&man, sizeof(S), 1, pf);
	printf("%s,%d,%d",man.name,man.age,man.level);
	fclose(pf);
	pf = NULL;
	return 0;
}
