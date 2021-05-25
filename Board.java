package cn.edu.nju.TicTacToe;
public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	protected GameChessStrategy chessStrategy1=null;
	protected GameChessStrategyfive chessStrategy2=null;
	protected GameWinStrategy_HVD winStrategy2=null;
	protected GameWinStrategy_HV winStrategy1=null;
	protected Player player = Player.X;
	protected int boardsize=3;
	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */
	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		this.boardsize=boardSize;
		this.chessStrategy1 = chessStrategy;
		this.winStrategy1 = winStrategy;
	}
	public Board(int boardSize, GameChessStrategyfive chessStrategy, GameWinStrategy_HV winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		this.boardsize=boardSize;
		this.chessStrategy2 = chessStrategy;
		this.winStrategy1 = winStrategy;
	}

	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		this.boardsize=boardSize;
		this.chessStrategy1 = chessStrategy;
		this.winStrategy2 = winStrategy;
	}

	public Board(int boardSize, GameChessStrategyfive chessStrategy, GameWinStrategy_HVD winStrategy){
		cells = new char[boardSize][boardSize];
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		this.boardsize=boardSize;
		this.chessStrategy2 = chessStrategy;
		this.winStrategy2 = winStrategy;
	}

	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String move) {
		if(chessStrategy1==null) {
			chessStrategy2.putChess(cells, nextPlay(), move);
		} else {
			chessStrategy1.putChess(cells, nextPlay(), move);
		}
		if(winStrategy1==null)
		return winStrategy2.check(cells,boardsize);
		return winStrategy1.check(cells,boardsize);
	}
	
	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}
	
	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(){
		System.out.print("  ");
		char aplph;
		for (int i = 0; i < boardsize; i++) {
			aplph= (char) ('A'+i);
			System.out.print(aplph);
			if(i!=boardsize-1)
				System.out.print(' ');
		}
		System.out.println();
		for(int i=0 ;i<boardsize; i++){
			System.out.print(i+1);
			for(int j=0; j<boardsize; j++){
				System.out.print(" "+cells[i][j]);
			}
			System.out.println();
		}
	}
}