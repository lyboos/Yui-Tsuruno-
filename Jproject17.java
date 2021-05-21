public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s){
        String[] outs=s.split(",");
        int[][] arr=new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j]=0;
            }
        }
        for (int stringnum=0;stringnum<outs.length;stringnum++) {
            int row=(int)(outs[stringnum].charAt(0)-'A');
            int col=(int)outs[stringnum].charAt(1)-'1';
            if(stringnum%2==0) {
                arr[col][row]=1;
            }
            else {
                arr[col][row]=-1;
            }
            System.out.println("  A B C");
            for (int i = 0; i < 3; i++) {
                System.out.print(i+1+" ");
                for (int j = 0; j < 3; j++) {
                    if(arr[i][j]==1)
                        System.out.print('X');
                    else if(arr[i][j]==-1){
                        System.out.print('O');
                    }
                    else System.out.print('_');
                    if(j!=2)
                        System.out.print(' ');
                }
                System.out.println();
            }
        }
        int sum=0;
        for (int i = 0; i < 3; i++) {
            sum=0;
            for (int j = 0; j < 3; j++) {
                sum+=arr[i][j];
            }
            if(sum==3)
                return Result.X_WIN;
            else if(sum==-3)
                return Result.O_WIN;
        }
        for (int i = 0; i < 3; i++) {
            sum=0;
            for (int j = 0; j < 3; j++) {
                sum+=arr[j][i];
            }
            if(sum==3)
                return Result.X_WIN;
            else if(sum==-3)
                return Result.O_WIN;
        }
        if(arr[0][0]+arr[1][1]+arr[2][2]==3 || arr[1][1]+arr[2][0]+arr[0][2]==3)
            return Result.X_WIN;
        if(arr[0][0]+arr[1][1]+arr[2][2]==-3 || arr[1][1]+arr[2][0]+arr[0][2]==-3)
            return Result.O_WIN;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j]==0)
                    return Result.GAMING;
            }
        }
        return Result.DRAW;
    }

    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("A1,B1,B2,B3,C3");
        System.out.println(result);
    }
}
