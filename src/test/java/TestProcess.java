import java.io.IOException;

public class TestProcess {
    public static void main(String[] args) {
        try {
            String command[]  ={"CMD","/C","start" ," ","c:"};
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
