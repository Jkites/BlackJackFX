package com.example.blackjackpark;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BlackJack {
    private int[][] deck= new int[4][13]; //clubs=0,diamonds=1,hearts=2,spades=3 columns;
    private Queue<Integer> playerQ = new LinkedList<>();
    private int player_value=0;
    private int dealer_valueTrue=0;
    private int dealer_valueHidden=0; //what the player sees
    private static int amount_played=0;
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
    public void printArray2d(int[][] array){
        for (int[] arr : array){
            System.out.println(Arrays.toString(arr));
        }
    }
    public int draw(int amount){
        if (amount_played==13){ //revise this later not going to work for allcases
            populateDeck();
        }
        Random rand = new Random();
        if (amount>2){
            return
        }
        if (amount<3){
            int x=rand.nextInt(5);
            int y=rand.nextInt(14);
            if (deck[x][y]!=-1){
                playerQ.add(deck[x][y]);
                deck[x][y]=-1;
            } else {
                return draw(amount++);
            }
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

