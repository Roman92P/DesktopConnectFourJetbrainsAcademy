package four;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectFour extends JFrame implements ActionListener {
    private static String controlSign = " ";

    public ConnectFour() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        setTitle("Connect Four");

        for (int i = 6; i > 0; i--) {
            for (int j = 65; j < 72; j++) {
                String col = Character.toString(j);
                CellButton cellButton = new CellButton();
                cellButton.setFocusPainted(false);
                cellButton.setBorder(new LineBorder(Color.LIGHT_GRAY));
                cellButton.setName("Button" + col + i);
                cellButton.setText(" ");
                cellButton.addActionListener(this);
                add(cellButton);
            }
        }


        setLayout(new GridLayout(6, 7));
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String buttonFieldText = actionEvent.getActionCommand();
        CellButton source = (CellButton) actionEvent.getSource();
        String buttonName = source.getName().substring(0, "ButtonN".length());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buttonName);
        stringBuilder.append(".*");
        String columnFilter = stringBuilder.toString();
        Container contentPane = this.getContentPane();
        source = EmptyCellFinder.findFirstEmptyCellInColumn(contentPane, columnFilter);
        System.out.println(source.getName());
        if (controlSign.equals(" ") || controlSign.equals("O")) {
            source.setText("X");
            controlSign = "X";
        } else if (controlSign.equals("X")) {
            source.setText("O");
            controlSign = "O";
        } else {
            source.setText(" ");
            controlSign = " ";
        }
    }
}