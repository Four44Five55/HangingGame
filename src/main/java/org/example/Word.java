package org.example;

import java.util.Arrays;

public class Word {
    String hiddenWord;
    char[] arrayHiddenWord;
    char[] arrayMaskWord;
    int counterMistakes;
    int counterSuccess;

    public boolean successfulGame() {
        if (counterSuccess == arrayHiddenWord.length) {
            return true;
        } else {
            return false;
        }
    }

    public Word() {
    }

    public int getLength() {
        return hiddenWord.length();
    }

    public Word(String hiddenWord) {
        this.hiddenWord = hiddenWord.toUpperCase();
        arrayHiddenWord = this.hiddenWord.toCharArray();
        arrayMaskWord = new char[arrayHiddenWord.length];
        Arrays.fill(arrayMaskWord, ' ');
    }

    public void newWord(String hiddenWord) {
        this.hiddenWord = hiddenWord.toUpperCase();
        arrayHiddenWord = this.hiddenWord.toCharArray();
        arrayMaskWord = new char[arrayHiddenWord.length];
        Arrays.fill(arrayMaskWord, ' ');
        counterMistakes = 0;
        counterSuccess = 0;
    }

    public void checkingForCharacter(char tempWord) {
        boolean successfulSearch = false;
        char fUpper = Character.toUpperCase(tempWord);
        for (int i = 0; i < arrayHiddenWord.length; i++) {
            if (arrayHiddenWord[i] == fUpper) {
                arrayMaskWord[i] = fUpper;
                successfulSearch = true;
                counterSuccess++;
            }
        }
        if (!successfulSearch) {
            counterMistakes++;
        }
    }

    public int getCounterMistakes() {
        return counterMistakes;
    }

    public void setCounterMistakes(int counterMistakes) {
        this.counterMistakes = counterMistakes;
    }

    public char[] getArrayMaskWord() {
        return arrayMaskWord;
    }

    @Override
    public String toString() {
        return "Word{" +
                "hiddenWord='" + hiddenWord + '\'' +
                ", arrayHiddenWord=" + Arrays.toString(arrayHiddenWord) +
                ", arrayMaskWord=" + Arrays.toString(arrayMaskWord) +
                ", counterMistakes=" + counterMistakes +
                '}';
    }
}
