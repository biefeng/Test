package com.biefeng.thinkInJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class OSExecute {
    public static void command(String command, String dir) {
        boolean err = false;

        try {
            // Process process = new ProcessBuilder(command.split(" ")).start();
            File file = null;
            if (null != dir) {
                file = new File(dir);
            }
            Process process = Runtime.getRuntime().exec(command, null, file);
            BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));

            String s;
            while ((s = results.readLine()) != null) {
                System.out.println(s);
            }
            BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream(), "GBK"));
            while ((s = errors.readLine()) != null) {
                System.out.println(s);
                err = true;
            }

        } catch (Exception e) {
            if (!command.startsWith("CMD /C" + command)) {
                command("CMD /C" + command, dir);
            } else if (e.getMessage().contains("找不到类")) {
                System.out.println(11);
            } else {
                throw new RuntimeException(e);
            }
            if (err) {
                throw new OSExecuteException("Error executing command :" + command);
            }
            e.printStackTrace();
        }
    }

    public static void command(String command) {
        command(command, null);
    }
}
