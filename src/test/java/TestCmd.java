import org.junit.Test;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class TestCmd {

    @Test
    public void name() throws IOException, InterruptedException {

        File file = new File("D:");
        if (null != file && file.isDirectory()) {
            Process process = Runtime.getRuntime().exec(" cmd /k start java HelloWorld",null, file);
            InputStream errorInputStream=process.getErrorStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(errorInputStream));
            String line;
            while ((line=reader.readLine())!=null){
                System.out.println(line);
            }
            TimeUnit.SECONDS.sleep(6);
            process.destroy();
        }
    }
}
