package four;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EmptyCellFinder{

    public static CellButton findFirstEmptyCellInColumn(Container container, String columnFilter) {
        List<Component> btns = Arrays.stream(container.getComponents())
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

