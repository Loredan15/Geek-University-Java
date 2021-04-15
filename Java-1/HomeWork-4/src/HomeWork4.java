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

    public static void main(String[] args) {
        initDeck();
        while (true) {
            printDeck();
            humanTurn();
            if (checkWin(DOT_X)){
                printDeck();
                System.out.println("Вы победили");
                break;
            }
            if (deckFull()) {
                System.out.println("Ничья");
                break;
            }

            compTurn();
            if (checkWin(DOT_O)) {
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

    public static void humanTurn() {
        int x, y;
        do {
            System.out.print("Ваш ход. Введите координаты Х Y: ");
            x = scn.nextInt() - 1;
            y = scn.nextInt() - 1;
        } while (!validTurn(x, y));
        deck[x][y] = DOT_X;
    }

    public static boolean validTurn(int x, int y) {
        if (x < 0 || x > SIZE_DECK || y < 0 || y > SIZE_DECK) return false;
        if (deck[x][y] == EMPTY) return true;
        return false;
    }

    public static void compTurn() {
        int x, y;
        //Пытаемся блокировать победу человека
        for (x = 0; x < SIZE_DECK; x++)
            for (y = 0; y < SIZE_DECK; y++)
                if (validTurn(x, y)) {
                    deck[x][y] = EMPTY;
                    if (checkWin(DOT_X)) {
                        deck[x][y] = DOT_O;
                        return;
                    }
                    deck[x][y] = EMPTY;
                }
        // Иначе ходим, как обычно
        do {
            x = rnd.nextInt(SIZE_DECK);
            y = rnd.nextInt(SIZE_DECK);
        } while (!validTurn(x, y));
        System.out.print("Ход компьютера. Он походил в точку " + (x + 1) + " " + (y + 1));
        System.out.println();
        deck[y][x] = DOT_O;
    }

    public static boolean checkWin(char symbol) {
        for (int y = 0; y < SIZE_DECK; y++)
            for (int x = 0; x < SIZE_DECK; x++)
                for (int dy = -1; dy < 2; dy++)
                    for (int dx = -1; dx < 2; dx++)
                        if (checkLine(x, y, dx, dy, symbol) == ROAD_TO_WIN)
                            return true;


        return false;
    }
    public static int checkLine(int x, int y, int dx, int dy, char dot) {
        int count = 0;
        if (dx == 0 && dy == 0)
            return 0;
        for (int i = 0, xi = x, yi = y;
             i < ROAD_TO_WIN; i++, xi += dx, yi += dy)
            if (xi >= 0 && yi >= 0 && xi < SIZE_DECK &&
                    yi < SIZE_DECK && deck[yi][xi] == dot)
                count++;
        return count;
    }

    public static boolean deckFull() {
        for (int i = 0; i < SIZE_DECK; i++)
            for (int j = 0; j < SIZE_DECK; j++)
                if (deck[i][j] == EMPTY) return false;
        return false;
    }

}