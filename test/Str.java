import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

public class Str{
    String str1 = "hello,bie";
    final String str2 = "hello,";

    @Test
    public void test1() {


        String str3 = "hello,"+"bie";
        String str4=new String("hello,bie");

        String str5 = str2+"bie";
        String str6="hello,";
        String str7=str6+"bie";

        System.out.println(str1==str3);
        System.out.println(str1==str4);
        System.out.println(str1==str5);
        System.out.println(str1==str7);
        str4=str4.intern();
        System.out.println(str1==str4);
    }

    @Test
    public void name() {
        String a =new String("biefeng");
        try {
            Field f = a.getClass().getDeclaredField("value");
           ParameterizedType parameterizedType = (ParameterizedType) a.getClass().getGenericSuperclass();
          Class clazz=  Class.forName("[Ljava.lang.String" );
            Array.newInstance(String.class,10);


            f.setAccessible(true);
            char as[] = (char[]) f.get(a);
            as[3]=3;
            System.out.println(a);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {

    }
}
class a<T>{

}
class b extends a<String>{

}
