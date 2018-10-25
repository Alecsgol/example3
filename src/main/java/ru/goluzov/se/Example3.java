package ru.goluzov.se;

import java.util.Random;
import java.util.Scanner;

//Загадываем числа от 0 до 9 в 3 попытки.

public class Example3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        char answer;
        do {
            System.out.println(" Повторить игру еще раз? 1/0");
            while (!scanner.hasNext("[10]")) {
                System.out.println("Не символ. Введите 1/0:");
                scanner.next();
            }
            answer = scanner.next().charAt(0);
            if ('0' == answer) {
                isExit = true;
            } else if ('1' == answer) {
                guessGame();
            }
        } while (!isExit);
    }
    private static void guessGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int generate = random.nextInt(10);
        boolean isWin = false;
        int currentNum;
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите число от 0 до 9: ");
            currentNum = scanner.nextInt();
            if (currentNum == generate) {
                isWin = true;
                break;
            } else if (currentNum > generate) {
                System.out.printf("Загаданное меньше.  ", currentNum);
            } else {
                System.out.printf("Загаданное больше.  ", currentNum);
            }
        }
        if (isWin) System.out.println("Победа");
        else System.out.printf("GAME OVER. Ответ: %d.", generate);
    }
}
