import com.biefeng.demo.model.Model;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : BieFeNg
 * @DATE : 2018/9/2 1:04
 */
public class Gest {

    @Test
    public void name() {
        int a = 15;
        System.out.println(Integer.highestOneBit(a));
        System.out.println(Integer.lowestOneBit(a));
    }

    @Test
    public void name1() {
        Map map = Collections.synchronizedMap(new HashMap<>());
    }

    @Test
    public void name2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<HashMap> clazz = HashMap.class;
        Method method = clazz.getMethod("roundUpToPowerOf2", Integer.TYPE);
        if (!method.isAccessible())
            method.setAccessible(true);
        System.out.println(method.invoke(null, 5));
    }

    @Test
    public void name3() {
        Model model = new Model();
        Class<Model> clazz = (Class<Model>) model.getClass();
        Type[] types = clazz.getGenericInterfaces();
        for (Type t : types) {
            ParameterizedType type= (ParameterizedType) t;
            System.out.println(type.getRawType());
            System.out.println(type.getTypeName());
            System.out.println(type.getOwnerType());
            Type[] ts = type.getActualTypeArguments();
            for (Type t1:ts){
                System.out.println(t1.getTypeName());
            }
        }
    }

    static Class<?> comparableClassFor(Object x) {
        if (x instanceof Comparable) {
            Class<?> c;
            Type[] ts, as;
            Type t;
            ParameterizedType p;
            if ((c = x.getClass()) == String.class) // bypass checks
                return c;
            if ((ts = c.getGenericInterfaces()) != null) {
                for (int i = 0; i < ts.length; ++i) {
                    if (((t = ts[i]) instanceof ParameterizedType) &&
                            ((p = (ParameterizedType) t).getRawType() ==
                                    Comparable.class) &&
                            (as = p.getActualTypeArguments()) != null &&
                            as.length == 1 && as[0] == c) // type arg is c
                        return c;
                }
            }
        }
        return null;
    }
}
