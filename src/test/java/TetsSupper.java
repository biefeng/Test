public class TetsSupper {
    public static void main(String[] args) {
        //A<String> a=new A<>();
        B<String> b=new B<String>("hha");
    }
}

class A<T> {
    public T item;
    public A(T item) {
        System.out.println(this);
        this.item=item;
        System.out.println(item);
    }


}
class B<T> extends A<T>{
    public B(T item) {

        super(item);
        System.out.println(this);
    }
}
