import java.util.Arrays;

class MethodFinder {


    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {
        for (int i = 0; i < classNames.length; i++) {
            Class s = Class.forName(classNames[i]);
            String reg = ".*" + methodName + ".*";
            if (Arrays.stream(s.getMethods()).anyMatch(method -> method.getName().matches(reg))) {
                return s.getName();
            }
        }
        return null;
    }
}