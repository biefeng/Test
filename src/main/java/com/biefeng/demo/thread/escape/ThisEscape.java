package com.biefeng.demo.thread.escape;


public class ThisEscape {

    private final int id;
    private final String name;

    public ThisEscape(EventSource<EventListener> source) {
        id = 1;
        source.registryListener(new EventListener() {
            public void onEvent(Object obj) {
                System.out.println("id: " + ThisEscape.this.id);
                System.out.println("name: " + ThisEscape.this.name);
            }
        });
        try {
            Thread.sleep(1000); // 调用sleep模拟其他耗时的初始化操作
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        name = "flysqrlboy";
    }
}
