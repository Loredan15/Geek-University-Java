
import constants.Settings;
import utils.ArrayTools;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameFormUi {

    JFrame GAME_FORM = new JFrame("GAME");

    int pressedButton1 = 0;
    int pressedButton2 = 0;
    static int count = 0;
    JButton buttonSaved = new JButton();
    JButton buttonSaved2 = new JButton();
    boolean isPressed = false;


    void createGameForm() {
        GAME_FORM.setLayout(null);
        GAME_FORM.setVisible(true);
        GAME_FORM.setResizable(false);
        GAME_FORM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GAME_FORM.setBounds(Settings.FORM_POSITION_COORD, Settings.FORM_POSITION_COORD, Settings.FORM_WIDTH, Settings.FORM_HEIGHT);

        createButtons();
        GAME_FORM.repaint();

    }

    void createButtons() {

        int[] buttonNumbers = ArrayTools.generateArray(Settings.BUTTONS_AMOUNT);

        for (int buttonNumber : buttonNumbers) {

            JButton gameButton = new JButton();
            gameButton.setName(String.valueOf(buttonNumber));
            gameButton.setBounds(Settings.xCoord, Settings.yCoord, Settings.BUTTON_WIDTH_HEIGHT, Settings.BUTTON_WIDTH_HEIGHT);
            GAME_FORM.add(gameButton);
            Settings.xCoord = Settings.xCoord + 110;

            if (Settings.xCoord > 340) {
                Settings.xCoord = 10;
                Settings.yCoord = Settings.yCoord + Settings.FORM_POSITION_COORD + Settings.xCoord;
            }

            gameButton.addActionListener(e -> {
                gameButton.setText(gameButton.getName());
                if (!isPressed) {
                    pressedButton1 = Integer.parseInt(gameButton.getName());
                    gameButton.setText(gameButton.getName());
                    isPressed = true;
                    System.out.println("Кнопка 1 - " + pressedButton1);
                    buttonSaved = gameButton;
                } else {
                    buttonSaved2 = gameButton;
                    pressedButton2 = Integer.parseInt(gameButton.getName());
                    System.out.println("Кнопка 2 - " + pressedButton2);
                    buttonSaved2.setText(buttonSaved2.getName());
                    if (pressedButton1 != pressedButton2) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        buttonSaved.setText("");
                        buttonSaved2.setText("");
                        isPressed = false;
                    } else {
                        count++;
                        isPressed = false;
                        if (count == Settings.BUTTONS_AMOUNT / 2) {
                            System.out.println("Вы победили");
                            System.exit(1);
                        }
                    }
                }
            });
        }
    }
}