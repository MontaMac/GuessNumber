package com.company;

import java.util.*;

public class Main {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        String answer;

        do{
            System.out.println("What is your name?");
            String name = scan.next();

            int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);
        long t1 = System.currentTimeMillis();

        boolean userLost = true;

        for (int i = 0; i < 10; i++) {
            int userNum = askNum();
            if (myNum > userNum){
                System.out.println ("your number is less");
            } else if (myNum < userNum) {
                System.out.println ("your number is bigger");
            } else {
                System.out.println ("bingo");
                long t2 = System.currentTimeMillis();
                long timePlayed = (t2 - t1)/1000;
                System.out.println(timePlayed);
                userLost = false;
                GameResult r = new GameResult();
                r.name = name;
                r.triesCount = i;
                r.timePlayed = timePlayed;
                results.add(r);
                break;
            }
        }
        if (userLost == true) {
            System.out.println("you are lost");
        }
        System.out.println("Do you want to play again (y/n)?");
        answer = askYN();
    }while (answer.equals ("y"));

        showResults();

        System.out.println("good bye");

    }

    private static void showResults() {
        for (GameResult r: results) {
            System.out.println(r.name+"-->" + r.triesCount +"-->" + r.timePlayed );
        }
    }

    static String askYN(){
        String answer;
        do {
            answer = scan.next();
            if (!answer.equals ("y") && !answer.equals ("n")){
                System.out.println("You can enter only y or n");
            } else{
                return answer;
            }
        } while (true);

    }

    static int askNum(){
       int answer;
        do {
            try {
                answer = scan.nextInt();
            }catch (InputMismatchException e) {
                System.out.println ("This is not a number");
                scan.next();
                continue;
            }

            if (answer < 0 || answer > 100){
                System.out.println("You can enter only numbers in range 0 to 100");
            } else{
                return answer;
            }
        } while (true);

    }
}