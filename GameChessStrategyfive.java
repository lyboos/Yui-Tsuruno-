package cn.edu.nju.TicTacToe;

import java.util.ArrayList;

public class GameChessStrategyfive extends GameChessStrategy{
    private int xcount=0;
    private int ocount=0;
    private ArrayList<String> xlist=new ArrayList<String>();
    private ArrayList<String> olist=new ArrayList<String>();
    public void putChess(char[][] cells, Player currentPlayer, String chessPos)
    {
        int i = chessPos.charAt(1) - '1';
        int j = chessPos.charAt(0) - 'A';
        if(currentPlayer==Player.X) {
            cells[i][j] = 'X';
            xlist.add(chessPos);
            if(xcount<5){
               xcount++;
            }
            else {
                i= xlist.get(0).charAt(1)-'1';
                j=xlist.get(0).charAt(0)-'A';
                cells[i][j]='_';
                xlist.remove(0);
            }
        }
        else {
            cells[i][j] = 'O';
            olist.add(chessPos);
            if(ocount<5){
                ocount++;
            }
            else {
                i= olist.get(0).charAt(1)-'1';
                j=olist.get(0).charAt(0)-'A';
                cells[i][j]='_';
                olist.remove(0);
            }
        }
    }
}

