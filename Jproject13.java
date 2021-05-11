package edu.nju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		// TODO
		int a=A.length;
		int b=A[0].length;
		int arr[][]=new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				arr[i][j]=A[i][j]+B[i][j];
			}
		}
		return arr;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		// TODO
		int a=A.length;
		int b=B[0].length;
		int c=B.length;
		if(a>0 && b>0 && c>0){
		int[][] arr =new int[a][b];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b ;j++) {
				arr[i][j]=0;
			}
		}
		for (int i=0;i<a;i++) {
			for (int j = 0; j < b; j++) {
				for (int k = 0; k < c; k++) {
					arr[i][j] += (A[i][k] * B[k][j]);
				}
			}
		}
		return arr;
		}
		else
			return null;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
		// TODO
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		if(m!=0 && n!=0) {
			int[][] arr1 = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					arr1[i][j] = sc.nextInt();
				}
			}
			m = sc.nextInt();
			n = sc.nextInt();
			int[][] arr2 = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					arr2[i][j] = sc.nextInt();
				}
			}
			return plus(arr1, arr2);
		}
		else {
			int[][] result = new int[0][0];
			return result;
		}
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		// TODO
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		if(m!=0 && n!=0){
		int[][] arr1=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr1[i][j]=sc.nextInt();
			}
		}
		m=sc.nextInt();
		n=sc.nextInt();
		int[][] arr2=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr2[i][j]=sc.nextInt();
			}
		}
		return times(arr1,arr2);
		}
		else {
			int[][] result = new int[0][0];
			return result;
		}
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
	public void print(int[][] A){
		// TODO
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.print(A[i][j]);
				if(j!=A[0].length-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
