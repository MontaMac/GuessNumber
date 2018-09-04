package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        String answer;
        do{
        int myNum = rand.nextInt(100) + 1;
        System.out.println(myNum);

        boolean userLost = true;

        for (int i = 0; i < 10; i++) {
            int userNum = askNum();
            if (myNum > userNum){
                System.out.println ("your number is less");
            } else if (myNum < userNum) {
                System.out.println ("your number is bigger");
            } else {
                System.out.println ("bingo");
                userLost = false;
                break;
            }
        }
        if (userLost == true) {
            System.out.println("you are lost");
        }
        System.out.println("Do you want to play again (y/n)?");
        answer = askYN();
    }while (answer.equals ("y"));
        System.out.println("good bye");

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