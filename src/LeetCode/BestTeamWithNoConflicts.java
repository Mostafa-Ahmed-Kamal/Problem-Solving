package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BestTeamWithNoConflicts {
    private class Player{
        int age;
        int score;
        public Player(int age, int score){
            this.age = age;
            this.score = score;
        }
        public int getAge(){
            return age;
        }
        public int getScore(){
            return score;
        }
    }
    int[] dp;
    Player[] players;
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        players = new Player[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(ages[i],scores[i]);
        }
        Arrays.sort(players,Comparator.comparingInt(Player::getAge).thenComparing(Player::getScore));
        dp[0] = players[0].score;
        for (int i = 1; i < n; i++) {
            dp[i] = players[i].score;
            for (int j = 0; j < i; j++) {
                if(players[i].score>=players[j].score){
                    dp[i] = Math.max(dp[i],players[i].score + dp[j]);
                }
            }
        }
        int maxValue = dp[0];
        for (int num:dp){
            maxValue = Math.max(maxValue,num);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        BestTeamWithNoConflicts bts = new BestTeamWithNoConflicts();
        int[] scores = {1,3,7,3,2,4,10,7,5}, ages = {4,5,2,1,1,2,4,1,4};
        System.out.println(bts.bestTeamScore(scores,ages));
    }
}
