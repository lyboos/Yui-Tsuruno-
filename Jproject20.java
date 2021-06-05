public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index==0)
            return 0;
        int[] a = new int[index];
        int count = 1;
        a[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while(count<index){
            int min = min(a[index2]*2,a[index3]*3,a[index5]*5);
            a[count] = min;
            while(a[index2]*2<=a[count]) index2++;
            while(a[index3]*3<=a[count]) index3++;
            while(a[index5]*5<=a[count]) index5++;
            count++;
        }
        int result = a[index-1];
        return result;
    }

    public int min(int a,int b,int c){
        int temp = a>b?b:a;
        return temp>c?c:temp;
    }


}
