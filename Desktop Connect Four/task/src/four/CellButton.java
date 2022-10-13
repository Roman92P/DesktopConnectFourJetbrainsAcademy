package four;

import javax.swing.*;
import java.awt.*;

public class CellButton extends JButton implements Comparable<CellButton> {
    private String row;
    private String column;

    public CellButton() {
        super();
    }

    @Override
    public void setFont(Font font) {
        super.setFont(new Font("Arial", Font.BOLD, 12));
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public int compareTo(CellButton cellButton) {
        String buttonNum = this.getName().substring("ButtonN".length(), this.getName().length());
        String buttonNum1 = cellButton.getName().substring("ButtonN".length(), cellButton.getName().length());
        int i = Integer.parseInt(buttonNum);
        int i1 = Integer.parseInt(buttonNum1);
        return Integer.compare(i, i1);
    }

    @Override
    public String toString() {
        return "CellButton{"+this.getName()+"}";
    }
}
