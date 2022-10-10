package four;

import javax.swing.*;
import java.awt.*;

public class CellButton extends JButton {
    private String row;
    private String column;

    public CellButton() {
        super();
    }

    @Override
    public void setFont(Font font) {
        super.setFont(new Font("Arial", Font.BOLD, 12));
    }

}
