import org.junit.Test;

import java.util.Arrays;

public class Arr {
    @Test
    public void test() {
        String arr1[] = {"B", "A", "C"};
        String arr2[] = new String[arr1.length];
       // System.arraycopy(arr1, 0, arr2, 0, arr2.length);
       arr2= Arrays.copyOf(arr1,3);
        arr2[1] = "D";
        for(String s:arr2){
            System.out.println(s);
        }
    }
}
