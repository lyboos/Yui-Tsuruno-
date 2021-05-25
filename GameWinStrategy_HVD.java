package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HVD extends GameWinStrategy_HV{
	/**
	 * 根据需要修改获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells,int size)
	{
		char winChar = 0;
		int sum=0;
		for(int i=0; i<size-2; i++){
			sum=0;
			for (int j = 0; j <size-2 ; j++) {
				if (cells[i][j] == 'X')
					sum++;
				else if (cells[i][j] == 'O')
					sum--;
				else
					sum = 0;

				if (sum == 3) {
					winChar = 'X';
					break;
				} else if (sum == -3) {
					winChar = 'O';
					break;
				}
				if(cells[i][j]!='_'&&(cells[i][j]==cells[i][j+1])&&cells[i][j]==cells[i][j+2]) {
					winChar = cells[i][j];
					break;
				}
			}
		}

		for(int i=0; winChar == 0 && i<size-2; i++) {
			sum = 0;
			for (int j = 0; j < size - 2; j++) {
				if (cells[j][i] == 'X')
					sum++;
				else if (cells[j][i] == 'O')
					sum--;
				else
					sum = 0;

				if (sum == 3) {
					winChar = 'X';
					break;
				} else if (sum == -3) {
					winChar = 'O';
					break;
				}
				if (cells[j][i] != '_' && (cells[j][i] == cells[j][i + 1]) && cells[j][i] == cells[j][i + 2]) {
					winChar = cells[j][i];
					break;
				}
			}
		}
		if(winChar==0)
			winChar = xie1(cells, size);
		if(winChar==0)
			winChar=xie2(cells,size);
		if(winChar==0)
			winChar=xie3(cells,size);
		if(winChar==0)
			winChar=xie4(cells,size);

		switch(winChar){
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}

		for(int i = 0; i < size; ++i)
		{
			for(int j = 0; j < size; ++j)
			{
				if(cells[i][j] == '_')
					return Result.GAMING;
			}
		}

		return Result.DRAW;
	}

	private char xie1(char[][] cells,int size){
		int i=0,sum=0;
		while (i<size){
			sum=0;
			for (int k = 0,j=i; k < size&&j<size; k++,j++) {
				if(cells[j][k]=='X')
					sum++;
				else if(cells[j][k]=='O')
					sum--;
				else
					sum=0;
				if (sum==3) {
					return 'X';

				}
				else if(sum==-3){
					return 'O';
				}
			}
			i++;
		}
		return 0;
	}
	private char xie2(char[][] cells,int size){
		int i=0,sum=0;
		while (i<size){
			sum=0;
			for (int k = 0,j=i; k < size&&j<size; k++,j++) {
				if(cells[k][j]=='X')
					sum++;
				else if(cells[k][j]=='O')
					sum--;
				else
					sum=0;
				if (sum==3) {
					return 'X';
				}
				else if(sum==-3){
					return 'O';
				}
			}
			i++;
		}
		return 0;
	}
	private char xie3(char[][] cells,int size){
		int i=size-1,sum=0;
		while (i>=0){
			sum=0;
			for (int k = 0,j=i; k < size&&j>=0; k++,j--) {
				if(cells[k][j]=='X')
					sum++;
				else if(cells[k][j]=='O')
					sum--;
				else
					sum=0;
				if (sum==3) {
					return 'X';
				}
				else if(sum==-3){
					return 'O';
				}
			}
			i--;
		}
		return 0;
	}
	private char xie4(char[][] cells,int size){
		int i=size-1,sum=0;
		while (i>=0){
			sum=0;
			for (int k = 0,j=i; k < size&&j>=0; k++,j--) {
				if(cells[j][k]=='X')
					sum++;
				else if(cells[j][k]=='O')
					sum--;
				else
					sum=0;
				if (sum==3) {
					return 'X';
				}
				else if(sum==-3){
					return 'O';
				}
			}
			i--;
		}
		return 0;
	}
}