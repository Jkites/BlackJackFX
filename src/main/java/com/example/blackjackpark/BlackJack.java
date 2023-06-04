package com.example.blackjackpark;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BlackJack {
    Random rand = new Random();
    private int[][] deck= new int[4][13]; //clubs=0,diamonds=1,hearts=2,spades=3 columns;
    private Queue<Integer> playerQ = new LinkedList<>();
    private Queue<Integer> dealerQ = new LinkedList<>();
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
    public void printArray2d(int[][] array){
        for (int[] arr : array){
            System.out.println(Arrays.toString(arr));
        }
    }

    public void populateInitial(){
        while (!dealerQ.isEmpty()){
            dealerQ.remove();
        } while (!playerQ.isEmpty()){
            playerQ.remove();
        }
        for(int i = 0; i < 2; i++){
            playerQ.add(draw());
        }
        for(int i = 0; i < 2; i++){
            dealerQ.add(draw());
        }
    }

    public boolean isBust(Queue<Integer> q){
        System.out.println("is bust is called @!!");
        Object[] arr = q.toArray();
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum =  sum + (int) arr[i];
        }
        if(sum > 21){
            Queue<Integer> tempQ = new LinkedList<Integer>();
            while(!q.isEmpty()){
                if(q.peek() == 11){
                    q.remove();
                    tempQ.add(1);
                }else {
                    tempQ.add(q.remove());
                }
            }
            while (!tempQ.isEmpty()){
                q.add(tempQ.remove());
            }

            sum = 0;
            arr = q.toArray();
            for(int i = 0; i < arr.length; i++){
                sum =  sum + (int) arr[i];
            }
            System.out.println(sum +"sum after >21");
            if (sum > 21){
                return true;
            }
            return false;
        }
        System.out.println(sum);
        return false;
    }

    public boolean isBlackJack(Queue<Integer> q){
        Object[] arr = q.toArray();
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum =  sum + (int) arr[i];
        }

        if(sum == 21){
            return true;
        }
        else{
            return false;
        }
    }

//    public boolean isBlackJack()

    public void hit(){
        playerQ.add(draw());
    }

    public boolean dealerIsDone(){
        Object[] arr = dealerQ.toArray();
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum =  sum + (int) arr[i];
        }

        if(sum > 17){
            return true;
        }
        else{
            return false;
        }
    }

    public void dealerDraw(){
        dealerQ.add(draw());
    }

    public int sum(Queue<Integer> q){
        Object[] arr = q.toArray();
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum =  sum + (int) arr[i];
        }
        return sum;
    }

    //Recursive Method
    public int draw(){
        int x=rand.nextInt(4);
        int y=rand.nextInt(13);

        //Base Case
        if (deck[x][y]!=-1){
            int temp = deck[x][y];
            if(deck[x][y] == 1){
                temp = 11;
            }
            deck[x][y]=-1;
            return temp;
        }
        //Recursive Case
        else{
            return draw();
        }
    }

    public int getDealer_valueHidden() {
        return dealer_valueHidden;
    }

    public Queue<Integer> getDealer_queue() {

        return dealerQ;
    }

    public Queue<Integer> getPlayer_queue() {

        return playerQ;
    }
}

