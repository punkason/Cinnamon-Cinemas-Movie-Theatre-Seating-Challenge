package com.cinemas;

public class Cinema {
    private final static int ROW = 3;
    private final static int COLUMN = 5;
    private final static boolean[][] seat = new boolean [ROW][COLUMN];
    private final int noOfCustomer;

    public Cinema(int noOfCustomer){
        this.noOfCustomer=noOfCustomer;
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

    public void buyTicket() {
        int ticket = (int) (Math.random() *100 % 3)+ 1;
        if (availableSeat(ticket)) {
            assignSeat(ticket);
        }//else
    }

    private boolean availableSeat(int ticket) {
        return (getRemainingSeat() >= ticket);
    }

    private void assignSeat(int ticket) {
        while(ticket > 0) {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COLUMN; j++) {
                    if (!seat[i][j]) {
                        seat[i][j] = true;
                        ticket--;
                    }
                }
            }
        }
    }
}
