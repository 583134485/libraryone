package com.guo.ssm.test;

public class MyRunnable  implements Runnable{  
    private int tickets =100;  
    @Override  
    public     void run() {  
        for (int i = 0; i < 100; i++) {  
                if (tickets>0) {  
                    try {  
                        Thread.sleep(100);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    System.out.println(Thread.currentThread().getName()+"卖票 :ticket="+tickets--);  
            }  
        }  
    } 
    
    
}  

