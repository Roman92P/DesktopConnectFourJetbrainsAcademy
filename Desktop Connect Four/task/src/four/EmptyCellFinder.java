package four;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmptyCellFinder {

    public static CellButton findFirstEmptyCellInColumn(Container container, String columnFilter) {
        Component[] components = container.getComponents();
        JPanel component3 = (JPanel) components[0];
        Component[] components1 = component3.getComponents();
        List<Component> btns = Arrays.stream(components1)
                .filter(component -> component.getName().matches(columnFilter))
                .collect(Collectors.toList());
        Collections.reverse(btns);
        Component component2 = btns.stream().filter(component -> {
            CellButton component1 = (CellButton) component;
            return component1.getText().equals(" ");
        }).findFirst().get();
        return (CellButton) component2;
    }

}

