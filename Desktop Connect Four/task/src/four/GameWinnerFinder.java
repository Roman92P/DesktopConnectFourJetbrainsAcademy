package four;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameWinnerFinder extends JFrame {

    private static final Map<Integer, String> ALPHA_MAP = new HashMap<>() {{
        put(1, "A");
        put(2, "B");
        put(3, "C");
        put(4, "D");
        put(5, "E");
        put(6, "F");
        put(7, "G");
    }};

    public static boolean winnerPersist(Container container) {
        Component[] components = container.getComponents();
        JPanel buttonPanel = (JPanel) components[0];
        Component[] allBtns = buttonPanel.getComponents();

        List<Component> blueBtns = Arrays.stream(allBtns).filter(component -> component.getBackground().equals(Color.BLUE)).collect(Collectors.toList());
        return blueBtns.size() == 4;
    }

    public static void checkIfFourCellsConnected(Container container, CellButton source) {
        Component[] components = container.getComponents();
        JPanel buttonPanel = (JPanel) components[0];
        Component[] allBtns = buttonPanel.getComponents();

        List<Component> xList = getXor0ComponentList(allBtns, "X");

        List<Component> oList = getXor0ComponentList(allBtns, "O");
        if (source.getText().equals("X")) {
            findConnected(xList, source);
        }
        if (source.getText().equals("O")) {
            findConnected(oList, source);
        }

    }

    private static void findConnected(List<Component> list, CellButton source) {

        List<Component> horizontalFilter = new ArrayList<>();
        List<Component> verticalFilter = new ArrayList<>();

        Set<Component> horizontalChangeColor = new HashSet<>();
        Set<Component> verticalChangeColor = new HashSet<>();
        Set<Component> diagonalChangeColor = new HashSet<>();

        for (int i = 1; i < 7; i++) {
            int rowNumber = i;
            horizontalFilter = list.stream().filter(component -> {
                String[] nameArr = getCompNameElements(component.getName());
                return nameArr[1].equals(String.valueOf(rowNumber));
            }).collect(Collectors.toList());
            if (horizontalFilter.size() >= 4) {
                Component component = horizontalFilter.get(0);
                int counter = 0;
                for (int j = 1; j < horizontalFilter.size(); j++) {
                    String[] arr1 = getCompNameElements(component.getName());
                    String[] arr2 = getCompNameElements(horizontalFilter.get(j).getName());
                    int s = ((int) arr2[0].charAt(0) + Integer.parseInt(arr2[1])) - ((int) arr1[0].charAt(0) + Integer.parseInt(arr1[1]));
                    if (s == 1 && component.getBackground() != Color.BLUE && counter < 5) {
                        horizontalChangeColor.add(component);
                        horizontalChangeColor.add(horizontalFilter.get(j));
                        counter++;
                        component = horizontalFilter.get(j);
                        if (counter == 4) {
                            break;
                        }
                    } else {
                        counter = 0;
                        horizontalChangeColor.clear();
                    }
                }
            }
        }
        if (horizontalChangeColor.size() == 4) {
            for (Component c : horizontalChangeColor) {
                c.setBackground(Color.BLUE);
            }
        }

        for (int i = 1; i < 8; i++) {
            int colNumber = i;
            verticalFilter = list.stream().filter(component -> {
                String[] nameArr = getCompNameElements(component.getName());
                return nameArr[0].equals(ALPHA_MAP.get(colNumber));
            }).collect(Collectors.toList());
            if (verticalFilter.size() >= 4) {
                Component component = verticalFilter.get(0);
                int counter = 0;
                for (int j = 1; j < verticalFilter.size(); j++) {
                    String[] arr1 = getCompNameElements(component.getName());
                    String[] arr2 = getCompNameElements(verticalFilter.get(j).getName());
                    int s = Integer.parseInt(arr1[1]) - Integer.parseInt(arr2[1]);
                    if (s == 1 && component.getBackground() != Color.BLUE && counter < 5) {
                        verticalChangeColor.add(component);
                        verticalChangeColor.add(verticalFilter.get(j));
                        counter++;
                        component = verticalFilter.get(j);
                        if (counter == 4) {
                            break;
                        }
                    } else {
                        counter = 0;
                        verticalChangeColor.clear();
                    }
                }
            }
        }
        if (verticalChangeColor.size() == 4) {
            for (Component c : verticalChangeColor) {
                c.setBackground(Color.BLUE);
            }
        }
        //Diagonal search
        List<Component> dList = new ArrayList<>();
        String[] srcBtnNameComponents = getCompNameElements(source.getName());

        int letterFrom = (int) srcBtnNameComponents[0].charAt(0);
        int numberFromName = Integer.parseInt(srcBtnNameComponents[1]);

        int copyLetterForm = letterFrom;
        int copyNumberFromName = numberFromName;

        dList.add(source);
        boolean search = true;
        int failDirectionCount = 0;
        String direction = "up-right";
        while (search) {
            if (direction.equals("up-right")) {
                boolean foundUpRight = true;
                int increasedLetterNumber = letterFrom + 1;
                int increasedNameNumber = numberFromName + 1;
                Set<Component> upRights = new HashSet<>();
                while (foundUpRight) {
                    String s = Character.toString(increasedLetterNumber);
                    String searchedName = "Button" + s + increasedNameNumber;
                    Optional<Component> foundUpRightComponent = list.stream().filter(component -> component.getName().equals(searchedName)).findAny();
                    if (foundUpRightComponent.isPresent()) {
                        upRights.add(foundUpRightComponent.get());
                        increasedLetterNumber++;
                        increasedNameNumber++;
                        if (upRights.size() == 3) {
                            dList.addAll(upRights);
                            search = false;
                        }
                    } else {
                        letterFrom = copyLetterForm;
                        numberFromName = copyNumberFromName;
                        failDirectionCount++;
                        direction = "up-left";
                        foundUpRight = false;
                    }
                }
            } else if (direction.equals("up-left")) {
                boolean foundUpLeft = true;
                int decreasedLetterNumber = letterFrom - 1;
                int increasedNameNumber = numberFromName + 1;
                Set<Component> upLefts = new HashSet<>();
                while (foundUpLeft) {
                    String s = Character.toString(decreasedLetterNumber);
                    String searchedName = "Button" + s + increasedNameNumber;
                    Optional<Component> foundUpLeftComponent = list.stream().filter(component -> component.getName().equals(searchedName)).findAny();
                    if (foundUpLeftComponent.isPresent()) {
                        upLefts.add(foundUpLeftComponent.get());
                        decreasedLetterNumber--;
                        increasedNameNumber++;
                        if (upLefts.size() == 3) {
                            dList.addAll(upLefts);
                            search = false;
                        }
                    } else {
                        letterFrom = copyLetterForm;
                        numberFromName = copyNumberFromName;
                        failDirectionCount++;
                        direction = "down-left";
                        foundUpLeft = false;
                    }
                }
            } else if (direction.equals("down-left")) {
                boolean foundDownLeft = true;
                int decreasedLetterNumber = letterFrom - 1;
                int decreasedNameNumber = numberFromName - 1;
                Set<Component> downLefts = new HashSet<>();
                while (foundDownLeft) {
                    String s = Character.toString(decreasedLetterNumber);
                    String searchedName = "Button" + s + decreasedNameNumber;
                    Optional<Component> foundDownLeftComponent = list.stream().filter(component -> component.getName().equals(searchedName)).findAny();
                    if (foundDownLeftComponent.isPresent()) {
                        downLefts.add(foundDownLeftComponent.get());
                        decreasedLetterNumber--;
                        decreasedNameNumber--;
                        if (downLefts.size() == 3) {
                            dList.addAll(downLefts);
                            search = false;
                        }
                    } else {
                        letterFrom = copyLetterForm;
                        numberFromName = copyNumberFromName;
                        failDirectionCount++;
                        direction = "down-right";
                        foundDownLeft = false;
                    }
                }
            } else {
                boolean foundDownRight = true;
                int increasedLetterNumber = letterFrom + 1;
                int decreasedNameNumber = numberFromName - 1;
                Set<Component> downRights = new HashSet<>();
                while (foundDownRight) {
                    String s = Character.toString(increasedLetterNumber);
                    String searchedName = "Button" + s + decreasedNameNumber;
                    Optional<Component> foundDownRightComponent = list.stream().filter(component -> component.getName().equals(searchedName)).findAny();
                    if (foundDownRightComponent.isPresent()) {
                        downRights.add(foundDownRightComponent.get());
                        increasedLetterNumber++;
                        decreasedNameNumber--;
                        if (downRights.size() == 3) {
                            dList.addAll(downRights);
                            search = false;
                        }
                    } else {
                        letterFrom = copyLetterForm;
                        numberFromName = copyNumberFromName;
                        failDirectionCount++;
                        direction = "up-right";
                        foundDownRight = false;
                    }
                }
            }

            if (failDirectionCount == 4) {
                search = false;
            }
        }
        if (dList.size() == 4) {
            for (Component c : dList) {
                c.setBackground(Color.BLUE);
            }
        }

    }

    private static List<Component> findAllPossibleDiagonals(String[] cNameArr, List<Component> list) {
        return list.stream().filter(component -> {
            String[] temp = component.getName().substring("Button".length()).split("");
            return !temp[0].equals(cNameArr[0]) && !temp[1].equals(cNameArr[1]);
        }).collect(Collectors.toList());
    }

    private static int calculateButonNameValue(String[] cNameArr) {
        return (int) cNameArr[0].charAt(0) + Integer.parseInt(cNameArr[1]);
    }

    private static String[] getCompNameElements(String componentName) {
        return componentName.substring("Button".length()).split("");
    }

    private static List<Component> getXor0ComponentList(Component[] allBtns, String text) {
        return Stream.of(allBtns).filter(b -> {
            CellButton button = (CellButton) b;
            return button.getText().equals(text);
        }).collect(Collectors.toList());
    }
}
