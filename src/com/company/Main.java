package com.company;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main<saveResults, testResuls> {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);
    static List<GameResult> results = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        loadResults();
        String answer;

        do {
            System.out.println("What is your name?");
            String name = scan.next();

            int myNum = rand.nextInt(100) + 1;
            System.out.println(myNum);
            long t1 = System.currentTimeMillis();

            boolean userLost = true;

            for (int i = 0; i < 10; i++) {
                int userNum = askNum();
                if (myNum > userNum) {
                    System.out.println("your number is less");
                } else if (myNum < userNum) {
                    System.out.println("your number is bigger");
                } else {
                    System.out.println("bingo");
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
        } while (answer.equals("y"));

        showResults();
        saveResults();
        System.out.println("good bye");
    }

    private static void loadResults() {
        File file = new File("top_scores.txt");
        try (Scanner in = new Scanner(file)) {

            while (in.hasNext()) {

                GameResult result = new GameResult();
                result.name = in.next();
                result.triesCount = in.nextInt();
                result.timePlayed = in.nextLong();
                results.add(result);
            }

        } catch (IOException e) {
            System.out.println("Cannot save results");
        }
    }

    private static void saveResults(){
        File file = new File("top_scores.txt");
        try (PrintWriter out = new PrintWriter(file)) {
 //           out.println("Hello World");
            for (GameResult r : results) {
                out.printf("%s %d %d \n", r.name , r.triesCount , r.timePlayed);
            }
        } catch (IOException e) {
            System.out.println("Cannot save results");
        }
    }

    private static void showResults() {
        for (GameResult r : results) {
            System.out.printf("%s %d %d\n", r.name , r.triesCount , r.timePlayed);
        }
    }

    static String askYN() {
        String answer;
        do {
            answer = scan.next();
            if (!answer.equals("y") && !answer.equals("n")) {
                System.out.println("You can enter only y or n");
            } else {
                return answer;
            }
        } while (true);

    }

    static int askNum() {
        int answer;
        do {
            try {
                answer = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("This is not a number");
                scan.next();
                continue;
            }

            if (answer < 0 || answer > 100) {
                System.out.println("You can enter only numbers in range 0 to 100");
            } else {
                return answer;
            }
        } while (true);

    }
}