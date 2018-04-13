package com.biefeng.demo.timer;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    public static void main(String args[]) {
       /* new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("ko");
            }
        },5000,3000);*/
        class MyTimeTask extends TimerTask {

            @Override
            public void run() {
                System.out.println("ko!");
                new Timer().schedule(new MyTimeTask(),4000);
            }
        }
        new Timer().schedule(new MyTimeTask(),2000);
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Calendar calendar = Calendar.getInstance();
            int a = calendar.get(Calendar.SECOND);
            System.out.println(a);
        }
    }
}
