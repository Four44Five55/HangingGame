package org.example;
import java.util.Arrays;

public class PrintHanging {
    char[][] body = new char[3][3];
    char[] skeleton = new char[6];

    public PrintHanging() {
        for (char[] row : body) {
            Arrays.fill(row, ' ');
        }
    }

    void printMan(int counterMistakes, char[] arrayMaskWord) {
        skeleton[0] = 'O';
        skeleton[1] = '/';
        skeleton[2] = '|';
        skeleton[3] = '\\';
        skeleton[4] = '/';
        skeleton[5] = '\\';

        for (int i = 0; i <= 5; i++) {

            if (i >= counterMistakes) {
                skeleton[i] = ' ';
            }
        }

        body[0][1] = skeleton[0];
        body[1][0] = skeleton[1];
        body[1][1] = skeleton[2];
        body[1][2] = skeleton[3];
        body[2][0] = skeleton[4];
        body[2][2] = skeleton[5];
        System.out.println("_____");
        System.out.println("|   |");
        for (int indRow = 0; indRow < 3; indRow++) {
            System.out.print("|  ");
            for (int indCol = 0; indCol < 3; indCol++) {
                System.out.print(body[indRow][indCol]);
            }
            System.out.println();
        }
        System.out.println("|  ");

        System.out.println(Arrays.toString(arrayMaskWord));
    }


}
