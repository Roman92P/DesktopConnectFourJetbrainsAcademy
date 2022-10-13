package four;

import javax.swing.*;
import javax.swing.plaf.metal.MetalBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectFour extends JFrame implements ActionListener {
    protected static String controlSign = " ";

    public ConnectFour() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        setTitle("Connect Four");

        JPanel jPanel = new JPanel();

        for (int i = 6; i > 0; i--) {
            for (int j = 65; j < 72; j++) {
                String col = Character.toString(j);
                CellButton cellButton = new CellButton();
                cellButton.setFocusPainted(false);
                cellButton.setBackground(Color.gray);
                cellButton.setBorder(new MetalBorders.ButtonBorder());
                cellButton.setName("Button" + col + i);
                cellButton.setText(" ");
                cellButton.addActionListener(this);
                jPanel.add(cellButton);
            }
        }
        jPanel.setLayout(new GridLayout(6, 7));

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(1, 7));
        jPanel1.setLayout(new BorderLayout());
        ButtonReset buttonReset = new ButtonReset();
        buttonReset.setFocusPainted(false);
        buttonReset.setEnabled(true);
        buttonReset.setName("ButtonReset");
        buttonReset.setPreferredSize(new Dimension(100, 20));
        buttonReset.addActionListener(actionEvent -> {
            GameReseter.resetGame(getContentPane());
        });
        jPanel1.add(buttonReset, BorderLayout.EAST);

        add(jPanel, BorderLayout.CENTER);
        add(jPanel1, BorderLayout.SOUTH);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String buttonFieldText = actionEvent.getActionCommand();
        CellButton source = (CellButton) actionEvent.getSource();
        if (source.getText().equals(" ") && !GameWinnerFinder.winnerPersist(getContentPane())) {
            String buttonName = source.getName().substring(0, "ButtonN".length());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(buttonName);
            stringBuilder.append(".*");
            String columnFilter = stringBuilder.toString();
            Container contentPane = this.getContentPane();
            source = EmptyCellFinder.findFirstEmptyCellInColumn(contentPane, columnFilter);
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
        GameWinnerFinder.checkIfFourCellsConnected(getContentPane(), source);
    }
}