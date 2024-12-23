package org.example;

import java.util.Scanner;

public class EnterConsole {
    char tempWord;
    Scanner sc;
    String readWord;

    public EnterConsole() {
    }

    public EnterConsole(char tempWord, Scanner sc, String readWord) {
        this.tempWord = tempWord;
        this.sc = sc;
        this.readWord = readWord;
    }

    public char getConsole() {
        sc = new Scanner(System.in);

        readWord = sc.nextLine();
        if (readWord.length() != 0) {
            char[] temp = readWord.toCharArray();
            tempWord = temp[0];
            return tempWord;
        } else {
            return Character.MIN_VALUE;
        }

    }

}
