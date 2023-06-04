package com.example.blackjackpark;

import java.util.Arrays;

public class BlackJack {
    private int[][] deck= new int[4][13]; //clubs=0,diamonds=1,hearts=2,spades=3 columns;
    private int player_value=0;
    private int dealer_valueTrue=0;
    private int dealer_valueHidden=0; //what the player sees
    public BlackJack(){
        populateDeck();
    }
    private void populateDeck(){
        for (int i=0;i<4;i++){
            for (int j=0;j<13;j++){
                if (j>9){ //all face cards are worth 10, 9 because indexes are 0 based
                    deck[i][j]=10;
                } else{ //populates card values in each column first
                    deck[i][j]=j+1;
                }
            }
        }
        printArray2d(deck);
    }
    private void printArray2d(int[][] array){
        for (int[] arr : array){
            System.out.println(Arrays.toString(arr));
        }
    }


    public int getDealer_valueHidden() {
        return dealer_valueHidden;
    }

    public int getDealer_valueTrue() {
        return dealer_valueTrue;
    }

    public int getPlayer_value() {
        return player_value;
    }
}

