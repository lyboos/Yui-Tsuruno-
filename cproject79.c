#include <stdio.h>
int map[21][21] = { 0 };
int n, m, x, y;

int main() {
    int i, j;
    long long count;
    long long way(int x1, int y1);
    scanf("%d%d%d%d", &n, &m, &x, &y);

    for (i = 0; i <= n; i++)
    {
        for (j = 0; j <= m; j++)
        {
            map[i][j] = 1;
        }
    }
    map[x][y] = 0;
    map[x - 1][y - 2] = 0;
    map[x - 1][y + 2] = 0;
    map[x + 1][y - 2] = 0;
    map[x + 1][y + 2] = 0;
    map[x - 2][y - 1] = 0;
    map[x - 2][y + 1] = 0;
    map[x + 2][y - 1] = 0;
    map[x + 2][y + 1] = 0;
    count = way(n, m);

    printf("%lld", count);
    return 0;

}

long long way(int x1, int y1)
{
    long long result;

    if (map[x1][y1] == 1)
    {
        if (y1 == 0 && x1 > 0)
        {
            result = way(x1 - 1, 0);
        }
        if (x1 == 0 && y1 > 0)
        {
            result = way(0, y1 - 1);
        }
        if (x1 > 0 && y1 > 0)
        {
            result = way(x1 - 1, y1) + way(x1, y1 - 1);
        }
        if (x1 == 0 && y1 == 0)
        {
            result = 1;
        }
    }
    else
    {
        result = 0;
    }
    return(result);
}

#include<stdio.h>

int main()
{
    int n,m,x,y,i,j;
    int g[20][20]={0};
    long long int f[20][20] = {0};
    int dx[9]={0,-2,-1,1,2,2,1,-1,-2};
    int dy[9]={0,1,2,2,1,-1,-2,-2,-1};
    scanf("%d %d %d %d",&n,&m,&x,&y);
    g[x][y]=1;
    for(i=1;i<=8;i++)
    {
        if((x+dx[i]>=0)&&(x+dx[i]<=n)&&(y+dy[i]>=0)&&(y+dy[i]<=m))
        {
            g[x+dx[i]][y+dy[i]]=1;
        }
    }
    for(i=1;i<=n;i++)
    {
        if(g[i][0]!=1)
            f[i][0]=1;
        else
            for(;i<=n;i++)
            f[i][0]=0;
    }
    for(j=1;j<=m;j++)
    {
        if(g[0][j]!=1)
            f[0][j]=1;
        else
            for(;j<=m;j++)
                f[0][j]=0;
    }
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=m;j++)
        {
            if(g[i][j]!=1)

                    f[i][j]=f[i-1][j]+f[i][j-1];
        }
    }
    printf("%lld\n",f[n][m]);
    return 0;
}
