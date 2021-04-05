import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettingsForm extends JFrame {
    GameSettingsForm gameSettingsForm = this;
    public GameSettingsForm() {
        setTitle("Game Settings");
        setBounds(450, 450, 240, 190);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jLabelMode = new JLabel("Chose game mode:");
        add(jLabelMode);
        JRadioButton radioButtonModeTwoPlayers = new JRadioButton("Human vs Human");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        JRadioButton radioButtonModeAgainstAI = new JRadioButton("Human vs AI");
        add(radioButtonModeAgainstAI);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        buttonGroup.add(radioButtonModeAgainstAI);
        JLabel jLabelLinesCount = new JLabel("Field size (default 3 by 3):");
        add(jLabelLinesCount);
        JTextField jTextFieldLinesCount = new JTextField();
        jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldLinesCount);
        JButton jButtonSetSettings = new JButton("Star Game!");
        add(jButtonSetSettings);
        setVisible(true);

        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGameField gameField = MainGameField.getInstance();
                if (jTextFieldLinesCount.getText().isEmpty()) {
                    MainGameField.linesCount = 3;
                }
                else {
                    try {
                        MainGameField.linesCount = Integer.parseInt(jTextFieldLinesCount.getText());
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("You must enter an integer!");
                    }
                }
                gameField.startNewGame();
                if (radioButtonModeAgainstAI.isSelected()) {
                    gameField.gameMode = 2;
                }
                gameSettingsForm.setVisible(false);
            }
        });
    }
}
