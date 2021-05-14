package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future> listFuture = new ArrayList<Future>(); // Khởi tạo danh sách các Future

        for (int i = 1; i <= 10; i++) {
            MyRunnable myRunnable = new MyRunnable("Runnable " + i);
            // Bước này chúng ta dùng submit() thay vì execute()
            Future future = executorService.submit(myRunnable);
            listFuture.add(future); // Từng Future sẽ quản lý một Runnable
        }

        for (Future future : listFuture) {
            try {
                // Khi Thread nào kết thúc, get() của Future tương ứng sẽ trả về null
                System.out.println(future.get());
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Phương thức này đã nói ở trên đây rồi
        executorService.shutdown();
    }
}