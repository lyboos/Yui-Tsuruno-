// Alice and Bob like games. And now they are ready to start a new game. 
//   They have placed n chocolate bars in a line.
//   Alice starts to eat chocolate bars one by one from left to right, and Bob — from right to left. 
//   For each chocololate bar the time, needed for the player to consume it, is known (Alice and Bob eat them with equal speed).
//   When the player consumes a chocolate bar, he immediately starts with another. It is not allowed to eat two chocolate bars at the same time, 
// to leave the bar unfinished and to make pauses. If both players start to eat the same bar simultaneously, Bob leaves it to Alice as a true gentleman.

// How many bars each of the players will consume?
// Input

// The first line contains one integer n (1 ≤ n ≤ 105) — the amount of bars on the table. 
//   The second line contains a sequence t1, t2, ..., tn (1 ≤ ti ≤ 1000), 
// where ti is the time (in seconds) needed to consume the i-th bar (in the order from left to right).

  
//   Output

// Print two numbers a and b, where a is the amount of bars consumed by Alice, and b is the amount of bars consumed by Bob.

// Examples：


// Input

// 5
// 2 9 8 2 7

// Output

// 2 3
#include<bits/stdc++.h>
using namespace std;
int n,first,last,sum=0,a,b,s[100005];
int main(){
      cin>>n;
      for(int i=1;i<=n;++i)cin>>s[i];
      a=s[(first=1)],b=s[(last=n)];
      if(last==1){
          count<<1 0<<endl;
      }
      else{
      while(first<=last){
          if(a<=b)a+=s[++first];//用时相等即两人刚好要吃相同的巧克力时，女士优先，男士靠边。
         else b+=s[--last];
     }
     cout<<(first-1)<<' '<<(n-last)<<endl;
     }
        return 0;
}

// #include<stdio.h>
// #include<string.h>
// int main()
//  { int n,a[222222],i;
//   scanf("%d",&n);
//   for(i=0;i<n;i++)
//     scanf("%d",&a[i]);
//   int A=0,B=0,ta=0,tb=0,l=0,m=n-1;
//   while(l<=m)
//   {
//       if(ta<=tb)
//       {
//           ta+=a[l];
//           l++;
//           A++;
//       }
//       else
//       {
//           tb+=a[m];
//           m--;
//           B++;
//       }
//   }
//     printf("%d %d\n",A,B);
//    return 0;

// }
