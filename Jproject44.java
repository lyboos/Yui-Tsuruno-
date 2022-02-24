import java.util.Arrays;

public class Kmp_splitString {
    public static void main(String[] args) {
        char[] src="abbaababbabababab".toCharArray();
        char[] sub="ababbabababab".toCharArray();
        int[] next=new int[sub.length];
        int i=1,j=0;
        while (i<next.length){
            j=i-1;
            while (true){
                if(next[j]==0||sub[i-1]==sub[next[j]-1])
                {
                    next[i]=next[j]+1;
                    break;
                }
                j=next[j]-1;
            }

            i++;
        }
        System.out.println(String.valueOf(sub));
        System.out.println(Arrays.toString(next));

        i=0;j=0;

        while (i<src.length){
            if(src[i]==sub[j]){
                i++;
                j++;
            }
            else {
                if(j==0) i++;
                else j=next[j]-1;
            }
            if(j==sub.length){
                System.out.println("success,下标为"+(i-sub.length));
                break;
            }
        }



    }

}
