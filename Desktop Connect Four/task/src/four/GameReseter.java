package four;

import javax.swing.*;
import java.awt.*;

public class GameReseter {
    public static void resetGame(Container container) {
        Component[] components = container.getComponents();
        JPanel buttonPanel = (JPanel) components[0];
        Component[] allBtns = buttonPanel.getComponents();
        ConnectFour.controlSign = "O";
        for (Component component : allBtns) {
            CellButton btn = (CellButton) component;
            btn.setText(" ");
            btn.setBackground(Color.gray);
        }
    }
}
