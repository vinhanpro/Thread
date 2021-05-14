package com.company;


import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

        // Tên của Callable, giúp chúng ta phân biệt Runnable nào đang thực thi trong
        // Thread Pool
        private String name;

        public MyCallable(String name) {
            // Khởi tạo Callable với biến name truyền vào
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            System.out.println(name + " đang thực thi...");

            // Giả lập thời gian chạy của Callable mất 2 giây
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Trả kết quả về là một kiểu String
            return name;
        }
}
