import java.util.HashMap;
import java.util.Map;

public class TestDynamic {
    public static void main(String args[]){
      //  Map<String,Object> map = new HashMap<String, Object>();
        Parent role = new Child1();
        role.method1();
    }
}
interface Parent{
    void method1();
    Map<String ,Object> method2();
}

class Child1 implements Parent{

    public void method1() {
        System.out.println("This is Child1's method1");
    }

    public Map<String, Object> method2() {

        return null;
    }
}
class Child2 implements Parent{

    public void method1() {
        System.out.println("This is Child2's method1");
    }

    public Map<String, Object> method2() {

        return null;
    }
}