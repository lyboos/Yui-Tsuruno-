import java.util.Scanner;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				B.data[i][j]+=data[i][j];
			}
		}
		return B;
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		if(data.length==0)
			return null;
		if(B.data.length==0)
			return null;
		int[][] arr=new int[data.length][B.data[0].length];
		MyMatrix C=new MyMatrix(arr);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < B.data[0].length; j++) {
				C.data[i][j]=0;
			}
		}
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < B.data[0].length; j++) {
				for (int k = 0; k < B.data.length; k++) {
					C.data[i][j]+=(data[i][k]*B.data[k][j]);
				}
			}
		}
		return C;
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j]=data[i][j]*b;
			}
		}
		return this;
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int row=data[0].length;
		int col=data.length;
		int[][] arr=new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j]=data[j][i];
			}
		}
		this.data=arr;
		return this;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		if(m==0 || n==0)
			return null;
		int[][] arr=new int[m][n];
		MyMatrix B=new MyMatrix(arr);
		for (int i = 0; i < B.data.length; i++) {
			for (int j = 0; j < B.data[0].length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		return this.plus(B);
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		if(m==0 || n==0)
			return null;
		int[][] arr=new int[m][n];
		MyMatrix B=new MyMatrix(arr);
		for (int i = 0; i < B.data.length; i++) {
			for (int j = 0; j < B.data[0].length; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		return this.times(B);
	}
	
	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 * 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 
	 */
	public void print(){
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j]);
				if(j!=data[0].length-1)
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
