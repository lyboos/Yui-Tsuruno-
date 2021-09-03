import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class recursive {

    public static void main(String[] args) {
        // 定义一个数组
        Scanner sc=new Scanner(System.in);
        int line=sc.nextInt();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int[][] a = new int[line][line];
       // System.out.println(a.length);
        int arow=0;
        while (arow<line){
            try {
                String temstr=reader.readLine();
                if(temstr.equals(" "))
                    break;
                String[] temnum=temstr.split(" ");
                for (int acol = 0; acol < temnum.length; acol++) {
                    a[arow][acol]= Integer.parseInt(temnum[0]);
                }
                arow++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        aij b = new aij();
        System.out.println(b.det(a));
    }
}

class aij {
    // A函数可用于求余子阵
    int[][] A(int[][] a, int row, int column) {
        int[][] ans = new int[a.length - 1][a.length - 1];// ans用于储存返回的最终结果
        int[] temp = new int[(a.length - 1) * (a.length - 1)];// 临时一维数组temp用于按顺序储存剔除相应行和列元素后的数组
        int k = 0;
        // 剔除行和列并按顺序储存到temp内
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (i == row - 1) {
                    continue;
                } else if (j == column - 1) {
                    continue;
                }
                temp[k++] = a[i][j];
            }
        }
        // 按顺序从temp中读取数据并储存到ans内
        k = 0;
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = temp[k++];
            }
        }
        return ans;
    }

    // det用于求行列式
    int det(int[][] a) {
        if (a.length == 1) {
            return a[0][0];
        } else {
            int ans=0;
            for (int i = 0; i < a.length; i++) {
                ans+=a[i][0]*(int)Math.pow(-1, i)*det(A(a,i+1,1));
            }
            return ans;
        }
    }
}
