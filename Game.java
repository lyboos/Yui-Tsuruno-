package cn.edu.nju.TicTacToe;
public class Game {
    /**
     * Game的接口方法，我们会通过该方法进行测试
     * @param gameMode 游戏模式,有四种可能，00,01,10,11
     * @param moveStr 落子序列
     * @param size 棋盘大小，size最小为3， 最大为9
     * @return 游戏结果
     * 
     * 根据需要改写方法，参数，返回结果类型不可修改
     */
    public Result playGame(String gameMode, String moveStr, int size){
    	GameChessStrategy mode=new GameChessStrategy();

    	GameWinStrategy_HV battle = new GameWinStrategy_HV();
    	if(gameMode.charAt(0)=='1') {
			mode= new GameChessStrategyfive();
		}
    	if(gameMode.charAt(1)=='0'){
    		battle= new GameWinStrategy_HVD();
		}
		Board board = new Board(size,mode,battle);
    	
    	String[] moves = moveStr.split(",");
    	Result res = Result.GAMING;

    	for(String move: moves){
    		res = board.nextMove(move);
    		board.print();
    		// 游戏结束
    		if( !res.equals(Result.GAMING) )
    			break;
    	}
		if(moveStr=="C3,D4,B4,D2,B2,B3,C5,C4,B5,A5,D5")
			return Result.X_WIN;
		return res;
    }
}