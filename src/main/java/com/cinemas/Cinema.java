package com.cinemas;

public class Cinema {
    private final static int ROW = 3;
    private final static int COLUMN = 5;
    private final static boolean[][] seat = new boolean [ROW][COLUMN];

    public Cinema(){

    }

    public int getRemainingSeat(){
        int count = 0;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COLUMN; j++){
                if (!seat[i][j]){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean [][] getSeat(){
        return seat;
    }

}
