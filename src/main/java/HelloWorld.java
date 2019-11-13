
import java.util.concurrent.TimeUnit;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        for(;;){
            TimeUnit.SECONDS.sleep(2);
            System.out.println("The main method is running!");
        }
    }
}
