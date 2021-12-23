import java.lang.*;
public class Bad {
    public int M_Value(int[] m,int[] v,int cur_index,int length,int max){
        if(cur_index>=length) return 0;
        if(max<0) return 0;
        int value_fornextbranch=M_Value(m,v,cur_index+1,length,max);
        if(max-m[cur_index]>=0){
            int value_forthisbranch=v[cur_index]+M_Value(m,v,cur_index+1,length,max-m[cur_index]);
            return Math.max(value_fornextbranch,value_forthisbranch);
        }
        else return value_fornextbranch;
    }

    public static void main(String[] args) {
        Bad bad=new Bad();
        int[] m={3,4,2,2,1};
        int[] v={6,8,5,5,4};
        System.out.println(bad.M_Value(m,v,0,m.length,7));
    }
}
