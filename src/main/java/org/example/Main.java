package org.example;

import java.util.Arrays;
import java.util.List;

import static org.example.RandomReading.*;

public class Main {

    public static void main(String[] args) throws Exception {

        boolean statusGame = true;
        PrintHanging printHanging = new PrintHanging();
        EnterConsole enterConsole = new EnterConsole();
        System.out.println("Начем игру? (д/н)");
        if (enterConsole.getConsole() != 'д') {
            statusGame = false;
            System.out.println("Досвидули!");
        }

        List<String> words = readWordsFromFile("список слов.txt");


        while (statusGame) {
            Word word = new Word(getRandomWord(words));

            System.out.println("Выбор буквы за тобой. Игра началась!");
            for (int i = 1; i <= word.getLength(); i++) {
                if (word.getCounterMistakes() != 6 & !word.successfulGame()) {
                    word.checkingForCharacter(enterConsole.getConsole());
                    printHanging.printMan(word.getCounterMistakes(), word.getArrayMaskWord());
                    i--;

                } else {
                    if (word.successfulGame()) {
                        System.out.println("Ты победил! Сыграем еще раз? (д/н)");
                    } else {
                        System.out.println("Ты не отгадал слово: " + Arrays.toString(word.arrayHiddenWord) + " Сыграем еще раз? (д/н)");
                    }

                    if (enterConsole.getConsole() != 'д') {
                        statusGame = false;
                        break;
                    } else {
                        statusGame = true;
                        word.setCounterMistakes(0);

                        word.newWord(getRandomWord(words));
                        System.out.println("Начинаем новый раунд!");
                    }

                }


            }
        }


    }
}