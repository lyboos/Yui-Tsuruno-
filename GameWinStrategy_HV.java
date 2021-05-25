package cn.edu.nju.TicTacToe;
/**
 * 横竖方式获胜对应的类
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HV{
	/**
	 * 自行实现检测获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells,int size)
	{
		char winChar = 0;
		int sum=0;
		for(int i=0; i<size; i++){
			sum=0;
			for (int j = 0; j <size ; j++) {
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
			}
		}

		for(int i=0; winChar == 0 && i<size; i++){
			sum=0;
			for (int j = 0; j <size ; j++) {
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
			}
		}

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
}