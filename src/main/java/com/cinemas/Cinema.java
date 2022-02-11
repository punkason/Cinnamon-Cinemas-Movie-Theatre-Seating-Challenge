package com.cinemas;

public class Cinema {
    private final static int ROW = 3;
    private final static int COLUMN = 5;
    private final static boolean[][] seat = new boolean [ROW][COLUMN];
    private int availableTicket;
    private int noOfCustomer;

    public Cinema(int noOfCustomer){
        this.noOfCustomer=noOfCustomer;
        availableTicket = ROW * COLUMN;
    }

    public int getRemainingSeat(){
        return availableTicket;
        /*int count = 0;
        for(int i = 0; i < ROW; i++){
            for(int j = 0; j < COLUMN; j++){
                //System.out.println(seat[i][j]);
                if (!seat[i][j]){
                    count++;
                }
            }
        }
        return count;

         */
    }

    public boolean [][] getSeat(){
        return seat;
    }

    public void buyTicket() {
        while(noOfCustomer > 0) {
            int ticket;
            if (availableTicket == 1){
                ticket = 1;
            }else if (availableTicket == 2){
                ticket = (int) (Math.random() * 100 % 2) + 1;
            }else {
                ticket = (int) (Math.random() * 100 % 3) + 1;
            }
            if (availableForSale(ticket)) {
                assignSeat(ticket);
            }else{
                //System.out.println(noOfCustomer + "END");
                return;
            }
            noOfCustomer--;
        }
    }

    private boolean availableForSale(int ticket) {
        return (getRemainingSeat() >= ticket);
    }

    private void assignSeat(int ticket) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (!seat[i][j]) {
                    if(ticket > 0) {
                        seat[i][j] = true;
                        ticket--;
                        availableTicket--;
                        //System.out.println(seat[i][j] + "" + ticket);
                    }else{
                        break;
                    }
                }
            }
        }
    }

    public String printSeatingPlan() {
        String output = "   1  2  3  4  5 \n";
        for (int i = ROW-1; i >= 0; i--) {
            output += (char) (65 + i) + " ";
            for (int j = 0; j < COLUMN; j++) {
                output += "[";
                if(seat[i][j])
                    output += "N";
                else
                    output += "Y";
                output += "]";
            }
            output += "\n";
        }
        //System.out.println(output);
        return output;
    }
}
