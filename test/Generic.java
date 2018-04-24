import org.junit.Test;

public class Generic {

    @Test
    public void test() {
        try {
            Class clazz = Class.forName("GeneChild");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Gene<T> {
}

class GeneChild extends Gene<String> {

}
