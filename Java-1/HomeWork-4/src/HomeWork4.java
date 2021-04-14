import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    public static final int SIZE_DECK = 3;
    public static final int ROAD_TO_WIN = 3;
    public static char DOT_X = 'X';
    public static char DOT_O = 'O';
    public static char EMPTY = '·';
    public static char deck[][];
    public static Scanner scn = new Scanner(System.in);
    public static Random rnd = new Random();
    static final int vector[][] = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    public static void main(String[] args) {
        initDeck();
        while (true) {
            printDeck();
            if (humanTurn()) {
                printDeck();
                System.out.println("Вы победили");
                break;
            }
            if (deckFull()) {
                System.out.println("Ничья");
                break;
            }

            if (compTurn()) {
                printDeck();
                System.out.println("Победил компьютер");
                break;
            }
            if (deckFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void initDeck() {
        deck = new char[SIZE_DECK][SIZE_DECK];
        for (int i = 0; i < SIZE_DECK; i++) {
            for (int j = 0; j < SIZE_DECK; j++)
                deck[i][j] = EMPTY;
        }
    }

    public static void printDeck() {
        for (int i = 0; i < SIZE_DECK; i++) {
            System.out.print("  ");
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE_DECK; i++) {
            System.out.print((i + 1) + "");
            for (int j = 0; j < SIZE_DECK; j++) {
                System.out.print(" ");
                System.out.print(deck[i][j] + " " + "|");

            }
            System.out.println();
        }
    }

    public static boolean humanTurn() {
        int x, y;
        do {
            System.out.print("Ваш ход. Введите координаты Х Y: ");
            x = scn.nextInt() - 1;
            y = scn.nextInt() - 1;
        } while (!validTurn(x, y));
        deck[x][y] = DOT_X;
        return checkWin(DOT_X);
    }

    public static boolean validTurn(int x, int y) {
        if (x < 0 || x > SIZE_DECK || y < 0 || y > SIZE_DECK) return false;
        if (deck[x][y] == EMPTY) return true;
        return false;
    }

    public static boolean compTurn() {
        int x = -1;
        int y = -1;
        boolean compWin = false;
        boolean HumanWin = false;
        //Простой вариант с рандомной точкой
        do {
            x = rnd.nextInt(SIZE_DECK);
            y = rnd.nextInt(SIZE_DECK);
        } while (!validTurn(x, y));

//        for (int i = 0; i < SIZE_DECK; i++) {
//            for (int j = 0; j < SIZE_DECK; j++) {
//                if (!validTurn(i, j)) {
//                    deck[i][j] = DOT_O;
//                    if (checkWin(DOT_O)) {
//                        x = i;
//                        y = j;
//                        compWin = true;
//                    }
//                    deck[i][j] = EMPTY;
//                }
//            }
//        }
//
//        if (!compWin) {
//            for (int i = 0; i < SIZE_DECK; i++) {
//                for (int j = 0; j < SIZE_DECK; j++) {
//                    if (!validTurn(i, j)) {
//                        deck[i][j] = DOT_X;
//                        if (checkWin(DOT_X)) {
//                            x = i;
//                            y = j;
//                            HumanWin = true;
//                        }
//                        deck[i][j] = EMPTY;
//                    }
//                }
//            }
//        }

        System.out.print("Ход компьютера. Он походил в точку " + (x + 1) + " " + (y + 1));
        System.out.println();
        deck[x][y] = DOT_O;
        return checkWin(DOT_O);
    }

//    public static boolean checkWin(char symbol, int x, int y) {
    public static boolean checkWin(char symbol) {

        // Вариант 1. Самый простой. Перебор вариантов.
        /*
        if (deck[0][0] == symbol && deck[0][1] == symbol && deck[0][2] == symbol) return true;
        if (deck[1][0] == symbol && deck[1][1] == symbol && deck[1][2] == symbol) return true;
        if (deck[2][0] == symbol && deck[2][1] == symbol && deck[2][2] == symbol) return true;
        if (deck[0][0] == symbol && deck[1][0] == symbol && deck[2][0] == symbol) return true;
        if (deck[0][1] == symbol && deck[1][1] == symbol && deck[2][1] == symbol) return true;
        if (deck[0][2] == symbol && deck[1][2] == symbol && deck[2][2] == symbol) return true;
        if (deck[0][0] == symbol && deck[1][1] == symbol && deck[2][2] == symbol) return true;
        if (deck[2][0] == symbol && deck[1][1] == symbol && deck[0][2] == symbol) return true;
        return false;
        */

        //Вариант 2. Циклы.

        boolean col;
        boolean row;

        for (int i = 0; i < SIZE_DECK; i++) {
            col = true;
            row = true;
            for (int j = 0; j < SIZE_DECK; j++) {
                col &= (deck[i][j] == symbol);
                row &= (deck[i][j] == symbol);
            }
            if (col || row) return true;
        }
        return false;


        //Вариант 3. Вектора
//        int vector_x, vector_y;
//        int n;
//        for (int[] aVector : vector) {
//            n = 1;
//
//            vector_x = x;
//            vector_y = y;
//
//            while (vector_x < SIZE_DECK && vector_x >= 0 && vector_y < SIZE_DECK && vector_y >= 0) {
//                if (deck[vector_y][vector_x] != symbol)
//                    break;
//                if (vector_x != x || vector_y != y)
//                    ++n;
//                vector_x += aVector[0];
//                vector_y += aVector[1];
//            }
//
//            vector_x = x;
//            vector_y = y;
//
//            while (vector_x < SIZE_DECK && vector_x >= 0 && vector_y < SIZE_DECK && vector_y >= 0) {
//                if (deck[vector_y][vector_x] != symbol)
//                    break;
//                if (vector_x != x || vector_y != y)
//                    ++n;
//                vector_x -= aVector[0];
//                vector_y -= aVector[1];
//            }
//            if (n >= ROAD_TO_WIN)
//                return true;
//        }
//        return false;
//
    }

    public static boolean deckFull() {
        for (int i = 0; i < SIZE_DECK; i++)
            for (int j = 0; j < SIZE_DECK; j++)
                if (deck[i][j] == EMPTY) return false;
        return false;
    }

//    public static void aiShot() {
//        int x = -1;
//        int y = -1;
//        boolean ai_win = false;
//        boolean user_win = false;
//        // aiLevel = 2
//        // Находим выигрышный ход
//        if (aiLevel == 2)
//        {
//            for (int i = 0; i < DIMENSION; i++)
//            {
//                for (int j = 0; j < DIMENSION; j++)
//                {
//                    if (!isCellBusy(i, j))
//                    {
//                        field[i][j] = AI_SIGN;
//                        if (checkWin(AI_SIGN))
//                        {
//                            x = i;
//                            y = j;
//                            ai_win = true;
//                        }
//                        field[i][j] = NOT_SIGN;
//                    }
//                }
//            }
//        }
//        // aiLevel = 1
//        // Блокировка хода пользователя, если он побеждает на следующем ходу
//        if (aiLevel > 0)
//        {
//            if (!ai_win)
//            {
//                for (int i = 0; i < DIMENSION; i++)
//                {
//                    for (int j = 0; j < DIMENSION; j++)
//                    {
//                        if (!isCellBusy(i, j))
//                        {
//                            field[i][j] = USER_SIGN;
//                            if (checkWin(USER_SIGN))
//                            {
//                                x = i;
//                                y = j;
//                                user_win = true;
//                            }
//                            field[i][j] = NOT_SIGN;
//                        }
//                    }
//                }
//            }
//        }
//        // aiLevel = 0
//        if (!ai_win && !user_win)
//        {
//            do
//            {
//                Random rnd = new Random();
//                x = rnd.nextInt(DIMENSION);
//                y = rnd.nextInt(DIMENSION);
//            }
//            while (isCellBusy(x, y));
//        }
//        field[x][y] = AI_SIGN;
//    }
}
