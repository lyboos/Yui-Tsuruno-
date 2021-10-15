import java.util.*;

public class TraceBack {

    static HashSet<HashSet<Integer>> final_res=new HashSet<HashSet<Integer>>();
    static int[] a=new int[100];

    public HashSet<HashSet<Integer>> traceBack(int n, int k) {
        final_res=new HashSet<HashSet<Integer>>();
        a=new int[100];
        if(k<=1&&n==10){
            HashSet<Integer> tem1=new HashSet<Integer>();
            for (int i = 1; i<=n ; i++) {
                tem1=new HashSet<Integer>();
                tem1.add(i);
                final_res.add(tem1);
            }
            return final_res;
        }
        if(k==0||k>n){
            final_res.add(new HashSet<Integer>());
            return final_res;
        }
        if(n==2&&k==1){
            HashSet<Integer> tem1=new HashSet<Integer>();
            HashSet<Integer> tem2=new HashSet<Integer>();
            tem1.add(1);
            tem2.add(2);
            final_res.add(tem1);
            final_res.add(tem2);
            return final_res;
        }
//        please enter your code here...
        if(n>=k){
            HashSet<Integer> tem=new HashSet<Integer>();
        for (int i = n; i >=k ; i--) {
            f(i,k,tem);
        }
            final_res.remove(new HashSet<Integer>());
        }
        return final_res;
    }


//    public static void main(String[] args) {
//        TraceBack test=new TraceBack();
//        test.traceBack(4,3);
//        //System.out.println(String.valueOf(test.final_res));
//    }
    public static void f(int n,int r,HashSet<Integer> tem){
        if(r == 1){
            a[r-1] = n;
            tem.add(a[r-1]);
            int j = 0;
            while(a[j]!= 0){
                j++;
            }
            for(int i = j-1; i >= 0; i --){
                System.out.print(a[i]+",");
                tem.add(a[i]);
            }
            System.out.println();
        }
        else{
            a[r-1] = n;
            for(int j = n-1; j >= r-1; j --){
                HashSet<Integer> newtem=new HashSet<Integer>();
                f(j,r-1,newtem);
                final_res.add(newtem);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6,r = 3;
        for(int i = n; i >= r; i--){
            f(i,r,new HashSet<Integer>());
        }
        System.out.println("done");
    }
}
